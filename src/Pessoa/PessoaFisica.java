package Pessoa;

public class PessoaFisica extends Pessoa{
    private String cpf;

    public PessoaFisica(String nome, String email, String telefone, String cpf, TipoPessoa tipoPessoa) {
        super(nome, email, telefone, tipoPessoa);
        if(validarCPF(cpf))
            this.cpf = cpf.replaceAll("[^0-9]", "");
        else
            throw new Error("CPF inválido");
    }

    public static boolean validarCPF(String cpf) {
        // Remova os caracteres não numéricos e verifique se o CPF tem 11 dígitos
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }

        // Verifique se todos os dígitos são iguais (ex: "111.111.111-11")
        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        // Verifique os dígitos verificadores
        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            numeros[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        // Primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }
        if (numeros[9] != digito1) {
            return false;
        }

        // Segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += numeros[i] * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }
        if (numeros[10] != digito2) {
            return false;
        }

        // Se chegou até aqui, o CPF é válido
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[^0-9]", "");;
    }

    public String getDocument() {
        return this.cpf;
    }
}
