package ar.edu.unlam.dominioIntraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ciclo {

	private Integer id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private List<LocalDate> inscripciones = new ArrayList<LocalDate>();

	public Ciclo(Integer id, LocalDate fechaInicio, LocalDate fechaFin) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(CharSequence fechaInicio) {
		this.fechaInicio = LocalDate.parse(fechaInicio);
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(CharSequence fechaFin) {
		this.fechaFin = LocalDate.parse(fechaFin);
	}

}
