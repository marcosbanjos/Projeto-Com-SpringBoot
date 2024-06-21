package Relatorios.TotalVendaCliente;

import Pessoa.TipoPessoa;
import Relatorios.TotalVendaProduto.TotalVendaProduto;

import java.util.ArrayList;
import java.util.List;

public class TotalVendaClienteService {
    private static List<TotalVendaCliente> totalVendaClientes = new ArrayList<>();

    private static TotalVendaCliente find(String nome) {
        return totalVendaClientes.stream().filter(item -> nome.equals(item.getNome()))
                .findFirst()
                .orElseThrow(() -> new Error("Cliente not found"));
    }

    public void addTotalVendaCliente(String nomeCliente, int qtd, TipoPessoa pf){
        try {
            TotalVendaCliente tp = find(nomeCliente);
            tp.setQtd(qtd);
            totalVendaClientes.set(totalVendaClientes.indexOf(tp), tp);
        }catch (Error err){
            totalVendaClientes.add(new TotalVendaCliente(nomeCliente, qtd, pf));
        }
    }

    public List<TotalVendaCliente> totalVendaCliente(){
        return totalVendaClientes;
    }
}
