package br.com.alura.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.modelo.TipoTransacao;
import br.com.alura.modelo.Transacao;

public class TesteTransacao {

	public static void main(String[] args) {

		Transacao t1 = new Transacao("TDFG", new BigDecimal("10.0"), 200, LocalDate.now(), TipoTransacao.COMPRA);

		Transacao t2 = new Transacao("GRDF", new BigDecimal("15.0"), 200, LocalDate.now(), TipoTransacao.VENDA);

		System.out.println(t1);
		System.out.println(t2);

	}

}
