public class Member extends Person implements Reservable {
    public static final double DEFAULT_DAILY_RATE = 1.00;
    private final String memberNumber;
    private final int age;
    private final String membershipType;
    private double outstandingFees;

    private Member(String personId, String name, String phone, String memberNumber, int age, String membershipType) {
        super(personId, name, phone);
        this.memberNumber = memberNumber;
        this.age = age;
        this.membershipType = membershipType;
        this.outstandingFees = 0.0;
    }

    public static Member registerMember(String personId, String name, String phone, String memberNumber, int age) {
        return registerMember(personId, name, phone, memberNumber, age, "Standard");
    }

    public static Member registerMember(String personId, String name, String phone, String memberNumber, int age,
                                        String membershipType) {
        if (isBlank(personId) || isBlank(memberNumber)) {
            System.out.println("Error: Registration failed - person ID and member number are required.");
            return null;
        }
        if (isBlank(name)) {
            System.out.println("Error: Registration failed - name cannot be empty.");
            return null;
        }
        if (isBlank(phone)) {
            System.out.println("Error: Registration failed - phone cannot be empty.");
            return null;
        }
        if (age < 1 || age > 120) {
            System.out.println("Error: Registration failed - age must be between 1 and 120.");
            return null;
        }
        if (isBlank(membershipType)
                || !(membershipType.equalsIgnoreCase("Standard") || membershipType.equalsIgnoreCase("Premium"))) {
            System.out.println("Error: Registration failed - membership must be Standard or Premium.");
            return null;
        }

        Member member = new Member(personId, name, phone, memberNumber, age, membershipType);
        System.out.println("Member registered successfully: " + name + " (" + memberNumber + ")");
        return member;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public double calculateLateFee(int daysOverdue) {
        return calculateLateFee(daysOverdue, DEFAULT_DAILY_RATE);
    }

    public double calculateLateFee(int daysOverdue, double dailyRate) {
        if (daysOverdue < 0) {
            System.out.println("Error: days overdue cannot be negative.");
            return 0.0;
        }
        if (dailyRate <= 0) {
            System.out.println("Error: daily rate must be greater than 0.");
            return 0.0;
        }
        return daysOverdue * dailyRate;
    }

    public void addFee(double amount) {
        if (amount <= 0) {
            System.out.println("Error: fee amount must be greater than 0.");
            return;
        }
        outstandingFees += amount;
    }

    @Override
    public String getRoleDescription() {
        return "Member";
    }

    @Override
    public void displayBasicDetails() {
        super.displayBasicDetails();
        System.out.println("Member number: " + memberNumber);
        System.out.println("Age: " + age);
        System.out.println("Membership: " + membershipType);
        System.out.printf("Outstanding fees: $%.2f%n", outstandingFees);
    }

    @Override
    public boolean reserveBook(String bookId) {
        if (isBlank(bookId)) {
            System.out.println("Error: Reservation failed - book ID cannot be empty.");
            return false;
        }
        System.out.println(getName() + " reserved book " + bookId + ".");
        return true;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public double getOutstandingFees() {
        return outstandingFees;
    }
}
