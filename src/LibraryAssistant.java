public class LibraryAssistant extends LibraryStaff {
    private final double hourlyRate;
    private final int hoursWorked;

    public LibraryAssistant(String personId, String name, String phone, String staffId, String department,
                            double hourlyRate, int hoursWorked) {
        super(personId, name, phone, staffId, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getRoleDescription() {
        return "Library Assistant";
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.printf("Hourly rate: $%.2f%n", hourlyRate);
        System.out.println("Hours worked: " + hoursWorked);
        System.out.printf("Monthly compensation: $%.2f%n", calculateMonthlyCompensation());
        System.out.println("Role: " + getRoleDescription());
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}
