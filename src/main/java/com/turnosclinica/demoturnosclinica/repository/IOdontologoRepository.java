package com.turnosclinica.demoturnosclinica.repository;

import com.turnosclinica.demoturnosclinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
    @Query("from Odontologo o where o.matricula like %:matricula%")
    Odontologo getOdontologoByMatriculaLike(@Param("matricula") String matricula);
}
