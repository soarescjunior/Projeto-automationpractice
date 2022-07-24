
@Test
  Feature:Escolher Itens para compras
  Scenario: buscar itens de compra
  Given estou no site 'http://automationpractice.com'
  And buscar primeiro produto
  |produto             |quantidade|
  |Printed Summer Dress|3         |
  And buscar segundo produto
  |produto|
  |Blouse|
  And adicionar ao carrinho
  And alterar a quantidade do primeiro produto
  And remover a um item do carrinho
  And informar dados do usuario
  |usuario|senha|
  |soarescjunior@teste.com.br|Teste@123|
  Then concluir a compra

