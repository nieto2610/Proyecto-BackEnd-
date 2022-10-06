package com.turnosclinica.demoturnosclinica.controller;

import com.turnosclinica.demoturnosclinica.exceptions.ResourceNotFoundException;
import com.turnosclinica.demoturnosclinica.model.OdontologoDTO;
import com.turnosclinica.demoturnosclinica.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/odontologo")
public class OdontologoController {

    final static Logger logger = Logger.getLogger(OdontologoController.class);

    private final IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> guardar(@RequestBody OdontologoDTO odontologoDTO) {
        logger.info("Estamos guardando el odontologo con matricula "+odontologoDTO.getMatricula());
        return new ResponseEntity<>(odontologoService.guardar(odontologoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        logger.info("Estamos buscando el odontologo con id "+id);
        ResponseEntity<OdontologoDTO> response;
        if(id != 0 && odontologoService.buscar(id) != null){
            response = ResponseEntity.ok(odontologoService.buscar(id));
        }else{
            logger.error("No se logro encontrar el odontologo con id "+id);
            throw new ResourceNotFoundException("El Odontologo buscado no fue encontrado");
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listar() throws ResourceNotFoundException {
        logger.info("Estamos listando odontologos");
        if(!odontologoService.listar().isEmpty()){
            return ResponseEntity.ok(odontologoService.listar());
        }else{
            throw new ResourceNotFoundException("No hay odontologos para mostrar");
        }
    }

    @PutMapping
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        ResponseEntity<OdontologoDTO> response;
        if(odontologoDTO.getId() != null  && odontologoService.buscar(odontologoDTO.getId()) != null){
            logger.info("Estamos actualizando el odontologo con id "+odontologoDTO.getId());
            response = ResponseEntity.ok(odontologoService.actualizar(odontologoDTO));
        }else{
            logger.error("No se logro actualizar el odontologo");
            throw new ResourceNotFoundException("El odontologo no fue encontrado");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> response;
        if(id != 0 && odontologoService.buscar(id) != null){
            logger.info("Estamos eliminando el odontologo con id "+id);
            odontologoService.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            logger.error("No se logro eliminar el odontologo con id "+id);
            throw new ResourceNotFoundException("El Odontologo no fue encontrado");
        }
        return response;
    }


}
