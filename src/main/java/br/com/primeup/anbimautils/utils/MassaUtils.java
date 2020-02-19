package br.com.primeup.anbimautils.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.thedeanda.lorem.LoremIpsum;

import br.com.denisluna.selenium_utils.utils.NumberUtils;
import br.com.primeup.anbimautils.enums.CargoMembro;
import br.com.primeup.anbimautils.enums.Categoria;
import br.com.primeup.anbimautils.enums.LocalReuniao;
import br.com.primeup.anbimautils.enums.Operadoras;
import br.com.primeup.anbimautils.enums.PermissaoForum;
import br.com.primeup.anbimautils.enums.RespostaBinaria;
import br.com.primeup.anbimautils.enums.Sexos;
import br.com.primeup.anbimautils.enums.TermoUtilizar;
import br.com.primeup.anbimautils.enums.TipoOrganismo;
import br.com.primeup.anbimautils.enums.TipoReuniao;
import br.com.primeup.anbimautils.models.Celular;
import br.com.primeup.anbimautils.models.Membro;
import br.com.primeup.anbimautils.models.Organismo;
import br.com.primeup.anbimautils.models.Reuniao;
import br.com.primeup.anbimautils.models.Secretaria;

public class MassaUtils {
	private static LoremIpsum lipsum = LoremIpsum.getInstance();
	private static boolean jaTemPresidente = false;
	private static boolean jaTemVicePresidente = false;

	private static final String[] listaNomesMasculinos = { "Miguel", "Otávio", "Davi", "Arthur", "Pedro", "Gabriel",
			"Bernardo", "Lucas", "Matheus", "Rafael", "Heitor", "Enzo", "Guilherme", "Nicolas", "Lorenzo", "Gustavo",
			"Felipe", "Samuel", "João Pedro", "Daniel", "Vitor", "Leonardo", "Henrique", "Theo", "Murilo", "Eduardo",
			"Pedro Henrique", "Pietro", "Cauã", "Isaac", "Caio", "Vinicius", "Benjamin", "João", "Lucca", "João Miguel",
			"Bryan", "Joaquim", "João Vitor", "Thiago", "Antônio", "Davi Lucas", "Francisco", "Astrogildo", "Bruno",
			"Emanuel", "João Gabriel", "Ian", "Davi Luiz", "Rodrigo" };

	private static final String[] listaNomesFemininos = { "Sophia", "Alice", "Julia", "Isabella", "Manuela", "Laura",
			"Luiza", "Valentina", "Giovanna", "Maria Eduarda", "Helena", "Beatriz", "Maria Luiza", "Lara", "Mariana",
			"Nicole", "Rafaela", "Heloísa", "Isadora", "Lívia", "Maria Clara", "Ana Clara", "Lorena", "Gabriela",
			"Yasmin", "Isabelly", "Sarah", "Ana Julia", "Letícia", "Ana Luiza", "Melissa", "Marina", "Clara", "Cecília",
			"Esther", "Emanuelly", "Rebeca", "Ana Beatriz", "Lavínia", "Vitória", "Bianca", "Catarina", "Larissa",
			"Maria Fernanda", "Fernanda", "Amanda", "Alícia", "Carolina", "Agatha", "Gabrielly" };

	private static final String[] listaSobreNomes = { "Alves", "Monteiro", "Novaes", "Mendes", "Barros", "Freitas",
			"Barbosa", "Pinto", "Moura", "Cavalcanti", "Dias", "Castro", "Campos", "Cardoso", "Silva", "Souza", "Costa",
			"Santos", "Oliveira", "Pereira", "Rodrigues", "Almeida", "Nascimento", "Lima", "Araújo", "Fernandes",
			"Carvalho", "Gomes", "Martins", "Rocha", "Ribeiro", "Rezende", "Sales", "Peixoto", "Fogaça", "Porto",
			"Ribeiro", "Duarte", "Moraes", "Ramos", "Pereira", "Ferreira", "Silveira", "Moreira", "Teixeira",
			"Caldeira", "Vieira", "Nogueira", "da Costa", "da Rocha", "da Cruz", "da Cunha", "da Mata", "da Rosa",
			"da Mota", "da Paz", "da Luz", "da Conceição", "das Neves", "Fernandes", "Gonçalves", "Rodrigues",
			"Martins", "Lopes", "Gomes", "Mendes", "Nunes", "Carvalho", "Melo", "Cardoso", "Pires", "Jesus", "Aragão",
			"Viana", "Farias" };

	private static final String[] listaServicos = { "Banco", "Restaurante", "Escola", "Academia", "Confeitaria",
			"Panificadora", "Consultoria" };
	private static final String[] listaNomesEmpresas = { "M Boi Mirim", "Ibirapuera", "Mooca", "Pacaembu", "Anhangabaú",
			"Tucuruvi", "Cambuci", "Itaquera", "Aricanduva", "Tietê", "Anhanguera", "Ipiranga", "Pirituba", "Pari",
			"Tatuapé" };
	private static final String[] listaTiposEmpresas = { "LTDA", "EIRELI", "SA", "ME", "MEI", "EPP" };

	private static Celular geraNumeroCelular() {
		RandomEnum<Operadoras> randomOperadora = new RandomEnum<>(Operadoras.class);
		Operadoras operadora = randomOperadora.random();
		int ddd = NumberUtils.pegaNumeroAleatorio(11, 99);
		Long telefone = NumberUtils.pegaNumeroAleatorio(995000000L, 999999999L);

		Celular celular = new Celular(operadora, ddd, telefone.toString());
		return celular;
	}

	private static String pegaValorArray(String[] array) {
		int index = NumberUtils.pegaNumeroAleatorio(0, array.length - 1);
		String retorno = array[index];

		return retorno;
	}

	private static StringBuilder geraNome(Sexos sexo) {
		StringBuilder nome = new StringBuilder("");
		if (sexo == Sexos.MASCULINO)
			nome.append(getNomeMasculino());
		else
			nome.append(getNomeFeminino());

		nome.append(getSobreNome());

		return nome;
	}

	private static Sexos geraSexoAleatorio() {
		if (NumberUtils.pegaNumeroAleatorio() % 2 == 0)
			return Sexos.MASCULINO;
		else
			return Sexos.FEMININO;
	}

	private static String getNomeMasculino() {
		String retorno = pegaValorArray(listaNomesMasculinos);
		return retorno;
	}

	private static String getNomeFeminino() {
		String retorno = pegaValorArray(listaNomesFemininos);
		return retorno;
	}

	private static String getSobreNome() {
		String retorno = " " + pegaValorArray(listaSobreNomes);
		return retorno;
	}

	private static String geraEmail(String nomeBase) {
		return nomeBase.toLowerCase().replaceAll(" ", "").concat("@loremipsum.com");
	}

	private static String pegaNomeInstituicao() {
		String servicoEmpresa = pegaValorArray(listaServicos);
		String nomeEmpresa = pegaValorArray(listaNomesEmpresas);
		String tipoEmpresa = pegaValorArray(listaTiposEmpresas);
		String empresa = servicoEmpresa + " " + nomeEmpresa + " " + tipoEmpresa;

		return empresa;
	}

	public static Membro geraMembro() {
		Sexos sexoAleatorio = geraSexoAleatorio();
		String cpf = CPF_utils.gerarCPF();
		StringBuilder nome = geraNome(sexoAleatorio);

		String instituicao = pegaNomeInstituicao();
		String instituicaoIndicada = pegaNomeInstituicao();

		String emailSecundario = geraEmail(nome.toString());
		Celular telefone = geraNumeroCelular();
		Celular telefone2 = geraNumeroCelular();

		String nomeSecretaria = pegaNomeInstituicao();
		String emailSecretaria = "tstdsftwr@gmail.com";
		Celular telefoneSecretaria = geraNumeroCelular();
		Secretaria secretaria = new Secretaria(nomeSecretaria, telefoneSecretaria, emailSecretaria);

		CargoMembro cargo = geraCargoMembro();

		RandomEnum<PermissaoForum> permissaoForumRandom = new RandomEnum<>(PermissaoForum.class);
		PermissaoForum permissao = permissaoForumRandom.random();

		Membro membro = new Membro(sexoAleatorio, cpf, nome.toString(), instituicao, instituicaoIndicada,
				emailSecundario, telefone, telefone2, secretaria, cargo, permissao);

		return membro;
	}

	private static CargoMembro geraCargoMembro() {
		CargoMembro cargoMembroRetorno = CargoMembro.PRESIDENTE;

		if (jaTemPresidente == false) {
			jaTemPresidente = true;
			return cargoMembroRetorno;
		}

		if (jaTemVicePresidente == true) {
			cargoMembroRetorno = CargoMembro.COORDENADOR;
			return cargoMembroRetorno;
		}

		while (cargoMembroRetorno.equals(CargoMembro.PRESIDENTE) || cargoMembroRetorno.equals(CargoMembro.MEMBRO)) {
			RandomEnum<CargoMembro> cargoMembroRandom = new RandomEnum<>(CargoMembro.class);
			cargoMembroRetorno = cargoMembroRandom.random();
		}

		if (cargoMembroRetorno.equals(CargoMembro.VICE_PRESIDENTE))
			setJaTemVicePresidente(true);

		return cargoMembroRetorno;
	}

	public static List<Membro> geraListaMembros(int quantidade) {
		List<Membro> listaMembro = new ArrayList<>();
		for (int i = 0; i <= quantidade; i++) {
			Membro membro = geraMembro();
			listaMembro.add(membro);
		}

		return listaMembro;
	}

	public static Membro geraMembroSimplificado() {
		Sexos sexoAleatorio = geraSexoAleatorio();
		String cpf = CPF_utils.gerarCPF();
		StringBuilder nome = geraNome(sexoAleatorio);

		String instituicao = pegaNomeInstituicao();

		Celular telefone = geraNumeroCelular();

		CargoMembro cargo = geraCargoMembro();

		RandomEnum<PermissaoForum> permissaoForumRandom = new RandomEnum<>(PermissaoForum.class);
		PermissaoForum permissao = permissaoForumRandom.random();

		Membro membro = new Membro(sexoAleatorio, cpf, nome.toString(), instituicao, telefone, cargo, permissao);
		return membro;
	}

	public static List<Membro> geraListaMembrosSimplificado(int quantidade) {
		List<Membro> listaMembro = new ArrayList<>();
		for (int i = 0; i <= quantidade; i++) {
			Membro membro = geraMembroSimplificado();
			listaMembro.add(membro);
		}

		return listaMembro;
	}

	public static void setJaTemPresidente(boolean jaTem) {
		jaTemPresidente = jaTem;
	}

	public static void setJaTemVicePresidente(boolean jaTem) {
		jaTemVicePresidente = jaTem;
	}

	public static Reuniao geraReuniao() {
		RandomEnum<TipoReuniao> randomTipo = new RandomEnum<>(TipoReuniao.class);
		TipoReuniao tipo = randomTipo.random();

		LocalDate data = LocalDate.now().plusDays(1);

		LocalTime horaAtual = LocalTime.now();

		int hora = NumberUtils.pegaNumeroAleatorio(horaAtual.getHour(), 23);
		LocalTime horaInicio = LocalTime.of(hora, 0);
		LocalTime horaTermino = LocalTime.of(hora, 30);
		String assunto = lipsum.getWords(2, 10);

		RandomEnum<LocalReuniao> randomLocal = new RandomEnum<>(LocalReuniao.class);
		LocalReuniao local = randomLocal.random();

		String outroLocal = lipsum.getWords(1, 3);
		String textoInvite = lipsum.getParagraphs(1, 5);

		RandomEnum<RespostaBinaria> randomResposta = new RandomEnum<>(RespostaBinaria.class);
		RespostaBinaria contabilizacaoDeFalta = randomResposta.random();

		Reuniao reuniao = new Reuniao(tipo, data, horaInicio, horaTermino, assunto, local, outroLocal, textoInvite,
				contabilizacaoDeFalta);
		return reuniao;
	}

	public static Organismo geraOrganismo() {
		StringBuilder nome = new StringBuilder("Pseudo Organismo ");
		nome.append(lipsum.getWords(2, 4));

		TipoOrganismo tipoOrganismo = TipoOrganismo.COMISSAO;

		String codigoPertence = "Código de Ética";
		RandomEnum<Categoria> randomCategoria = new RandomEnum<>(Categoria.class);
		Categoria categoria = randomCategoria.random();

		LocalDate dataInicio = LocalDate.now();
		LocalDate dataFim = dataInicio.plusYears(5);

		int qtdeMinimaMembros = NumberUtils.pegaNumeroAleatorio(1, 10);
		int qtdeMaximaMembros = NumberUtils.pegaNumeroAleatorio(qtdeMinimaMembros, 10);

		RandomEnum<RespostaBinaria> randomRespostaBinaria = new RandomEnum<>(RespostaBinaria.class);
		RespostaBinaria possuiTermo = randomRespostaBinaria.random();

		RespostaBinaria possuiRevisaoDeMembros = randomRespostaBinaria.random();

		RandomEnum<TermoUtilizar> randomTermo = new RandomEnum<>(TermoUtilizar.class);
		TermoUtilizar termo = randomTermo.random();

		RespostaBinaria enviarComunicacaoMembro = randomRespostaBinaria.random();

		RespostaBinaria solicitarAssinatura = randomRespostaBinaria.random();

		return new Organismo(nome.toString(), tipoOrganismo, codigoPertence, categoria, dataInicio, dataFim,
				qtdeMinimaMembros, qtdeMaximaMembros, possuiTermo, possuiRevisaoDeMembros, termo,
				enviarComunicacaoMembro, solicitarAssinatura);
	}
}
