package com.curso.springBoot.dao;

import org.springframework.stereotype.Repository;

import com.curso.springBoot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao  {

}
