package br.com.primeup.anbimautils.utils;

import br.com.denisluna.selenium_utils.modelos.Usuario;

public final class UsuarioUtils {
	private static final String SENHA = PropertiesUtils.getVariable("massa.user.senha");
	private static final Usuario USUARIO_GESTAO = new Usuario(PropertiesUtils.getVariable("massa.user.login"), SENHA);

	public static Usuario pegaUsuarioGestao() {
		return USUARIO_GESTAO;
	}
}
