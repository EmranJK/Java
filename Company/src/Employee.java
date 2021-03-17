public abstract class Employee {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private String ppsNum;
    private double hoursWorked;
    private double hourRate;
    static final double NORMAL_WORKWEEK = 39.5;
    static final double MIN_WAGE = 9.80;

    public Employee(String firstName, String lastName, String email,
                    String phoneNum, String ppsNum, double hoursWorked, double hourRate) {
        this.firstName = Utilities.max30Chars(firstName);
        this.lastName = Utilities.max30Chars(lastName);
        if (Utilities.validEmail(email))
        this.email = email;
        else
            this.email = "Invalid";
        if (Utilities.onlyContainsNumbers(phoneNum))
        this.phoneNum = phoneNum;
        else
            this.phoneNum = "Invalid";
        if (Utilities.validPps(ppsNum))
        this.ppsNum = ppsNum;
        else
            this.ppsNum = "Invalid";
        if (hoursWorked > 0)
        this.hoursWorked = hoursWorked;
        else
            this.hoursWorked = 0;
        if (hourRate >= MIN_WAGE)
        this.hourRate = hourRate;
        else
            this.hourRate = MIN_WAGE;

    }

    public String getFirstName() {
        return firstName;
    }

    /*989*/  public void setFirstName(String firstName) {
        if (firstName.length() <= 30)
        this.firstName = Utilities.max30Chars(firstName); //is that all
    }

    public String getLastName() {
        return lastName;
    }

    /*989*/   public void setLastName(String lastName) {
        if (lastName.length() <= 30)
        this.lastName = Utilities.max30Chars(lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Utilities.validEmail(email))
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if (Utilities.onlyContainsNumbers(phoneNum))
        this.phoneNum = phoneNum;
    }

    public String getPpsNum() {
        return ppsNum;
    }

    public void setPpsNum(String ppsNum) {
        if (Utilities.validPps(ppsNum))
            this.ppsNum = ppsNum;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked > 0)
            this.hoursWorked = hoursWorked;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        if (hourRate >= MIN_WAGE)
            this.hourRate = hourRate;
    }



    public double getOverTime()
    {
        if (hoursWorked > NORMAL_WORKWEEK)
        {
            double overTimeHours = hoursWorked - NORMAL_WORKWEEK;
            return overTimeHours * (hourRate * 2);
        }
        else
        {
            return 0;
        }

    }

    public double getSalary()
    {
        if (hoursWorked > NORMAL_WORKWEEK)
        {
           double normal_sal = NORMAL_WORKWEEK * hourRate;
           return normal_sal + getOverTime();
        }
        else
        {
            return hoursWorked * hourRate;
        }
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", ppsNum='" + ppsNum + '\'' +
                ", Hours Worked=" + hoursWorked +
                ", per hour=" + hourRate +
                ", NORMAL_WORKWEEK=" + NORMAL_WORKWEEK +
                ", MIN_WAGE=" + MIN_WAGE +
                '}';
    }
}
