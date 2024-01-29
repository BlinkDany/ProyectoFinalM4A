package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona{

	
	@Column(nullable = false)
	private String cedula_profesor_fk;
	
	private String Titulo;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ced_profesor_fk")
	private List<Asignatura> listaAsignaturas;

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getCedula_profesor_fk() {
		return cedula_profesor_fk;
	}

	public void setCedula_profesor_fk(String cedula_profesor_fk) {
		this.cedula_profesor_fk = cedula_profesor_fk;
	}
	
}
