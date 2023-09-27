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

	public void registrarNota1erParcial(Comision comision, Integer idalumno,Integer nota) {
		Alumno alumno = comision.getAlumnoByID(idalumno);
		Integer idmateriacursando = comision.getMateria().getId();
		Materia materiacursando = alumno.getCursandoByID(idmateriacursando);
		materiacursando.setParcial1(nota);
	}
	
	public void registrarNota2doParcial(Comision comision, Integer idalumno,Integer nota) {
		Alumno alumno = comision.getAlumnoByID(idalumno);
		Integer idmateriacursando = comision.getMateria().getId();
		Materia materiacursando = alumno.getCursandoByID(idmateriacursando);
		materiacursando.setParcial2(nota);
	}
	
	public boolean registrarNota(Comision comision,Integer idalumno, Integer nota) {
		Alumno alumno = comision.getAlumnoByID(idalumno);
		Integer idmateriacursando = comision.getMateria().getId();
		Materia materiacursando = alumno.getCursandoByID(idmateriacursando);
		Integer idcorrelativa = materiacursando.getIdCorrelativa();
		Integer notaCorrelativa = alumno.getAprobadasByID(idcorrelativa).getNotaFinal();
		
		
		if(nota>0 && nota<=10 && notaCorrelativa>=7.0 && (materiacursando.getParcial1() >= 7) && (materiacursando.getParcial2() >=7) ) {
			materiacursando.registrarNota(nota);
			return true;
			
		}
		else return false;	
	}
	
	
	public boolean soloPuedeRecuperar1(Comision comision,Integer idalumno) {
		Alumno alumno = comision.getAlumnoByID(idalumno);
		Integer idmateriacursando = comision.getMateria().getId();
		Materia materiacursando = alumno.getCursandoByID(idmateriacursando);
		if((materiacursando.isRec1erparcial() == false) && (materiacursando.isRec2doparcial() == false)) {
			return true;
		}else return false;
	}
	
	
	public Materia getMateriaByID(Integer idmateria) {
		Materia found =null;
		for(Comision comision : listaComisiones) {
			if(comision.getMateria().getId().equals(idmateria)) {
				found = comision.getMateria();
			}
		}return found;
	}
	
	public boolean checkCorrelativasAprobadas(Integer idcorrelativa) {
		if(getMateriaByID(idcorrelativa).getNotaFinal()>=7.0) {
			return true;
		}else return false;
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
	
	public void agregarAlumno(Alumno alumno) {
		this.registroAlumnos.add(alumno);
	}

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
	
	private Alumno getAlumno(Integer id) {
		Alumno found = null ;
		for(Alumno alumno : registroAlumnos) {
			if(alumno.getDni().equals(id)) {
				found=alumno;
			}
		}
		return found;
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

	public Boolean asignarAlumnoEnComison(Alumno alumno1,Comision comision) {
		// TODO Auto-generated method stub
		return comision.agregarAlumno(alumno1);
	}

}
