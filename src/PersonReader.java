import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Person> people = new ArrayList<>();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while (reader.ready()) {
                    rec = reader.readLine();
                    String[] fields = rec.split(",");
                    if (fields.length == 5) {
                        String id = fields[0].trim();
                        String firstName = fields[1].trim();
                        String lastName = fields[2].trim();
                        String title = fields[3].trim();
                        int yob = Integer.parseInt(fields[4].trim());

                        Person p = new Person(firstName, lastName, id, title, yob);
                        people.add(p);
                    }
                }
                reader.close();

                System.out.printf("%-8s %-12s %-12s %-8s %-4s%n", "ID", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("=================================================");

                for (Person p : people) {
                    System.out.printf("%-8s %-12s %-12s %-8s %-4d%n",
                            p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
                 }

                System.out.println("\nData file read!");

            } else {
                System.out.println("No file selected!!! ... exiting.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}