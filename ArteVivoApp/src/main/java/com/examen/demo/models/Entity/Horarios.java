package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long codigoHorarios;
	private String hora_Inicio;
	private String hora_fin;
	private String dia;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoHorarios")
	private List<Asignatura> listaAsignaturas;
	
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Long getCodigoHorarios() {
		return codigoHorarios;
	}

	public void setCodigoHorarios(Long codigoHorarios) {
		this.codigoHorarios = codigoHorarios;
	}

	
	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	public String getHora_Inicio() {
		return hora_Inicio;
	}

	public void setHora_Inicio(String hora_Inicio) {
		this.hora_Inicio = hora_Inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
