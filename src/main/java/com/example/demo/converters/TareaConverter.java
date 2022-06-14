package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Empleado;
import com.example.demo.entities.Tarea;
import com.example.demo.models.TareaModel;


@Component
public class TareaConverter {
	public Tarea modelToEntity(TareaModel tareaModel){
		Tarea tarea = new Tarea();
		tarea.setId(tareaModel.getId());
		tarea.setTitulo(tareaModel.getTitulo());
		tarea.setFecha(tareaModel.getFecha());
		tarea.setEstado(tareaModel.getEstado());
		tarea.setDescripcion(tareaModel.getDescripcion());
		Empleado empleado = new Empleado();
		empleado.setEmail(tareaModel.getEmail());
		tarea.setEmpleado(empleado);
		return tarea;
	}
	public TareaModel entityToModel (Tarea tarea){
		TareaModel tareaModel = new TareaModel();
		tareaModel.setId(tarea.getId());
		tareaModel.setTitulo(tarea.getTitulo());
		tareaModel.setFecha(tarea.getFecha());
		tareaModel.setEstado(tarea.getEstado());
		tareaModel.setDescripcion(tarea.getDescripcion());
		Empleado empleado = tarea.getEmpleado();
		tareaModel.setEmail(empleado.getEmail());
		return tareaModel;
	}
}
