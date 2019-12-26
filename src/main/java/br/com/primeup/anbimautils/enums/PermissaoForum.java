package br.com.primeup.anbimautils.enums;

public enum PermissaoForum {
	MASTER(1) {
		@Override
		public String toString() {
			return "Master";
		}
	},
	ADMINISTRADOR(2) {
		@Override
		public String toString() {
			return "Administrador";
		}
	},
	CONSULTA(3) {
		@Override
		public String toString() {
			return "Consulta";
		}
	};

	private final int valor;

	private PermissaoForum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}
