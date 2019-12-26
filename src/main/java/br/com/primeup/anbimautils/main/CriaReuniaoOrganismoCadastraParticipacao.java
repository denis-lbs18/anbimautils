package br.com.primeup.anbimautils.main;

import static br.com.primeup.anbimautils.enums.Sistemas.GAO;

import br.com.denisluna.selenium_utils.modelos.Usuario;
import br.com.denisluna.selenium_utils.utils.selenium.WebDriverUtils;
import br.com.primeup.anbimautils.pageobjects.TelaDeLogin;
import br.com.primeup.anbimautils.pageobjects.gao.TelaAdministrarOrganismo;
import br.com.primeup.anbimautils.pageobjects.gao.TelaNovaReuniao;
import br.com.primeup.anbimautils.pageobjects.gao.TelaOrganismos;
import br.com.primeup.anbimautils.utils.MassaUtils;
import br.com.primeup.anbimautils.utils.UsuarioUtils;

public class CriaReuniaoOrganismoCadastraParticipacao {
	static Usuario usuario = UsuarioUtils.pegaUsuarioGestao();

	public static void main(String[] args) {
		TelaDeLogin telaDeLogin = new TelaDeLogin(WebDriverUtils.instanciaChromeDriver());
		TelaOrganismos telaOrganismos = (TelaOrganismos) telaDeLogin.realizaLogin(GAO, usuario);
		telaOrganismos.insereFiltroOrganismo("Lorem");
		telaOrganismos.clicaBotaoFiltrarOrganismo();

		TelaAdministrarOrganismo telaAdministrarOrganismo = telaOrganismos.clicaBotaoAdministrar(1);
		TelaNovaReuniao telaNovaReuniao = telaAdministrarOrganismo.clicaBotaoNovaReuniao();
		telaNovaReuniao.cadastraReuniaoSelecionaParticipacao(MassaUtils.geraReuniao());
	}
}