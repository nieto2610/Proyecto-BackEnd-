package com.turnosclinica.demoturnosclinica.service;

import com.turnosclinica.demoturnosclinica.model.DomicilioDTO;

public interface IDomicilioService {
    public DomicilioDTO guardar(DomicilioDTO domicilioDTO);
    public DomicilioDTO buscar(Long id);
    public DomicilioDTO actualizar(DomicilioDTO domicilioDTO);
    public void eliminar(Long id);
}
