package br.com.primeup.anbimautils.pageobjects.gao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.denisluna.selenium_utils.utils.selenium.ByUtils;
import br.com.primeup.anbimautils.models.TelaBaseAnbima;
import br.com.primeup.anbimautils.utils.PropertiesUtils;

public class TelaOrganismos extends TelaBaseAnbima {
	private By botaoNovoOrganismo = ByUtils.encontraByID("novoOrganismo");
	private By inputFiltroOrganismo = ByUtils.encontraByID("nomeOrganiamo");
	private By botaoFiltrarOrganismo = ByUtils.encontraByID("filtrarButton");
	private By linkAdministrar = ByUtils.encontraByTexto(ByUtils.A_LINK, "Administrar");
	private By linkOrganismoConsulta = ByUtils.encontraByTextoContains(ByUtils.A_LINK,
			PropertiesUtils.getVariable("massa.organismo.nome"));

	public TelaOrganismos(WebDriver driver) {
		super(driver);
	}

	public TelaNovoOrganismo clicaBotaoNovoOrganismo() {
		this.getElemento().elementoWebClica(this.botaoNovoOrganismo);
		return new TelaNovoOrganismo(this.getDriver());
	}

	public void insereFiltroOrganismo(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputFiltroOrganismo, texto);
	}

	public void clicaBotaoFiltrarOrganismo() {
		this.getElemento().elementoWebClica(this.botaoFiltrarOrganismo);
	}

	public TelaAdministrarOrganismo clicaBotaoAdministrar(int indiceBotao) {
		this.sleep(2);
		List<WebElement> listaAdministrar = null;
		try {
			listaAdministrar = this.getElemento().elementoWebAchaElementosWait(this.linkAdministrar);
		} catch (TimeoutException ex) {
			System.out.println("*******************************************************");
			System.out.println("* Não foram encontrados registros com o nome buscado. *");
			System.out.println("* Mensagem de erro:                                   *");
			System.out.println(ex.toString());
			System.out.println("*******************************************************");
			throw new IllegalArgumentException("Organismo não encontrado.");
		}

		if (!(indiceBotao > listaAdministrar.size()))
			listaAdministrar.get(indiceBotao - 1).click();

		return new TelaAdministrarOrganismo(this.getDriver());
	}

	public TelaAdministrarOrganismo clicaBotaoOrganismoConsulta() {

		try {
			this.getElemento().elementoWebClica(this.linkOrganismoConsulta);
			return new TelaAdministrarOrganismo(this.getDriver());
		} catch (TimeoutException ex) {
			System.out.println("*******************************************************");
			System.out.println("* Não foram encontrados registros com o nome buscado. *");
			System.out.println("* Mensagem de erro:                                   *");
			System.out.println(ex.toString());
			System.out.println("*******************************************************");
			throw new IllegalArgumentException("Organismo não encontrado.");
		}
	}
}