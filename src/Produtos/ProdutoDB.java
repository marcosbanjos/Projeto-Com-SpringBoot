package Produtos;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDB {
    public static List<Produto> produtos = new ArrayList<Produto>();

    public Produto insert(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Produto findById(int id) {
        return produtos.stream().filter(produtoItem -> Integer.toString(id).equals(Integer.toString(produtoItem.getId())))
                .findFirst()
                .orElseThrow(() -> new Error("Produto not found"));
    }

    public Produto update(Produto produto) {
        return produtos.set(produtos.indexOf(findById(produto.getId())), produto);
    }

    public void remove(int id){
        produtos.remove(findById(id));
    }
}
