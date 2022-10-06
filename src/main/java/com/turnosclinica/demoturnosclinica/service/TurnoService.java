package com.turnosclinica.demoturnosclinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnosclinica.demoturnosclinica.model.*;
import com.turnosclinica.demoturnosclinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    private final ITurnoRepository turnoRepository;
    private final ObjectMapper mapper;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository, ObjectMapper mapper) {
        this.turnoRepository = turnoRepository;
        this.mapper = mapper;
    }

    @Override
    public TurnoDTO guardar(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        Turno turnoAlmacenado = turnoRepository.getTurnoByOdontologoAndPaciente(turno.getOdontologo().getId(), turno.getPaciente().getId());
        Optional<Turno> turnoResponse = turnoRepository.findById(turnoAlmacenado.getId());
        return mapper.convertValue(turnoResponse, TurnoDTO.class);
    }

    @Override
    public Set<TurnoDTO> listar() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        for (Turno turno: turnos) {
            turnoDTOS.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnoDTOS;
    }

    @Override
    public TurnoDTO buscar(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public TurnoDTO actualizar(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        return turnoDTO;
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }
}
