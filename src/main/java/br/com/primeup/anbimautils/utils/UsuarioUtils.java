package br.com.primeup.anbimautils.utils;

import br.com.denisluna.selenium_utils.modelos.Usuario;

public final class UsuarioUtils {
	private static final String SENHA = "Anbima2014";
	private static final Usuario USUARIO_GESTAO = new Usuario("31533816310", SENHA);

	public static Usuario pegaUsuarioGestao() {
		return USUARIO_GESTAO;
	}
}
