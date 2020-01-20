package br.com.primeup.anbimautils.models;

import java.time.LocalDate;

import br.com.primeup.anbimautils.enums.Categoria;
import br.com.primeup.anbimautils.enums.RespostaBinaria;
import br.com.primeup.anbimautils.enums.TermoUtilizar;
import br.com.primeup.anbimautils.enums.TipoOrganismo;

public class Organismo {
	private String nome;
	private TipoOrganismo tipo;
	private String codigoPertencente;
	private Categoria categoria;
	private LocalDate dataInicioOrganismo;
	private LocalDate dataFimOrganismo;
	private int qtdeMinimaMembros;
	private int qtdeMaximaMembros;
	private RespostaBinaria possuiTermo;
	private RespostaBinaria possuiRevisaoDeMembros;
	private TermoUtilizar termo;
	private RespostaBinaria enviarComunicacaoMembro;
	private RespostaBinaria solicitarAssinatura;

	public Organismo(String nome, TipoOrganismo tipo, String codigoPertencente, Categoria categoria,
			LocalDate dataInicioOrganismo, LocalDate dataFimOrganismo, int qtdeMinimaMembros, int qtdeMaximaMembros,
			RespostaBinaria possuiTermo, RespostaBinaria possuiRevisaoDeMembros, TermoUtilizar termo,
			RespostaBinaria enviarComunicacaoMembro, RespostaBinaria solicitarAssinatura) {
		this.nome = nome;
		this.tipo = tipo;
		this.codigoPertencente = codigoPertencente;
		this.categoria = categoria;
		this.dataInicioOrganismo = dataInicioOrganismo;
		this.dataFimOrganismo = dataFimOrganismo;
		this.qtdeMinimaMembros = qtdeMinimaMembros;
		this.qtdeMaximaMembros = qtdeMaximaMembros;
		this.possuiTermo = possuiTermo;
		this.possuiRevisaoDeMembros = possuiRevisaoDeMembros;
		this.termo = termo;
		this.enviarComunicacaoMembro = enviarComunicacaoMembro;
		this.solicitarAssinatura = solicitarAssinatura;
	}

	public String getNome() {
		return nome;
	}

	public TipoOrganismo getTipo() {
		return tipo;
	}

	public String getCodigoPertencente() {
		return codigoPertencente;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public LocalDate getDataInicioOrganismo() {
		return dataInicioOrganismo;
	}

	public LocalDate getDataFimOrganismo() {
		return dataFimOrganismo;
	}

	public int getQtdeMinimaMembros() {
		return qtdeMinimaMembros;
	}

	public int getQtdeMaximaMembros() {
		return qtdeMaximaMembros;
	}

	public RespostaBinaria getPossuiTermo() {
		return possuiTermo;
	}

	public RespostaBinaria getPossuiRevisaoDeMembros() {
		return possuiRevisaoDeMembros;
	}

	public TermoUtilizar getTermo() {
		return termo;
	}

	public RespostaBinaria getEnviarComunicacaoMembro() {
		return enviarComunicacaoMembro;
	}

	public RespostaBinaria getSolicitarAssinatura() {
		return solicitarAssinatura;
	}
}