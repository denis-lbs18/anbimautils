package br.com.primeup.anbimautils.pageobjects;

import static br.com.primeup.anbimautils.enums.Sistemas.GAO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.selenium_utils.modelos.Usuario;
import br.com.denisluna.selenium_utils.utils.selenium.ByUtils;
import br.com.primeup.anbimautils.constantes.PadraoDeURLs;
import br.com.primeup.anbimautils.enums.Sistemas;
import br.com.primeup.anbimautils.models.TelaBaseAnbima;
import br.com.primeup.anbimautils.pageobjects.gao.TelaOrganismos;

public class TelaDeLogin extends TelaBaseAnbima {
	private By inputLogin = ByUtils.encontraByID("username");
	private By inputSenha = ByUtils.encontraByID("password");
	private By botaoEntrar = ByUtils.encontraByID("submit");

	public TelaDeLogin(WebDriver driver) {
		super(driver);
	}

	public void insereLogin(String texto) {
		for (Character mander : texto.toCharArray()) {
			this.getElemento().elementoWebInsereTexto(this.inputLogin, mander.toString());
		}

	}

	public void insereSenha(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputSenha, texto);
	}

	public void clicaBotaoEntrar() {
		this.getElemento().elementoWebClica(this.botaoEntrar);
	}

	public void realizaLogin(String login, String senha) {
		this.insereLogin(login);
		this.sleep(1);
		this.insereSenha(senha);
		this.sleep(1);
		this.clicaBotaoEntrar();
	}

	public TelaBaseAnbima realizaLogin(Sistemas sistema, Usuario usuario) {
		String url = PadraoDeURLs.pegaURL(sistema);
		this.navega(url);
		this.sleep(2);
		this.realizaLogin(usuario.getUsuario(), usuario.getSenha());

		if (sistema.equals(GAO))
			return new TelaOrganismos(this.getDriver());
		else
			return null;
	}
}
