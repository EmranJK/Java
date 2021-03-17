public class SalesWorker extends Employee {

private double percentage;

    public SalesWorker(String firstName, String lastName, String email,
                       String phoneNum, String ppsNum, double hoursWorked, double hourRate, double percentage) {

        super(firstName, lastName, email, phoneNum, ppsNum, hoursWorked, hourRate);
        if (percentage > -1 && percentage < 21)
        this.percentage = percentage;

    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
      /*989*/  if (percentage > -1 && percentage < 21)
        this.percentage = percentage;
      else
          this.percentage = getPercentage();
    }

    @Override
    public double calculateSalary() {
        return getSalary()+(getSalary()*percentage/100);
    }
}
