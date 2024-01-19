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
	private int cupo;
	
	@Column(nullable = false)
	private String ced_estudiante_fk;
	
	@Column(nullable = false)
	private Long codigoAsignatura;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_matricula_pk")
	private List<Tareas> listTareas;
	
	
	public Long getCod_matricula_pk() {
		return cod_matricula_pk;
	}
	
	

	public Long getCodigoAsignatura() {
		return codigoAsignatura;
	}



	public void setCodigoAsignatura(Long codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}



	public List<Tareas> getListTareas() {
		return listTareas;
	}



	public void setListTareas(List<Tareas> listTareas) {
		this.listTareas = listTareas;
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

	public String getCed_estudiante_fk() {
		return ced_estudiante_fk;
	}



	public void setCed_estudiante_fk(String ced_estudiante_fk) {
		this.ced_estudiante_fk = ced_estudiante_fk;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getCupo() {
		return cupo;
	}



	public void setCupo(int cupo) {
		this.cupo = cupo;
	}



	
	
	
	
}
