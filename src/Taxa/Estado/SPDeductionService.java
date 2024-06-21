package Taxa.Estado;

import Taxa.DeductionService;

public class SPDeductionService implements DeductionService {
    private double taxa = 0.10;
    private double taxaPercent = taxa * 100;
    @Override
    public double deduction(double amount){
        return amount * taxa;
    }

    @Override
    public double getTaxaPercent() {
        return taxaPercent;
    }
}
