package Transacoes.Compra;

import java.util.ArrayList;
import java.util.List;

public class CompraDB {
    public static List<Compra> compras = new ArrayList<Compra>();

    public Compra insert(Compra compra) {
        compras.add(compra);
        return compra;
    }

    public List<Compra> findAll() {
        return compras;
    }

    public Compra findById(int id) {
        //Converti o id para string para facilitar a vida com o metodo equals da String ;)
        return compras.stream().filter(compraItem -> Integer.toString(id).equals(Integer.toString(compraItem.getId())))
                .findFirst()
                .orElseThrow(() -> new Error("Compra not found"));
    }

    public Compra update(Compra compra) {
        return compras.set(compras.indexOf(findById(compra.getId())), compra);
    }

    public void remove(int id){
        compras.remove(findById(id));
    }
}
