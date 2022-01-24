package com.curso.springBoot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long>{
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00") //columnDefinition vai servir para que eu defina o tipo de dado
	private BigDecimal salario;					                              //que eu vou ter lá no banco de dados		

	@Column(name = "data_entrada" , nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Column(name = "data_saida" , columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	@OneToOne(cascade = CascadeType.ALL) //relacionamento um para um. 
	@JoinColumn(name = "endereco_id_fk") //quando for inserir um funcionário, eu vou inserir tbm
	private Endereco endereco;			//por cascata um endereço, mesma coisa quando for editar 	
										//um funcinario, se eu precisar eu já edito o endereço
										//e quando eu excluir um funcionário, eu quero que o 
	                                    //endereço seja excluido tbm da base de dados
	@ManyToOne //relacionamento um para muitos, um cargo vai ter muitos funcionários
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
	
	
	
	
	
}