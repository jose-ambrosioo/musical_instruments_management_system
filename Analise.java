/*****************************************************/
/* Ficheiro: Analise.java                            */
/* Versão: 1.0                                       */
/* Autor: José Nazareno Torres Ambrósio (12683)	     */
/* Orientador: Prof. Doutor Engº Aires Araújo Veloso */
/*****************************************************/

/*
1 - Definição do Problema

    1.1 - Implementar uma Loja Instrumentos Musicais Online, com as seguintes funcionalidades:
         
    1.2 - Requisitos Funcionais:
	 - Clientes
		 - Cadastrar
		 - Alterar
		 - Remover
		 - Listar

	 - Funcionários
		 - Cadastrar
		 - Alterar
		 - Remover
		 - Listar

	- Fornecedores
		 - Cadastrar
		 - Alterar
		 - Remover
		 - Listar
	- Armazém
		 - Cadastrar Produto
		 - Listar Produtos
		 - Definir Quantidade Máxima de Produto
		 - Definir Preço de Produto
	         - Dar Entrada de Produto

	- Montra
		- Visualizar
		- Colocar Produto
		- Remover Produto
	
	- Balancetes
		- Diário
		- Mensal
		- Por Intervalo de Tempo
		- Por Tipo de Produto
		- Por Produtos em Ruptura
		- Por Produtos em Quase Ruptura	
		- Por Produtos em Pré-Ruptura

	- Tabelas
		- Carregar
		- Visualizar

	- Carrinho
		 - Submeter carrinho de compras pelos clientes
		 - Realizar de vendas por carrinhos de compras submetidos pelos clientes
		 - Listar carrinhos de compras submetidos
		 - Listar vendas realizadas
		 - Listar compras (em espera e realizadas) por clientes

     1.3 - Requisitos Não Funcionais:
         - Ambiente de Desenvolvimento Netbeans 8.2
         - SGBD PostgreSQL 10.5
         - Java Versão: jdk_8
         - Nome da Base de Dados: ucandb


2 - Interface do Utilizador:

    2.1 - Apresentação e termos de uso (xhtml)
       - Aceitar 
            -> login (xhtml)
                - Entrar (como root, administrador, cliente cadastrado ou não cadastrado)
                    -> homePage com menu de cliente não cadastrado (xhtml)
                        - Perfil
			    -> Home
                            -> Sair                       
			- Cliente
                            -> Cadastrar
                        - Montra
                            -> Visualizar

                    -> homePage com menu de cliente cadastrado (xhtml)
                        - Perfil
			    -> Home
                            -> Sair
                        - Montra
                            -> Visualizar
                                - Adicionar ao carrinho
                                - Remover do carrinho
                            -> Carrinho

                    -> homePage com menu de funcionário (xhtml)
                        - Perfil
			    -> Home
                            -> Sair
                        - Armazem
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)
                        - Montra
                            -> Visualizar
                            -> Adicionar (Instrumentos Musicais) a montra
                            -> Remover (Instrumentos Musicais) da montra

                    -> homePage com menu de administrador (xhtml)
                        - Perfil
			    -> Home
                            -> Sair
                        - Armazem
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)
                        - Montra
                            -> Visualizar
                            -> Adicionar (Instrumentos Musicais) a montra
                            -> Remover (Instrumentos Musicais) da montra
			- Funcionario
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)

                    -> homePage com menu de root (xhtml)
                        - Perfil
			    -> Home
                            -> Sair
			- Cliente
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)
                        - Armazem
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)
                        - Montra
                            -> Visualizar
                            -> Adicionar (Instrumentos Musicais) a montra
                            -> Remover (Instrumentos Musicais) da montra
			- Funcionario
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)
			- Fornecedor
                            -> Cadastrar Produto (Instrumentos Musicais)
                            -> Listar Produtos (Instrumentos Musicais)
                            -> Dar Entrada de Produto (Instrumentos Musicais)
			- Balancetes
                            -> Diário
                            -> Mensal
                            -> Num Intervalo de Tempo
		            -> Por Tipo de Produto
			    -> Por Intervalo de Tempo
			    -> Por Tipo de Produto
			    -> Por Produtos em Ruptura
			    -> Por Produtos em Quase Ruptura	
			    -> Por Produtos em Pré-Ruptura
			- Tabelas
                            -> Carregar do Excel
				-> País
			   	-> Província	
				-> Município
				-> Comuna
				-> Categoria1
				-> Categoria2
				-> Categoria3
				-> Produto
			    -> Visualizar
			- Carrinho

       - Cancelar


3 - Principais Entidades ligadas a Interface do Utilizador (IU):

	- Conta
	- Cliente
	- Funcionario
	- Fornecedor
	- Produto
	- Montra
	- Venda
	- ItemVenda
	- Carrinho


4 - Entidades Persistentes (Tabelas na Base de Dados):

	- categoria1 (pk_categoria1, nome)
	- categoria2 (pk_categoria2, nome, fk_categoria1)
	- categoria3 (pk_categoria3, nome, fk_categoria2)
	- comuna (pk_comuna, nome, fk_municipio)
	- conta (pk_conta, usuario, senha, fk_tipo_conta)
	- endereco (pk_endereco, fk_comuna, bairro, rua, numero_casa)
	- fornecedor (pk_fornecedor, nome)
	- historico_preco (pk_historico_preco, fk_produto, preco, data_alteracao)
	- itens_venda (pk_itens_venda, fk_produto, fk_venda)
	- montra (pk_montra, fk_produto)
	- municipio (pk_municipio, nome, fk_provinicia)
	- operadora (pk_operadora, nome)
	- pais (pk_pais, nome)
	- pessoa (pk_pessoa, nome, numero_bi, fk_sexo, fk_conta, data_nascimento, email, telefone)
	- produto (pk_produto, nome, quantidade_maxima, fk_fornecedor, foto)
	- provincia (pk_provincia, nome, fk_pais)
	- sexo (pk_sexo, nome)
	- tipo_conta (pk_tipo_conta, nome)
	- tipo_pagamento (pk_tipo_pagamento, nome)
	- venda (pk_venda, fk_pessoa, fk_tipo_pagamento, data_venda, total_venda, numero_cartao)


5. Implementação

	- Implementado em Java Web (JSF, EJB, PrimeFaces)


6. Debugging (Depuração) 

 
7. Documentação 
  
	- Core JavaServer Faces 3rd Ed. 2010
	- Primefaces User Guide 6.0


8. Entrega ao Cliente 

	- Entregue Ao Professor Doutor Engenheiro Aires Manuel Araújo Veloso 

*/


