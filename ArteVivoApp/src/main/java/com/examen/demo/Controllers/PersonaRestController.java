package com.examen.demo.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.v4.runtime.tree.xpath.XPathLexerErrorListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.examen.demo.models.Entity.Persona;
import com.examen.demo.models.Service.IPersonaService;

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
	public Persona create(@RequestPart("persona") Persona persona,
	                      @RequestPart(value = "imagen", required = false) MultipartFile imagen) {
	    if (imagen != null && !imagen.isEmpty()) {
	        try {
	            String foto = almacenarImagen(imagen);
	            persona.setFoto(foto);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

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
		
		return personaService.save(personaActual);
	}
	
	//ELIMINAR
	@DeleteMapping("/persona/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String cedula) {
		
		personaService.delete(cedula);
	}
	
	// foto

		@GetMapping("/proveedores/imagen/{imagen}")
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
	
}
