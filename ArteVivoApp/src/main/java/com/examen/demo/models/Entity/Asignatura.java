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
@Table(name = "asignatura")
public class Asignatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAsignatura;

	private String nombre;
	private String descripcion;

	@Column(nullable = false)
	private Long codigoCategorias;

	@Column(nullable = false)
	private String ced_profesor_fk;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoAsignatura")
	private List<Matricula> listMatriculas;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoAsignatura")
	private List<Horarios> lisHorarios;

	public Long getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Long idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCodigoCategorias() {
		return codigoCategorias;
	}

	public void setCodigoCategorias(Long codigoCategorias) {
		this.codigoCategorias = codigoCategorias;
	}

	public String getCed_profesor_fk() {
		return ced_profesor_fk;
	}

	public void setCed_profesor_fk(String ced_profesor_fk) {
		this.ced_profesor_fk = ced_profesor_fk;
	}
	
	
	
}
