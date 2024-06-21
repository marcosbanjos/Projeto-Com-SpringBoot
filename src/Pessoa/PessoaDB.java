package Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDB {
    private static List<Pessoa> pessoas = new ArrayList<>();

    public Pessoa insert(Pessoa pessoa){
        pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> findAll(){
        return pessoas;
    }

    public Pessoa findById(int id){
        return pessoas.stream().filter(pessoa -> Integer.toString(id).equals(Integer.toString(pessoa.getId())))
                .findFirst()
                .orElseThrow(()-> new Error("Pessoa not found"));
    }
}
