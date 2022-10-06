package com.turnosclinica.demoturnosclinica.model;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {
    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDateTime fecha_hora;
}
