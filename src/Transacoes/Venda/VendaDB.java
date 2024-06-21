package Transacoes.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaDB {
    public static List<Venda> vendas = new ArrayList<Venda>();

    public static Venda insert(Venda venda){
        vendas.add(venda);
        return venda;
    }

    public static List<Venda> findAll() {
        return vendas;
    }

    public static Venda findById(int id) {
        //Converti o id para string para facilitar a vida com o metodo equals da String ;)
        return vendas.stream().filter(vendaItem -> Integer.toString(id).equals(Integer.toString(vendaItem.getId())))
                .findFirst()
                .orElseThrow(() -> new Error("Venda not found"));
    }

    public static Venda update(Venda venda) {
        return vendas.set(vendas.indexOf(findById(venda.getId())), venda);
    }

    public static void remove(int id){
        vendas.remove(findById(id));
    }
}
