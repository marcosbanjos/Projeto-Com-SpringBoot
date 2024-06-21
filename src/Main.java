import Pessoa.Pessoa;
import Pessoa.PessoaFisica;
import Pessoa.PessoaJuridica;
import Pessoa.PessoaService;
import Pessoa.TipoPessoa;
import Produtos.GeneroProduto;
import Produtos.Produto;
import Produtos.ProdutoService;
import Relatorios.RelatoriosService;
import Taxa.Estado.MGDeductionService;
import Taxa.Estado.SPDeductionService;
import Transacoes.Compra.Compra;
import Transacoes.Compra.CompraService;
import Transacoes.Itens;
import Transacoes.Venda.Venda;
import Transacoes.Venda.VendaService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();
        VendaService vendaService = new VendaService();
        PessoaService pessoaService = new PessoaService();

        Pessoa pf1 = pessoaService.createPessoaFisica(new PessoaFisica("Danilo Amorim",  "danilo@email.com", "(18)98181-1644", "029.946.465-28", TipoPessoa.FISICA));
        Pessoa pf2 = pessoaService.createPessoaFisica(new PessoaFisica("Marcos Batista", "marcos@email.com", "(18)97070-7170", "780.047.840-89", TipoPessoa.FISICA));
        Pessoa pf3 = pessoaService.createPessoaFisica(new PessoaFisica("Marjory Washio", "marjory@email.com", "(18)97070-7171", "469.754.080-84", TipoPessoa.FISICA));

        Pessoa pj1 = pessoaService.createPessoaJuridica(new PessoaJuridica("Mercadinho da esquina", "empresa_sa@email.com", "(18)97070-7070", "88.723.152/0001-63", TipoPessoa.JURIDICA));
        Pessoa pj2 = pessoaService.createPessoaJuridica(new PessoaJuridica("Fornecedor S.A", "empresa_sa@email.com", "(18)97070-7071", "84.675.865/0001-48", TipoPessoa.JURIDICA));
        Pessoa pj3 = pessoaService.createPessoaJuridica(new PessoaJuridica("Empresa S.A", "empresa_sa@email.com", "(18)97070-7072", "43.173.040/0001-48", TipoPessoa.JURIDICA));

        GeneroProduto gp1 = new GeneroProduto("Perecível");
        GeneroProduto gp2 = new GeneroProduto("Não Perecível");

        Produto pd1 = produtoService.create(
                new Produto("Arroz 5 kg", gp2, 21.99, 100, 5, 50)
        );
        Produto pd2 = produtoService.create(
                new Produto("Feijão 1 kg", gp2, 8.99, 100, 5, 40)
        );
        Produto pd3 = produtoService.create(
                new Produto("Leite UHT", gp1, 5.35, 100, 10, 23)
        );
        Produto pd4 = produtoService.create(
                new Produto("Iogurte Morango 540g", gp1, 5.39, 100, 5, 77)
        );
        Produto pd5 = produtoService.create(
                new Produto("Café Tradicional 500g", gp2, 15.90, 100, 5, 65)
        );

        List<Itens> listItens1 = new ArrayList<Itens>();
        listItens1.add(new Itens(pd1, 10));
        listItens1.add(new Itens(pd2, 10));
        listItens1.add(new Itens(pd5, 10));

        compraService.create(new Compra(listItens1, pj2, pj1, new MGDeductionService()));

        List<Itens> listItens2 = new ArrayList<Itens>();
        listItens2.add(new Itens(pd3, 10));
        listItens2.add(new Itens(pd4, 10));

        compraService.create(new Compra(listItens2, pj3, pj1, new SPDeductionService()));

        List<Itens> listItens3 = new ArrayList<Itens>();
        listItens3.add(new Itens(pd1, 10));
        listItens3.add(new Itens(pd2, 10));
        listItens3.add(new Itens(pd5, 10));

        List<Itens> listItens4 = new ArrayList<Itens>();
        listItens4.add(new Itens(pd3, 31));
        listItens4.add(new Itens(pd4, 10));

        vendaService.create(new Venda(listItens3, pf3, pf2));
        vendaService.create(new Venda(listItens4, pf3, pf2));
        vendaService.create(new Venda(listItens3, pf1, pf2));

        System.out.println("\n\n----------------------------------------------");
        RelatoriosService relatoriosService = new RelatoriosService();

        relatoriosService.totalVendaProduto();
        System.out.println();
        relatoriosService.totalVendaGenero();
        System.out.println();
        relatoriosService.totalVendaCliente();
        System.out.println();
        relatoriosService.totalComprasEstoque();
        System.out.println();
        relatoriosService.produtoMaisVendido();
    }
}
