package Pessoa;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, String cnpj, TipoPessoa tipoPessoa) {
        super(nome, email, telefone, tipoPessoa);
        this.cnpj = cnpj.replaceAll("[^0-9]", "");;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj.replaceAll("[^0-9]", "");;
    }

    public String getDocument() {
        return this.cnpj;
    }
}
