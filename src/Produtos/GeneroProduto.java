package Produtos;

public class GeneroProduto {
    private int id;
    private String nome;
    private static int auto_id = 0;

    public GeneroProduto(String nome) {
        auto_id++;
        this.id = auto_id;
        this.nome = nome;
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
}
