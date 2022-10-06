package com.turnosclinica.demoturnosclinica.controller;

import com.turnosclinica.demoturnosclinica.exceptions.ResourceNotFoundException;
import com.turnosclinica.demoturnosclinica.model.TurnoDTO;
import com.turnosclinica.demoturnosclinica.service.IOdontologoService;
import com.turnosclinica.demoturnosclinica.service.IPacienteService;
import com.turnosclinica.demoturnosclinica.service.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/turno")
public class TurnoController {

    final static Logger logger = Logger.getLogger(TurnoController.class);

    private final ITurnoService turnoService;
    private final IPacienteService pacienteService;
    private final IOdontologoService odontologoService;

    public TurnoController(ITurnoService turnoService, IPacienteService pacienteService, IOdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> guardar(@RequestBody TurnoDTO turnoDTO) {
        logger.info("Estamos guardando el turno");
        ResponseEntity<TurnoDTO> response;

        if(pacienteService.buscar(turnoDTO.getPaciente().getId()) != null
            && odontologoService.buscar(turnoDTO.getOdontologo().getId()) != null){
            response = new ResponseEntity<>(turnoService.guardar(turnoDTO), HttpStatus.CREATED);
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable("id") Long id) throws ResourceNotFoundException {
        logger.info("Estamos buscando el turno con id "+id);
        ResponseEntity<TurnoDTO> response;
        if(id != 0 && turnoService.buscar(id) != null){
            response = ResponseEntity.ok(turnoService.buscar(id));
        }else{
            logger.error("No se logro encontrar el turno con id "+id);
            throw new ResourceNotFoundException("El turno no fue encontrado");
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> listar() throws ResourceNotFoundException {
        logger.info("Estamos listando turnos");
        if(!turnoService.listar().isEmpty()){
        return ResponseEntity.ok(turnoService.listar());
        }else{
            throw new ResourceNotFoundException("No hay turnos para mostrar");
        }
    }

    @PutMapping
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException {
        ResponseEntity<TurnoDTO> response;
        if(turnoDTO.getId() != null && turnoService.buscar(turnoDTO.getId()) != null){
            logger.info("Estamos actualizando el turno con id "+turnoDTO.getId());
            response = ResponseEntity.ok(turnoService.actualizar(turnoDTO));
        }else{
            logger.error("No se logro actualizar el turno con id "+turnoDTO.getId());
            throw new ResourceNotFoundException("El turno no fue encontrado");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> response;
        if(id != 0 && turnoService.buscar(id) != null){
            logger.info("Estamos eliminando el turno con id "+id);
            turnoService.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            logger.error("No se logro eliminar el turno con id "+id);
            throw new ResourceNotFoundException("El turno no fue encontrado");
        }
        return response;
    }
}
