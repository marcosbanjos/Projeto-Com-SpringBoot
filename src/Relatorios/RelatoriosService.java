package Relatorios;

import Relatorios.TotalVendaCliente.TotalVendaClienteService;
import Relatorios.TotalVendaGenero.TotalVendaGeneroService;
import Relatorios.TotalVendaProduto.TotalVendaProduto;
import Relatorios.TotalVendaProduto.TotalVendaProdutoService;
import Transacoes.Compra.CompraService;
import Transacoes.Transacoes;
import Transacoes.Venda.VendaService;

import java.util.concurrent.atomic.AtomicReference;

public class RelatoriosService {
    private final TotalVendaGeneroService totalVendaGeneroService = new TotalVendaGeneroService();
    private final TotalVendaProdutoService totalVendaProdutoService = new TotalVendaProdutoService();
    // total de vendas por produto
    public void totalVendaProduto() {
        System.out.println("> Total de venda por produto");
        totalVendaProdutoService.totalVendaProdutos().forEach(totalVendaProduto -> {
            System.out.println("    " + totalVendaProduto.getNome() + " - " + totalVendaProduto.getQtd());
        });
    }

    // total de vendas por genero
    public void totalVendaGenero(){
        System.out.println("> Total de vendas por gênero");
        totalVendaGeneroService.totalVendaGeneros().forEach(totalVendaGenero -> {
            System.out.println("    " + totalVendaGenero.getNome() + " - " + totalVendaGenero.getQtd());
        });
    }

    // total de vendas por cliente (PF/PJ)
    public void totalVendaCliente(){
        System.out.println("> Total de vendas por cliente");
        TotalVendaClienteService totalVendaClienteService = new TotalVendaClienteService();
        totalVendaClienteService.totalVendaCliente().forEach(totalVendaCliente -> {
            System.out.println("    " + totalVendaCliente.getNome() + " - " + totalVendaCliente.getQtd() + " - " + totalVendaCliente.getTipoPessoa());
        });

    }

    // compras (reposição) de estoque
    public void totalComprasEstoque(){
        CompraService compraService = new CompraService();
        double total = compraService.findAll().stream().mapToDouble(Transacoes::getTotal).sum();

        System.out.printf("> Total de compras realizadas: R$ %.02f\n", total);
    }

    // produto mai vendido
    public void produtoMaisVendido() {
        TotalVendaProduto totalVendaProduto = totalVendaProdutoService.maisVendido();
        System.out.println("> Produto mais vendido: " + totalVendaProduto.getNome() + " - " + totalVendaProduto.getQtd());
    }
}
