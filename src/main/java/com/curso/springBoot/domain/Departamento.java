package com.curso.springBoot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	public String nome;
	
	@OneToMany(mappedBy = "departamento") //Muitos para um, muitos cargos para um departamento //sempe se ler da direita para esquerda
	private List<Cargo> cargos;			  //O MAPPEDBY, ESTE ATRIBUTO É NECESSÁRIO PQ ESSE RELACIONAMENTO É BI-DIRECIONAL ENTRE DEPARTAMENTO
										  //E QUANDO TEMOS UM RELACIONAMENTO BI-DIRECIONAL, TEMOS QUE DEFINIR QUAL O LADO FRACO, E O LADO FORTE
										  //DA RELAÇÃO, O LADO FORTE É AQUELE QUE CONTEM A CHAVE ESTRANGEIRA, NO CASO CARGOS ENTÃO O 				
										  //MEPPEDBY SERVE PARA VC DIZER QUAL O ATRIBUTO QUE ESTÁ FAZENDO PARTE DO LADO FORTE DA RELAÇÃO
	                                      //O ATRIBUTO ENTÃO É O DEPARTAMENTO, LÁ NA CLASSE CARGO
	
	
	public String getNome() {
		return nome;
	}
	
	public void serNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
}
