package com.turnosclinica.demoturnosclinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnosclinica.demoturnosclinica.model.Paciente;
import com.turnosclinica.demoturnosclinica.model.PacienteDTO;
import com.turnosclinica.demoturnosclinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    private final IPacienteRepository pacienteRepository;
    private final ObjectMapper mapper;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository, ObjectMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    @Override
    public PacienteDTO guardar(PacienteDTO pacienteDTO) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pacienteDTO.setFechaAlta(timestamp.toLocalDateTime());
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        Paciente pacienteResponse = pacienteRepository.getPacienteByDNILike(pacienteDTO.getDNI());
        return  mapper.convertValue(pacienteResponse, PacienteDTO.class);
    }

    @Override
    public Set<PacienteDTO> listar() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for (Paciente paciente:pacientes) {
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOS;
    }

    @Override
    public PacienteDTO buscar(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public PacienteDTO actualizar(PacienteDTO pacienteDTO) {
        PacienteDTO pacienteDTO1 = buscar(pacienteDTO.getId());
        pacienteDTO.setFechaAlta(pacienteDTO1.getFechaAlta());
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
        return pacienteDTO;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
