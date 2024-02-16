package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdPelicula")
	private int id;
	@Column(name="Titulo")
	private String titulo;
	@Column(name="Descripcion")
	private String descripcion;
	@Column(name="Duracion")
	private String duracion;
	@Column(name="Puntuacion")
	private Double puntuacion;
	@Column(name="Genero")
	private String genero;
	@Column(name="FechaEstreno")
	private Date fechaEstreno;
	@Column(name="Director")
	private String director;
	@Column(name="Actores")
	private String actores;
	@Column(name="Compania")
	private String compania;
	@Column(name="FechaVisualizacion")
	private Date FechaVisualizacion;
	@Column(name="ValoracionUsuario")
	private int valoracionUsuario;
	@Column(name="Cartel")
	private String cartel ;
	@Column(name="LocalizacionPelicula")
	private String LocalizacionPelicula;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActores() {
		return actores;
	}
	public void setActores(String actores) {
		this.actores = actores;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public Date getFechaVisualizacion() {
		return FechaVisualizacion;
	}
	public void setFechaVisualizacion(Date fechaVisualizacion) {
		FechaVisualizacion = fechaVisualizacion;
	}
	public int getValoracionUsuario() {
		return valoracionUsuario;
	}
	public void setValoracionUsuario(int valoracionUsuario) {
		this.valoracionUsuario = valoracionUsuario;
	}
	public String getCartel() {
		return cartel;
	}
	public void setCartel(String cartel) {
		this.cartel = cartel;
	}
	public String getLocalizacionPelicula() {
		return LocalizacionPelicula;
	}
	public void setLocalizacionPelicula(String localizacionPelicula) {
		LocalizacionPelicula = localizacionPelicula;
	}
	
	

}
