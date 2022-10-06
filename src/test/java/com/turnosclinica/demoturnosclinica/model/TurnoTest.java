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

class TurnoTest {

    @Test
    @DisplayName("Que setee y obtenga el id")
    void setGetId() {
        //arrange
        Turno turno = new Turno();
        //act
        turno.setId(1L);
        //asserts
        Assertions.assertEquals(1L, turno.getId());
    }

    @Test
    @DisplayName("Que setee y obtenga el Odontologo")
    void setGetOdontologo() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        odontologo.setNombre("Carla");
        odontologo.setApellido("Nieto");
        odontologo.setMatricula("AS52654");

        Turno turno = new Turno();

        //Act
        turno.setOdontologo(odontologo);

        //Assert
        Assertions.assertEquals(1L, turno.getOdontologo().getId());
        Assertions.assertEquals("Carla", turno.getOdontologo().getNombre());
        Assertions.assertEquals("Nieto", turno.getOdontologo().getApellido());
        Assertions.assertEquals("AS52654", turno.getOdontologo().getMatricula());
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

        Turno turno = new Turno();

        //Act
        turno.setPaciente(paciente);

        //Assert
        Assertions.assertEquals(1L, turno.getPaciente().getId());
        Assertions.assertEquals("Gonzalo", turno.getPaciente().getNombre());
        Assertions.assertEquals("Acosta", turno.getPaciente().getApellido());
        Assertions.assertEquals("31100545", turno.getPaciente().getDNI());
        Assertions.assertEquals(timestamp.toLocalDateTime(), turno.getPaciente().getFechaAlta());
        Assertions.assertEquals(1L, turno.getPaciente().getDomicilio().getId());
        Assertions.assertEquals("Remedios", turno.getPaciente().getDomicilio().getCalle());
        Assertions.assertEquals(245, turno.getPaciente().getDomicilio().getNumero());
        Assertions.assertEquals("Salvador", turno.getPaciente().getDomicilio().getLocalidad());
        Assertions.assertEquals("Jujuy", turno.getPaciente().getDomicilio().getProvincia());

    }

    @Test
    @DisplayName("Que setee y obtenga la fecha_hora")
    void setGetFecha_hora() {
        //Arrange
        Turno turno = new Turno();

        //Act
        LocalDateTime fecha_hora = LocalDateTime.parse("2022-06-10T10:30:00");
        turno.setFecha_hora(fecha_hora);

        //Asserts
        Assertions.assertEquals(fecha_hora, turno.getFecha_hora());
    }

    @Nested
    @DisplayName("Que pueda utilizar el constructor")
    public class PruebaConstructor {

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio() {
            //Arrange
            Turno turno = new Turno();
            //Act

            //Assert
            Assertions.assertNotNull(turno);
        }

        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos() {
            //Arrange
            //Turno
            Turno turno = new Turno();
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

            LocalDateTime fecha_hora = LocalDateTime.parse("2022-06-10T10:30:00");

            //Act
            turno.setId(1L);
            turno.setOdontologo(odontologo);
            turno.setPaciente(paciente);
            turno.setFecha_hora(fecha_hora);

            //Assert
            Assertions.assertEquals(1L, turno.getOdontologo().getId());
            Assertions.assertEquals("Carla", turno.getOdontologo().getNombre());
            Assertions.assertEquals("Nieto", turno.getOdontologo().getApellido());
            Assertions.assertEquals("AS52654", turno.getOdontologo().getMatricula());

            Assertions.assertEquals(1L, turno.getPaciente().getId());
            Assertions.assertEquals("Gonzalo", turno.getPaciente().getNombre());
            Assertions.assertEquals("Acosta", turno.getPaciente().getApellido());
            Assertions.assertEquals("31100545", turno.getPaciente().getDNI());
            Assertions.assertEquals(timestamp.toLocalDateTime(), turno.getPaciente().getFechaAlta());
            Assertions.assertEquals(1L, turno.getPaciente().getDomicilio().getId());
            Assertions.assertEquals("Remedios", turno.getPaciente().getDomicilio().getCalle());
            Assertions.assertEquals(245, turno.getPaciente().getDomicilio().getNumero());
            Assertions.assertEquals("Salvador", turno.getPaciente().getDomicilio().getLocalidad());
            Assertions.assertEquals("Jujuy", turno.getPaciente().getDomicilio().getProvincia());

            Assertions.assertEquals(fecha_hora, turno.getFecha_hora());

        }

        @Test
        void testToString() {

            Domicilio domicilio = new Domicilio();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Set<Turno> turnos = new HashSet<Turno>();

            Odontologo odontologo = new Odontologo(1L,"Carla","Nieto","AS52654",turnos);
            Paciente paciente = new Paciente(1L,  "Acosta", "Gonzalo", "31100545", timestamp.toLocalDateTime(), domicilio,  turnos);
            Turno turno = new Turno(1L,odontologo, paciente, timestamp.toLocalDateTime());

            Assertions.assertNotNull(turno.toString());
            Assertions.assertNotNull(turno);
        }

        @Test
        void testBuilder() {
            Domicilio domicilio = new Domicilio();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Set<Turno> turnos = new HashSet<Turno>();

            Odontologo odontologo = new Odontologo(1L,"Carla","Nieto","AS52654",turnos);
            Paciente paciente = new Paciente(1L,  "Acosta", "Gonzalo", "31100545", timestamp.toLocalDateTime(), domicilio,  turnos);

            Turno turno = Turno.builder()
                    .id(1L)
                    .odontologo(odontologo)
                    .paciente(paciente)
                    .fecha_hora(timestamp.toLocalDateTime())
                    .build();

            Assertions.assertNotNull(turno.toString());
            Assertions.assertNotNull(turno);
        }
    }
}