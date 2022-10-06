package com.turnosclinica.demoturnosclinica.repository;

import com.turnosclinica.demoturnosclinica.model.Domicilio;
import com.turnosclinica.demoturnosclinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {
    @Query("from Domicilio o where o.calle =:calle AND o.numero =:numero")
    Domicilio getDomicilioByCalleLike(@Param("calle") String calle, @Param("numero") Integer numero);
}
