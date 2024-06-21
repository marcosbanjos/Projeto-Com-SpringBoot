package Transacoes.Venda;

import Pessoa.Pessoa;
import Transacoes.Itens;
import Transacoes.Transacoes;

import java.util.List;

public class Venda extends Transacoes {
    public Venda(List<Itens> itens, Pessoa vendedor, Pessoa comprador) {
        super(itens, vendedor, comprador);
    }
}
