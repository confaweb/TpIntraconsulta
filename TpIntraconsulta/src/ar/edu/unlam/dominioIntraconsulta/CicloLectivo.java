package ar.edu.unlam.dominioIntraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CicloLectivo {
	
	private LocalDate inicio;
	private LocalDate fin;
	private List <LocalDate> inscripciones = new ArrayList<>();
	
	public CicloLectivo(LocalDate inicio, LocalDate fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public void AgregarInscripcion(LocalDate fecha) {
		this.inscripciones.add(fecha);
	}
	
	public Boolean CheckFecha(LocalDate fecha) {
		if(this.inscripciones.contains(fecha)) {
			return true;
		}else return false;
	}
	
	
	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	
	
	
	
	
}
