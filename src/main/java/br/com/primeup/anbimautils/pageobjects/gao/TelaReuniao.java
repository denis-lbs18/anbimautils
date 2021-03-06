package br.com.primeup.anbimautils.pageobjects.gao;

import static br.com.primeup.anbimautils.enums.LocalReuniao.OUTRO;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.denisluna.selenium_utils.enums.Formato;
import br.com.denisluna.selenium_utils.utils.LocalDateTimeUtils;
import br.com.denisluna.selenium_utils.utils.selenium.ByUtils;
import br.com.primeup.anbimautils.enums.EstadoReuniao;
import br.com.primeup.anbimautils.enums.LocalReuniao;
import br.com.primeup.anbimautils.enums.Participacao;
import br.com.primeup.anbimautils.enums.RespostaBinaria;
import br.com.primeup.anbimautils.enums.TipoReuniao;
import br.com.primeup.anbimautils.models.Reuniao;
import br.com.primeup.anbimautils.models.TelaBaseAnbima;
import br.com.primeup.anbimautils.utils.PropertiesUtils;
import br.com.primeup.anbimautils.utils.RandomEnum;

public class TelaReuniao extends TelaBaseAnbima {
	private static final String XPATH_MEMBRO_REUNIAO = PropertiesUtils
			.getVariable("project.params.xpath.reuniao.membro");;
	private By inputData = ByUtils.encontraByID("dataReuniao");
	private By inputHoraInicio = ByUtils.encontraByID("horarioInicial");
	private By inputHoraTerminio = ByUtils.encontraByID("horarioFinal");
	private By inputAssunto = ByUtils.encontraByID("assunto-reuniao");
	private By selectLocal = ByUtils.encontraByID("selectLocalReuniao");
	private By inputLocal = ByUtils.encontraByID("dsLocalReuniao");
	private By inputTextoInvite = ByUtils.encontraByID("textoInvite");
	private By botaoSalvar = ByUtils.encontraByID("btnCriarReuniao");
	private By selectParticipacaoEfetiva = ByUtils.encontraByClass(ByUtils.SELECT, "gnosys-select");
	private By listaChecksAdministradores = By
			.xpath("//tbody[@id='tabela-lista-administradores-reuniao:tb']//input[contains(@class, 'gnosys-check')]");

	public TelaReuniao(WebDriver driver) {
		super(driver);
	}

	public void escolheTipoReuniao(TipoReuniao tipo) {
		By opcaoPermissaoAcesso = ByUtils.encontraByTextoContains(ByUtils.LABEL, tipo.toString());
		this.escolheOption(opcaoPermissaoAcesso, "Erro ao selecionar tipo de reunião.");
	}

	public void insereInputData(LocalDate data) {
		this.getElemento().elementoWebClica(this.inputData);
		this.sleep(1);
		By tdData = ByUtils.encontraByTexto(ByUtils.TD, Integer.toString(data.getDayOfMonth()));
		this.getElemento().elementoWebClica(tdData);
		this.sleep(1);
	}

	public void insereInputHoraInicio(String hora) {
		this.getElemento().elementoWebInsereTexto(this.inputHoraInicio, hora);
		this.sleep(1);
	}

	public void insereInputHoraTermino(String hora) {
		this.getElemento().elementoWebInsereTexto(this.inputHoraTerminio, hora);
		this.sleep(1);
	}

	public void insereInputAssunto(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputAssunto, texto);
		this.sleep(1);
	}

	public void selecionaLocal(String texto) {
		this.getElemento().elementoWebSelecionaLista(this.selectLocal, texto);
		this.sleep(1);
	}

	public void selecionaLocal(int indice) {
		this.getElemento().elementoWebSelecionaLista(this.selectLocal, indice);
		this.sleep(1);
	}

	public void selecionaLocal(LocalReuniao local) {
		this.selecionaLocal(local.toString());
	}

	public void insereInputLocal(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputLocal, texto);
		this.sleep(1);
	}

	public void insereInputTextoInvite(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputTextoInvite, texto);
		this.sleep(1);
	}

	public void escolheContabilizacaoDeFalta(RespostaBinaria resposta) {
		By optionContabilizacaoDeFalta = ByUtils.encontraByTextoContains(ByUtils.LABEL, resposta.toString());
		this.escolheOption(optionContabilizacaoDeFalta, "Erro ao selecionar Contabilização de falta.");
	}

	public int listaQuantidadeItensParticipacaoEfetiva() {
		int retorno = this.getElemento().elementoWebAchaElementosWait(this.selectParticipacaoEfetiva).size();
		return retorno;
	}

	public void clicaBotaoSalvar() {
		this.getElemento().elementoWebClica(this.botaoSalvar);
		this.sleep(1);
	}

	public void cadastraReuniao(Reuniao reuniao) {
		preencheDados(reuniao);
	}

	public void selecionaParticipacaoEfetiva(Participacao participacao, int index) {
		By selectParticipacao = ByUtils.encontraByClass(ByUtils.SELECT, "gnosys-select", index);
		this.getElemento().elementoWebSelecionaLista(selectParticipacao, participacao.toString());
		this.sleep(2);
	}

	public void cadastraReuniaoSelecionaParticipacao(Reuniao reuniao) {
		preencheDados(reuniao);

		for (int index = 1; index <= this.listaQuantidadeItensParticipacaoEfetiva(); index++) {
			RandomEnum<Participacao> randomParticipacao = new RandomEnum<>(Participacao.class);
			Participacao participacao = randomParticipacao.random();
			this.selecionaParticipacaoEfetiva(participacao, index);
		}

		this.clicaBotaoSalvar();

	}

	private void preencheDados(Reuniao reuniao) {
		this.escolheTipoReuniao(reuniao.getTipo());

		this.insereInputData(reuniao.getData());

		String horaInicialFormatada = LocalDateTimeUtils.formataHora(Formato.HM, reuniao.getHoraInicio());
		this.insereInputHoraInicio(horaInicialFormatada);

		String horaTerminoFormatada = LocalDateTimeUtils.formataHora(Formato.HM, reuniao.getHoraTermino());
		this.insereInputHoraTermino(horaTerminoFormatada);

		this.insereInputAssunto(reuniao.getAssunto());

		this.selecionaLocal(reuniao.getLocal());

		if (reuniao.getLocal().equals(OUTRO))
			this.insereInputLocal(reuniao.getOutroLocal());

		this.insereInputTextoInvite(reuniao.getTextoInvite());
		this.escolheContabilizacaoDeFalta(reuniao.getContabilizacaoDeFalta());
	}

	public void selecionaEstadoReuniao(EstadoReuniao estado, String membro) {
		this.sleep(2);
		By selectEstado = By.xpath(String.format(XPATH_MEMBRO_REUNIAO, membro));

		this.getElemento().elementoWebMoveParaOElemento(selectEstado);
		this.getElemento().elementoWebSelecionaListaSelect(selectEstado, estado.toString());
		this.sleep(2);
	}

	public void selecionaAdministradoresReuniao() {
		List<WebElement> listaChecks = this.getElemento().elementoWebAchaElementosWait(this.listaChecksAdministradores);

		for (WebElement check : listaChecks) {
			check.click();
			this.sleep(2);
		}

	}
}