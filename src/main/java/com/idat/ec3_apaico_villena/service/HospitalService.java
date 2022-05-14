package com.idat.ec3_apaico_villena.service;

import java.util.List;

import com.idat.ec3_apaico_villena.dto.HospitalRequestDTO;
import com.idat.ec3_apaico_villena.model.Hospital;

public interface HospitalService {

	public void guardarHospital(HospitalRequestDTO p);

	public void eliminarHospital(Integer id);

	public void editarHospital(Hospital c);

	public List<Hospital> listarHospital();

	public Hospital hospitalById(Integer id);

}
