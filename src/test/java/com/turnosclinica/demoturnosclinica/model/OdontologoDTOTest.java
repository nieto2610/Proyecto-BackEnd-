package com.turnosclinica.demoturnosclinica.model;

import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class OdontologoDTOTest {

    @BeforeEach
    void setUpBeforeEach(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
    }

    @Test
    @DisplayName("Que setee y obtenga el id")
    void setGetId() {
        //arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        //act
        odontologoDTO.setId(1L);
        //asserts
        Assertions.assertNotNull(odontologoDTO.getId());
        Assertions.assertEquals(1L, odontologoDTO.getId());
    }

    @Test
    @DisplayName("Que setee y obtenga el nombre")
    void setGetNombre() {
        //arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        //act
        odontologoDTO.setNombre("Carla");
        //asserts
        Assertions.assertNotNull(odontologoDTO.getNombre());
        Assertions.assertEquals("Carla", odontologoDTO.getNombre());
    }

    @Test
    @DisplayName("Que setee y obtenga el apellido")
    void setGetApellido() {
        //arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        //act
        odontologoDTO.setApellido("Nieto");
        //asserts
        Assertions.assertNotNull(odontologoDTO.getApellido());
        Assertions.assertEquals("Nieto", odontologoDTO.getApellido());
    }

    @Test
    @DisplayName("Que setee y obtenga la matricula")
    void setGetMatricula() {
        //arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        //act
        odontologoDTO.setMatricula("AS5678");
        //asserts
        Assertions.assertNotNull(odontologoDTO.getMatricula());
        Assertions.assertEquals("AS5678", odontologoDTO.getMatricula());
    }

    @Test
    @DisplayName("Si se usa toString")
    void testToString(){
        //Arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO(1L, "Carla", "Nieto","AS5678");

        Assertions.assertNotNull(odontologoDTO.toString());
        Assertions.assertNotNull(odontologoDTO);;
    }

    @Nested
    @DisplayName("Que pueda utilizar el constructor")
    public class PruebaConstructor{

        @Test
        @DisplayName("Si se tiene un constructor vacio")
        void ConstructorVacio(){
            //Arrange
            OdontologoDTO odontologoDTO = new OdontologoDTO();
            //Act

            //Assert
            Assertions.assertNotNull(odontologoDTO);
        }

        @Test
        @DisplayName("Si se tiene un constructor con todos los atributos")
        void ConstructorConTodosLosAtributos(){
            //Arrange
            OdontologoDTO odontologoDTO = new OdontologoDTO();
            odontologoDTO.setId(1L);
            odontologoDTO.setNombre("Carla");
            odontologoDTO.setApellido("Nieto");
            odontologoDTO.setMatricula("AS5678");
            //Act

            //Assert
            Assertions.assertNotNull(odontologoDTO);
            Assertions.assertEquals(1L, odontologoDTO.getId());
            Assertions.assertEquals("Carla", odontologoDTO.getNombre());
            Assertions.assertEquals("Nieto", odontologoDTO.getApellido());
            Assertions.assertEquals("AS5678", odontologoDTO.getMatricula());
        }

        @Test
        void testBuilder() {
            OdontologoDTO odontologoDTO = OdontologoDTO.builder()
                    .id(1L)
                    .nombre("Carla")
                    .apellido("Nieto")
                    .matricula("AS5678")
                    .build();

            Assertions.assertNotNull(odontologoDTO);
            System.out.println(odontologoDTO.toString().trim());

        }

    }
}