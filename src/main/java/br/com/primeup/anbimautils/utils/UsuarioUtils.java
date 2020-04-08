package br.com.primeup.anbimautils.utils;

import br.com.denisluna.selenium_utils.modelos.Usuario;

public final class UsuarioUtils {
	private static final String SENHA = PropertiesUtils.getVariable("massa.user.senha");
	private static final Usuario USUARIO_GESTAO = new Usuario(PropertiesUtils.getVariable("massa.user.login"), SENHA);
	private static final Usuario USUARIO_CONSULTA = new Usuario(
			PropertiesUtils.getVariable("massa.user.login.consulta"), SENHA);

	public static Usuario pegaUsuarioGestao() {
		return USUARIO_GESTAO;
	}

	public static Usuario pegaUsuarioConsulta() {
		return USUARIO_CONSULTA;
	}
}
