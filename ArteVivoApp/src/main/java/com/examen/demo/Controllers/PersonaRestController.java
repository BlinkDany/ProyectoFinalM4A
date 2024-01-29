package com.examen.demo.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.xpath.XPathLexerErrorListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.examen.demo.models.Entity.Estudiante;
import com.examen.demo.models.Entity.Persona;
import com.examen.demo.models.Service.IPersonaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PersonaRestController {
	
	private static final String CARPETA_IMAGENES_ESPECIFICA = 
			"C:\\Users\\juan_\\OneDrive\\Escritorio\\foto";


	@Autowired
	private IPersonaService personaService;
	
	//LISTAR
	@GetMapping("/persona")
	public List<Persona> index(){
		
		return personaService.findAll();
	}
	
	//CREAR
	@PostMapping("/persona")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona) {
	    return personaService.save(persona);
	}
	
	//BUSCARPERSONA
	@GetMapping("/persona/{cedula}")
	public Persona show(@PathVariable String cedula) {
		
		return personaService.findById(cedula);
	}
	
	//ACTUALIZAR
	@PutMapping("/persona/{cedula}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona update(@PathVariable String cedula, @RequestBody Persona persona) {
		
		Persona personaActual = personaService.findById(cedula);
		personaActual.setApellidos(persona.getApellidos());
		personaActual.setCorreo(persona.getCorreo());
		personaActual.setDireccion(persona.getDireccion());
		personaActual.setFecha_nac(persona.getFecha_nac());
		personaActual.setNombres(persona.getNombres());
		personaActual.setTelf(persona.getTelf());
		personaActual.setFoto(persona.getFoto());
		personaActual.setContrasena(persona.getContrasena());
		
		return personaService.save(personaActual);
	}
	
	//ELIMINAR
	@DeleteMapping("/persona/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String cedula) {
		
		personaService.delete(cedula);
	}
	
	// foto

		@GetMapping("/persona/imagen/{imagen}")
		public ResponseEntity<Resource> getImagen(@PathVariable String imagen) {
			Path imagenPath = Paths.get(CARPETA_IMAGENES_ESPECIFICA, imagen);
			Resource imagenResource = new FileSystemResource(imagenPath);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE).body(imagenResource);
		}

		private String almacenarImagen(MultipartFile imagen) throws IOException {
			String nombreUnico = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
			Path rutaCompleta = Paths.get(CARPETA_IMAGENES_ESPECIFICA, nombreUnico);
			Files.write(rutaCompleta, imagen.getBytes());
			return nombreUnico;
		}
		
		// AUTENTICACIÓN
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
		    String correo = credentials.get("correo");
		    String contrasena = credentials.get("contrasena");

		    System.out.println("Intento de inicio de sesión para el correo: " + correo+ contrasena);

		    Persona persona = personaService.authenticate(correo, contrasena);

		    if (persona != null) {
		        System.out.println("Inicio de sesión exitoso para el correo: " + correo);
		        return ResponseEntity.ok(persona);
		    } else {
		        System.out.println("Falló el inicio de sesión para el correo: " + correo + contrasena);
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticación fallida");
		    }
		}
		
		///////////LOGIN SOLO ESTUDIANTE
		@PostMapping("/loginEstudiante")
		public ResponseEntity<?> loginEstudiante(@RequestBody Map<String, String> credentials) {
		    String correo = credentials.get("correo");
		    String contrasena = credentials.get("contrasena");

		    System.out.println("Intento de inicio de sesión para el correo: " + correo);

		    Persona persona = personaService.authenticate(correo, contrasena);

		    if (persona != null) {
		        System.out.println("Inicio de sesión exitoso para el correo: " + correo);

		        // Asegúrate de que la persona autenticada sea un estudiante
		        if (persona instanceof Estudiante) {
		            // Solo permitir el acceso si es un estudiante
		            return ResponseEntity.ok(persona);
		        } else {
		            // Si la persona autenticada no es un estudiante, denegar el acceso
		            System.out.println("Inicio de sesión denegado. Solo se permite el acceso a estudiantes.");
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Inicio de sesión denegado. Solo se permite el acceso a estudiantes.");
		        }
		    } else {
		        System.out.println("Falló el inicio de sesión para el correo: " + correo);
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticación fallida");
		    }
		}
		
		// NUEVO MÉTODO PARA OBTENER TIPO DE USUARIO
	    @GetMapping("/persona/tipo-usuario")
	    public ResponseEntity<String> getTipoUsuario(@RequestParam String cedula) {
	        String tipoUsuario = personaService.getTipoUsuario(cedula);

	        if (tipoUsuario != null) {
	            return ResponseEntity.ok(tipoUsuario);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	///////////Buscadores x nombre apellido y mail///////////////////////
	    @GetMapping("/persona/buscar-por-nombre")
	    public List<Persona> buscarPorNombre(@RequestParam String nombres) {
	        return personaService.findByNombre(nombres);
	    }

	    @GetMapping("/persona/buscar-por-apellido")
	    public List<Persona> buscarPorApellido(@RequestParam String apellidos) {
	        return personaService.findByApellido(apellidos);
	    }

	    @GetMapping("/persona/buscar-por-correo")
	    public List<Persona> buscarPorCorreo(@RequestParam String correo) {
	        return personaService.findByCorreo(correo);
	    }	    
}
