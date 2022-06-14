package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Empleado;
import com.example.demo.models.EmpleadoModel;


@Component
public class EmpleadoConverter {
	public Empleado modelToEntity(EmpleadoModel empleadoModel){
		Empleado empleado = new Empleado();
		empleado.setNombre(empleadoModel.getNombre());
		empleado.setApellidos(empleadoModel.getApellidos());
		empleado.setEmail(empleadoModel.getEmail());
		empleado.setContrasena(empleadoModel.getContrasena());
		return empleado;
	}
	public EmpleadoModel entityToModel(Empleado empleado){
		EmpleadoModel empleadoModel = new EmpleadoModel();
		empleadoModel.setNombre(empleado.getNombre());
		empleadoModel.setApellidos(empleado.getApellidos());
		empleadoModel.setEmail(empleado.getEmail());
		empleadoModel.setContrasena(empleado.getContrasena());
		return empleadoModel;
	}
}
