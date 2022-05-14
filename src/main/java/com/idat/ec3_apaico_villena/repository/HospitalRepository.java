package com.idat.ec3_apaico_villena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec3_apaico_villena.model.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
