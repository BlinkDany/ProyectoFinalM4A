package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tareas")
public class Tareas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoTareas;
	private String observaciones;
	private String notas;
	
	@Column(nullable = false)
	private Long cod_matricula_pk;
	
	@Column(name = "fecharegistro")
	@Temporal(TemporalType.DATE)
	private Date fecharegistro;
	
	
	
    public Long getCod_matricula_pk() {
		return cod_matricula_pk;
	}


	public void setCod_matricula_pk(Long cod_matricula_pk) {
		this.cod_matricula_pk = cod_matricula_pk;
	}


	@PrePersist
	public void prePersist() {
    	fecharegistro = new Date();
	}


	public Long getCodigoTareas() {
		return codigoTareas;
	}


	public String getNotas() {
		return notas;
	}


	public void setNotas(String notas) {
		this.notas = notas;
	}


	public void setCodigoTareas(Long codigoTareas) {
		this.codigoTareas = codigoTareas;
	}


	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
    
    
}
