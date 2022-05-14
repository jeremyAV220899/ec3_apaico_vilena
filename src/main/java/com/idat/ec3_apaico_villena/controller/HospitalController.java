package com.idat.ec3_apaico_villena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec3_apaico_villena.dto.HospitalRequestDTO;
import com.idat.ec3_apaico_villena.model.Hospital;
import com.idat.ec3_apaico_villena.service.HospitalService;

@RestController
@RequestMapping("/hospital/v1")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<Hospital>>listar(){
		
		return new ResponseEntity<List<Hospital>>(service.listarHospital(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody HospitalRequestDTO hospital){
		service.guardarHospital(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Hospital> clientsById(@PathVariable Integer id){
		Hospital hospital = service.hospitalById(id);
		if(hospital != null) {
			return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);

		}
		return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Hospital hospital = service.hospitalById(id);
		if(hospital != null) {
			service.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Hospital hospitals){
		Hospital hospital = service.hospitalById(hospitals.getIdHospital());
		if(hospital != null) {
			service.editarHospital(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
