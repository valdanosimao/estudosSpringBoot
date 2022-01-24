package com.curso.springBoot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@ManyToOne //Um para muitos, um departamento tem muitos cargos/ SE LER DA DIREITA PARA ESQUERDA
	@JoinColumn(name = "id_departamento_fk") //notação que referencia a chave estrangeira no banco de dados
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo") 				//Muitos para um, muitos funcinarios para um cargo
	private List<Funcionario> funcionarios;		//a classe cargo é o lado fraco do relacionamento
												//e o lado forte é funcionario			

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	 
}

