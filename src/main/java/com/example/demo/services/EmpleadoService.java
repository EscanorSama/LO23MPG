package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converters.EmpleadoConverter;
import com.example.demo.entities.Empleado;
import com.example.demo.models.EmpleadoModel;
import com.example.demo.repositories.EmpleadoRepo;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoConverter empleadoConverter;
	@Autowired
	private EmpleadoRepo empleadoRepo;
	
	public List<EmpleadoModel> getEmpleados(){
		List<Empleado> empleados = empleadoRepo.findAll();
		List<EmpleadoModel> empleadosModel = new ArrayList<>();
		for(Empleado empleado:empleados){
			EmpleadoModel empleadoModel = empleadoConverter.entityToModel(empleado);
			empleadoModel.setContrasena("***********");
			empleadosModel.add(empleadoModel);
		}return empleadosModel;
	}
	
	public void anadirEmpleado(EmpleadoModel empleadoModel){
		Empleado empleado = empleadoConverter.modelToEntity(empleadoModel);
		empleadoRepo.save(empleado);
	}

}
