package br.com.nutrition.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import br.com.nutrition.controller.NutricionistaController;
import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaNotFoundException;
import br.com.nutrition.repository.NutricionistaRepository;

@SpringBootTest
//@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_nutri_para_test_buscar_por_id.sql")
@AutoConfigureMockMvc
@WebMvcTest(NutricionistaController.class)

public class BuscarNutricionistaPorIdServiceImplTest {

  @Autowired
  private BuscarNutricionistaPorIdServiceImpl serviceImpl = mock(BuscarNutricionistaPorIdServiceImpl.class);

  @Autowired
  private NutricionistaRepository nutricionistaRepository;
  
 
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void buscarPorIdTest() throws NutricionistaNotFoundException {
	  Nutricionista nutricionistaMock = new Nutricionista();
	  nutricionistaMock.setCodigoRegistro("123");
	  nutricionistaMock.setId_paciente(123L);
	  nutricionistaMock.setNome("murilo");
	  
	when(serviceImpl.buscarPorId(11L)).thenReturn(nutricionistaMock);

    Nutricionista nutricionista = serviceImpl.buscarPorId(11L);

    assertEquals("123", nutricionista.getCodigoRegistro());
    assertEquals("123", String.valueOf(nutricionista.getId_paciente()));
    assertEquals("murilo", nutricionista.getNome());
    
    verify(serviceImpl, times(1)).buscarPorId(11L);
    
  }

//  @Test
//  public void deletarPorIdTest() throws NutricionistaNotFoundException {
//    serviceImpl.deletarPorId(11L);
//
//    Optional<Nutricionista> optionalNutricionista = nutricionistaRepository.findById(11L);
//
//    assertFalse(optionalNutricionista.isPresent());
//  }

}
