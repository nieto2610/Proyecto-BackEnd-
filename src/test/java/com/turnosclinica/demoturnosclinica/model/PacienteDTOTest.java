package com.turnosclinica.demoturnosclinica.model;

import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDTOTest {

    @BeforeEach
    void setUpBeforeEach(){
        PacienteDTO pacienteDTO = new PacienteDTO();
    }


    @Test
    @DisplayName("Que obtenga el id")
    void setGetId() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();

        //act
        pacienteDTO.setId(1L);
        //asserts
        Assertions.assertNotNull(pacienteDTO.getId());
        Assertions.assertEquals(1L, pacienteDTO.getId());
    }

    @Test
    @DisplayName("Que obtenga el apellido")
    void setGetApellido() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        //act
        pacienteDTO.setApellido("Acosta");
        //asserts
        Assertions.assertNotNull(pacienteDTO.getApellido());
        Assertions.assertEquals("Acosta", pacienteDTO.getApellido());
    }

    @Test
    @DisplayName("Que obtenga el nombre")
    void setGetNombre() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        //act
        pacienteDTO.setNombre("Gonzalo");
        //asserts
        Assertions.assertNotNull(pacienteDTO.getNombre());
        Assertions.assertEquals("Gonzalo", pacienteDTO.getNombre());
    }

    @Test
    @DisplayName("Que obtenga el DNI")
    void setGetDNI() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        //act
        pacienteDTO.setDNI("31100545");
        //asserts
        Assertions.assertNotNull(pacienteDTO.getDNI());
        Assertions.assertEquals("31100545", pacienteDTO.getDNI());
    }

    @Test
    @DisplayName("Que obtenga la fecha de alta")
    void setGetFechaAlta() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        //act
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pacienteDTO.setFechaAlta(timestamp.toLocalDateTime());
        //asserts
        Assertions.assertNotNull(pacienteDTO.getFechaAlta());
        Assertions.assertEquals(timestamp.toLocalDateTime(), pacienteDTO.getFechaAlta());
    }

    @Test
    @DisplayName("Que obtenga el domicilio")
    void setGetDomicilio() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        //act
        Domicilio domicilio = new Domicilio();
        domicilio.setId(1L);
        domicilio.setCalle("Remedios");
        domicilio.setNumero(245);
        domicilio.setLocalidad("Salvador");
        domicilio.setProvincia("Jujuy");

        pacienteDTO.setDomicilio(domicilio);
        //asserts
        Assertions.assertNotNull(domicilio);
        Assertions.assertEquals(1L, pacienteDTO.getDomicilio().getId());
        Assertions.assertEquals("Remedios", pacienteDTO.getDomicilio().getCalle());
        Assertions.assertEquals(245, pacienteDTO.getDomicilio().getNumero());
        Assertions.assertEquals("Salvador", pacienteDTO.getDomicilio().getLocalidad());
        Assertions.assertEquals("Jujuy", pacienteDTO.getDomicilio().getProvincia());
    }

    @Nested
    public class PruebaConstructor{

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio(){
            //Arrange
            PacienteDTO pacienteDTO = new PacienteDTO();
            //Act

            //Assert
            Assertions.assertNotNull(pacienteDTO);
        }

        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos(){
            //Arrange
            PacienteDTO pacienteDTO = new PacienteDTO();

            //Act

            Domicilio domicilio = new Domicilio();
            domicilio.setId(1L);
            domicilio.setCalle("Remedios");
            domicilio.setNumero(245);
            domicilio.setLocalidad("Salvador");
            domicilio.setProvincia("Jujuy");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            pacienteDTO.setId(1L);
            pacienteDTO.setApellido("Acosta");
            pacienteDTO.setNombre("Gonzalo");
            pacienteDTO.setDNI("31100545");
            pacienteDTO.setFechaAlta(timestamp.toLocalDateTime());
            pacienteDTO.setDomicilio(domicilio);

            //Assert
            Assertions.assertNotNull(pacienteDTO);
            Assertions.assertEquals(1L, pacienteDTO.getId());
            Assertions.assertEquals("Gonzalo", pacienteDTO.getNombre());
            Assertions.assertEquals("Acosta", pacienteDTO.getApellido());
            Assertions.assertEquals("31100545", pacienteDTO.getDNI());
            Assertions.assertEquals(timestamp.toLocalDateTime(), pacienteDTO.getFechaAlta());
            Assertions.assertEquals(1L, pacienteDTO.getDomicilio().getId());
            Assertions.assertEquals("Remedios", pacienteDTO.getDomicilio().getCalle());
            Assertions.assertEquals(245, pacienteDTO.getDomicilio().getNumero());
            Assertions.assertEquals("Salvador", pacienteDTO.getDomicilio().getLocalidad());
            Assertions.assertEquals("Jujuy", pacienteDTO.getDomicilio().getProvincia());

        }

        @Test
        void testToString() {
            Domicilio domicilio = new Domicilio();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            PacienteDTO pacienteDTO = new PacienteDTO(1L,  "Acosta", "Gonzalo", "31100545", timestamp.toLocalDateTime(), domicilio);

            Assertions.assertNotNull(pacienteDTO.toString());
            Assertions.assertNotNull(pacienteDTO);
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
            PacienteDTO pacienteDTO = PacienteDTO.builder()
                    .id(1L)
                    .nombre("Gonzalo")
                    .apellido("Acosta")
                    .DNI("31100545")
                    .domicilio(domicilio)
                    .fechaAlta(timestamp.toLocalDateTime())
                    .build();

            Assertions.assertNotNull(pacienteDTO);
            Assertions.assertNotNull(pacienteDTO.toString());
        }

    }
}