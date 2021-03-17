public class AdminWorker extends Employee {

    private double bonus;

    public AdminWorker(String firstName, String lastName, String email,
                       String phoneNum, String ppsNum, double hoursWorked, double hourRate, double bonus) {
        super(firstName, lastName, email, phoneNum, ppsNum, hoursWorked, hourRate);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    /*989*/ public void setBonus(double bonus) {
        if (bonus >= 0)
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getSalary()+bonus;
    }

}
