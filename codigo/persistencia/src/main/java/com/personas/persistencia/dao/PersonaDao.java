package com.personas.persistencia.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.personas.persistencia.entidad.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer> {

	@Query("SELECT p FROM PERSONA p WHERE p.tipoDocumento.codTipoDocumento = :codTipoDocumento AND p.numeroDocumento = :numeroDocumento AND p.paisNacionalidad.codPais = :codPaisNacionalidad AND p.sexo.codSexo = :codSexo  ")
	Persona find(@Param("codTipoDocumento") String codTipoDocumento, @Param("numeroDocumento")  String numeroDocumento, @Param("codPaisNacionalidad")  String codPaisNacionalidad, @Param("codSexo")  String codSexo);

}
