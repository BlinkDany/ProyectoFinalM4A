package com.examen.demo.models.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_estudiante_pk;
	
	@Column(nullable = false)
	private String cedula_estudiante_fk;

	

	public Long getCod_estudiante_pk() {
		return cod_estudiante_pk;
	}


	public void setCod_estudiante_pk(Long cod_estudiante_pk) {
		this.cod_estudiante_pk = cod_estudiante_pk;
	}


	public String getCedula_estudiante_fk() {
		return cedula_estudiante_fk;
	}



	public void setCedula_estudiante_fk(String cedula_estudiante_fk) {
		this.cedula_estudiante_fk = cedula_estudiante_fk;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
