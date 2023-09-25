
package ar.edu.unlam.dominioIntraconsulta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comision {

	public Turno turno;
	private Ciclo cicloLectivo;
	private List<Docente> docentes = new ArrayList<Docente>();
	private Materia materia;

	public Comision(Ciclo cicloLectivo,Turno turno, Materia materia) {
		this.cicloLectivo=cicloLectivo;
		this.materia=materia;
		this.turno = turno;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Ciclo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(Ciclo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public List<Docente> getDocente() {
		return docentes;
	}

	public void agregarDocente(Docente docente) {
		this.docentes.add(docente);
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(materia,cicloLectivo);
	}
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Comision miClase = (Comision) obj; 
        return materia == miClase.materia && Objects.equals(cicloLectivo, miClase.cicloLectivo);
		
	}

}

