package br.com.primeup.anbimautils.models;

public class Secretaria {
	private String nome;
	private Celular telefone;
	private String email;

	public Secretaria(String nome, Celular telefone, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public Celular getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
}
