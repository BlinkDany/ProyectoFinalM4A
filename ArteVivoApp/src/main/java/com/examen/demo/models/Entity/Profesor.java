package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "profesores")
public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_profesor_pk;

	private String Titulo;
	@Column(nullable = false)
	private String cedula_profesor_fk;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoProfesores")
	private List<Asignatura> listaAsignaturas;
	
	public Long getCod_profesor_pk() {
		return cod_profesor_pk;
	}

	public void setCod_profesor_pk(Long cod_profesor_pk) {
		this.cod_profesor_pk = cod_profesor_pk;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
