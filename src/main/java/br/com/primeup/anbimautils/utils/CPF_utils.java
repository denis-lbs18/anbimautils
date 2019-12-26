package br.com.primeup.anbimautils.utils;

import java.util.Random;

public class CPF_utils {

	public static String validar(Long cpf) {
		int dig1 = 0;
		int dig2 = 0;
		int contador = 0;
		String validacao = "Não";
		String mascara = String.format("%011d", cpf);
		char[] charCpf = mascara.toCharArray();

		do {

			dig1 += Character.getNumericValue(charCpf[contador]) * (10 - contador);
			dig2 += Character.getNumericValue(charCpf[contador]) * (11 - contador);
			contador++;
		} while (contador < 9);

		dig1 = (11 - (dig1 % 11) > 9) ? 0 : 11 - (dig1 % 11);
		dig2 = (11 - ((dig2 + dig1 * 2) % 11) > 9) ? 0 : 11 - ((dig2 + dig1 * 2) % 11);

		if (dig1 == Character.getNumericValue(charCpf[9]) & dig2 == Character.getNumericValue(charCpf[10])) {
			validacao = "SIM";
		}
		return validacao;

	}

	public static String gerarCPF() {
		Random gerador = new Random();

		int n1 = gerador.nextInt(9);
		int n2 = gerador.nextInt(9);
		int n3 = gerador.nextInt(9);
		int n4 = gerador.nextInt(9);
		int n5 = gerador.nextInt(9);
		int n6 = gerador.nextInt(9);
		int n7 = gerador.nextInt(9);
		int n8 = gerador.nextInt(9);
		int n9 = gerador.nextInt(9);
		int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		d2 = 11 - (mod(d2, 11));

		if (d2 >= 10)
			d2 = 0;
		return "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;
	}

	private static int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	public static String verificaFarol(String cpf) {

		String farol = null;
		char[] charCpf = cpf.toCharArray();

		switch (Character.getNumericValue(charCpf[8])) {
		case 0:
			farol = "ND";
			break;

		case 1:
			farol = "VERDE";
			break;

		case 9:
			farol = "VERMELHO";
			break;

		default:
			farol = "AMARELO";
		}

		return farol;

	}
}
