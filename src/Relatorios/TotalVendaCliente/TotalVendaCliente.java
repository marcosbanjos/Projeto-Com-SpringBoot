package Relatorios.TotalVendaCliente;

import Pessoa.TipoPessoa;

public class TotalVendaCliente {
    private String nome;
    private int qtd;
    private TipoPessoa tipoPessoa;

    public TotalVendaCliente(String nome, int qtd, TipoPessoa pf) {
        this.nome = nome;
        this.qtd = qtd;
        this.tipoPessoa = pf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd += qtd;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
