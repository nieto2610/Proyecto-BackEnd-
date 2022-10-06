package com.turnosclinica.demoturnosclinica.controller;

import com.turnosclinica.demoturnosclinica.exceptions.ResourceNotFoundException;
import com.turnosclinica.demoturnosclinica.model.PacienteDTO;
import com.turnosclinica.demoturnosclinica.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/paciente")
public class PacienteController {

    final static Logger logger = Logger.getLogger(PacienteController.class);

    private final IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> guardar(@RequestBody PacienteDTO pacienteDTO) {
        logger.info("Estamos guardando el paciente con DNI: "+pacienteDTO.getDNI());
        return new ResponseEntity<>(pacienteService.guardar(pacienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        logger.info("Estamos buscando el paciente con id "+id);
        ResponseEntity<PacienteDTO> response;
        if(id != 0 && pacienteService.buscar(id) != null){
            response = ResponseEntity.ok(pacienteService.buscar(id));
        }else{
            logger.error("No se logro encontrar el  paciente con id "+id);
            throw new ResourceNotFoundException("el paciente buscado no fue encontrado");
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> listar() throws ResourceNotFoundException {
        logger.info("Estamos listando los pacientes");
        if(!pacienteService.listar().isEmpty()){
        return ResponseEntity.ok(pacienteService.listar());
        }else{
            throw new ResourceNotFoundException("No hay pacientes para mostrar");
        }
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        ResponseEntity<PacienteDTO> response;
        if(pacienteDTO.getId() != 0 && pacienteService.buscar(pacienteDTO.getId()) != null){
            logger.info("Estamos actualizando el paciente con id "+pacienteDTO.getId());
            response = ResponseEntity.ok(pacienteService.actualizar(pacienteDTO));
        }else
        {
            logger.error("No se logro actualizar el paciente con id "+pacienteDTO.getId());
            throw new ResourceNotFoundException("El paciente no fue encontrado");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> response;
        if(id != 0 && pacienteService.buscar(id) != null){
            logger.info("Estamos eliminando el paciente con id "+id);
            pacienteService.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            logger.error(" No se logro eliminar el paciente con id "+id);
            throw new ResourceNotFoundException("El paciente no fue encontrado");
        }
        return response;
    }

}
