package br.com.primeup.anbimautils.enums;

public enum Participacao {
	PRESENTE {
		@Override
		public String toString() {
			return "Presente";
		}
	},
	AUSENTE {
		@Override
		public String toString() {
			return "Ausente";
		}
	};
}