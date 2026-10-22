public abstract class LibraryStaff extends Person {
    private final String staffId;
    private final String department;
    private static int staffCount = 0;

    public LibraryStaff(String personId, String name, String phone, String staffId, String department) {
        super(personId, name, phone);
        this.staffId = staffId;
        this.department = department;
        staffCount++;
    }

    public static int getStaffCount() {
        return staffCount;
    }

    public abstract double calculateMonthlyCompensation();

    public void displayStaffDetails() {
        displayBasicDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }

    public String getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }
}
