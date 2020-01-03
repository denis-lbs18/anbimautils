package br.com.primeup.anbimautils.constantes;

import br.com.primeup.anbimautils.enums.Sistemas;
import br.com.primeup.anbimautils.utils.PropertiesUtils;

public final class PadraoDeURLs {
	public static final String URL_GAO = PropertiesUtils.getVariable("URL_GAO");
	public static final String URL_SSM = PropertiesUtils.getVariable("URL_SSM");
	public static final String URL_IDP = PropertiesUtils.getVariable("URL_IDP");

	public static String pegaURL(Sistemas sistema) {
		switch (sistema) {
		case GAO:
			return URL_GAO;
		case SSM:
			return URL_SSM;
		default:
			return URL_IDP;
		}
	}
}
