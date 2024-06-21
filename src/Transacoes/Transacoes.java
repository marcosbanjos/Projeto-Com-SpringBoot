package Transacoes;

import Pessoa.Pessoa;

import java.util.List;

public abstract class Transacoes {
    private int id;
    private List<Itens> itens;
    private double total = 0;
    private Pessoa vendedor;
    private Pessoa comprador;

    public Transacoes(List<Itens> itens, Pessoa vendedor, Pessoa comprador) {
        this.itens = itens;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }

    public Pessoa getVendedor() {
        return vendedor;
    }

    public void setVendedor(Pessoa vendedor) {
        this.vendedor = vendedor;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public int getId() {
        return id;
    }

    public List<Itens> getItens() {
        return itens;
    }

    public void setItens(List<Itens> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
