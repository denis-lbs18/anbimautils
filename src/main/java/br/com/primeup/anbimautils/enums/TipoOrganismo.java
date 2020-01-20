package br.com.primeup.anbimautils.enums;

public enum TipoOrganismo {
	COMISSAO(1) {
		@Override
		public String toString() {
			return "Comissão";
		}
	},
	COMISSAO_TESTE(2) {
		@Override
		public String toString() {
			return "Comissão de Teste";
		}
	},
	COMITE(3) {
		@Override
		public String toString() {
			return "Comitê";
		}
	},
	CONSELHO(4) {
		@Override
		public String toString() {
			return "Conselho";
		}
	},
	FORUM(5) {
		@Override
		public String toString() {
			return "Fórum";
		}
	},
	GRUPO_CONSULTIVO(6) {
		@Override
		public String toString() {
			return "Grupo Consultivo";
		}
	},
	GRUPO_DE_TRABALHO(7) {
		@Override
		public String toString() {
			return "Grupo de Trabalho";
		}
	},
	GT(8) {
		@Override
		public String toString() {
			return "GT";
		}
	};

	private final int valor;

	private TipoOrganismo(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
