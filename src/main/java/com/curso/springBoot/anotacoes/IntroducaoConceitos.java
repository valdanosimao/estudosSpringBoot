package com.curso.springBoot.anotacoes;

public class IntroducaoConceitos {
	
	/*  INJEÇÃO DE DEPEDÊNCIAS!	 * 	
	 * 	É um padrão de projeto que já está implementado pelo Spring framework,
	 *  este padrão possui alguns princípios, destaque para dois dele
	 *  primeiro: diminuir a buscar por acoplamento entre classes
	 *  baseado em abstrações: interfaces
	 *  no String não podemos injetar classes abstratas, e sim interfaces e classes concretas
	 *  
	 *  O QUE É UMA DEPEDÊNCIA?	 *  
	 *  Uma dependência é simplesmente um objeto que a sua classe precisa para funcionar
	 *  ou seja, se vc declara uma classe A, e dentro da classe A um atributo da classe B
	 *  a classe A só será criada, quando existir uma instância da classe B.
	 *  
	 *  INVERSÃO DE CONTROLE!
	 *  Tem como princípio remover do programador a responsabilidade dele criar a
	 *  instância de seus objetos, desta forma estamos passando esta responsábilidade
	 *  para um software que é chamado de "CONTAINER", o qual implementa os padrões de 
	 *  injeção de dependência e inversão de controle
	 *  
	 *  BEAN!
	 *  No Spring para gente trabalhar com injeção de depedência, a gente vai precisar
	 *  trabalhar com bean, o que são bean? São as classes as quais vc passa a responsábilidade
	 *  do gerênciamento delas para o Spring, e para passar para o Spring a responsábilidade
	 *  de gerênciar uma classe vc utiliza "Anotações"
	 *  por exemplo: 
	 *  
	 *  @Component:
	 *  É uma anotação básica para criar qualquer tipo de bean gerenciado pelo Spring Framework.
	 *  Normalmente usada quando não se define um bean como @Repository ou @Service.
	 *  
	 *  @Repository:
	 *  Define um bean como sendo do tipo persistente para uso em classes de acesso a banco de dados. 
	 *  A partir desta anotação o Spring pode usar recursos referentes a persistência, como
	 *  tratar as exceções específicas para este fim. Ou seja acessar o banco de dados
	 *  
	 *  @Service:
	 *  Usado para classes do tipo serviço(Service Layer), que possuem, por exemplo, regras de negócios
	 *  
	 *  @Autowired:
	 *  Anotação usada para informar ao Spring que ele deve injetar a variável de instância anotada na classe
	 *  em que está declarada.
	 *  Exemplo: 
	 *  
	 *  @Service
	 *  public class ComputadorService{
	 *  	
	 *  	@Autowired
	 *  	private ComputadorDao dao;
	 *  
	 *  	public void salvar(Computador computador) {
	 *  	
	 *  		dao.saveOrUpdate(computador);
	 *  	}
	 *  }
	 *  		Nã classe computadorService nós declaramos uma variável de instância
	 *  para computador dao, e para injetar computador dao aqui em computadorService
	 *  nós anotamos a variável de instância com o Autowired. Dessa form o Spring
	 *  quando cria a classe computadorService, ele garante para nós que ela já vai ser
	 *  criada contendo uma instância para computadorDao, por isso no método salvar
	 *  a gente pode utilizar a variável dao, sem ter null pointer exception
	 *  
	 *  SPRING MVC!
	 *  O Spring MVC, tem como caractéristica principal, dividir a aplicação em três 
	 *  componentes, de responsábilidades distintas.(Model, View e Controller)
	 *  
	 *  MODEL:
	 *  Define o modelo ou domónio da aplicação, ou seja classes de domínio 
	 *  ou classes de modelo, essas classes são as quais toda aplicação gira em torno
	 *  por exmplo uma classe de entidade que representa uma tabela no banco de dados,
	 *  toda aplicação acaba tendo como foco trabalhar com essa classe, assim como 
	 *  a camada de persistência, camada de serviço ou regras de negócio, até mesmo 
	 *  as interfaces gráficas é baseada nos atributos das classes de entidade
	 *  Classes de regras de negócios ou camada se serviçoes e a persistência de
	 *  dados, tbm fazem parte do componente model.
	 *  
	 *  VIEW:
	 *  É o componente com a responsábilidade de fornecer a interação com o usuário
	 *  é nele que serão inseridos o dados de entrada e saída e tbm visualizar os
	 *  dados de saída
	 *  
	 *  CONTROLLER:
	 *  Componente intermediário entre o Model e o View, é ele que vai receber as
	 *  requisições do usuário que partem do view e tbm vai se comunicar ou requisitar
	 *  ao model ao que o usuário solicitou a partir dos dados de entrada
	 *  
	 *  Porque usar o SPRING MVC?
	 *  Ele é considerado modermo e poderoso, pq a partir dele podemos desde simples
	 *  até robustas aplicações e ela podem ser construidas  com os mais modernos e 
	 *  atuais recursos da linguagem Java entre esses recursos temos a integração
	 *  com templates Web como (Jstl, JS, Thymeleaf) tbm podemos fazer uso de forma
	 *  muito simples requisições baseada em Ajax. Outro ponto interessante é a 
	 *  conversão de dados entre a interface gráfica e o modelo, o Spring mvc
	 *  fornece algumas formas distintas para realizar essa conversão com o minimo
	 *  de esforço possível, algumas como convensão de datas e valores, ponto flutuante
	 *  podem ser convertidos apenas com o uso de anotações
	 *  a integração com validação do lado servidor, podem ser facilmente realizada
	 *  junto ao Spring Mvc quando vc usar o Hibernate, o Spring mvc tbm pode
	 *  tbm lidar com serviços RESTful, sendo usado inclusive para criação
	 *  de api RESTful
	 *  
	 *  O Padrão MVC:
	 *  No Spring MVC vai existir um rercurso que fica abstraido de nós chamado de 
	 *  Front Controller (Dispatcher Servlet: que seria receber as requisições
	 *  que vem a interface gráfica ou seja dos navegadores)
	 *  
	 *  ANOTAÇÕES SPRING MVC!
	 *  
	 *  @Controller
	 *  Transforma a classe em um bean do tipo controller do MVC
	 *  
	 *  @RequestMapping
	 *  Usada para mapear URL´s de acesso a um controller e os métodos contidos
	 *  nele, Tbm podemos definir vermos HTTP (POST,GET,...) de acesso aos métodos.
	 *  Exemplo:
	 *  
	 *  @Controller
	 *  @RequestMapping("/computadores") 
	 *  public class ComputadorController {
	 *  	
	 *  	@RequestMapping(path = "/listagem" , method = requestMethod.GET)
	 *  	public String getComputadores(){
	 *   }
	 * }  
	 *  	
	 *  	Ainda temos um grupo de anotações para facilitar substituir o uso de RequestMapping
	 *  Exemplo:
	 *  
	 *  @GetMapping:
	 *  Mesmo funcionalidade do RequestMapping, porém não precisa informar o RequestMethod do tipo GET 
	 *   	  
	 *  @PostMapping:
	 *  Mesma coisa, ao invés de usar o o RequestMapping e informar que é um método POST, GET, DELETE etc..
	 *  Vc pode usar diretamente umas das anotações 	 
	 *  @PutMapping
	 *  @DeleteMapping
	 *  @PatchMapping
	 *  
	 *  @PathVariable
	 *  Tem o objetivo de extrair da URL um parâmetro que foi incluido como path da URL,
	 *  o que são parametros na forma de path? é quando seu parâmetro faz parte de um caminho
	 *  da URL
	 *  Exmplo:
	 *  			http://localhost:8080/demo/computadores/listagem/ibm
	 *  	o /ibm neste caso seria um parâmetro que está como um path dessa url
	 *  
	 *  Sendo assim na assinatura do método que vai receber a solicitação usar a anotação @PathVariable
	 *  
	 *  Exmplo:
	 *  @Controller
	 *  @RequestMapping("/computadores")
	 *  public class computadorController {
	 *  
	 *  	@RequestMapping(path = "/listagem/{marca}" , method = RequestMethod.GET) //o {marca} substitui o /imb
	 *  	public String getComputadoresPorMarca(@PathVariable("marca") String marca){
	 *   }
	 * }  	
	 *  
	 * @RequestParam
	 * Tem como objetivo capturar um parâmetro de consulta (Query Param) enviado por uma solicitação.
	 * ela vai trabalhar com parametros que vem no corpo da requisição	 * 
	 * Exemplo:
	 * 				http://localhost:8080/demo/computadores/listagem?marca=ibm
	 * 																aqui temos um parametro do tipo Query Param
	 *  															este parametro vem no objeto da requisição
	 *  															e não na URL				
	 * 
	 * Exmplo:
	 *  @Controller
	 *  @RequestMapping("/computadores")
	 *  public class computadorController {
	 *  
	 *  	@RequestMapping(path = "/listagem/{marca}" , method = RequestMethod.GET)  o /imb
	 *  	public String getComputadoresPorMarca(@RequestParam(name = "marca") String marca){
	 *   }
	 * } 			
	 * 
	 *  @ModelAttribute
	 *  Pode ser usado sobre a assinatura de um método ou com argumento de um método
	 *  
	 *  @Valid
	 *  Anotação responsável por injetar a validação back-end via Hibernate Validator, 
	 *  Bean Validation ou Spring Validator		
	 *  
	 *  
	 *  OBJETOS DE RESPOSTA DO SPRING MVC!
	 *  
	 *  MODELMAP
	 *  Objeto Usado para enviar dados a página como resposta de uma solicitação.
	 *  Trabalha como uma resposta do tipo forward
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	

}
