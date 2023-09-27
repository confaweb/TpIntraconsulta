package ar.edu.unlam.Testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unlam.dominioIntraconsulta.Alumno;

import ar.edu.unlam.dominioIntraconsulta.CicloLectivo;
import ar.edu.unlam.dominioIntraconsulta.Comision;
import ar.edu.unlam.dominioIntraconsulta.Docente;
import ar.edu.unlam.dominioIntraconsulta.Materia;
import ar.edu.unlam.dominioIntraconsulta.PeriodoDeInscripcion;
import ar.edu.unlam.dominioIntraconsulta.Turno;
import ar.edu.unlam.dominioIntraconsulta.Universidad;

public class TddIntraconsulta {

	@Test
	public void queSePuedaInscribirUnAlumnoALaUniverdidad() {

		// Entrada
		String nombreInstitucion = "UniversidadBuenosAires";
		String nombre = "Pedro";
		String apellido = "Perez";
		Integer dni = 1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.of(2020, Month.MARCH, 01);

		// Proceso
		Universidad uba = new Universidad(nombreInstitucion);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		Boolean vo = uba.ingresarAlumno(alumno1, dni);
		// Salida-
		assertTrue(vo);
	}

	@Test
	public void queSePuedaCalcularEdadAlumno() {

		// Entrada

		String nombre = "Pedro";
		String apellido = "Perez";
		Integer dni = 1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.of(2020, Month.MARCH, 01);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		// Proceso
		alumno1.calcularEdad();
		// Salida-
		assertEquals(alumno1.calcularEdad(), 28, 0.01);
	}

	@Test
	public void queNoSePuedaInscribirDosAlumnosRepetidosALaUniverdidad() {

		// Entrada
		String nombreInstitucion = "UniversidadBuenosAires";
		Universidad uba = new Universidad(nombreInstitucion);
		String nombre = "Pedro";
		String apellido = "Perez";
		Integer dni = 1111;
		Integer dni2 = 1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.of(2020, Month.MARCH, 01);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		Alumno alumno2 = new Alumno(nombre, apellido, dni2, fechaNacimiento, fechaIngreso);

		// Proceso
		uba.limpiarRegistroAlumnos();
		Boolean vo = uba.ingresarAlumno(alumno1, dni);
		Boolean vo1 = uba.ingresarAlumno(alumno2, dni2);
		// Salida-Validacion
		assertFalse(vo1);
	}

	@Test
	public void queNoSePuedaAgregarMateriaConMismoId() {
		// Entrada-Preparacion

		String nombre = "Desarrollo 1";
		String nombre2 = "Desarrolo 2";
		Integer id = 0001;
		Integer id2 = 0001;
		String nombreInstitucion = "UniversidadBuenosAires";

		// Proceso
		Materia materia1 = new Materia(nombre, id);
		Materia materia2 = new Materia(nombre2, id2);
		Universidad uba = new Universidad(nombreInstitucion);

		Boolean vo = uba.agregarMateria(materia1);
		Boolean vo1 = uba.agregarMateria(materia2);
		// Salida-Validacion
		assertTrue(vo);
		assertFalse(vo1);
	}

	@Test
	public void QueNoSePuedaAgregardosCiclosLectivosMismoId() {// con ArrayList (@Overwrite hashcode +
																// equals-->.contains(object)
		// Preparacion-Entrada
		String nombreInstitucion = "UniversidadBuenosAires";
		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		LocalDate fechaInicio2 = LocalDate.of(2022, 8, 01);
		LocalDate fechaFin2 = LocalDate.of(2022, 12, 01);
		Integer id = 11111;
		Integer id2 = 11111;

		// Proceso
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);
		CicloLectivo cicloLectivo2 = new CicloLectivo(id2, fechaInicio2, fechaFin2);

		Universidad uba = new Universidad(nombreInstitucion);
		Boolean vo = uba.agregarCicloLectivo(cicloLectivo);
		Boolean vo2 = uba.agregarCicloLectivo(cicloLectivo2);

		// Ejeccucion-Salida
		assertTrue(vo);
		assertFalse(vo2);
	}

	@Test
	public void QueNoSePuedaAgregardosCiclosLectivosRangoDeFechaSuperpuesta() {// con ArraytList (@Overwrite hashcode +
																				// equals-->.)LocalDate.isBefore/isAfter
		// Preparacion-Entrada
		String nombreInstitucion = "UniversidadBuenosAires";
		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		LocalDate fechaInicio2 = LocalDate.of(2022, 07, 01);
		LocalDate fechaFin2 = LocalDate.of(2022, 12, 01);
		Integer id = 11111;
		Integer id2 = 22222;

		// Proceso
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);
		CicloLectivo cicloLectivo2 = new CicloLectivo(id2, fechaInicio2, fechaFin2);

		Universidad uba = new Universidad(nombreInstitucion);

		Boolean vo = uba.agregarCicloLectivo(cicloLectivo);
		Boolean vo2 = uba.agregarCicloLectivo(cicloLectivo2);

		// Ejeccucion-Salida
		assertTrue(vo);
		assertFalse(vo2);
	}

	@Test
	public void QueNoSePuedagenerarDosComisionesParaMismaMateriaCicloLectivoYTurno() {// con ArraytList (@Overwrite
																						// hashcode +
																						// equals-->.)LocalDate.isBefore/isAfter
		// Preparacion-Entrada
		String nombreInstitucion = "UniversidadBuenosAires";

		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		LocalDate fechaInicio2 = LocalDate.of(2022, 07, 03);
		LocalDate fechaFin2 = LocalDate.of(2022, 12, 01);
		Integer id = 11111;
		Integer id2 = 22222;

		String nombre = "Desarrollo 1";
		String nombre2 = "Desarrolo 2";
		Integer idMateria = 0001;
		Integer idMateria2 = 0002;

		Integer dni = 12345;
		Integer dni2 = 54321;
		String nombreDocente = "Juan";
		String nombreDocente2 = "Pedro";

		Turno turno = Turno.TARDE;
		Turno turno2 = Turno.TARDE;
		Integer idComision = null;
		Integer idComision2 = null;

		// Proceso
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);
		CicloLectivo cicloLectivo2 = new CicloLectivo(id2, fechaInicio2, fechaFin2);

		Docente docente = new Docente(dni, nombreDocente);
		Docente docente2 = new Docente(dni2, nombreDocente2);

		Materia materia = new Materia(nombre, idMateria);
		Materia materia2 = new Materia(nombre2, idMateria2);

		ArrayList<Alumno> listadoAlumnosDeLaComision = new ArrayList<Alumno>();
		Comision comision = new Comision(idComision,cicloLectivo, docente, turno, materia, listadoAlumnosDeLaComision);
		Comision comision2 = new Comision(idComision2,cicloLectivo2, docente2, turno2, materia2, listadoAlumnosDeLaComision);

		Universidad uba = new Universidad(nombreInstitucion);

		Boolean vo = uba.agregarComision(comision);
		Boolean vo2 = uba.agregarComision(comision2);

		// Ejeccucion-Salida
		assertTrue(vo);
		assertFalse(vo2);
	}

	@Test
	public void queNoSePuedaAgregarDosDocentesconElMismoDni() {
//		Preparacion-Entrada
		String nombreInstitucion = "UniversidadBuenosAires";

		Integer dni = 12345;
		Integer dni2 = 12345;
		String nombreDocente = "Juan";
		String nombreDocente2 = "Pedro";

//		Proceso
		Docente docente = new Docente(dni, nombreDocente);
		Docente docente2 = new Docente(dni2, nombreDocente2);

		Universidad uba = new Universidad(nombreInstitucion);

		Boolean vo = uba.agregarDocente(docente);
		Boolean vo2 = uba.agregarDocente(docente2);

//		Validacion-Salida
		assertTrue(vo);
		assertFalse(vo2);
	}

	@Test
	public void queSePuedaAsignarDocenteAUnaComision() {
//		Preparacion-Entrada
		String nombreInstitucion = "UniversidadBuenosAires";

		Integer dni = 12345;
		Integer dni2 = 54321;
		String nombreDocente = "Juan";
		String nombreDocente2 = "Pedro";

		String nombre = "Desarrollo 1";
		Integer idMateria = 0001;

		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		Integer id = 11111;

		Turno turno = Turno.TARDE;
		Integer idComision = null;
//		Proceso
		Docente docente = new Docente(dni, nombreDocente);
		Docente docente2 = new Docente(dni2, nombreDocente2);

		Materia materia = new Materia(nombre, idMateria);
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);

		ArrayList<Alumno> listadoAlumnosDeLaComision = new ArrayList<Alumno>();
		Comision comision = new Comision(idComision,cicloLectivo, docente, turno, materia, listadoAlumnosDeLaComision);

		Universidad uba = new Universidad(nombreInstitucion);

		uba.agregarComision(comision);

		Docente vo = uba.asignarDocenteAComision(comision, docente2);
		Docente ve = docente2;

//		Validacion-Salida
		assertEquals(ve, vo);

	}

	/*
	 * agregarCorrelatividad(idMateria, idCorrelativa)
	 * 
	 */
	@Test
	public void QueSePuedaAgregarCorrelatividad() {//// Se debe validar que ambos códigos existan en una materia
		// Preparacion-Entrada
		String nombreInstitucion = "UniversidadBuenosAires";

		String nombre = "Desarrollo 1";
		String nombre2 = "Desarrolo 2";
		Integer idMateria = 0001;
		Integer idCorrelativa = 0002;
		Integer idMateria2 = 0002;
		Integer idCorrelativa2 = null;

		// Proceso
		Universidad uba = new Universidad(nombreInstitucion);

		Materia materia = new Materia(nombre, idMateria, idCorrelativa);
		uba.agregarMateria(materia);
		Materia materia2 = new Materia(nombre2, idMateria2);
		uba.agregarMateria(materia2);

		Boolean vo = uba.agregarCorrelatividad(idMateria, idCorrelativa);
		Boolean vo2 = uba.agregarCorrelatividad(idMateria2, idCorrelativa2);

		// Ejeccucion-Salida
		assertTrue(vo);
		assertFalse(vo2);
	}

	@Test
	public void QueLaUniversidadAsigneAlumnosAUnaComisionSoloDuranteFechaDeInscripcion() {
		// Preparacion- Entrada
		// UNIVERSIDAD-ALUMNO--COMISION-PERIODO DE INSCRIPCION
		String nombreInstitucion = "UniversidadBuenosAires";
		String nombre = "Pedro";
		String apellido = "Perez";
		Integer dni = 1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.of(2020, Month.MARCH, 01);

		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		Integer id = 11111;

		String nombreMat = "Desarrollo 1";
		Integer idMateria = 0001;

		Integer dniDocente = 12345;
		String nombreDocente = "Juan";

		Turno turno = Turno.TARDE;
		Integer idComision = null;

		Integer idCicloLectivo = 2024_1;
		LocalDate fechaInicioInscr = LocalDate.of(2024, 03, 03);
		LocalDate FechaFinInscr = LocalDate.of(2024, 03, 9);
		// Proceso
		PeriodoDeInscripcion fechaInncripicon = new PeriodoDeInscripcion(idCicloLectivo, fechaInicioInscr,
				FechaFinInscr);
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);
		Docente docente = new Docente(dniDocente, nombreDocente);
		Materia materia = new Materia(nombreMat, idMateria);
		ArrayList<Alumno> listadoAlumnosDeLaComision = new ArrayList<Alumno>();
		Comision comision = new Comision(idComision,cicloLectivo, docente, turno, materia, listadoAlumnosDeLaComision);
		Universidad uba = new Universidad(nombreInstitucion);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaNacimiento, fechaIngreso);

		Boolean ve = uba.asignarAlumnoEnComision(alumno1, comision);

		// Ejecucion-Salida

		assertTrue(ve);
	}
	/*
	 * asignarAulaAlaComision(idComision, dniDocente)
// verificar que exista la comisión y el docente
//Cada 20 alumnos se debe agregar un docente ejemplo de 1 a 20 alumnos solo se puede asignar un docente, de 21 a 40 2 docentes
	 */
	@Test
	public void QueSePuedaAsignarUnAulaALaComision() {
		// Preparacion- Entrada
		
		String nombreInstitucion = "UniversidadBuenosAires";
		String nombre = "Pedro";
		String apellido = "Perez";
		Integer dni = 1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.of(2020, Month.MARCH, 01);

		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		Integer id = 11111;

		String nombreMat = "Desarrollo 1";
		Integer idMateria = 0001;

		Integer dniDocente = 12345;
		Integer dniDocente2=54321;
		String nombreDocente = "Juan";

		Turno turno = Turno.TARDE;
		Integer idComision = 1111;

		Integer idCicloLectivo = 2024_1;
		LocalDate fechaInicioInscr = LocalDate.of(2024, 03, 03);
		LocalDate FechaFinInscr = LocalDate.of(2024, 03, 9);
		// Proceso
		PeriodoDeInscripcion fechaInncripicon = new PeriodoDeInscripcion(idCicloLectivo, fechaInicioInscr,FechaFinInscr);
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);
		Docente docente = new Docente(dniDocente, nombreDocente);
		Materia materia = new Materia(nombreMat, idMateria);
		ArrayList<Alumno> listadoAlumnosDeLaComision = new ArrayList<Alumno>();
		Comision comision = new Comision(idComision,cicloLectivo, docente, turno, materia, listadoAlumnosDeLaComision);
		Universidad uba = new Universidad(nombreInstitucion);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		
		uba.agregarDocente(docente);// solo se agregó el elemento "docente" en la lista.
		uba.agregarComision(comision);

		Boolean ve = uba.asignarAulaEnComision(idComision, dniDocente);
		Boolean ve1 = uba.asignarAulaEnComision(idComision, dniDocente2);// al no existir elelemento "docente2" en la lista NO SE ASIGNA AULA PARA LA COMISION.

		// Ejecucion-Salida

		assertTrue(ve);
		assertFalse(ve1);
	}
	@Test
	public void QueSeAsignerUnDocenteCada20Alumnos() {
		// Preparacion- Entrada
		
		String nombreInstitucion = "UniversidadBuenosAires";
		String nombre = "Pedro";
		String apellido = "Perez";
		Integer dni = 1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		LocalDate fechaIngreso = LocalDate.of(2020, Month.MARCH, 01);

		LocalDate fechaInicio = LocalDate.of(2022, 03, 01);
		LocalDate fechaFin = LocalDate.of(2022, 07, 01);
		Integer id = 11111;

		String nombreMat = "Desarrollo 1";
		Integer idMateria = 0001;

		Integer dniDocente = 12345;
		Integer dniDocente2=54321;
		Integer dniDocente3=45678;
		String nombreDocente = "Juan";
		String nombreDocente2 = "Pedro";
		String nombreDocente3 = "Manuel";

		Turno turno = Turno.TARDE;
		Integer idComision = 1111;

		Integer idCicloLectivo = 2024_1;
		LocalDate fechaInicioInscr = LocalDate.of(2024, 03, 03);
		LocalDate FechaFinInscr = LocalDate.of(2024, 03, 9);
		// Proceso
		PeriodoDeInscripcion fechaInncripicon = new PeriodoDeInscripcion(idCicloLectivo, fechaInicioInscr,FechaFinInscr);
		CicloLectivo cicloLectivo = new CicloLectivo(id, fechaInicio, fechaFin);
		Docente docente = new Docente(dniDocente, nombreDocente);
		Docente docente2 = new Docente(dniDocente2, nombreDocente2);
		Docente docente3 = new Docente(dniDocente3, nombreDocente3);
		Materia materia = new Materia(nombreMat, idMateria);
		ArrayList<Alumno> listadoAlumnosDeLaComision = new ArrayList<Alumno>();
		Comision comision = new Comision(idComision,cicloLectivo, docente, turno, materia, listadoAlumnosDeLaComision);
		Universidad uba = new Universidad(nombreInstitucion);
		Alumno alumno1 = new Alumno(nombre, apellido, dni, fechaNacimiento, fechaIngreso);
		
		//Caso cantidad de alumnos < 20.
		comision.simularCantidadDeAlumnos(12);// Simula cantidad de alumnos en una comision
		uba.asignarDocentesAComision(comision, docente, docente2, docente3);
		
		Integer vo_menosDe20Alumnos = comision.getCantidadDocentes().size();
		Integer ve_menosDe20Alumnos = 1;
		
		// Ejecucion-Salida1
		
		assertEquals(vo_menosDe20Alumnos,ve_menosDe20Alumnos);
		
		
		//Caso cantidad de alumnos > 20.
		comision.simularCantidadDeAlumnos(22);// Simula cantidad de alumnos en una comision
		uba.asignarDocentesAComision(comision, docente, docente2, docente3);
		Integer vo_masDe20Alumnos = comision.getCantidadDocentes().size();
		Integer ve_masDe20Alumnos  = 2;
		
		// Ejecucion-Salida2
		
		assertEquals(vo_masDe20Alumnos,ve_masDe20Alumnos);
		
		//Caso cantidad de alumnos > 40.
		comision.simularCantidadDeAlumnos(42);// Simula cantidad de alumnos en una comision
		uba.asignarDocentesAComision(comision, docente, docente2, docente3);//Agrega Docente  a la comision por parametro según cantidad de alumnos
	
		Integer vo_masDe40Alumnos = comision.getCantidadDocentes().size();
		Integer ve_masDe40Alumnos = 3;
		
		assertEquals(vo_masDe40Alumnos,ve_masDe40Alumnos);

		
		
	}
}
