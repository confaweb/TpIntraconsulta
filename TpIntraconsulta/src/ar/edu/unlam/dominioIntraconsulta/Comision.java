package ar.edu.unlam.dominioIntraconsulta;

public class Comision {

	private Turno turno;
	private Ciclo cicloLectivo;
	private Docente docente;
	private Materia materia;

	public Comision(Ciclo cicloLectivo, Docente docente, Turno turno, Materia materia) {
		this.cicloLectivo=cicloLectivo;
		this.docente=docente;
		this.materia=materia;
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

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}
