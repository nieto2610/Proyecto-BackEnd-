package com.turnosclinica.demoturnosclinica.controller;

import com.turnosclinica.demoturnosclinica.exceptions.ResourceNotFoundException;
import com.turnosclinica.demoturnosclinica.model.DomicilioDTO;
import com.turnosclinica.demoturnosclinica.service.IDomicilioService;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/domicilio")
public class DomicilioController {

    final static Logger logger = Logger.getLogger(DomicilioController.class);

    private final IDomicilioService domicilioService;

    @Autowired
    public DomicilioController(IDomicilioService domicilioService) {
        this.domicilioService = domicilioService;
    }

    @PostMapping
    public ResponseEntity<DomicilioDTO> guardar(@RequestBody DomicilioDTO domicilioDTO) {
        logger.info("Estamos agregando un domicilio");
        return new ResponseEntity<>(domicilioService.guardar(domicilioDTO), HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> buscar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        logger.info("Estamos buscando un domicilio con id "+id);
        ResponseEntity<DomicilioDTO> response;
        if(id != 0 && domicilioService.buscar(id) != null){
            response = ResponseEntity.ok(domicilioService.buscar(id));
        }else{
            logger.error("No se logro  el domicilio con id "+id);
            throw new ResourceNotFoundException("El domicilio buscado no fue encontrado");
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<DomicilioDTO> actualizar(@RequestBody DomicilioDTO domicilioDTO) throws ResourceNotFoundException {
        ResponseEntity<DomicilioDTO> response;
        if(domicilioDTO.getId() != null && domicilioService.buscar(domicilioDTO.getId()) != null){
            logger.info("Estamos actualizando el domicilio con id "+domicilioDTO.getId());
            response = ResponseEntity.ok(domicilioService.actualizar(domicilioDTO));
        }else{
            logger.error("No se logro  actualizar domicilio con id "+domicilioDTO.getId());
            throw new ResourceNotFoundException("El domicilio no fue encontrado");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> response;
        if(id != 0 && domicilioService.buscar(id) != null){
            logger.info("Estamos eliminando el domicilio con id "+id);
            domicilioService.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            logger.error("No se logro eliminar el domicilio con id "+id);
            throw new ResourceNotFoundException("El domicilio no fue encontrado\"");
        }
        return response;
    }
}
