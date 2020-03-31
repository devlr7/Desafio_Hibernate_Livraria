package com.qintess.estudo.livraria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_autor;
	
	@Column(length = 100)
	private String nome;
	
	@Column(length = 100)
	private String email;
	
	//construtor default
	public Autor() {
		
	}
	
	//construtor parametrizado
	public Autor(String nome, String email) {
		
		this.nome = nome;
		this.email = email;
		
	}
	
	@Override
	public String toString() {
		
		return "Autor [ID = "+ id_autor +",  nome = "+ nome  + ", email= " + email + "]";
		
	}
	
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	  
}
