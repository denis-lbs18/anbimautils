package br.com.primeup.anbimautils.enums;

public enum Categoria {
	COMUNICACAO(1) {
		@Override
		public String toString() {
			return "Comunicação";
		}
	},
	DIRETORIA(2) {
		@Override
		public String toString() {
			return "Diretoria";
		}
	},
	ESTATUTARIO(3) {
		@Override
		public String toString() {
			return "Estatutário";
		}
	},
	ORGANISMO_DE_APOIO(4) {
		@Override
		public String toString() {
			return "Organismos de apoio";
		}
	},
	ORGANISMO_AUTORREGULACAO(5) {
		@Override
		public String toString() {
			return "Organismos de autorregulação";
		}
	},
	ORGANISMO_PRODUTOS_SERVICOS(6) {
		@Override
		public String toString() {
			return "Organismos de produtos e serviços";
		}
	},
	ORGANISMO_REPRESENTACAO(7) {
		@Override
		public String toString() {
			return "Organismos de representação";
		}
	};

	private final int valor;

	private Categoria(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}