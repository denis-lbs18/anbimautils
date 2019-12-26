package br.com.primeup.anbimautils.models;

import br.com.primeup.anbimautils.enums.CargoMembro;
import br.com.primeup.anbimautils.enums.PermissaoForum;
import br.com.primeup.anbimautils.enums.Sexos;

public class Membro {
	private Sexos genero;
	private String cpf;
	private String nome;
	private String instituicao;
	private String instituicaoIndicada;
	private String emailPrincipal = "tstdsftwr@gmail.com";
	private String emailSecundario;
	private Celular telefonePrimario;
	private Celular telefoneSecundario;
	private Secretaria secretaria;
	private CargoMembro cargo;
	private PermissaoForum permissao;

	public Membro(Sexos genero, String cpf, String nome, String instituicao, Celular telefonePrimario,
			CargoMembro cargo, PermissaoForum permissao) {
		super();
		this.genero = genero;
		this.cpf = cpf;
		this.nome = nome;
		this.instituicao = instituicao;
		this.telefonePrimario = telefonePrimario;
		this.cargo = cargo;
		this.permissao = permissao;
	}

	public Membro(Sexos genero, String cpf, String nome, String instituicao, String instituicaoIndicada,
			String emailSecundario, Celular telefonePrimario, Celular telefoneSecundario, Secretaria secretaria,
			CargoMembro cargo, PermissaoForum permissao) {
		super();
		this.genero = genero;
		this.cpf = cpf;
		this.nome = nome;
		this.instituicao = instituicao;
		this.instituicaoIndicada = instituicaoIndicada;
		this.emailSecundario = emailSecundario;
		this.telefonePrimario = telefonePrimario;
		this.telefoneSecundario = telefoneSecundario;
		this.secretaria = secretaria;
		this.cargo = cargo;
		this.permissao = permissao;
	}

	public Sexos getGenero() {
		return genero;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public String getInstituicaoIndicada() {
		return instituicaoIndicada;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public Celular getTelefonePrimario() {
		return telefonePrimario;
	}

	public Celular getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public CargoMembro getCargo() {
		return cargo;
	}

	public PermissaoForum getPermissao() {
		return permissao;
	}
}