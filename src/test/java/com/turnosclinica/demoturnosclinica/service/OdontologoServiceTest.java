package com.turnosclinica.demoturnosclinica.service;

import com.turnosclinica.demoturnosclinica.model.Odontologo;
import com.turnosclinica.demoturnosclinica.model.OdontologoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

   /* @Autowired
    IOdontologoService odontologoService;

    @Test
    @DisplayName("Que guarde el odontologo")
    void guardar() {
        //Arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Gonzalez");
        odontologoDTO.setMatricula("AE2545");

        //Act
        odontologoService.guardar(odontologoDTO);

        //Asserts
        OdontologoDTO odontologoDTO1 = odontologoService.buscar(1L);
        Assertions.assertTrue(odontologoDTO1 != null);
        Assertions.assertEquals(1L, odontologoDTO1.getId());
        Assertions.assertEquals("Juan", odontologoDTO1.getNombre());
        Assertions.assertEquals("Gonzalez", odontologoDTO1.getApellido());
        Assertions.assertEquals("AE2545", odontologoDTO1.getMatricula());

    }

    @Test
    @DisplayName("Que liste los odontologos")
    void listar() {
        //Arrange
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("Juan");
        odontologoDTO1.setApellido("Gonzalez");
        odontologoDTO1.setMatricula("AE2545");

        //Arrange
        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("Andrés");
        odontologoDTO2.setApellido("Escobar");
        odontologoDTO2.setMatricula("AB5555");

        //Act
        odontologoService.guardar(odontologoDTO1);
        odontologoService.guardar(odontologoDTO2);

        //Asserts
        Set<OdontologoDTO> listadoOdontologosDTO = odontologoService.listar();

        Assertions.assertTrue(listadoOdontologosDTO.size() > 0);

    }

    @Test
    @DisplayName("Que busque un odontologo")
    void buscar() {
        //Arrange
        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setNombre("Andrés");
        odontologoDTO2.setApellido("Escobar");
        odontologoDTO2.setMatricula("AB5555");

        //Act
        odontologoService.guardar(odontologoDTO2);

        //Asserts
        OdontologoDTO odontologoDTO = odontologoService.buscar(1L);
        Assertions.assertEquals(1L, odontologoDTO.getId() );
        Assertions.assertEquals("Andrés", odontologoDTO.getNombre());
        Assertions.assertEquals("Escobar", odontologoDTO.getApellido());
        Assertions.assertEquals("AB5555", odontologoDTO.getMatricula());
    }

    @Test
    void actualizar() {
        //Arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Carlos");
        odontologoDTO.setApellido("Zamora");
        odontologoDTO.setMatricula("A77889");

        //Act
        odontologoService.guardar(odontologoDTO);

        //Asserts
        OdontologoDTO odontologoAlmacenado = odontologoService.buscar(1L);
        odontologoAlmacenado.setMatricula("A22225");
        odontologoService.actualizar(odontologoAlmacenado);
        OdontologoDTO odontologoActualizado = odontologoService.buscar(1L);
        Assertions.assertEquals(1L, odontologoActualizado.getId() );
        Assertions.assertEquals("Carlos", odontologoActualizado.getNombre());
        Assertions.assertEquals("Zamora", odontologoActualizado.getApellido());
        Assertions.assertEquals("A22225", odontologoActualizado.getMatricula());
    }

    @Test
    void eliminar() {
        //Arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Carlos");
        odontologoDTO.setApellido("Zamora");
        odontologoDTO.setMatricula("A77889");

        //Act
        odontologoService.guardar(odontologoDTO);

        //Asserts
        odontologoService.eliminar(1L);
        Set<OdontologoDTO> listadoOdontologosDTO = odontologoService.listar();

        Assertions.assertTrue(listadoOdontologosDTO.size() == 0);
    }
    */

}