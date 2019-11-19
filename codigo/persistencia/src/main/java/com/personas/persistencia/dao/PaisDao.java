package com.personas.persistencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personas.persistencia.entidad.Pais;

public interface PaisDao extends JpaRepository<Pais, String> {

}
