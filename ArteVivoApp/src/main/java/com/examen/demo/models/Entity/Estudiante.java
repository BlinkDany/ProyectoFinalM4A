package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona {

	@Column(nullable = false)
	private String cedula_estudiante_fk;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ced_estudiante_fk")
	private List<Matricula> listaMatriculaAsignList;

	public String getCedula_estudiante_fk() {
		return cedula_estudiante_fk;
	}

	public void setCedula_estudiante_fk(String cedula_estudiante_fk) {
		this.cedula_estudiante_fk = cedula_estudiante_fk;
	}

}
