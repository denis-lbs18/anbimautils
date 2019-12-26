package br.com.primeup.anbimautils.constantes;

import br.com.primeup.anbimautils.enums.Sistemas;

public final class PadraoDeURLs {
	public static final String URL_GAO = "https://localhost:8443/gao/";
	public static final String URL_SSM = "https://localhost:8443/ssm/";
	public static final String URL_IDP = "https://localhost:8443/idp/";

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
