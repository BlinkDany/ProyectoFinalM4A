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
@Table(name="asignatura")
public class Asignatura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoAsignatura;
	
	private String nombre;
	private String descripcion;

	@Column(nullable = false)
	private Long codigoCategorias;
	
	@Column(nullable = false)
	private String ced_profesor_fk;
	
	@Column(nullable = false)
	private Long codigoMatriculas;
	
	@Column(nullable = false)
	private Long codigoHorarios;
	
	@Column(nullable = false)
	private Long codigoTareas;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoAsignatura")
	private List<EstudianteAsignatura> listAsignaturas;
	
	public Long getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(Long codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
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

	public Long getCodigoMatriculas() {
		return codigoMatriculas;
	}

	public void setCodigoMatriculas(Long codigoMatriculas) {
		this.codigoMatriculas = codigoMatriculas;
	}

	public Long getCodigoHorarios() {
		return codigoHorarios;
	}

	public void setCodigoHorarios(Long codigoHorarios) {
		this.codigoHorarios = codigoHorarios;
	}

	public Long getCodigoTareas() {
		return codigoTareas;
	}

	public void setCodigoTareas(Long codigoTareas) {
		this.codigoTareas = codigoTareas;
	}



}
