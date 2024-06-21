package Transacoes.Compra;

import Pessoa.Pessoa;
import Taxa.DeductionService;
import Taxa.Estado.MGDeductionService;
import Taxa.PayService;
import Transacoes.Itens;
import Transacoes.Transacoes;

import java.util.List;

public class Compra extends Transacoes {
    private double taxa;
    private double taxaPercent;

    private double totalSemTributo;
    public Compra(List<Itens> itens, Pessoa vendedor, Pessoa comprador, DeductionService taxaEstadual) {
        super(itens, vendedor, comprador);

        PayService payService = new PayService(taxaEstadual);

        itens.forEach(item -> {
            setTotal(getTotal() + item.getValorTotal());
        });

        this.totalSemTributo = getTotal();

        this.taxa = payService.tax(getTotal());
        this.taxaPercent = taxaEstadual.getTaxaPercent();

        setTotal(getTotal() + this.taxa);
    }

    public double getTaxa() {
        return taxa;
    }

    public double getTaxaPercent() {
        return taxaPercent;
    }

    public double getTotalSemTributo() {
        return totalSemTributo;
    }
}

/*
PayService payService = new PayService(new MGDeductionService());
        double tax = payService.tax(1000.0);
        System.out.println(tax);
 */
