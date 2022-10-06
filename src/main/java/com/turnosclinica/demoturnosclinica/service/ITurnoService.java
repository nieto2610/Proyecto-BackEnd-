package com.turnosclinica.demoturnosclinica.service;

import com.turnosclinica.demoturnosclinica.model.Turno;
import com.turnosclinica.demoturnosclinica.model.TurnoDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITurnoService {
    public TurnoDTO guardar(TurnoDTO turnoDTO);
    public Set<TurnoDTO> listar();
    public TurnoDTO buscar(Long id);
    public TurnoDTO actualizar(TurnoDTO turnoDTO);
    public void eliminar(Long id);
}
