package com.examen.demo.models.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudianteAsignatura")
public class EstudianteAsignatura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEstAsig;
	private Long codigoEstudiante;
	private Long codigoAsignatura;
	private double calificacion;
	private String estado;
	private int Asistencias;

	public Long getCodigoEstAsig() {
		return codigoEstAsig;
	}

	public void setCodigoEstAsig(Long codigoEstAsig) {
		this.codigoEstAsig = codigoEstAsig;
	}

	public Long getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(Long codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public Long getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(Long codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getAsistencias() {
		return Asistencias;
	}

	public void setAsistencias(int asistencias) {
		Asistencias = asistencias;
	}

}