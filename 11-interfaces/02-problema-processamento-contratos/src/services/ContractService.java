package services;

import entities.Contract;
import entities.Installment;
import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    // Injeção de dependência para garantir baixo acoplamento
    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            // Calcula o juro simples sobre o valor da parcela base
            double interest = onlinePaymentService.interest(basicQuota, i);

            // Calcula a taxa de pagamento sobre o valor da parcela + juros
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);

            // Valor total da parcela final
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }
    }
}