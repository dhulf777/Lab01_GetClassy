import java.util.Calendar;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String ID) {
        this(firstName, lastName, ID, "", 2000);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    public String toCSV() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toJSON() {
        return "{\"ID\":\"" + ID + "\",\"firstName\":\"" + firstName + "\",\"lastName\":\"" + lastName + "\",\"title\":\"" + title + "\",\"YOB\":" + YOB + "}";
    }

    public String toXML() {
        return "<Person><ID>" + ID + "</ID><firstName>" + firstName + "</firstName><lastName>" + lastName + "</lastName><title>" + title + "</title><YOB>" + YOB + "</YOB></Person>";
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(title, person.title);
    }
}