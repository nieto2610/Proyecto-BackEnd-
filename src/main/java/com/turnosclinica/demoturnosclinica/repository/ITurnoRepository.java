package com.turnosclinica.demoturnosclinica.repository;

import com.turnosclinica.demoturnosclinica.model.Domicilio;
import com.turnosclinica.demoturnosclinica.model.Paciente;
import com.turnosclinica.demoturnosclinica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
    @Query("from Turno t where t.odontologo.id =:id_odontologo AND t.paciente.id =:id_paciente")
    Turno getTurnoByOdontologoAndPaciente(@Param("id_odontologo") Long id_odontologo, @Param("id_paciente") Long id_paciente);

}
