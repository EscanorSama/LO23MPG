package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converters.TareaConverter;
import com.example.demo.entities.Empleado;
import com.example.demo.entities.Tarea;
import com.example.demo.models.TareaModel;
import com.example.demo.repositories.TareaRepo;

@Service
public class TareaService {
	Logger LOG = Logger.getLogger(TareaService.class.getCanonicalName());
	
	@Autowired
	private TareaConverter tareaConverter;
	@Autowired
	private TareaRepo tareaRepo;
	
	public void anadirTask(TareaModel tareaModel) throws Exception
	{
		String estado = tareaModel.getEstado();
		if((estado.equals(("progresando")) || estado.equals(("pendiente")) || estado.equals(("acabada")))){
		Tarea tarea = tareaConverter.modelToEntity(tareaModel);
		tareaRepo.save(tarea);
		}
	}
	
	public List<TareaModel> getTareasEmpleado(String email){
		List<Tarea> tareas = new ArrayList<>();
		List<TareaModel> tareasModel = new ArrayList<>();
		Empleado empleado = new Empleado();
		empleado.setEmail(email);
		tareas = tareaRepo.findByEmpleado(empleado);
		for (Tarea tarea:tareas) {
			tareasModel.add(tareaConverter.entityToModel(tarea));
		}
		return tareasModel;
	}
	public List<TareaModel> getTareas()
	{
		List<Tarea> tareas = tareaRepo.findAll();
		List<TareaModel> tareasModel = new ArrayList<>();
		for (Tarea tarea:tareas){
			tareasModel.add(tareaConverter.entityToModel(tarea));
		}
		return tareasModel;
	}
	public List<TareaModel> getTareaEstado(String estado) throws Exception
	{

		List<Tarea> tasks = tareaRepo.findByEstado(estado);
		List<TareaModel> taskModel = new ArrayList<>();
		for (Tarea task:tasks){
			taskModel.add(tareaConverter.entityToModel(task));
		}
		return taskModel;
	}
	public void cambioEstado(long id , String estado) throws Exception
	{
		if(estado.equals("progresando") || estado.equals("pendiente") || estado.equals("acabada")){
		Optional<Tarea> tareaNueva = tareaRepo.findById(id);
		Tarea tarea = tareaNueva.get();
		tarea.setEstado(estado);
		tareaRepo.save(tarea);
		}
		
	}
	
	public Optional<TareaModel> eliminarTarea(long id){
		Optional<TareaModel> tareaResult = Optional.empty();
		Optional<Tarea> idTarea = tareaRepo.findById(id);
		if(idTarea.isPresent()) {
			Tarea tarea = idTarea.get();
			TareaModel tareaModel = tareaConverter.entityToModel(tarea);
			tareaResult = Optional.of(tareaModel);
			tareaRepo.delete(tarea);
		}
		return tareaResult;
	}
}
