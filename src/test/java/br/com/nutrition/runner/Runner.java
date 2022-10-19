package br.com.nutrition.runner;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.nutrition.controller.NutricionistaController;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@WebAppConfiguration
@Sql(scripts = "/sql/insert_nutri_para_test_buscar_por_id.sql")
@AutoConfigureMockMvc
@WebMvcTest(NutricionistaController.class)
@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/pedro/git/nutrition/src/test/resources/br/com/nutrition/features", tags = "@test", plugin = {
		"pretty", "junit:target/cucumber.xml" }, monochrome = true, glue = "br.com.nutrition.stepsDefinition")

public class Runner {
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
}
