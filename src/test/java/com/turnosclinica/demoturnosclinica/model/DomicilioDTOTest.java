package com.turnosclinica.demoturnosclinica.model;

import org.junit.jupiter.api.*;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

class DomicilioDTOTest {

    @BeforeEach
    void setUpBeforeEach(){
        DomicilioDTO DomicilioDTO = new DomicilioDTO();
    }


    @Test
    @DisplayName("Que obtenga el id")
    void setGetId() {
        //arrange
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        //act
        domicilioDTO.setId(1L);
        //asserts
        Assertions.assertNotNull(domicilioDTO.getId());
        Assertions.assertEquals(1L, domicilioDTO.getId());
    }

    @Test
    @DisplayName("Que obtenga la calle")
    void setGetCalle() {
        //arrange
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        //act
        domicilioDTO.setCalle("Escalada");
        //asserts
        Assertions.assertNotNull(domicilioDTO.getCalle());
        Assertions.assertEquals("Escalada", domicilioDTO.getCalle());
    }

    @Test
    @DisplayName("Que setee y obtenga el numero")
    void setGetNumero() {
        //arrange
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        //act
        domicilioDTO.setNumero(457);
        //asserts
        Assertions.assertNotNull(domicilioDTO.getNumero());
        Assertions.assertEquals(457, domicilioDTO.getNumero());
    }

    @Test
    @DisplayName("Que setee y obtenga la localidad")
    void setGetLocalidad() {
        //arrange
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        //act
        domicilioDTO.setLocalidad("Salvador");
        //asserts
        Assertions.assertNotNull(domicilioDTO.getLocalidad());
        Assertions.assertEquals("Salvador", domicilioDTO.getLocalidad());
    }

    @Test
    @DisplayName("Que setee y obtenga la provincia")
    void setGetProvincia() {
        //arrange
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        //act
        domicilioDTO.setProvincia("Valle");
        //asserts
        Assertions.assertNotNull(domicilioDTO.getProvincia());
        Assertions.assertEquals("Valle", domicilioDTO.getProvincia());
    }


    @Nested
    @DisplayName("Que pueda utilizar el constructor")
    public class PruebaConstructor{

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio(){
            //Arrange
            DomicilioDTO domicilioDTO = new DomicilioDTO();
            //Act

            //Assert
            Assertions.assertNotNull(domicilioDTO);
        }

        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos(){
            //Arrange
            DomicilioDTO domicilioDTO = new DomicilioDTO();
            domicilioDTO.setId(1L);
            domicilioDTO.setCalle("Remedios");
            domicilioDTO.setNumero(245);
            domicilioDTO.setLocalidad("Salvador");
            domicilioDTO.setProvincia("Jujuy");
            //Act

            //Assert
            Assertions.assertNotNull(domicilioDTO);
            Assertions.assertEquals(1L, domicilioDTO.getId());
            Assertions.assertEquals("Remedios", domicilioDTO.getCalle());
            Assertions.assertEquals(245, domicilioDTO.getNumero());
            Assertions.assertEquals("Salvador", domicilioDTO.getLocalidad());
            Assertions.assertEquals("Jujuy", domicilioDTO.getProvincia());
        }

        @Test
        void testToString() {
            DomicilioDTO domicilioDTO = new DomicilioDTO(1L, "Colina", 587, "Bogotá", "Cundinamarca");

            Assertions.assertNotNull(domicilioDTO.toString());
            Assertions.assertNotNull(domicilioDTO);
        }

        @Test
        void testBuilder() {
            DomicilioDTO domicilioDTO = DomicilioDTO.builder()
                .id(1L)
                .calle("Colina")
                .numero(587)
                .localidad("Bogotá")
                .provincia("Cundinamarca")
                .build();

            Assertions.assertNotNull(domicilioDTO);
            Assertions.assertNotNull(domicilioDTO.toString());

        }

    }
}