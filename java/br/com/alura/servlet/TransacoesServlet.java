package br.com.alura.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.dao.TransacaoDao;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.TipoTransacao;
import br.com.alura.modelo.Transacao;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {

	private TransacaoDao dao;

	public TransacoesServlet() {

		this.dao = new TransacaoDao(new ConnectionFactory().getConnection());

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("transacoes", dao.Listar());

		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String ticker = req.getParameter("ticker");
		LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(",", "."));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));

		Transacao t = new Transacao(ticker, preco, quantidade, data, tipo);

		dao.Cadastrar(t);
		resp.sendRedirect("transacoes");

	}

}
