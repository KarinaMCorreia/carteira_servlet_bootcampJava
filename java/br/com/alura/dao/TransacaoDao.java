package br.com.alura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.TipoTransacao;
import br.com.alura.modelo.Transacao;

public class TransacaoDao {

	private Connection conexao;

	public TransacaoDao(Connection conexao) {

		this.conexao = conexao;
	}

	public void Cadastrar(Transacao transacao) {

		try {

			String Sql = ("insert into transacoes (ticker, preco, quantidade, data, tipo) value (?,?,?,?,?)");

			PreparedStatement ps = conexao.prepareStatement(Sql);

			ps.setString(1, transacao.getTicker());
			ps.setBigDecimal(2, transacao.getPreco());
			ps.setInt(3, transacao.getQuantidade());
			ps.setDate(4, Date.valueOf(transacao.getData()));
			ps.setString(5, transacao.getTipo().toString());

			ps.execute();

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

	public List<Transacao> Listar() {

		try {

			String Sql = ("select * from transacoes");
			PreparedStatement ps = conexao.prepareStatement(Sql);
			ResultSet rs = ps.executeQuery();

			List<Transacao> transacoes = new ArrayList<>();
			
			while (rs.next()) {

				Transacao t = new Transacao();
				t.setTicker(rs.getString("ticker"));
				t.setPreco(rs.getBigDecimal("preco"));
				t.setQuantidade(rs.getInt("quantidade"));
				t.setData(rs.getDate("data").toLocalDate());
				t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));


				transacoes.add(t);

			}

			return transacoes;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

	}

}
