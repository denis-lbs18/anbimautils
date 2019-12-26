package br.com.primeup.anbimautils.models;

import br.com.primeup.anbimautils.enums.Operadoras;

public class Celular {
	private Operadoras operadora;
	private int ddd;
	private String numero;

	public Celular(Operadoras operadora, int ddd, String numero) {
		this.operadora = operadora;
		this.ddd = ddd;
		this.numero = numero;
	}

	public Operadoras getOperadora() {
		return this.operadora;
	}

	public String getNumero() {
		return this.numero;
	}

	public String getNumeroCompleto() {
		return this.ddd + this.numero;
	}

	@Override
	public String toString() {
		return this.ddd + this.numero;
	}
}
