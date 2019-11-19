package com.personas.persistencia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personas.persistencia.entidad.TipoDocumento;


public interface TipoDocumentoDao extends JpaRepository<TipoDocumento, String> {

}
