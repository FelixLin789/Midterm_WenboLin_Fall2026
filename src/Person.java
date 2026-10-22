public abstract class Person {
    private final String personId;
    private final String name;
    private final String phone;
    private static int personCount = 0;

    public Person(String personId, String name, String phone) {
        this.personId = personId;
        this.name = name;
        this.phone = phone;
        personCount++;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public void displayBasicDetails() {
        System.out.println("Person ID: " + personId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return "Person ID: " + personId + ", Name: " + name + ", Role: " + getRoleDescription();
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
