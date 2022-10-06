package com.turnosclinica.demoturnosclinica.model;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDTO {
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}