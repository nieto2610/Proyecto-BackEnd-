package com.turnosclinica.demoturnosclinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private String DNI;
    private LocalDateTime fechaAlta;
    private Domicilio domicilio;

}
