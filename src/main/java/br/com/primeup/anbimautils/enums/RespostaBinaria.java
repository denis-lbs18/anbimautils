package br.com.primeup.anbimautils.enums;

/**
 * Enum que parametriza os valores padrão de respostas positivas/negativas.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public enum RespostaBinaria {
	SIM {
		@Override
		public String toString() {
			return "Sim";
		}
	},
	NAO {
		@Override
		public String toString() {
			return "Não";
		}
	};
}
