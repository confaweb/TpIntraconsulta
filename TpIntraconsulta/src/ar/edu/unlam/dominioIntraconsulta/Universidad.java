package ar.edu.unlam.dominioIntraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	private String nombreInstitucion;
	private ArrayList<Alumno> registroAlumnos;
	private ArrayList<Materia> listadoDeMaterias;
	private ArrayList<Ciclo> listaCicloLectivo;
	private ArrayList<Comision> listaComisiones;
	private ArrayList<Docente> listaDocentes;

	public Universidad(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
		this.registroAlumnos = new ArrayList<Alumno>();
		this.listadoDeMaterias = new ArrayList<Materia>();
		this.listaCicloLectivo = new ArrayList<Ciclo>();
		this.listaComisiones = new ArrayList<Comision>();
		this.listaDocentes = new ArrayList<Docente>();
	}
	// Getters &Setters

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}
	// limpiar-borrar todos los datos/registros de las Listas

	public void limpiarRegistroAlumnos() {
		registroAlumnos.clear();
	}

	public void limpiarListadoDeMaterias() {
		listadoDeMaterias.clear();
	}

	public void limpiarListaDeCicloLectivo() {
		listaCicloLectivo.clear();
	}

	public void limpiarListaDecomisiones() {
		listaComisiones.clear();
	}
	// Eliminar un registro determinado de una lista

	public void eliminarAlumno(Alumno alumno) {
		registroAlumnos.clear();
	}

	public void eliminarMateria(Materia materia) {
		listadoDeMaterias.clear();
	}

	public void eliminarCicloLectivo(Ciclo cicloLectivo) {
		listaCicloLectivo.clear();
	}

	public void eliminarComision(Comision comision) {
		listaComisiones.clear();
	}

	// Metodos para ingreso/agregado de datos

	public Boolean ingresarAlumno(Alumno alumno1, Integer dni) {

		if (!this.buscarAlumnoPorDni(dni))
			return registroAlumnos.add(alumno1);
		else
			return false;
	}

	public Boolean agregarMateria(Materia materia) {

		if (!chequearMateriaExistente(materia))
			return listadoDeMaterias.add(materia);
		else
			return false;

	}

	public Boolean agregarCicloLectivo(Ciclo cicloLectivo) {
		if (!chequearCicloPorId(cicloLectivo.getId()) && !chequearSuperposicion(cicloLectivo.getFechaInicio()))
			return listaCicloLectivo.add(cicloLectivo);
		else
			return false;
	}

	public Boolean agregarComision(Comision comision) {

		if (!chequearComision(comision))
			return listaComisiones.add(comision);
		else
			return false;

	}

	public Boolean agregarDocente(Docente docente) {
		if (!chequearDocente(docente))
			return listaDocentes.add(docente);
		else
			return false;
	}

	// Busquedas Chequeos y Verificaciones(se utiliza foreach y/0 .contains(object)

	private boolean chequearDocente(Docente docente) {
		for (Docente docentes : listaDocentes) {
			if (docentes.getDni().equals(docente.getDni()))
				return true;
		}
		return false;
	}

	private Boolean buscarAlumnoPorDni(Integer dni) {
		for (Alumno alumno : registroAlumnos) {
			if (alumno.getDni().equals(dni))
				return true;

		}
		return false;
	}

	private boolean chequearMateriaExistente(Materia materia) {
		return listadoDeMaterias.contains(materia);

	}

	private boolean chequearSuperposicion(LocalDate fechaInicio) {
		for (Ciclo ciclo : listaCicloLectivo) {
			if (ciclo.getFechaFin().isAfter(fechaInicio) || ciclo.getFechaFin().equals(fechaInicio))
				return true;

		}
		return false;
	}

	private boolean chequearCicloPorId(Integer id) {
		for (Ciclo ciclo : listaCicloLectivo) {
			if (ciclo.getId().equals(id))
				return true;

		}
		return false;
	}

	private Boolean chequearComision(Comision comision) {// QueNoSePuedagenerarDosComisionesParaMismaMateriaCicloLectivoYTurno
		for (Comision comisiones : listaComisiones) {
			if (comisiones.getMateria().getId().equals(comision.getMateria().getId())
					|| comisiones.getCicloLectivo().getId().equals(comision.getCicloLectivo().getId())
					|| comisiones.getTurno().equals(comision.getTurno()))
				return true;

		}
		return false;
	}

	public Docente asignarDocenteAComision(Comision comision, Docente docente) {
		for (Comision comisiones : listaComisiones) {
			if (comisiones.getDocente() == null && !comisiones.getDocente().getDni().equals(docente.getDni())) {
				comision.setDocente(docente);
				return docente;
			}
		}
		return null;
	}

}
