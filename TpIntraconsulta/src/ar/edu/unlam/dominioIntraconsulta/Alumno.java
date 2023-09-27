package ar.edu.unlam.dominioIntraconsulta;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

	private String nombre;
	private String apellido;
	private Integer dni;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIingreso;

	public Alumno(String nombre, String apellido, Integer dni, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.fechaNacimiento=fechaNacimiento;
		this.fechaIingreso=fechaIngreso;
	}

	public Alumno() {
		
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIingreso() {
		return fechaIingreso;
	}

	public void setFechaIingreso(LocalDate fechaIingreso) {
		this.fechaIingreso = fechaIingreso;
	}
	public Integer calcularEdad() {
		Integer edad= LocalDate.now().getYear()-this.fechaNacimiento.getYear();
		return edad;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaIingreso=" + fechaIingreso + "]";
	}

}
