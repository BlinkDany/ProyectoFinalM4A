package com.examen.demo.models.Entity;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Entity;
<<<<<<< Updated upstream
=======
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
>>>>>>> Stashed changes
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "horarios")
public class Horarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< Updated upstream
	
	@Id
=======

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> Stashed changes
	private Long codigoHorarios;
	private LocalTime hora_Inicio;
	private LocalTime hora_fin;

	public Long getCodigoHorarios() {
		return codigoHorarios;
	}

	public void setCodigoHorarios(Long codigoHorarios) {
		this.codigoHorarios = codigoHorarios;
	}

	public LocalTime getHora_Inicio() {
		return hora_Inicio;
	}

	public void setHora_Inicio(LocalTime hora_Inicio) {
		this.hora_Inicio = hora_Inicio;
	}

	public LocalTime getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(LocalTime hora_fin) {
		this.hora_fin = hora_fin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
