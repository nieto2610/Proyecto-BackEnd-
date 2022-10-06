package com.turnosclinica.demoturnosclinica.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TurnoDTOTest {
    @Test
    @DisplayName("Que setee y obtenga el id")
    void setGetId() {
        //arrange
        TurnoDTO turnoDTO = new TurnoDTO();
        //act
        turnoDTO.setId(1L);
        //asserts
        Assertions.assertEquals(1L, turnoDTO.getId());
    }

    @Test
    @DisplayName("Que setee y obtenga el Odontologo")
    void setGetOdontologo() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        odontologo.setNombre("Carlos");
        odontologo.setApellido("Gomez");
        odontologo.setMatricula("A57845");

        TurnoDTO turnoDTO = new TurnoDTO();

        //Act
        turnoDTO.setOdontologo(odontologo);

        //Assert
        Assertions.assertEquals(1L, turnoDTO.getOdontologo().getId());
        Assertions.assertEquals("Carlos", turnoDTO.getOdontologo().getNombre());
        Assertions.assertEquals("Gomez", turnoDTO.getOdontologo().getApellido());
        Assertions.assertEquals("A57845", turnoDTO.getOdontologo().getMatricula());
    }

    @Test
    @DisplayName("Que setee y obtenga el paciente")
    void setGetPaciente() {
        //Arrange
        Paciente paciente = new Paciente();

        Domicilio domicilio = new Domicilio();
        domicilio.setId(1L);
        domicilio.setCalle("Remedios");
        domicilio.setNumero(245);
        domicilio.setLocalidad("Salvador");
        domicilio.setProvincia("Jujuy");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        paciente.setId(1L);
        paciente.setApellido("Acosta");
        paciente.setNombre("Gonzalo");
        paciente.setDNI("31100545");
        paciente.setFechaAlta(timestamp.toLocalDateTime());
        paciente.setDomicilio(domicilio);

        TurnoDTO turnoDTO = new TurnoDTO();

        //Act
        turnoDTO.setPaciente(paciente);

        //Assert
        Assertions.assertEquals(1L, turnoDTO.getPaciente().getId());
        Assertions.assertEquals("Gonzalo", turnoDTO.getPaciente().getNombre());
        Assertions.assertEquals("Acosta", turnoDTO.getPaciente().getApellido());
        Assertions.assertEquals("31100545", turnoDTO.getPaciente().getDNI());
        Assertions.assertEquals(timestamp.toLocalDateTime(), turnoDTO.getPaciente().getFechaAlta());
        Assertions.assertEquals(1L, turnoDTO.getPaciente().getDomicilio().getId());
        Assertions.assertEquals("Remedios", turnoDTO.getPaciente().getDomicilio().getCalle());
        Assertions.assertEquals(245, turnoDTO.getPaciente().getDomicilio().getNumero());
        Assertions.assertEquals("Salvador", turnoDTO.getPaciente().getDomicilio().getLocalidad());
        Assertions.assertEquals("Jujuy", turnoDTO.getPaciente().getDomicilio().getProvincia());

    }

    @Test
    @DisplayName("Que setee y obtenga la fecha_hora")
    void setGetFecha_hora() {
        //Arrange
        TurnoDTO turnoDTO = new TurnoDTO();

        //Act
        LocalDateTime fecha_hora = LocalDateTime.parse("2022-06-10T11:30:00");
        turnoDTO.setFecha_hora(fecha_hora);

        //Asserts
        Assertions.assertEquals(fecha_hora, turnoDTO.getFecha_hora());
    }



        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos() {
            //Arrange
            //Turno
            TurnoDTO turnoDTO = new TurnoDTO();
            //Odontologo
            Odontologo odontologo = new Odontologo();
            //Paciente
            Domicilio domicilio = new Domicilio();
            Paciente paciente = new Paciente();


            odontologo.setId(1L);
            odontologo.setNombre("Carla");
            odontologo.setApellido("Nieto");
            odontologo.setMatricula("AS52654");

            domicilio.setId(1L);
            domicilio.setCalle("Remedios");
            domicilio.setNumero(245);
            domicilio.setLocalidad("Salvador");
            domicilio.setProvincia("Jujuy");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            paciente.setId(1L);
            paciente.setApellido("Acosta");
            paciente.setNombre("Gonzalo");
            paciente.setDNI("31100545");
            paciente.setFechaAlta(timestamp.toLocalDateTime());
            paciente.setDomicilio(domicilio);

            LocalDateTime fecha_hora = LocalDateTime.parse("2022-06-10T11:30:00");

            //Act
            turnoDTO.setId(1L);
            turnoDTO.setOdontologo(odontologo);
            turnoDTO.setPaciente(paciente);
            turnoDTO.setFecha_hora(fecha_hora);

            //Assert
            Assertions.assertEquals(1L, turnoDTO.getOdontologo().getId());
            Assertions.assertEquals("Carla", turnoDTO.getOdontologo().getNombre());
            Assertions.assertEquals("Nieto", turnoDTO.getOdontologo().getApellido());
            Assertions.assertEquals("AS52654", turnoDTO.getOdontologo().getMatricula());

            Assertions.assertEquals(1L, turnoDTO.getPaciente().getId());
            Assertions.assertEquals("Gonzalo", turnoDTO.getPaciente().getNombre());
            Assertions.assertEquals("Acosta", turnoDTO.getPaciente().getApellido());
            Assertions.assertEquals("31100545", turnoDTO.getPaciente().getDNI());
            Assertions.assertEquals(timestamp.toLocalDateTime(), turnoDTO.getPaciente().getFechaAlta());
            Assertions.assertEquals(1L, turnoDTO.getPaciente().getDomicilio().getId());
            Assertions.assertEquals("Remedios", turnoDTO.getPaciente().getDomicilio().getCalle());
            Assertions.assertEquals(245, turnoDTO.getPaciente().getDomicilio().getNumero());
            Assertions.assertEquals("Salvador", turnoDTO.getPaciente().getDomicilio().getLocalidad());
            Assertions.assertEquals("Jujuy", turnoDTO.getPaciente().getDomicilio().getProvincia());

            Assertions.assertEquals(fecha_hora, turnoDTO.getFecha_hora());

        }

        @Test
        void testToString() {

            Domicilio domicilio = new Domicilio();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Set<Turno> turnos = new HashSet<Turno>();

            Odontologo odontologo = new Odontologo(1L,"Carla","Nieto","AS52654",turnos);
            Paciente paciente = new Paciente(1L,  "Acosta", "Gonzalo", "31100545", timestamp.toLocalDateTime(), domicilio,  turnos);
            TurnoDTO turnoDTO = new TurnoDTO(1L,odontologo, paciente, timestamp.toLocalDateTime());

            Assertions.assertNotNull(turnoDTO.toString());
            Assertions.assertNotNull(turnoDTO);
        }

        @Test
        void testBuilder() {
            Domicilio domicilio = new Domicilio();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Set<Turno> turnos = new HashSet<Turno>();

            Odontologo odontologo = new Odontologo(1L,"Carla","Nieto","AS52654",turnos);
            Paciente paciente = new Paciente(1L,  "Acosta", "Gonzalo", "31100545", timestamp.toLocalDateTime(), domicilio,  turnos);

            TurnoDTO turnoDTO = TurnoDTO.builder()
                    .id(1L)
                    .odontologo(odontologo)
                    .paciente(paciente)
                    .fecha_hora(timestamp.toLocalDateTime())
                    .build();

            Assertions.assertNotNull(turnoDTO.toString());
            Assertions.assertNotNull(turnoDTO);
        }
    }

