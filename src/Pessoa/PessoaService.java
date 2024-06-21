package Pessoa;

import java.util.List;

public class PessoaService {
    private static PessoaDB repository = new PessoaDB();

    public Pessoa createPessoaJuridica(PessoaJuridica pessoaJuridica){
        return repository.insert(pessoaJuridica);
    }

    public Pessoa createPessoaFisica(PessoaFisica pessoaFisica){
        return repository.insert(pessoaFisica);
    }

    public Pessoa findOne(int id){
        return repository.findById(id);
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }
}
