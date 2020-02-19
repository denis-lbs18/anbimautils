package br.com.primeup.anbimautils.enums;

public enum EstadoReuniao {
	INDEFINIDO(1) {
		@Override
		public String toString() {
			return "";
		}
	},
	PRESENTE(2) {
		@Override
		public String toString() {
			return "Presente";
		}
	},
	AUSENTE(3) {
		@Override
		public String toString() {
			return "Ausente";
		}
	};

	private int valor;

	public int getValor() {
		return this.valor;
	}

	private EstadoReuniao(int valor) {
		this.valor = valor;
	}
}
