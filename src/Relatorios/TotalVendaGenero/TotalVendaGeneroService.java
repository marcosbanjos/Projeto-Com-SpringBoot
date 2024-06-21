package Relatorios.TotalVendaGenero;

import Relatorios.TotalVendaProduto.TotalVendaProduto;

import java.util.ArrayList;
import java.util.List;

public class TotalVendaGeneroService {
    private static List<TotalVendaGenero> totalVendaGeneros = new ArrayList<>();

    private static TotalVendaGenero find(String nome){
        return totalVendaGeneros.stream().filter(generoItem -> nome.equals(generoItem.getNome()))
                .findFirst()
                .orElseThrow(() -> new Error("Genero not found"));
    }

    public void addTotalVendaGenero(String nomeGenero, int qtd){
        try{
            TotalVendaGenero tp = find(nomeGenero);
            tp.setQtd(qtd);
            totalVendaGeneros.set(totalVendaGeneros.indexOf(tp), tp);
        }catch (Error err){
            totalVendaGeneros.add(new TotalVendaGenero(nomeGenero, qtd));
        }
    }

    public List<TotalVendaGenero> totalVendaGeneros(){
        return totalVendaGeneros;
    }
}
