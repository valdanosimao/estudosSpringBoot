package com.curso.springBoot.service;

import java.util.List;

import com.curso.springBoot.domain.Departamento;

public interface DepartamentoService {
	
void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();

	boolean departamentoTemCargo(Long id);

}
