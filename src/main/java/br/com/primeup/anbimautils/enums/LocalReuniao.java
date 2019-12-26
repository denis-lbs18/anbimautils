package br.com.primeup.anbimautils.enums;

public enum LocalReuniao {
	ANBIMA_SP {
		@Override
		public String toString() {
			return "ANBIMA SP";
		}
	},
	ANBIMA_RJ {
		@Override
		public String toString() {
			return "ANBIMA RJ";
		}
	},
	ANBIMA_SP_RJ {
		@Override
		public String toString() {
			return "ANBIMA SP / ANBIMA RJ";
		}
	},
	/*
	 * ANBIMA_SP_SELIC {
	 * 
	 * @Override public String toString() { return "ANBIMA SP / Selic"; } },
	 */
	OUTRO {
		@Override
		public String toString() {
			return "Outro...";
		}
	};
}
