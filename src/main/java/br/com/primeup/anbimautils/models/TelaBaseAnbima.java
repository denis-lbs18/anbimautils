package br.com.primeup.anbimautils.models;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.selenium_utils.modelos.TelaBase;

public class TelaBaseAnbima extends TelaBase {
	public TelaBaseAnbima(WebDriver driver) {
		super(driver);
	}

	protected void trataErroEAguardaContinuidadeConsole(String mensagem) {
		System.out.println("************************************************************");
		System.out.printf("\n*%1$58s*\n", mensagem);
		System.out.println("*                                                          *");
		System.out.println("* Escolha uma opção de permissão, e digite *");
		System.out.println("* '1' para continuar o script              *");
		System.out.println("************************************************************");

		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (scanner.nextInt() == 1)
				break;
		}
		scanner.close();
	}

	public void escolheOption(By by, String mensagemErro) {
		try {
			this.getElemento().elementoWebClica(by);
		} catch (ElementClickInterceptedException ex) {
			this.trataErroEAguardaContinuidadeConsole(mensagemErro);
		}
		this.sleep(1);
	}
}
