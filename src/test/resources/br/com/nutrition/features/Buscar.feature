@test
Feature: Buscar
  

  
  Scenario Outline: Buscar nutricionista por ID
    Given realizo o Mock dos seguintes dados para o nutricionista ID '<ID>' codigoRegistro '<CodigoRegistro>', id_paciente '<Id_paciente>' e nome '<nome>'
    And que realizo a pesquisa pelo ID '<ID>'
    When recebo a resposta com sucesso
    Then o valor recebido é codigoRegistro '<CodigoRegistro>', id_paciente '<Id_paciente>' e nome '<nome>'
    
    Examples: 
      | ID  | CodigoRegistro | Id_paciente  | nome   |
      | 11  |     123        |  123         | murilo |
