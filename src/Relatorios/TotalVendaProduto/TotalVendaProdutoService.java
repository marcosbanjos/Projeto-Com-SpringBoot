package Relatorios.TotalVendaProduto;

import java.util.ArrayList;
import java.util.List;

public class TotalVendaProdutoService {
    private static List<TotalVendaProduto> totalVendaProduto = new ArrayList<>();

    private static TotalVendaProduto find(String nome){
        return totalVendaProduto.stream().filter(produtoItem -> nome.equals(produtoItem.getNome()))
                .findFirst()
                .orElseThrow(() -> new Error("Produto not found"));
    }
    public void addTotalVendaProduto(String nomeProduto, int qtd){
        try {
            TotalVendaProduto tp = find(nomeProduto);
            tp.setQtd(qtd);
            totalVendaProduto.set(totalVendaProduto.indexOf(tp), tp);
        }catch (Error err){
            totalVendaProduto.add(new TotalVendaProduto(nomeProduto, qtd));
        }
    }

    public List<TotalVendaProduto> totalVendaProdutos(){
        return totalVendaProduto;
    }

    public TotalVendaProduto maisVendido(){
        TotalVendaProduto totalVendaProduto1 = totalVendaProduto.get(0);
        for (int i = 0; i < totalVendaProduto.size(); i++) {
            if(totalVendaProduto.get(i).getQtd() > totalVendaProduto1.getQtd()){
                totalVendaProduto1 = totalVendaProduto.get(i);
            }
        }

        return totalVendaProduto1;
    }
}
