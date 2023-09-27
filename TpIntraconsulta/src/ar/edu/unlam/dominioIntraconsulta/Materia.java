package ar.edu.unlam.dominioIntraconsulta;

import java.util.Objects;

public class Materia {

	private String nombre;
	private Integer id;
	private Integer idCorrelativa;
	private Integer parcial1;
	private Integer parcial2;
	private Integer Rec1Parcial;
	private Integer Rec2Parcial;
	private Integer notafinal;
	private boolean rec1erparcial=false;
	private boolean rec2doparcial=false;
	

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
	
	public void registrarNota(Integer nota) {
		this.notafinal=nota;
	}
	
	public Integer getNotaFinal() {
		return this.notafinal;
	}
	

	public boolean isRec1erparcial() {
		return rec1erparcial;
	}
	public void setRec1erparcial(boolean rec1erparcial) {
		this.rec1erparcial = rec1erparcial;
	}
	public boolean isRec2doparcial() {
		return rec2doparcial;
	}
	public void setRec2doparcial(boolean rec2doparcial) {
		this.rec2doparcial = rec2doparcial;
	}
	public Integer getIdCorrelativa() {
		return idCorrelativa;
	}
	public void setIdCorrelativa(Integer idCorrelativa) {
		this.idCorrelativa = idCorrelativa;
	}
	
	public Integer getParcial1() {
		return parcial1;
	}
	public void setParcial1(Integer parcial1) {
		this.parcial1 = parcial1;
	}
	public Integer getParcial2() {
		return parcial2;
	}
	public void setParcial2(Integer parcial2) {
		this.parcial2 = parcial2;
	}
	public Integer getRec1Parcial() {
		return Rec1Parcial;
	}
	public void setRec1Parcial(Integer rec1Parcial) {
		Rec1Parcial = rec1Parcial;
	}
	public Integer getRec2Parcial() {
		return Rec2Parcial;
	}
	public void setRec2Parcial(Integer rec2Parcial) {
		Rec2Parcial = rec2Parcial;
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
