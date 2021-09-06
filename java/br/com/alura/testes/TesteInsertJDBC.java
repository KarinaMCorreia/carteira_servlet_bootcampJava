package br.com.alura.testes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

import br.com.alura.dao.TransacaoDao;
import br.com.alura.modelo.TipoTransacao;
import br.com.alura.modelo.Transacao;

public class TesteInsertJDBC {

	public static void main(String[] args) {

		try {

			String url = "jdbc:mysql://localhost:3306/carteira01?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "123456";
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			TransacaoDao dao = new TransacaoDao(conexao);
			
			Transacao t = new Transacao("TESTE02", new BigDecimal("12.10"), 200, LocalDate.now(), TipoTransacao.COMPRA);
			dao.Cadastrar(t);
			
		} catch (Exception e) {

			System.out.println("ocorreu um erro!");
		}

	}

}
