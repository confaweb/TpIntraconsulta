package ar.edu.unlam.Testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

import ar.edu.unlam.dominioIntraconsulta.Alumno;
import ar.edu.unlam.dominioIntraconsulta.Materia;
import ar.edu.unlam.dominioIntraconsulta.Universidad;

public class TddIntraconsulta {

	@Test
	public void queSePuedaInscribirUnAlumnoALaUniverdidad() {
		String nombreInstitucion="UniversidadBuenosAires";
		//Entrada
		Universidad uba = new Universidad(nombreInstitucion);
		String nombre="Pedro";
		String apellido="Perez";
		Integer dni=1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);		
		LocalDate fechaIngreso =LocalDate.of(2020,Month.MARCH,01);
		Alumno alumno1=new Alumno(nombre,apellido,dni,fechaNacimiento,fechaIngreso);
		//Proceso
		uba.limpiarRegistroAlumnos();
		uba.ingresarAlumno(alumno1,dni);
		//Salida-
		assertTrue(uba.ingresarAlumno(alumno1,dni));
	}
	@Test
	public void queSePuedaCalcularEdadAlumno() {
		
		//Entrada
		
		String nombre="Pedro";
		String apellido="Perez";
		Integer dni=1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);		
		LocalDate fechaIngreso =LocalDate.of(2020,Month.MARCH,01);
		Alumno alumno1=new Alumno(nombre,apellido,dni,fechaNacimiento,fechaIngreso);
		//Proceso
		alumno1.calcularEdad();
		//Salida-
		assertEquals(alumno1.calcularEdad(),28,0.01);
	}
	@Test
	public void queNoSePuedaInscribirDosAlumnosRepetidosALaUniverdidad() {
		
		//Entrada
		String nombreInstitucion="UniversidadBuenosAires";
		Universidad uba = new Universidad(nombreInstitucion);
		String nombre="Pedro";
		String apellido="Perez";
		Integer dni=1111;
		Integer dni2=1111;
		Integer anio = 1995;
		Month mes = Month.APRIL;
		Integer dia = 29;
		LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
		
		LocalDate fechaIngreso =LocalDate.of(2020,Month.MARCH,01);
		Alumno alumno1=new Alumno(nombre,apellido,dni,fechaNacimiento,fechaIngreso);
		Alumno alumno2=new Alumno(nombre,apellido,dni2,fechaNacimiento,fechaIngreso);
		
		//Proceso
		uba.limpiarRegistroAlumnos();
		uba.ingresarAlumno(alumno1,dni);
		uba.ingresarAlumno(alumno2,dni);
		//Salida-Validacion
		assertFalse(uba.ingresarAlumno(alumno2,dni));
	}
	@Test
	public void queNoSePuedaAgregarMateriaConMismoId() {
		//Entrada-Preparacion
		
		String nombre = "Desarrollo 1";
		String nombre2 = "Desarrolo 2";
		Integer id = 0001;
		Integer id2 = 0001;
		String nombreInstitucion="UniversidadBuenosAires";

		//Proceso
		Materia materia1=new Materia(nombre,id);		
		Materia materia2=new Materia(nombre2,id2);
		Universidad uba = new Universidad(nombreInstitucion);
		
		uba.agregarMateria(materia1);
		uba.materiaAgregada(materia1);
		uba.agregarMateria(materia2);
		uba.materiaAgregada(materia2);
		
		//Salida-Validacion
		
		assertFalse(uba.materiaAgregada(materia2));
	}

}
