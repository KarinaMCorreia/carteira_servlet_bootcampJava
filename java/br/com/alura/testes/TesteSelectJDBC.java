package br.com.alura.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import br.com.alura.dao.TransacaoDao;
import br.com.alura.modelo.Transacao;

public class TesteSelectJDBC {

	public static void main(String[] args) {

		try {
			String url = "jdbc:mysql://localhost:3306/carteira01?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "123456";
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			TransacaoDao dao = new TransacaoDao(conexao);
			
			List<Transacao> t = dao.Listar();
			t.forEach(System.out::println);
			
			
		} catch (Exception e) {
			
			System.out.println("ocorreu um erro!");
		}

	}

}
