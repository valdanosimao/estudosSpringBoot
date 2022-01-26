package com.curso.springBoot.Conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.curso.springBoot.domain.Departamento;
import com.curso.springBoot.service.DepartamentoService;

@Component
public class StringToDepartamentoConversor implements Converter<String, Departamento>{
	
	@Autowired
	private DepartamentoService service;

	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
