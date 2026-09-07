import java.util.Scanner;

public class ObjInputTest {

    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your full name");
        System.out.println("Output: " + name + "\n");

        int age = input.getRangedInt("Enter your age", 1, 120);
        System.out.println("Output: " + age + "\n");

        int favoriteInt = input.getInt("Enter any integer");
        System.out.println("Output: " + favoriteInt + "\n");

        double gpa = input.getRangedDouble("Enter your GPA", 0.0, 4.0);
        System.out.println("Output: " + gpa + "\n");

        double price = input.getDouble("Enter any double value");
        System.out.println("Output: " + price + "\n");

        String ssn = input.getRegExString("Enter a SSN (xxx-xx-xxxx)", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("Output: " + ssn + "\n");

        boolean confirm = input.getYNConfirm("Do you want to save this data");
        System.out.println("Output: " + confirm + "\n");

        input.prettyHeader("SafeInputObj Testing Complete");

        Scanner customScanner = new Scanner(System.in);
        SafeInputObj customInput = new SafeInputObj(customScanner);
        System.out.println("\nTesting object instantiated with parameterized constructor:");
        String check = customInput.getNonZeroLenString("Enter 'OK' to finish");
        System.out.println("Output: " + check);
    }
}