package ar.edu.unlam.dominioIntraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	private String nombreInstitucion;
	private ArrayList<Alumno> registroAlumnos;
	private ArrayList<Materia> listadoDeMaterias;
	private ArrayList<CicloLectivo> listaCicloLectivo;
	private ArrayList<Comision> listaComisiones;
	private ArrayList<Docente> listaDocentes;
	private ArrayList<Materia> listaCorrelativas;

	public Universidad(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
		this.registroAlumnos = new ArrayList<Alumno>();
		this.listadoDeMaterias = new ArrayList<Materia>();
		this.listaCicloLectivo = new ArrayList<CicloLectivo>();
		this.listaComisiones = new ArrayList<Comision>();
		this.listaDocentes = new ArrayList<Docente>();
		this.listaCorrelativas = new ArrayList<Materia>();
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

	public void eliminarCicloLectivo(CicloLectivo cicloLectivo) {
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

	public Boolean agregarCicloLectivo(CicloLectivo cicloLectivo) {
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
		for (CicloLectivo cicloLectivo : listaCicloLectivo) {
			if (cicloLectivo.getFechaFin().isAfter(fechaInicio) || cicloLectivo.getFechaFin().equals(fechaInicio))
				return true;

		}
		return false;
	}

	private boolean chequearCicloPorId(Integer id) {
		for (CicloLectivo cicloLectivo : listaCicloLectivo) {
			if (cicloLectivo.getId().equals(id))
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

	// El mismo docente no puede ser profesor de la misma comisión 2 veces.
	public Docente asignarDocenteAComision(Comision comision, Docente docente) {

		if (!comision.getDocente().getDni().equals(docente.getDni()))
			comision.setDocente(docente);
		return comision.getDocente();

	}

	public Boolean agregarCorrelatividad(Integer idMateria, Integer idCorrelativa) {
		for (Materia materia : listadoDeMaterias) {
			if (materia.getId().equals(idMateria) && materia.getIdCorrelativa() != null
					&& materia.getIdCorrelativa().equals(idCorrelativa))
				return listaCorrelativas.add(materia);
		}
		return false;
	}

	public Boolean asignarAlumnoEnComision(Alumno alumno1, Comision comision) {
		// TODO Auto-generated method stub
		return comision.agregarAlumno(alumno1);
	}

	public Boolean asignarAulaEnComision(Integer idComision, Integer dniDocente) {
		Boolean aulaAsignada = false;
		if (existeComision(idComision) && existeDocente(dniDocente))
			aulaAsignada = true;
		return aulaAsignada;
	}

	private boolean existeComision(Integer idComision) {
		for (Comision comisiones : listaComisiones) {
			if (comisiones.getIdComision().equals(idComision))
				return true;
		}
		return false;

	}

	private boolean existeDocente(Integer dniDocente) {
		for (Docente docentes : listaDocentes) {
			if (docentes.getDni().equals(dniDocente))
				return true;
		}
		return false;

	}

	private Integer cantidadDeDocentesPorComision(Comision comision) {
		Integer cantidadDocentes = 0;
		if (comision.getListaAlumnosComision().size() < 20)
			cantidadDocentes++;
		else if (comision.getListaAlumnosComision().size() > 20 && comision.getListaAlumnosComision().size() < 40) {
			cantidadDocentes++;
			cantidadDocentes++;
		}

		else {
			cantidadDocentes++;
			cantidadDocentes++;
			cantidadDocentes++;
		}

		return cantidadDocentes;
	}

	public Integer asignarDocentesAComision(Comision comision, Docente docente1, Docente docente2, Docente docente3) {
		if (cantidadDeDocentesPorComision(comision) == 1)
			comision.agregarDocente(docente1);
		
		else if (cantidadDeDocentesPorComision(comision) == 2) {
			comision.getCantidadDocentes().clear();
			comision.agregarDocente(docente1);
			comision.agregarDocente(docente2);
		}

		else if (cantidadDeDocentesPorComision(comision) == 3) {
			comision.getCantidadDocentes().clear();
			comision.agregarDocente(docente1);
			comision.agregarDocente(docente2);
			comision.agregarDocente(docente3);
		}
		return comision.getCantidadDocentes().size();

	}

}
