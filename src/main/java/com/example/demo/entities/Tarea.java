package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="tarea")
public class Tarea {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="titulo", length = 50)
	private String titulo;
	
	@Column(name="descripcion", length = 150)
	private String descripcion;
	
	
	@ManyToOne
	@JsonManagedReference
	Empleado empleado;



	
}
