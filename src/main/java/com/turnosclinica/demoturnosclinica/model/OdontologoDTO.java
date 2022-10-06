package com.turnosclinica.demoturnosclinica.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

}
