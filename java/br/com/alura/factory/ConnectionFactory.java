package br.com.alura.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			String url = "jdbc:mysql://localhost:3306/carteira01?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "123456";
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}
}
