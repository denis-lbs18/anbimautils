package br.com.primeup.anbimautils.main;

import static br.com.primeup.anbimautils.enums.Sistemas.GAO;

import br.com.denisluna.selenium_utils.modelos.Usuario;
import br.com.denisluna.selenium_utils.utils.selenium.WebDriverUtils;
import br.com.primeup.anbimautils.pageobjects.TelaDeLogin;
import br.com.primeup.anbimautils.pageobjects.gao.TelaAdministrarOrganismo;
import br.com.primeup.anbimautils.pageobjects.gao.TelaOrganismos;
import br.com.primeup.anbimautils.utils.PropertiesUtils;
import br.com.primeup.anbimautils.utils.UsuarioUtils;

public class AbreRegistroReuniaoMembro {
	static Usuario usuario = UsuarioUtils.pegaUsuarioConsulta();

	public static void main(String[] args) {
		TelaDeLogin telaDeLogin = new TelaDeLogin(WebDriverUtils.instanciaChromeDriver());
		TelaOrganismos telaOrganismos = (TelaOrganismos) telaDeLogin.realizaLogin(GAO, usuario);

		TelaAdministrarOrganismo telaAdministrarOrganismo = telaOrganismos.clicaBotaoOrganismoConsulta();
		telaAdministrarOrganismo.clicaLinkExpandirHistoricoReunioes();
		telaAdministrarOrganismo.clicaBotaoEditarReuniaoVisaoMembro(PropertiesUtils.getVariable("massa.organismo.reuniao.nome"));
	}
}