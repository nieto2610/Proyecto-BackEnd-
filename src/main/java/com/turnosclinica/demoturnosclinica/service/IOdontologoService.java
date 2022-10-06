package com.turnosclinica.demoturnosclinica.service;

import com.turnosclinica.demoturnosclinica.model.Odontologo;
import com.turnosclinica.demoturnosclinica.model.OdontologoDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {
    public OdontologoDTO guardar(OdontologoDTO odontologoDTO);
    public Set<OdontologoDTO> listar();
    public OdontologoDTO buscar(Long id);
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO);
    public void eliminar(Long id);
}
