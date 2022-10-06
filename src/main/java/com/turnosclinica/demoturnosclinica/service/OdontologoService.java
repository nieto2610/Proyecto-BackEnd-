package com.turnosclinica.demoturnosclinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnosclinica.demoturnosclinica.model.Odontologo;
import com.turnosclinica.demoturnosclinica.model.OdontologoDTO;
import com.turnosclinica.demoturnosclinica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    private final IOdontologoRepository odontologoRepository;
    private final ObjectMapper mapper;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository, ObjectMapper mapper) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = mapper;
    }


    @Override
    public OdontologoDTO guardar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        Odontologo odontologoResponse = odontologoRepository.getOdontologoByMatriculaLike(odontologoDTO.getMatricula());
        return  mapper.convertValue(odontologoResponse, OdontologoDTO.class);
    }

    @Override
    public Set<OdontologoDTO> listar() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTOS = new HashSet<>();

        for (Odontologo odontologo: odontologos){
            odontologosDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTOS;
    }

    @Override
    public OdontologoDTO buscar(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        return odontologoDTO;
    }

    @Override
    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }
}
