package br.com.primeup.anbimautils.pageobjects.gao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.selenium_utils.utils.selenium.ByUtils;
import br.com.primeup.anbimautils.enums.CargoMembro;
import br.com.primeup.anbimautils.models.TelaBaseAnbima;
import br.com.primeup.anbimautils.utils.MassaUtils;

public class TelaAdministrarOrganismo extends TelaBaseAnbima {
	private By botaoNovaReuniao = ByUtils.encontraByID("form-area-botoes-nova-reuniao:novaReuniao");
	private By botaoControleDeFaltas = ByUtils.encontraByID("form-area-botoes-nova-reuniao:controleFaltas");
	private By botaoAdministrarMandato = ByUtils.encontraByID("administrarMandato");
	private By linkExpandirMembrosOrganismos = By.xpath("//div[@id='bloco-lista-membros']//p[1]");
	private By labelPresidente = ByUtils.encontraByTexto(ByUtils.LABEL, CargoMembro.PRESIDENTE.toString());
	private By labelVicePresidente = ByUtils.encontraByTexto(ByUtils.LABEL, CargoMembro.VICE_PRESIDENTE.toString());

	public TelaAdministrarOrganismo(WebDriver driver) {
		super(driver);
	}

	public TelaNovaReuniao clicaBotaoNovaReuniao() {
		this.getElemento().elementoWebClica(this.botaoNovaReuniao);
		return new TelaNovaReuniao(this.getDriver());
	}

	public void clicaBotaoControleDeFaltas() {
		this.getElemento().elementoWebClica(this.botaoControleDeFaltas);
	}

	public TelaConfiguracaoMandatos clicaBotaoAdministrarMandato() {
		this.getElemento().elementoWebClica(this.botaoAdministrarMandato);
		boolean jaTemPresidente = this.getElemento().elementoWebEstaVisivelWait(this.labelPresidente);
		System.out.println("****************************************");
		System.out.println("*        Presidente cadastrado         *");
		System.out.println("****************************************");
		MassaUtils.setJaTemPresidente(jaTemPresidente);

		boolean jaTemVicePresidente = this.getElemento().elementoWebEstaVisivel(this.labelVicePresidente);
		MassaUtils.setJaTemVicePresidente(jaTemVicePresidente);
		System.out.println("****************************************");
		System.out.println("*     Vice-Presidente cadastrado       *");
		System.out.println("****************************************");

		return new TelaConfiguracaoMandatos(this.getDriver());
	}

	public void clicaLinkExpandirMembrosOrganismos() {
		this.getElemento().elementoWebClica(this.linkExpandirMembrosOrganismos);
	}
}
