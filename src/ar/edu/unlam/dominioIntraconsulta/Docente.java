package ar.edu.unlam.dominioIntraconsulta;

import java.util.Objects;

public class Docente {

	private Integer dni;
	private String nombredocente;

	public Docente(Integer dni, String nombreDocente) {
		this.dni=dni;
		this.nombredocente=nombreDocente;
	}

	public String getNombredocente() {
		return nombredocente;
	}

	public void setNombredocente(String nombredocente) {
		this.nombredocente = nombredocente;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
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
		Docente other = (Docente) obj;
		return Objects.equals(dni, other.dni);
	}

}
