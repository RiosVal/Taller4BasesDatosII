package com.bezkoder.spring.jpa.postgresql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  
	  @Column(name = "nombre")
	  private String nombre;
	  
	  @Column (name = "apellido")
	  private String apellido;	
	  
	  @Column (name = "edad")
	  private Integer edad;
	  
	  @Column (name = "estado_civil")
	  private String estadoCivil;
	  
	  @Column (name = "estado_laboral")
	  private String estadoLaboral;
	  
	  @Column (name = "genero")
	  private String genero;
	  
	  @Column (name = "telefono")
	  private String telefono;
	  
	  public long getId() {
		  return id;
	  }
	  
	  public String getNombre() {
		  return nombre;
	  }
	  
	  public void setNombre(String nombre) {
		  this.nombre = nombre;
	  }
	  
	  public String getApellido() {
		  return apellido;
	  }
	  
	  public void setEdad(Integer edad) {
		  this.edad = edad;
	  }
	  
	  public Integer getEdad() {
		  return edad;
	  }
	  
	  public void setApellido(String apellido) {
		  this.apellido = apellido;
	  }	  
	  
	  public String getEstadoCivil() {
		  return estadoCivil;
	  }
	  
	  public void setEstadoCivil(String estadoCivil) {
		  this.estadoCivil = estadoCivil;
	  }

	  public String getEstadoLaboral() {
		  return estadoLaboral;
	  }
	  
	  public void setEstadoLaboral(String estadoLaboral) {
		  this.estadoLaboral = estadoLaboral;
	  }
	  
	  public String getGenero() {
		  return genero;
	  }
	  
	  public void setGenero(String genero) {
		  this.genero = genero;
	  }
	  
	  public String getTelefono() {
		  return telefono;
	  }
	  
	  public void setTelefono(String telefono) {
		  this.telefono = telefono;
	  }
	  
	  @Override
	  public String toString() {
		  return "Persona [id="+ id + " nombre=" + nombre + " apellido="+ apellido;
	  }
}
