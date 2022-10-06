package com.turnosclinica.demoturnosclinica.model;

import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @BeforeEach
    void setUpBeforeEach(){
        Paciente paciente = new Paciente();
    }

    @Test
    @DisplayName("Que obtenga el id")
    void setGetId() {
        //arrange
        Paciente paciente = new Paciente();
        //act
        paciente.setId(1L);
        //asserts
        Assertions.assertNotNull(paciente.getId());
        Assertions.assertEquals(1L, paciente.getId());
    }

    @Test
    @DisplayName("Que obtenga el apellido")
    void setGetApellido() {
        //arrange
        Paciente paciente = new Paciente();
        //act
        paciente.setApellido("Castro");
        //asserts
        Assertions.assertNotNull(paciente.getApellido());
        Assertions.assertEquals("Castro", paciente.getApellido());
    }

    @Test
    @DisplayName("Que obtenga el nombre")
    void setGetNombre() {
        //arrange
        Paciente paciente = new Paciente();
        //act
        paciente.setNombre("Daniel");
        //asserts
        Assertions.assertNotNull(paciente.getNombre());
        Assertions.assertEquals("Daniel", paciente.getNombre());
    }

    @Test
    @DisplayName("Que obtenga el DNI")
    void setGetDNI() {
        //arrange
        Paciente paciente = new Paciente();
        //act
        paciente.setDNI("12345678");
        //asserts
        Assertions.assertNotNull(paciente.getDNI());
        Assertions.assertEquals("12345678", paciente.getDNI());
    }

    @Test
    @DisplayName("Que obtenga la fecha de alta")
    void setGetFechaAlta() {
        //arrange
        Paciente paciente = new Paciente();
        //act
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        paciente.setFechaAlta(timestamp.toLocalDateTime());
        //asserts
        Assertions.assertNotNull(paciente.getFechaAlta());
        Assertions.assertEquals(timestamp.toLocalDateTime(), paciente.getFechaAlta());
    }

    @Test
    @DisplayName("Que obtenga el domicilio")
    void setGetDomicilio() {
        //arrange
        Paciente paciente = new Paciente();
        //act
        Domicilio domicilio = new Domicilio();
        domicilio.setId(1L);
        domicilio.setCalle("Remedios");
        domicilio.setNumero(245);
        domicilio.setLocalidad("Salvador");
        domicilio.setProvincia("Jujuy");

        paciente.setDomicilio(domicilio);
        //asserts
        Assertions.assertNotNull(domicilio);
        Assertions.assertEquals(1L, paciente.getDomicilio().getId());
        Assertions.assertEquals("Remedios", paciente.getDomicilio().getCalle());
        Assertions.assertEquals(245, paciente.getDomicilio().getNumero());
        Assertions.assertEquals("Salvador", paciente.getDomicilio().getLocalidad());
        Assertions.assertEquals("Jujuy", paciente.getDomicilio().getProvincia());
    }

    @Test
    @DisplayName("Que obtenga y setee Turnos")
    void setGetTurnos() {
        //arrange
        Paciente paciente = new Paciente();
        Set<Turno> turnos= new HashSet<Turno>();
        //act
        paciente.setTurnos(turnos);
        //asserts
        assertNotNull(paciente.getTurnos());
        assertEquals(0, paciente.getTurnos().size());
    }


    @Nested
    @DisplayName("Que pueda utilizar el constructor")
    public class PruebaConstructor{

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio(){
            //Arrange
            Paciente paciente = new Paciente();
            //Act

            //Assert
            Assertions.assertNotNull(paciente);
        }

        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos(){
            //Arrange
            Paciente paciente = new Paciente();
            Set<Turno> turnos= new HashSet<Turno>();
            //Act

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
            paciente.setTurnos(turnos);

            //Assert
            Assertions.assertNotNull(paciente);
            Assertions.assertEquals(1L, paciente.getId());
            Assertions.assertEquals("Gonzalo", paciente.getNombre());
            Assertions.assertEquals("Acosta", paciente.getApellido());
            Assertions.assertEquals("31100545", paciente.getDNI());
            Assertions.assertEquals(timestamp.toLocalDateTime(), paciente.getFechaAlta());
            Assertions.assertEquals(1L, paciente.getDomicilio().getId());
            Assertions.assertEquals("Remedios", paciente.getDomicilio().getCalle());
            Assertions.assertEquals(245, paciente.getDomicilio().getNumero());
            Assertions.assertEquals("Salvador", paciente.getDomicilio().getLocalidad());
            Assertions.assertEquals("Jujuy", paciente.getDomicilio().getProvincia());

        }

        @Test
        void testToString() {
            Domicilio domicilio = new Domicilio();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Set<Turno> turnos = new HashSet<Turno>();
            Paciente paciente = new Paciente(1L,  "Acosta", "Gonzalo", "31100545", timestamp.toLocalDateTime(), domicilio,  turnos);

            Assertions.assertNotNull(paciente.toString());
            Assertions.assertNotNull(paciente);
        }

        @Test
        void testBuilder() {
            Domicilio domicilio = new Domicilio();
            domicilio.setId(1L);
            domicilio.setCalle("Remedios");
            domicilio.setNumero(245);
            domicilio.setLocalidad("Salvador");
            domicilio.setProvincia("Jujuy");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Set<Turno> turnos= new HashSet<Turno>();
            Paciente paciente = Paciente.builder()
                    .id(1L)
                    .nombre("Gonzalo")
                    .apellido("Acosta")
                    .DNI("31100545")
                    .domicilio(domicilio)
                    .fechaAlta(timestamp.toLocalDateTime())
                    .turnos(turnos)
                    .build();

            Assertions.assertNotNull(paciente);
            Assertions.assertNotNull(paciente.toString());
        }

    }
}