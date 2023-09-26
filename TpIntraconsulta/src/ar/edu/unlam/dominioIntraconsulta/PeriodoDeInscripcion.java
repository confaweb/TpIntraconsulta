package ar.edu.unlam.dominioIntraconsulta;

import java.time.LocalDate;
import java.util.Objects;

public class PeriodoDeInscripcion {

	private Integer idCicloLectivo;
	private LocalDate fechaInicioInscr;
	private LocalDate fechaFinInscr;

	public PeriodoDeInscripcion(Integer idCicloLectivo, LocalDate fechaInicioInscr, LocalDate fechaFinInscr) {
		this.idCicloLectivo=idCicloLectivo;
		this.fechaInicioInscr=fechaFinInscr;
		this.fechaFinInscr=fechaFinInscr;
	}

	

	public Integer getIdCicloLectivo() {
		return idCicloLectivo;
	}

	public void setIdCicloLectivo(Integer idCicloLectivo) {
		this.idCicloLectivo = idCicloLectivo;
	}

	public LocalDate getFechaInicioInscr() {
		return fechaInicioInscr;
	}

	public void setFechaInicioInscr(LocalDate fechaInicioInscr) {
		this.fechaInicioInscr = fechaInicioInscr;
	}

	public LocalDate getFechaFinInscr() {
		return fechaFinInscr;
	}

	public void setFechaFinInscr(LocalDate fechaFinInscr) {
		this.fechaFinInscr = fechaFinInscr;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCicloLectivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeriodoDeInscripcion other = (PeriodoDeInscripcion) obj;
		return Objects.equals(idCicloLectivo, other.idCicloLectivo);
	}

}
