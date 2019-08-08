package com.franca.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Configs {

	// TODO: Verificar método de ler um arquivo a partir de um caminho relativo
	public static void main(String[] args) throws IOException {
		File file = new File("com.franca.utils/config.properties");
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(file);
		prop.load(ip);
		System.out.println(prop.getProperty("name"));


	}

}
