package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Cancion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id_cancion;
	
	@Column(length = 32, nullable = false)
	private String Nombre;
	
	private Date Fecha;
	
	@Column(columnDefinition = "Text")
	private String Letra;
	
	private Integer Puntuacion;

	public Integer getId_cancion() {
		return Id_cancion;
	}

	public void setId_cancion(Integer id_cancion) {
		Id_cancion = id_cancion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getLetra() {
		return Letra;
	}

	public void setLetra(String letra) {
		Letra = letra;
	}

	public Integer getPuntuacion() {
		return Puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		Puntuacion = puntuacion;
	}
}
