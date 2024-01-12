package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="matriculas")
public class Matricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_matricula_pk;

	private Date fecha_ini;
	private Date feche_fin;
	
	@Column(nullable = false)
	private Long cod_estudiante_fk;
	

	
	public Long getCod_matricula_pk() {
		return cod_matricula_pk;
	}

	public void setCod_matricula_pk(Long cod_matricula_pk) {
		this.cod_matricula_pk = cod_matricula_pk;
	}

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public Date getFeche_fin() {
		return feche_fin;
	}

	public void setFeche_fin(Date feche_fin) {
		this.feche_fin = feche_fin;
	}

	public Long getCod_estudiante_fk() {
		return cod_estudiante_fk;
	}

	public void setCod_estudiante_fk(Long cod_estudiante_fk) {
		this.cod_estudiante_fk = cod_estudiante_fk;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
