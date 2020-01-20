package br.com.primeup.anbimautils.enums;

public enum TermoUtilizar {
	TERMO_POSSE(1) {
		@Override
		public String toString() {
			return "Termo de Posse";
		}
	},
	TERMO_CONFIDENCIALIDDADE(2) {
		@Override
		public String toString() {
			return "Termo de Confidencialidade";
		}
	};

	private final int valor;

	private TermoUtilizar(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
