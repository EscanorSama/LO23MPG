package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TareaModel;
import com.example.demo.services.TareaService;



@RestController
public class TareaController {
	
	@Autowired
	private TareaService tareaService;
	
	@GetMapping(path = "/tareas")
	public List<TareaModel> getTareas() throws Exception{
		return tareaService.getTareas();
	}
	
	@GetMapping(path="/tarea/estado/{estado}")
	public List<TareaModel> getTareaEstado (@PathVariable(name="estado") String estado) throws Exception{
		return tareaService.getTareaEstado(estado);
	}
	
	@GetMapping (path = "/tareas/empleado/{email}")
	public List <TareaModel> getTareasEmpleado(@PathVariable(name="email") String email){
		return tareaService.getTareasEmpleado(email);
	}
	
	@PostMapping (path = "/tarea")
	public void postTarea(@RequestBody TareaModel tareaModel) throws Exception{
		tareaService.anadirTask(tareaModel);
	}
	
	@DeleteMapping(path = "/tarea/{id}")
	public void deleteTarea(@PathVariable(name = "id") long id) {
		tareaService.eliminarTarea(id);
	}
	
	@PutMapping (path="/tarea/{id}")
	public void cambioEstados(@PathVariable(name = "id") long id, @RequestParam(name = "estado", required = true) String estado) throws Exception{
		tareaService.cambioEstado(id, estado);
	}
	
}
