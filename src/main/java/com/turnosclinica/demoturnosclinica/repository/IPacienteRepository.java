package com.turnosclinica.demoturnosclinica.repository;

import com.turnosclinica.demoturnosclinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("from Paciente p where p.DNI like %:dni%")
    Paciente getPacienteByDNILike(@Param("dni") String dni);
}
