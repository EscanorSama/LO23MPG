package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Empleado;
import com.example.demo.entities.Tarea;

public interface TareaRepo extends JpaRepository<Tarea, Long>{
	public List<Tarea> findByEstado(String estado);
	public List<Tarea> findByEmpleado(Empleado empleado);
}
