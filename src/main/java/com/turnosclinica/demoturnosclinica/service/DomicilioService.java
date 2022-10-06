package com.turnosclinica.demoturnosclinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnosclinica.demoturnosclinica.model.Domicilio;
import com.turnosclinica.demoturnosclinica.model.DomicilioDTO;
import com.turnosclinica.demoturnosclinica.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService {

    private final IDomicilioRepository domicilioRepository;

    private final ObjectMapper mapper;

    @Autowired
    public DomicilioService(IDomicilioRepository domicilioRepository, ObjectMapper mapper) {
        this.domicilioRepository = domicilioRepository;
        this.mapper = mapper;
    }

    @Override
    public DomicilioDTO guardar(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        Domicilio domicilioAlmacenado = domicilioRepository.getDomicilioByCalleLike(domicilioDTO.getCalle(), domicilioDTO.getNumero());
        return mapper.convertValue(domicilioAlmacenado, DomicilioDTO.class);
    }

    @Override
    public DomicilioDTO buscar(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public DomicilioDTO actualizar(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return domicilioDTO;
    }

    @Override
    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }
}
