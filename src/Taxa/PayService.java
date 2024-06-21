package Taxa;

public class PayService {
    private DeductionService deductionService;

    public PayService (DeductionService deductionService){
        this.deductionService = deductionService;
    }

    public double tax (double amount){
        return deductionService.deduction(amount);
    }
}
