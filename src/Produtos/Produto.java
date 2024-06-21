package Produtos;

public class Produto {
    private int id;
    private String nome;
    private GeneroProduto generoProduto;
    private double valorUnitario;
    private int qtdeMaxima;
    private int qtdeMinimo = 0;
    private int qtdEstoque = 0;
    private static int auto_id = 1;

    public Produto(String nome, GeneroProduto generoProduto, double valorUnitario, int qtdeMaximo, int qtdeMinimo, int qtdEstoque) {
        if (qtdEstoque < qtdeMinimo) {
            throw new Error("A quantidade em estoque é inferior o limite mínimo em estoque!");
        }
        this.id = auto_id;
        this.nome = nome;
        this.generoProduto = generoProduto;
        this.valorUnitario = valorUnitario;
        this.qtdeMaxima = qtdeMaximo;
        this.qtdeMinimo = qtdeMinimo;
        this.qtdEstoque = qtdEstoque;
        auto_id++;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        if (qtdEstoque < 0) {
            throw new Error("A quantidade em estoque nao pode ser inferior a 0!");
        } else {
            this.qtdEstoque = qtdEstoque;
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroProduto getGeneroProduto() {
        return generoProduto;
    }

    public void setGeneroProduto(GeneroProduto generoProduto) {
        this.generoProduto = generoProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQtdeMaxima() {
        return qtdeMaxima;
    }

    public void setQtdeMaxima(int qtdeMaxima) {
        this.qtdeMaxima = qtdeMaxima;
    }

    public int getQtdeMinimo() {
        return qtdeMinimo;
    }

    public void setQtdeMinimo(int qtdeMinimo) {
        this.qtdeMinimo = qtdeMinimo;
    }
}
