package Pessoa;


public abstract class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private TipoPessoa tipoPessoa;
    private static int auto_id = 0;

    public Pessoa(String nome, String email, String telefone, TipoPessoa tipoPessoa) {
        auto_id ++;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoPessoa = tipoPessoa;
    }

    public abstract String getDocument();

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
