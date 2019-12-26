package br.com.primeup.anbimautils.enums;

public enum CargoMembro {
	PRESIDENTE {
		@Override
		public String toString() {
			return "Presidente";
		}
	},
	VICE_PRESIDENTE {
		@Override
		public String toString() {
			return "Vice-presidente";
		}
	},
	MEMBRO {
		@Override
		public String toString() {
			return "Membro";
		}
	},
	COORDENADOR {
		@Override
		public String toString() {
			return "Coordenador";
		}
	};
}
