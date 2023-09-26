package ar.edu.unlam.dominioIntraconsulta;

import java.util.ArrayList;

public class Comision {

	public Turno turno;
	private CicloLectivo cicloLectivo;
	private Docente docente;
	private Materia materia;
	private ArrayList<Alumno>listaAlumnosComision;

	public Comision(CicloLectivo cicloLectivo, Docente docente, Turno turno, Materia materia,ArrayList<Alumno>listaAlumnosComision) {
		this.cicloLectivo=cicloLectivo;
		this.docente=docente;
		this.materia=materia;
		this.turno = turno;
		this.listaAlumnosComision=new ArrayList<Alumno>();
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public ArrayList<Alumno> getListaAlumnosComision() {
		return listaAlumnosComision;
	}

	public void setListaAlumnosComision(ArrayList<Alumno> listaAlumnosComision) {
		this.listaAlumnosComision = listaAlumnosComision;
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
	public Boolean agregarAlumno(Alumno alumno) {
		return this.listaAlumnosComision.add(alumno);
	}
	public void borrarAlumno(Alumno alumno) {
		this.listaAlumnosComision.remove(alumno);
	}

}
