public class Librarian extends LibraryStaff implements Reportable {
    private final double baseSalary;
    private final double allowance;

    public Librarian(String personId, String name, String phone, String staffId, String department,
                     double baseSalary, double allowance) {
        super(personId, name, phone, staffId, department);
        this.baseSalary = baseSalary;
        this.allowance = allowance;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return baseSalary + allowance;
    }

    @Override
    public String getRoleDescription() {
        return "Librarian";
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.printf("Base salary: $%.2f%n", baseSalary);
        System.out.printf("Allowance: $%.2f%n", allowance);
        System.out.printf("Monthly compensation: $%.2f%n", calculateMonthlyCompensation());
        System.out.println("Role: " + getRoleDescription());
    }

    @Override
    public String generateReport() {
        return String.format("Report by %s (%s): %s department, monthly compensation $%.2f",
                getName(), getStaffId(), getDepartment(), calculateMonthlyCompensation());
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getAllowance() {
        return allowance;
    }
}
