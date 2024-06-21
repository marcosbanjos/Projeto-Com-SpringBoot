package Transacoes.Venda;

import Pessoa.Pessoa;
import Pessoa.PessoaService;
import Produtos.Produto;
import Produtos.ProdutoService;
import Relatorios.TotalVendaCliente.TotalVendaCliente;
import Relatorios.TotalVendaCliente.TotalVendaClienteService;
import Relatorios.TotalVendaGenero.TotalVendaGeneroService;
import Relatorios.TotalVendaProduto.TotalVendaProdutoService;
import Taxa.Estado.MGDeductionService;
import Transacoes.Compra.Compra;
import Transacoes.Compra.CompraService;
import Transacoes.Itens;

import java.util.ArrayList;
import java.util.List;

public class VendaService {
    private final CompraService compraService = new CompraService();
    private final PessoaService pessoaService = new PessoaService();
    private final TotalVendaProdutoService totalVendaProdutoService = new TotalVendaProdutoService();
    private final TotalVendaGeneroService totalVendaGeneroService = new TotalVendaGeneroService();
    private final TotalVendaClienteService totalVendaClienteService = new TotalVendaClienteService();

    public Venda create(Venda venda){
        Venda vendaNew = VendaDB.insert(venda);

        try {
            venda.getItens().forEach(item -> {
                ProdutoService produtoService = new ProdutoService();
                // Tem que rever isso
                produtoService.removeProdutoEstoque(item.getProduto().getId(), item.getQtdeProduto());

                //e se nao der certo
                Produto p = produtoService.findById(item.getProduto().getId());
                if(p.getQtdEstoque() < p.getQtdeMinimo()){
                    System.out.printf("\nInfo -> Efetuando a compra de %d %s\n", (p.getQtdeMaxima() - p.getQtdEstoque()), p.getNome());
                    List<Itens> itens = new ArrayList<>();
                    itens.add(new Itens(p,  p.getQtdeMaxima() - p.getQtdEstoque()));
                    Pessoa pessoa = pessoaService.findAll().stream().findFirst().orElseThrow(()-> new Error("Pessoa not found"));
                    Compra compra = new Compra(itens, pessoa, pessoa, new MGDeductionService());
                    compraService.create(compra);
                }
            });
        } catch (Error err){
            System.out.println("Erro ao gerar a venda!");
            VendaDB.remove(venda.getId());
            System.out.println(err.getMessage());
        }

        try {
            venda.getItens().forEach(item -> {
                totalVendaProdutoService.addTotalVendaProduto(item.getProduto().getNome(), item.getQtdeProduto());
                totalVendaGeneroService.addTotalVendaGenero(item.getProduto().getGeneroProduto().getNome(), item.getQtdeProduto());
            });
            totalVendaClienteService.addTotalVendaCliente(venda.getVendedor().getNome(), 1, venda.getVendedor().getTipoPessoa());
        } catch (Error err){
            System.out.println(err.getMessage());
        }

        return vendaNew;
    }

    public Venda findOne(int id){
        return VendaDB.findById(id);
    }

    public List<Venda> findAll(){
        return VendaDB.findAll();
    }
}
