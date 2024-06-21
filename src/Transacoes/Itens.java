package Transacoes;

import Produtos.Produto;

public class Itens {
    private int id;
    private Produto produto;
    private int qtdeProduto = 0;
    private double valorTotal;
    private static int auto_id = 0;

    public Itens(Produto produto, int qtdeProduto) {
        auto_id++;
        this.id = auto_id;
        this.produto = produto;
        this.qtdeProduto = qtdeProduto;
        this.valorTotal = produto.getValorUnitario() * qtdeProduto;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
