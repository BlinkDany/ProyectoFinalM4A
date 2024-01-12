package com.examen.demo.models.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String direccion;
	private String telf;
	
	@Column(name="fecha_nac")
	@Temporal(TemporalType.DATE)
	private Date fecha_nac;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_profesor_fk")
	private List<Profesor> listaProfesors;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_estudiante_fk")
	private List<Estudiante> listEstudiantes;
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelf() {
		return telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

}
