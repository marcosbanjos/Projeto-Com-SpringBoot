package Produtos;

import java.util.List;

public class ProdutoService {
    private static ProdutoDB repository = new ProdutoDB();

    public Produto create(Produto produto){
        return repository.insert(produto);
    }

    public Produto findById(int id){
        return repository.findById(id);
    }
    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto addProdutoEstoque(int idProduto, int qtd){
        Produto produto = repository.findById(idProduto);

        int newQtd = qtd + produto.getQtdEstoque();

        if(newQtd > produto.getQtdeMaxima()){
            throw new Error("A quantidade não respeita a quantidade máxima do produto");
        }

        produto.setQtdEstoque(newQtd);

        return repository.update(produto);
    }

    public Produto removeProdutoEstoque(int idProduto, int qtd){
        Produto produto = repository.findById(idProduto);

        int newQtd = produto.getQtdEstoque() - qtd;

        if(newQtd < 0){
            throw new Error("Não existe produto em estoque");
        }

        produto.setQtdEstoque(newQtd);

        return repository.update(produto);
    }
}
