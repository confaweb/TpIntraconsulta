package ar.edu.unlam.dominioIntraconsulta;

import java.util.ArrayList;

public class Universidad {

	private String nombreInstitucion;
	private ArrayList<Alumno> registroAlumnos;
	private ArrayList<Materia> listadoDeMaterias;

	public Universidad(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
		this.registroAlumnos = new ArrayList<Alumno>();
		this.listadoDeMaterias = new ArrayList<Materia>();
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

	public Boolean ingresarAlumno(Alumno alumno1,Integer dni) {

		if (this.buscarAlumnoPorDni(dni) == null) {
			registroAlumnos.add(alumno1);

		}

		return registroAlumnos.add(alumno1);

	}

	private Alumno buscarAlumnoPorDni(Integer dni) {
		for (Alumno alumno : registroAlumnos) {
			if (alumno.getDni().equals(dni) == true)
				return alumno;

		}
		return null;
	}

	public void agregarMateria(Materia materia) {

		if (!listadoDeMaterias.contains(materia))
			listadoDeMaterias.add(materia);

		// TODO Auto-generated method stub

	}

	public boolean materiaAgregada(Materia materia) {
		// TODO Auto-generated method stub
		return listadoDeMaterias.contains(materia);
	}

//	private boolean verificarMateriaPorId(Integer id) {
//		
//		return false;
//	}

//	private boolean chequearAlumnoExistentexDni(Alumno alumno1) {
//		Boolean repetido = false;
//
//		for (Alumno alumno : registroAlumnos) {
//
//			if (this.registroAlumnos.contains(alumno1))
//				repetido = true;
//		}
//		return repetido;
//	}

}
