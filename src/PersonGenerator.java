import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        SafeInputObj input = new SafeInputObj();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.toString(), "personData.txt");

        boolean done = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {
            ID = input.getNonZeroLenString("Enter the ID [6 digits]");
            firstName = input.getNonZeroLenString("Enter the first name");
            lastName = input.getNonZeroLenString("Enter the last name");
            title = input.getNonZeroLenString("Enter the title");
            YOB = input.getRangedInt("Enter the year of Birth", 1940, 2010);

            Person p = new Person(firstName, lastName, ID, title, YOB);
            people.add(p);

            done = input.getYNConfirm("Are you done?");

        } while (!done);

        for (Person p : people) {
            System.out.println(p.toString());
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Person p : people) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}