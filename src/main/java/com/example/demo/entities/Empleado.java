package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="empleado")
public class Empleado {
	
	@Id
	@Column(name="email" , length = 200)
	private String email;
	
	@Column(name="contrasena", length = 50)
	private String contrasena;

	@Column(name="nombre" , length = 60)
	private String nombre;
	
	@Column(name="apellidos" , length = 100)
	private String apellidos;
	
	@OneToMany(mappedBy = "empleado")
	@JsonManagedReference
	private List<Tarea> tareas = new ArrayList<>();

	
	
}
