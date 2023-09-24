package ar.edu.unlam.dominioIntraconsulta;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class Universidad {

	private String nombreInstitucion;
	private ArrayList<Alumno> registroAlumnos;
	private ArrayList<Materia> listadoDeMaterias;
	private ArrayList<Ciclo> listaCicloLectivo;

	public Universidad(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
		this.registroAlumnos = new ArrayList<Alumno>();
		this.listadoDeMaterias = new ArrayList<Materia>();
		this.listaCicloLectivo = new ArrayList<Ciclo>();
	}

	public String getNombreInstitucion() {
		return nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	public void limpiarRegistroAlumnos() {
		registroAlumnos.clear();
	}

	public Boolean ingresarAlumno(Alumno alumno1, Integer dni) {

		if (!this.buscarAlumnoPorDni(dni))
			return registroAlumnos.add(alumno1);
		else
			return false;
	}

	private Boolean buscarAlumnoPorDni(Integer dni) {
		for (Alumno alumno : registroAlumnos) {
			if (alumno.getDni().equals(dni))
				return true;

		}
		return false;
	}

	public Boolean agregarMateria(Materia materia) {

		if (!chequearMateriaExistente(materia))
			return listadoDeMaterias.add(materia);
		else
			return false;

		// TODO Auto-generated method stub

	}

	private boolean chequearMateriaExistente(Materia materia) {
		return listadoDeMaterias.contains(materia);

	}

	public Boolean agregarCicloLectivo(Ciclo cicloLectivo) {
		if (!chequearCicloPorId(cicloLectivo.getId())&& !chequearSuperposicion(cicloLectivo.getFechaInicio()))
			return listaCicloLectivo.add(cicloLectivo);
		else
			return false;
	}

	private boolean chequearSuperposicion(LocalDate fechaInicio) {
		for (Ciclo ciclo : listaCicloLectivo) {
			if (ciclo.getFechaFin().isAfter(fechaInicio)||ciclo.getFechaFin().equals(fechaInicio))
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



}
