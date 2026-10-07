package entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double basicTax;
        if (getAnualIncome() < 20000.0) {
            basicTax = getAnualIncome() * 0.15;
        } else {
            basicTax = getAnualIncome() * 0.25;
        }

        basicTax -= healthExpenditures * 0.5;

        // Garante que o imposto não seja negativo caso os gastos com saúde sejam muito altos
        if (basicTax < 0.0) {
            basicTax = 0.0;
        }
        return basicTax;
    }
}