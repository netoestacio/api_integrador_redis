package br.com.integrador.controllers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class IntegradorController {
	
	@GetMapping()
	@Cacheable("hello")
	public String teste() {
		System.out.println("Chamada Cache");
		return "Hello cache";
	}
	
	@GetMapping(path = "/cancel")
	@CacheEvict("hello")
	public String cancelar() {
		System.out.println("Limpar Cache");
		return "Cache cancelado";
	}
}
