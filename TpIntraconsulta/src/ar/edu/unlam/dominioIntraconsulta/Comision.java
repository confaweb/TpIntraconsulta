package ar.edu.unlam.dominioIntraconsulta;

import java.util.ArrayList;
import java.util.Objects;

public class Comision {

	public Turno turno;
	private CicloLectivo cicloLectivo;
	private Docente docente;
	private Materia materia;
	private ArrayList<Alumno> listaAlumnosComision;
	private ArrayList<Docente> cantidadDocentes;
	private Integer idComision;

	public Comision(Integer idComision, CicloLectivo cicloLectivo, Docente docente, Turno turno, Materia materia,
			ArrayList<Alumno> listaAlumnosComision) {
		this.cicloLectivo = cicloLectivo;
		this.docente = docente;
		this.materia = materia;
		this.turno = turno;
		this.listaAlumnosComision = new ArrayList<Alumno>();
		this.idComision = idComision;
		this.cantidadDocentes = new ArrayList<Docente>();
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
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

	public ArrayList<Docente> getCantidadDocentes() {
		return cantidadDocentes;
	}

	public void setCantidadDocentes(ArrayList<Docente> cantidadDocentes) {
		this.cantidadDocentes = cantidadDocentes;
	}

	public Boolean agregarAlumno(Alumno alumno) {
		return this.listaAlumnosComision.add(alumno);
	}

	public void borrarAlumno(Alumno alumno) {
		this.listaAlumnosComision.remove(alumno);
	}

	public void agregarDocente(Docente docente) {

		this.cantidadDocentes.add(docente);
	}
	public void simularCantidadDeAlumnos(Integer cantidadDeseada) {
		Alumno alumno = new Alumno();
		for (int i = 0; i < cantidadDeseada; i++) {
			this.listaAlumnosComision.add(alumno);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idComision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(idComision, other.idComision);
	}

}
