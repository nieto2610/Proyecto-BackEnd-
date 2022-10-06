package com.turnosclinica.demoturnosclinica.model;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioTest {

    @Test
    @DisplayName("Que setee y obtenga el id")
    void setGetId() {
        //arrange
        Domicilio domicilio = new Domicilio();
        //act
        domicilio.setId(1L);
        //asserts
        Assertions.assertNotNull(domicilio.getId());
        Assertions.assertEquals(1L, domicilio.getId());
    }

    @Test
    @DisplayName("Que setee y obtenga la calle")
    void setGetCalle() {
        //arrange
        Domicilio domicilio = new Domicilio();
        //act
        domicilio.setCalle("Escalada");
        //asserts
        Assertions.assertNotNull(domicilio.getCalle());
        Assertions.assertEquals("Escalada", domicilio.getCalle());
    }

    @Test
    @DisplayName("Que setee y obtenga el numero")
    void setGetNumero() {
        //arrange
        Domicilio domicilio = new Domicilio();
        //act
        domicilio.setNumero(457);
        //asserts
        Assertions.assertNotNull(domicilio.getNumero());
        Assertions.assertEquals(457, domicilio.getNumero());
    }

    @Test
    @DisplayName("Que setee y obtenga la localidad")
    void setGetLocalidad() {
        //arrange
        Domicilio domicilio = new Domicilio();
        //act
        domicilio.setLocalidad("Salvador");
        //asserts
        Assertions.assertNotNull(domicilio.getLocalidad());
        Assertions.assertEquals("Salvador", domicilio.getLocalidad());
    }

    @Test
    @DisplayName("Que setee y obtenga la provincia")
    void setGetProvincia() {
        //arrange
        Domicilio domicilio = new Domicilio();
        //act
        domicilio.setProvincia("Jujuy");
        //asserts
        Assertions.assertNotNull(domicilio.getProvincia());
        Assertions.assertEquals("Jujuy", domicilio.getProvincia());
    }

    @Test
    @DisplayName("Para setee y obtenga setTurnos")
    void setGetTurnos() {
        //arrange
        Odontologo odontologo = new Odontologo();
        Set<Turno> turnos= new HashSet<Turno>();
        //act
        odontologo.setTurnos(turnos);
        //asserts
        Assertions.assertNotNull(odontologo.getTurnos());
        Assertions.assertEquals(0, odontologo.getTurnos().size());
    }
    @Nested
    @DisplayName("Para que pueda utilizar el constructor")
    public class PruebaConstructor{

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio(){
            //Arrange
            Domicilio domicilio = new Domicilio();
            //Act

            //Assert
            Assertions.assertNotNull(domicilio);
        }

        @Test
        @DisplayName("Si tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos(){
            //Arrange
            Domicilio domicilio = new Domicilio();
            domicilio.setId(1L);
            domicilio.setCalle("Remedios");
            domicilio.setNumero(245);
            domicilio.setLocalidad("Salvador");
            domicilio.setProvincia("Jujuy");
            //Act

            //Assert
            Assertions.assertNotNull(domicilio);
            Assertions.assertEquals(1L, domicilio.getId());
            Assertions.assertEquals("Remedios", domicilio.getCalle());
            Assertions.assertEquals(245, domicilio.getNumero());
            Assertions.assertEquals("Salvador", domicilio.getLocalidad());
            Assertions.assertEquals("Jujuy", domicilio.getProvincia());
        }


        @Test
        void testToString() {
            Domicilio domicilio = new Domicilio(1L, "Remedios", 245, "Salvador", "Jujuy");

            Assertions.assertNotNull(domicilio.toString());
            Assertions.assertNotNull(domicilio);
        }

        @Test
        void testBuilder() {
            Domicilio domicilio = Domicilio.builder()
                    .id(1L)
                    .calle("Remedios")
                    .numero(245)
                    .localidad("Salvador")
                    .provincia("Jujuy")
                    .build();

            Assertions.assertNotNull(domicilio);
            Assertions.assertNotNull(domicilio.toString());

        }


    }
}