package com.personas.persistencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personas.persistencia.entidad.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer> {

}
