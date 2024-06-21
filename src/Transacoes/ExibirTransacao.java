package Transacoes;

import Taxa.Estado.MGDeductionService;
import Transacoes.Compra.Compra;
import Transacoes.Venda.Venda;

public class ExibirTransacao {
    public static void exibirCompra(Compra compra){
        System.out.println("\n\n#########################################################################\n\n");

        compra.getItens().forEach(item -> {
            System.out.printf("%s :: %.2f :: (x%d) = %.2f\n",item.getProduto().getNome(), item.getProduto().getValorUnitario(), item.getQtdeProduto(), item.getValorTotal());
        });

        System.out.println("----------------------------------------");
        System.out.printf("Total sem taxa: %.2f\n", compra.getTotalSemTributo());
        System.out.printf("Valor da taxa: %.2f\n", compra.getTaxa());
        System.out.printf("Taxa em porcentagem: %.0f%%\n", compra.getTaxaPercent());
        System.out.printf("Total: %.2f\n", compra.getTotal());
        System.out.println("----------------------------------------");
        System.out.println("Vendedor: " + compra.getVendedor().getNome());
        System.out.println("Comprador: " + compra.getComprador().getNome());
    }

    public static void exibirVenda(Venda venda){
        System.out.println("\n\n#########################################################################\n\n");

        venda.getItens().forEach(item -> {
            System.out.printf("%s :: %.2f :: (x%d) = %.2f\n",item.getProduto().getNome(), item.getProduto().getValorUnitario(), item.getQtdeProduto(), item.getValorTotal());
        });

        System.out.println("----------------------------------------");
        System.out.printf("Total: %.2f\n", venda.getTotal());
        System.out.println("----------------------------------------");
        System.out.println("Vendedor: " + venda.getVendedor().getNome());
        System.out.println("Comprador: " + venda.getComprador().getNome());
    }
}
