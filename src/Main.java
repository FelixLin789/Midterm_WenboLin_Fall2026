public class Main {
    public static void main(String[] args) {
        System.out.println("MAPLE LEAF PUBLIC LIBRARY - LIBRARY MANAGEMENT SYSTEM");
        System.out.println();
        System.out.println("--- Member registration ---");
        Member aisha = Member.registerMember("P001", "Aisha Khan", "416-555-0101", "M1001", 20);
        Member daniel = Member.registerMember("P002", "Daniel Tremblay", "416-555-0102", "M1002", 34, "Premium");
        Member.registerMember("P006", "", "416-555-0106", "M1003", 25);                 // invalid: empty name
        Member.registerMember("P006", "Mei Chen", "416-555-0106", "M1003", 150);        // invalid: age
        Member.registerMember("P006", "Mei Chen", "416-555-0106", "M1003", 19, "Gold"); // invalid: membership

        Librarian sarah = new Librarian("P003", "Sarah Thompson", "416-555-0103", "S2001",
                "Circulation", 4300.00, 250.00);
        SeniorLibrarian robert = new SeniorLibrarian("P004", "Robert Singh", "416-555-0104", "S2002",
                "Administration", 5600.00, 250.00, 600.00);
        LibraryAssistant olivia = new LibraryAssistant("P005", "Olivia Martin", "416-555-0105", "S2003",
                "Circulation", 22.50, 160);

        System.out.println();
        System.out.println("--- Members ---");
        aisha.displayBasicDetails();
        System.out.println();
        daniel.displayBasicDetails();

        System.out.println();
        System.out.println("--- Method overloading: late fees ---");
        double fee1 = aisha.calculateLateFee(7);
        double fee2 = daniel.calculateLateFee(7, 1.50);
        System.out.printf("7 days at default rate: $%.2f%n", fee1);
        System.out.printf("7 days at $1.50/day: $%.2f%n", fee2);
        aisha.addFee(fee1);
        daniel.addFee(fee2);
        System.out.printf("Outstanding fees for %s: $%.2f%n", aisha.getName(), aisha.getOutstandingFees());
        System.out.printf("Outstanding fees for %s: $%.2f%n", daniel.getName(), daniel.getOutstandingFees());
        aisha.calculateLateFee(-2);

        System.out.println();
        System.out.println("--- Runtime polymorphism / staff details ---");
        LibraryStaff[] staffList = {sarah, robert, olivia};
        for (LibraryStaff staff : staffList) {
            System.out.println();
            System.out.println(staff.getRoleDescription());
            staff.displayStaffDetails();
        }

        System.out.println();
        System.out.println("--- Runtime polymorphism / Person references ---");
        Person[] people = {aisha, daniel, sarah, robert, olivia};
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println();
        System.out.println("--- Interface: Reservable ---");
        Reservable[] reservers = {aisha, daniel, robert};
        reservers[0].reserveBook("B101");
        reservers[1].reserveBook("B205");
        reservers[2].reserveBook("B310");
        aisha.reserveBook("");

        System.out.println();
        System.out.println("--- Interface: Reportable ---");
        Reportable[] reporters = {sarah, robert};
        for (Reportable reporter : reporters) {
            System.out.println(reporter.generateReport());
        }

        System.out.println();
        System.out.println("--- Static counters ---");
        System.out.println("Total persons: " + Person.getPersonCount());
        System.out.println("Total staff: " + LibraryStaff.getStaffCount());
    }
}
