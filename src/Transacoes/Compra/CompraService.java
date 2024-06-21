package Transacoes.Compra;

import Produtos.Produto;
import Produtos.ProdutoService;

import java.util.List;

public class CompraService {
    private static CompraDB repository = new CompraDB();

    public Compra create(Compra compra){
        repository.insert(compra);

        try {
            compra.getItens().forEach(item -> {
                ProdutoService produtoService = new ProdutoService();
                produtoService.addProdutoEstoque(item.getProduto().getId(), item.getQtdeProduto());
            });
        } catch (Error err){
            System.out.println("Erro ao gerar a compra!");
            repository.remove(compra.getId());
        }

        return compra;
    }

    public Compra findOne(int id){
       return repository.findById(id);
    }

    public List<Compra> findAll(){
        return repository.findAll();
    }
}
