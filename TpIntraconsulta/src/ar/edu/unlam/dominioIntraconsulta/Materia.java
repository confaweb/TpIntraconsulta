package ar.edu.unlam.dominioIntraconsulta;

import java.util.Objects;

public class Materia {

	private String nombre;
	private Integer id;
	private Integer idCorrelativa;

	public Materia(String nombre, Integer id) {
		this.nombre=nombre;
		this.id=id;
	}
	public Materia(String nombre, Integer id,Integer idCorrelativa) {
		this.nombre=nombre;
		this.id=id;
		this.idCorrelativa=idCorrelativa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCorrelativa() {
		return idCorrelativa;
	}
	public void setIdCorrelativa(Integer idCorrelativa) {
		this.idCorrelativa = idCorrelativa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id);
	}

}
