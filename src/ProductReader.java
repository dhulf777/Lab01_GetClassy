import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Product> products = new ArrayList<>();

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
                    if (fields.length == 4) {
                        String name = fields[0].trim();
                        String description = fields[1].trim();
                        String id = fields[2].trim();
                        double cost = Double.parseDouble(fields[3].trim());

                        Product p = new Product(name, description, id, cost);
                        products.add(p);
                    }
                }
                reader.close();

                System.out.printf("%-15s %-25s %-8s %-10s%n", "Name", "Description", "ID", "Cost");
                System.out.println("=================================================================");

                for (Product p : products) {
                    System.out.printf("%-15s %-25s %-8s $%-10.2f%n",
                            p.getName(), p.getDescription(), p.getID(), p.getCost());
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