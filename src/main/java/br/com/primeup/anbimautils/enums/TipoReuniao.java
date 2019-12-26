package br.com.primeup.anbimautils.enums;

public enum TipoReuniao {
	ORDINARIA {
		@Override
		public String toString() {
			return "Ordinária";
		}
	},
	EXTRA_ORDINARIA {
		@Override
		public String toString() {
			return "Extraordinária";
		}
	};
}
