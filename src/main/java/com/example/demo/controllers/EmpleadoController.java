package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.services.EmpleadoService;

@RestController
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping(path = "/empleado")
	public void postEmpleado(@RequestBody EmpleadoModel empleadoModel) {
		empleadoService.anadirEmpleado(empleadoModel);
	}
	
	@GetMapping(path="/empleados")
	public List<EmpleadoModel> getEmpleado(){
		return empleadoService.getEmpleados();
	}
	
	
}
