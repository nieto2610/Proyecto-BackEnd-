package com.turnosclinica.demoturnosclinica.model;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

class OdontologoTest {

    @BeforeEach
    void setUpBeforeEach(){
        Odontologo odontologo = new Odontologo();
    }

    @Test
    @DisplayName("Que setee y obtenga el id")
    void setGettId() {
        //arrange
        Odontologo odontologo = new Odontologo();
        //act
        odontologo.setId(1L);
        //asserts
        Assertions.assertNotNull(odontologo.getId());
        Assertions.assertEquals(1L, odontologo.getId());
    }

    @Test
    @DisplayName("Que setee y obtenga el nombre")
    void setGetNombre() {
        //arrange
        Odontologo odontologo = new Odontologo();
        //act
        odontologo.setNombre("Carla");
        //asserts
        Assertions.assertNotNull(odontologo.getNombre());
        Assertions.assertEquals("Carla", odontologo.getNombre());
    }

    @Test
    @DisplayName("Que setee y obtenga el apellido")
    void setGetApellido() {
        //arrange
        Odontologo odontologo = new Odontologo();
        //act
        odontologo.setApellido("Nieto");
        //asserts
        Assertions.assertNotNull(odontologo.getApellido());
        Assertions.assertEquals("Nieto", odontologo.getApellido());
    }

    @Test
    @DisplayName("Que setee y obtenga la matricula")
    void setGetMatricula() {
        //arrange
        Odontologo odontologo = new Odontologo();
        //act
        odontologo.setMatricula("AS2645");
        //asserts
        Assertions.assertNotNull(odontologo.getMatricula());
        Assertions.assertEquals("AS2645", odontologo.getMatricula());
    }

    @Test
    @DisplayName("Que setee y obtenga setTurnos")
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
    @Test
    @DisplayName("Si se usa toString")
    void testToString(){
        //Arrange
        Set<Turno> turnos= new HashSet<Turno>();
        Odontologo odontologo = new Odontologo(1L, "Carla", "Nieto","AS2645", turnos);

        Assertions.assertNotNull(odontologo.toString());
        Assertions.assertNotNull(odontologo);;
    }

    @Test
    void testBuilder() {
        Set<Turno> turnos = new HashSet<Turno>();
        Odontologo odontologo = Odontologo.builder()
                .id(1L)
                .nombre("Carla")
                .apellido("Nieto")
                .matricula("AS2645")
                .turnos(turnos)
                .build();

        String string = "Odontologo(" + "id=" + "1" +
                ", nombre=" + "Carla"  +
                ", apellido=" + "Nieto" +
                ", matricula=" + "AS2645" +
                ", turnos=[]" + "" +
                ')';
        Assertions.assertNotNull(odontologo);
        Assertions.assertEquals(string,odontologo.toString());
    }

    @Nested
    @DisplayName("Que pueda utilizar el constructor")
    public class PruebaConstructor{

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio(){
            //Arrange
            Odontologo odontologo = new Odontologo();
            //Act

            //Assert
            Assertions.assertNotNull(odontologo);
        }

        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos(){
            //Arrange
            Odontologo odontologo = new Odontologo();
            odontologo.setId(1L);
            odontologo.setNombre("Carla");
            odontologo.setApellido("Nieto");
            odontologo.setMatricula("AS2645");
            //Act

            //Assert
            Assertions.assertNotNull(odontologo);
            Assertions.assertEquals(1L, odontologo.getId());
            Assertions.assertEquals("Carla", odontologo.getNombre());
            Assertions.assertEquals("Nieto", odontologo.getApellido());
            Assertions.assertEquals("AS2645", odontologo.getMatricula());
        }


    }

}