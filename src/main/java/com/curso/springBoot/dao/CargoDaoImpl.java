package com.curso.springBoot.dao;

import org.springframework.stereotype.Repository;

import com.curso.springBoot.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}
