package ar.edu.unlam.Testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

import ar.edu.unlam.dominioIntraconsulta.Alumno;

import ar.edu.unlam.dominioIntraconsulta.Ciclo;
import ar.edu.unlam.dominioIntraconsulta.Comision;
import ar.edu.unlam.dominioIntraconsulta.Docente;
import ar.edu.unlam.dominioIntraconsulta.Materia;
import ar.edu.unlam.dominioIntraconsulta.Turno;
import ar.edu.unlam.dominioIntraconsulta.Universidad;

public class TddIntraconsulta {

	@Test
	public void queSePuedaInscribirUnAlumnoALaUniverdidad() {
		String nombreInstitucion = "UniversidadBuenosAires";
		// Entrada
		Universidad uba = new Universidad(nombreInstitucion);
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
		Ciclo cicloLectivo = new Ciclo(id, fechaInicio, fechaFin);
		Ciclo cicloLectivo2 = new Ciclo(id2, fechaInicio2, fechaFin2);

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
		Ciclo cicloLectivo = new Ciclo(id, fechaInicio, fechaFin);
		Ciclo cicloLectivo2 = new Ciclo(id2, fechaInicio2, fechaFin2);

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
		Integer id = 11111;
		String nombre = "Desarrollo 1";
		Integer idMateria = 0001;
		Integer dni=12345;
		String nombreDocente="Juan";
		Turno turno=Turno.MANIANA;
		Turno turno2=Turno.TARDE;

		// Proceso
		Ciclo cicloLectivo = new Ciclo(id, fechaInicio, fechaFin);
		Docente docente = new Docente(dni, nombreDocente);
		Materia materia = new Materia(nombre, idMateria);
		Comision comision = new Comision(cicloLectivo,turno, materia);
		

		Universidad uba = new Universidad(nombreInstitucion);
		uba.agregarCicloLectivo(cicloLectivo);
		uba.agregarMateria(materia);
		uba.agregarComision(comision);
		assertFalse(uba.agregarComision(comision));
		
	}

}
