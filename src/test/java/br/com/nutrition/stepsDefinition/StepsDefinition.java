package br.com.nutrition.stepsDefinition;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaNotFoundException;
import br.com.nutrition.service.BuscarNutricionistaPorIdServiceImpl;
import io.cucumber.java.en.*;

public class StepsDefinition {
	@Autowired
	private BuscarNutricionistaPorIdServiceImpl serviceImpl = mock(BuscarNutricionistaPorIdServiceImpl.class);

	Nutricionista nutricionista;

	@Given("realizo o Mock dos seguintes dados para o nutricionista ID {string} codigoRegistro {string}, id_paciente {string} e nome {string}")
	public void realizo_o_mock_dos_seguintes_dados_para_o_nutricionista_id_codigo_registro_id_paciente_e_nome(
			String id, String codigoRegistro, String id_paciente, String nome)
			throws NutricionistaNotFoundException {

		Nutricionista nutricionistaMock = new Nutricionista();
		nutricionistaMock.setCodigoRegistro(codigoRegistro);
		nutricionistaMock.setId_paciente(Long.parseLong(id_paciente));
		nutricionistaMock.setNome(nome);

		when(serviceImpl.buscarPorId(Long.parseLong(id))).thenReturn(nutricionistaMock);
	}

	@Given("que realizo a pesquisa pelo ID {string}")
	public void que_realizo_a_pesquisa_pelo_id(String ID) throws NutricionistaNotFoundException {
		nutricionista = serviceImpl.buscarPorId(Long.parseLong(ID));

	}

	@When("recebo a resposta com sucesso")
	public void recebo_a_resposta_com_sucesso() {
		assertTrue(!nutricionista.toString().isEmpty());
	}

	@Then("o valor recebido é codigoRegistro {string}, id_paciente {string} e nome {string}")
	public void o_valor_recebido_é_codigo_registro_id_paciente_e_nome(String codigoRegistro, String id_paciente,
			String nome) {
		assertTrue("Valor recebido: " + nutricionista.getCodigoRegistro() + " valor esperado: " + codigoRegistro, codigoRegistro.contains(nutricionista.getCodigoRegistro()));
		assertTrue("Valor recebido: " + nutricionista.getId_paciente() + " valor esperado: " + id_paciente, Long.parseLong(id_paciente) == nutricionista.getId_paciente());
		assertTrue("Valor recebido: " + nutricionista.getNome() + " valor esperado: " + nome ,nome.contains(nutricionista.getNome()));
	}

}
