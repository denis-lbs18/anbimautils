package br.com.primeup.anbimautils.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesUtils {
	
	public static String getVariable(String variableKey){
		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("application.properties").getFile());
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("Arquivo application.properties não foi encontrado");
			e.printStackTrace();
		}
		return (String)properties.get(variableKey);
	}
	
}
