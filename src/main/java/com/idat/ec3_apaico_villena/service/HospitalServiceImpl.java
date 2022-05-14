package com.idat.ec3_apaico_villena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec3_apaico_villena.dto.HospitalRequestDTO;
import com.idat.ec3_apaico_villena.model.Hospital;
import com.idat.ec3_apaico_villena.repository.HospitalRepository;



@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository repository;
	
	@Override
	public void guardarHospital(HospitalRequestDTO p) {
		Hospital hospital = new Hospital();
		hospital.setIdHospital(p.getIdHospital());
		hospital.setNombre(p.getNombre());
		hospital.setDescripcion(p.getDescripcion());
		hospital.setDistrito(p.getDistrito());
		repository.save(hospital);
	}
	
	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void editarHospital(Hospital c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);
	}

	@Override
	public List<Hospital> listarHospital() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Hospital hospitalById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
