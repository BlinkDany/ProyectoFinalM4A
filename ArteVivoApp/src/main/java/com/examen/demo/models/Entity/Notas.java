package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="notas")
public class Notas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoNotas;
	private String observaciones;
	
	@Column(name = "fecharegistro")
	@Temporal(TemporalType.DATE)
	private Date fecharegistro;
	
    @PrePersist
	public void prePersist() {
    	fecharegistro = new Date();
	}

	public Long getCodigoNotas() {
		return codigoNotas;
	}

	public void setCodigoNotas(Long codigoNotas) {
		this.codigoNotas = codigoNotas;
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
