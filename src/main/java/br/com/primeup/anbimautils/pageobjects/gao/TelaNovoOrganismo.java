package br.com.primeup.anbimautils.pageobjects.gao;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.selenium_utils.enums.Formato;
import br.com.denisluna.selenium_utils.utils.LocalDateTimeUtils;
import br.com.denisluna.selenium_utils.utils.selenium.ByUtils;
import br.com.primeup.anbimautils.enums.Categoria;
import br.com.primeup.anbimautils.enums.RespostaBinaria;
import br.com.primeup.anbimautils.enums.TermoUtilizar;
import br.com.primeup.anbimautils.enums.TipoOrganismo;
import br.com.primeup.anbimautils.models.Organismo;
import br.com.primeup.anbimautils.models.TelaBaseAnbima;

public class TelaNovoOrganismo extends TelaBaseAnbima {
	private By inputNomeOrganismo = ByUtils.encontraByID("nomeOrganismo");
	private By selectTipoOrganismo = ByUtils.encontraByID("tipoOrganismo");
	private By selectCodigoPertencente = ByUtils.encontraByID("codigoPertencente");
	private By selectCategoria = ByUtils.encontraByID("categoria");
	private By inputDataInicioOrganismo = ByUtils.encontraByID("inicioOrganismoInputCurrentDate");
	private By inputDataFimOrganismo = ByUtils.encontraByID("fimOrganismoInputCurrentDate");
	private By inputQtdeMinimaOrganismo = ByUtils.encontraByID("qtdMinima");
	private By inputQtdeMaximaOrganismo = ByUtils.encontraByID("qtdMaxima");
	private By botaoCriarOrganismo = ByUtils.encontraByID("btnCriarOrganismo");

	public TelaNovoOrganismo(WebDriver driver) {
		super(driver);
	}

	public void insereInputNomeOrganismo(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputNomeOrganismo, texto);
		this.sleep(2);
	}

	public void selecionaTipoOrganismo(String texto) {
		this.getElemento().elementoWebSelecionaListaSelect(this.selectTipoOrganismo, texto);
		this.sleep(2);
	}

	public void selecionaTipoOrganismo(int index) {
		this.getElemento().elementoWebSelecionaListaSelect(this.selectTipoOrganismo, index);
		this.sleep(2);
	}

	public void selecionaTipoOrganismo(TipoOrganismo tipo) {
		this.selecionaTipoOrganismo(tipo.toString());
	}

	public void selecionaCodigoPertencenteOrganismo(String texto) {
		this.getElemento().elementoWebSelecionaListaSelect(this.selectCodigoPertencente, texto);
		this.sleep(2);
	}

	public void selecionaCodigoPertencenteOrganismo(int index) {
		this.getElemento().elementoWebSelecionaListaSelect(this.selectCodigoPertencente, index);
		this.sleep(2);
	}

	public void selecionaCategoriaOrganismo(String texto) {
		this.getElemento().elementoWebSelecionaListaSelect(this.selectCategoria, texto);
		this.sleep(2);
	}

	public void selecionaCategoriaOrganismo(int index) {
		this.getElemento().elementoWebSelecionaListaSelect(this.selectCategoria, index);
		this.sleep(2);
	}

	public void selecionaCategoriaOrganismo(Categoria tipo) {
		this.selecionaCategoriaOrganismo(tipo.toString());
	}

	public void insereInputDataInicioOrganismo(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputDataInicioOrganismo, texto);

		this.sleep(2);
	}

	public void insereInputDataFimOrganismo(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputDataFimOrganismo, texto);
		this.sleep(2);
	}

	public void insereInputQtdeMinimaOrganismo(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputQtdeMinimaOrganismo, texto);
		this.sleep(2);
	}

	public void insereInputQtdeMinimaOrganismo(int valor) {
		this.insereInputQtdeMinimaOrganismo(Integer.toString(valor));
	}

	public void insereInputQtdeMaximaOrganismo(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputQtdeMaximaOrganismo, texto);
		this.sleep(2);
	}

	public void insereInputQtdeMaximaOrganismo(int valor) {
		this.insereInputQtdeMaximaOrganismo(Integer.toString(valor));
	}

	public void escolheTermo(RespostaBinaria resposta) {
		By optionOrganismoPossuiTermo = ByUtils.encontraByTextoContains(ByUtils.LABEL, resposta.toString(), 1);
		this.escolheOption(optionOrganismoPossuiTermo, "Erro ao selecionar opção de Termo.");
	}

	public void escolheOrganismoPossuiRevisao(RespostaBinaria resposta) {
		By optionOrganismoPossuiRevisao = ByUtils.encontraByTextoContains(ByUtils.LABEL, resposta.toString(), 2);
		this.escolheOption(optionOrganismoPossuiRevisao, "Erro ao selecionar se organismo possui revisão de membros.");
	}

	public void escolheTermoUtilizar(TermoUtilizar termo) {
		By optionTermo = ByUtils.encontraByTextoContains(ByUtils.LABEL, termo.toString());
		this.escolheOption(optionTermo, "Erro ao selecionar Termo.");
	}

	public void escolheEnviarComunicacao(RespostaBinaria resposta) {
		By optionEnviarComunicacao = ByUtils.encontraByTextoContains(ByUtils.LABEL, resposta.toString(), 3);
		this.escolheOption(optionEnviarComunicacao, "Erro ao selecionar opção de envio de comunicação.");
	}

	public void escolheSolicitarAssinatura(RespostaBinaria resposta) {
		By optionSolicitarAssinatura = ByUtils.encontraByTextoContains(ByUtils.LABEL, resposta.toString(), 4);
		this.escolheOption(optionSolicitarAssinatura,
				"Erro ao selecionar assinatura deve ser solicitada ao renovar mandato.");
	}

	public void clicaBotaoCriarOrganismo() {
		this.getElemento().elementoWebClica(this.botaoCriarOrganismo);
		this.sleep(2);
	}

	public void preencherCadastro(Organismo organismo) {
		this.insereInputNomeOrganismo(organismo.getNome());
		this.selecionaTipoOrganismo(organismo.getTipo());
		this.selecionaCodigoPertencenteOrganismo(organismo.getCodigoPertencente());
		this.selecionaCategoriaOrganismo(organismo.getCategoria());
		try {
			String dataInicio = LocalDateTimeUtils.formataData(Formato.DDMMYYYY, organismo.getDataInicioOrganismo());
			this.insereInputDataInicioOrganismo(dataInicio);

			String dataFim = LocalDateTimeUtils.formataData(Formato.DDMMYYYY, organismo.getDataFimOrganismo());
			this.insereInputDataFimOrganismo(dataFim);
		} catch (TimeoutException ex) {
			super.trataErroEAguardaContinuidadeConsole("Erro ao inserir data de início do organismo.");
		}
		this.insereInputQtdeMinimaOrganismo(organismo.getQtdeMinimaMembros());
		this.insereInputQtdeMaximaOrganismo(organismo.getQtdeMaximaMembros());

		this.escolheTermo(organismo.getPossuiTermo());
		this.escolheOrganismoPossuiRevisao(organismo.getPossuiRevisaoDeMembros());

		if (organismo.getPossuiTermo().equals(RespostaBinaria.SIM)) {
			this.escolheTermoUtilizar(organismo.getTermo());
			this.escolheEnviarComunicacao(organismo.getEnviarComunicacaoMembro());
			this.escolheSolicitarAssinatura(organismo.getSolicitarAssinatura());
		}

		this.clicaBotaoCriarOrganismo();
	}
}