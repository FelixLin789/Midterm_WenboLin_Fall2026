public class SeniorLibrarian extends Librarian implements Reservable {
    private final double leadershipBonus;

    public SeniorLibrarian(String personId, String name, String phone, String staffId, String department,
                           double baseSalary, double allowance, double leadershipBonus) {
        super(personId, name, phone, staffId, department, baseSalary, allowance);
        this.leadershipBonus = leadershipBonus;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return super.calculateMonthlyCompensation() + leadershipBonus;
    }

    @Override
    public String getRoleDescription() {
        return "Senior Librarian";
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.printf("Leadership bonus: $%.2f%n", leadershipBonus);
    }

    @Override
    public String generateReport() {
        return super.generateReport() + String.format(" (includes leadership bonus $%.2f)", leadershipBonus);
    }

    @Override
    public boolean reserveBook(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            System.out.println("Error: Reservation failed - book ID cannot be empty.");
            return false;
        }
        System.out.println(getName() + " reserved book " + bookId + " for a library event.");
        return true;
    }

    public double getLeadershipBonus() {
        return leadershipBonus;
    }
}
