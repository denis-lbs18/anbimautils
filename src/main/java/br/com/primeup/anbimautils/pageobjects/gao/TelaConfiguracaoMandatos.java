package br.com.primeup.anbimautils.pageobjects.gao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.denisluna.selenium_utils.utils.selenium.ByUtils;
import br.com.primeup.anbimautils.enums.CargoMembro;
import br.com.primeup.anbimautils.enums.PermissaoForum;
import br.com.primeup.anbimautils.models.Celular;
import br.com.primeup.anbimautils.models.Membro;
import br.com.primeup.anbimautils.models.TelaBaseAnbima;

public class TelaConfiguracaoMandatos extends TelaBaseAnbima {
	private By botaoAdicionarMembro = ByUtils.encontraByID("addMembroBtn");
	private By inputNomeMembro = ByUtils.encontraByID("nomeMembro");
	private By linkCadastreAgora = ByUtils.encontraByID("linkAbrirModalCriarNovoMembro");
	private By botaoSalvarMandato = ByUtils.encontraByID("salvarMandatoBtn");
	private By botaoConfirmarAlteracoes = ByUtils.encontraByID("j_idt700");

	private By inputCPF = ByUtils.encontraByID("cpf");
	private By inputNome = ByUtils.encontraByID("nome");
	private By inputInstituicao = ByUtils.encontraByID("instituicaoAutocomplete");
	private By inputInstituicaoIndicada = ByUtils.encontraByID("instituicaoIndicada");
	private By inputEmailPrincipal = ByUtils.encontraByID("emailPrimario");
	private By inputEmailSecundario = ByUtils.encontraByID("emailSecundario");
	private By inputTelefone_1 = ByUtils.encontraByID("telefonePrimario");
	private By inputTelefone_2 = ByUtils.encontraByID("telefoneSecudario");

	private By inputNomeSecretaria = ByUtils.encontraByID("nomeSecretaria");
	private By inputTelefoneSecretaria = ByUtils.encontraByID("telefoneSecretaria");
	private By inputEmailSecretaria = ByUtils.encontraByID("emailSecretaria");
	private By selectCargoMembro = ByUtils.encontraByID("tipoNovoMembroSelect");
	private By botaoSalvar = ByUtils.encontraByID(ByUtils.INPUT, "j_idt883");
	private By botaoSim = ByUtils.encontraByID(ByUtils.INPUT, "j_idt950");

	public TelaConfiguracaoMandatos(WebDriver driver) {
		super(driver);
	}

	public void clicaBotaoAdicionarMembro() {
		this.getElemento().elementoWebClica(this.botaoAdicionarMembro);
		this.sleep(1);
	}

	public void insereInputNomeMembro(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputNomeMembro, texto);
	}

	public void clicaLinkCadastreAgora() {
		this.getElemento().elementoWebClica(this.linkCadastreAgora);
		this.sleep(1);
	}

	public void insereInputCPF(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputCPF, Keys.HOME);
		this.sleep(1);
		this.getElemento().elementoWebInsereTexto(this.inputCPF, texto);
		this.sleep(1);
		this.getElemento().elementoWebInsereTexto(this.inputCPF, Keys.TAB);
		this.sleep(1);
	}

	public void insereInputNome(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputNome, texto);
		this.sleep(1);
	}

	public void insereInputInstituicao(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputInstituicao, texto);
		this.sleep(1);
		this.getElemento().elementoWebInsereTexto(this.inputInstituicao, Keys.TAB);
		this.sleep(4);
	}

	public void insereInputInstituicaoIndicada(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputInstituicaoIndicada, texto);
		this.sleep(4);
	}

	public void insereInputEmailPrincipal(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputEmailPrincipal, texto);
		this.sleep(1);
	}

	public void insereInputEmailSecundario(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputEmailSecundario, texto);
		this.sleep(1);
	}

	public void insereInputTelefone_1(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputTelefone_1, texto);
		this.sleep(3);
	}

	public void insereInputTelefone_1(Celular celular) {
		this.insereInputTelefone_1(celular.toString());
	}

	public void insereInputTelefone_2(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputTelefone_2, texto);
		this.sleep(3);
	}

	public void insereInputTelefone_2(Celular celular) {
		this.insereInputTelefone_2(celular.toString());
	}

	public void insereInputNomeSecretaria(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputNomeSecretaria, texto);
		this.sleep(1);
	}

	public void insereInputTelefoneSecretaria(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputTelefoneSecretaria, texto);
		this.sleep(1);
	}

	public void insereInputTelefoneSecretaria(Celular celular) {
		this.insereInputTelefoneSecretaria(celular.toString());
	}

	public void insereInputEmailSecretaria(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputEmailSecretaria, texto);
		this.sleep(1);
	}

	public void selecionaCargoMembro(String texto) {
		this.getElemento().elementoWebSelecionaLista(this.selectCargoMembro, texto);
		this.sleep(1);
	}

	public void selecionaCargoMembro(int valor) {
		this.getElemento().elementoWebSelecionaLista(this.selectCargoMembro, valor);
		this.sleep(1);
	}

	public void selecionaCargoMembro(CargoMembro cargo) {
		this.getElemento().elementoWebSelecionaLista(this.selectCargoMembro, cargo.toString());
		this.sleep(1);
		this.getElemento().elementoWebInsereTexto(this.selectCargoMembro, Keys.TAB);
		this.sleep(5);
	}

	public void incluiNovoMembro(Membro membro) {
		this.insereInputCPF(membro.getCpf());
		this.insereInputNome(membro.getNome());
		this.insereInputInstituicao(membro.getInstituicao());
		this.insereInputInstituicaoIndicada(membro.getInstituicaoIndicada());
		this.insereInputEmailPrincipal(membro.getEmailPrincipal());
		this.insereInputEmailSecundario(membro.getEmailSecundario());
		this.insereInputTelefone_1(membro.getTelefonePrimario());
		this.insereInputTelefone_2(membro.getTelefoneSecundario());

		if (!(membro.getSecretaria() == null)) {
			this.insereInputNomeSecretaria(membro.getSecretaria().getNome());
			this.insereInputTelefoneSecretaria(membro.getSecretaria().getTelefone());
			this.insereInputEmailSecretaria(membro.getSecretaria().getEmail());
		}

		this.selecionaCargoMembro(membro.getCargo());
		this.selecionaPermissaoAcessoForum(membro.getPermissao());
		this.clicaBotaoSalvar();
		this.clicaBotaoSim();
		this.sleep(2);
	}

	public void incluiNovoMembroSimplificado(Membro membro) {
		this.insereInputCPF(membro.getCpf());
		this.insereInputNome(membro.getNome());
		this.insereInputInstituicao(membro.getInstituicao());
		this.insereInputEmailPrincipal(membro.getEmailPrincipal());
		this.insereInputTelefone_1(membro.getTelefonePrimario());

		this.selecionaCargoMembro(membro.getCargo());
		this.selecionaPermissaoAcessoForum(membro.getPermissao());
		this.clicaBotaoSalvar();
		this.clicaBotaoSim();
		this.sleep(2);
	}

	public void selecionaPermissaoAcessoForum(PermissaoForum permissao) {
		By opcaoPermissaoAcesso = ByUtils.encontraByTextoContains(ByUtils.LABEL, permissao.toString());
		this.escolheOption(opcaoPermissaoAcesso, "Erro ao selecionar permissão de acesso.");
	}

	public void clicaBotaoSalvar() {
		this.getElemento().elementoWebClica(this.botaoSalvar);
		this.sleep(1);
	}

	public void clicaBotaoSim() {
		this.getElemento().elementoWebClica(this.botaoSim);
		this.sleep(3);
	}

	public void clicaBotaoSalvarMandato() {
		this.sleep(3);
		this.getElemento().elementoWebClica(this.botaoSalvarMandato);
	}

	public void clicaBotaoConfirmarAlteracoes() {
		this.sleep(3);
		this.getElemento().elementoWebClica(this.botaoConfirmarAlteracoes);
	}
}
