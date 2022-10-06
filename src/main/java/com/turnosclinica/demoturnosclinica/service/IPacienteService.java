package com.turnosclinica.demoturnosclinica.service;

import com.turnosclinica.demoturnosclinica.model.Paciente;
import com.turnosclinica.demoturnosclinica.model.PacienteDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
    public PacienteDTO guardar(PacienteDTO pacienteDTO);
    public Set<PacienteDTO> listar();
    public PacienteDTO buscar(Long id);
    public PacienteDTO actualizar(PacienteDTO pacienteDTO);
    public void eliminar(Long id);
}
