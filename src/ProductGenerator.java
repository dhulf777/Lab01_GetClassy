import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        SafeInputObj input = new SafeInputObj();

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.toString(), "productData.txt");

        boolean done = false;

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;

        do {
            ID = input.getNonZeroLenString("Enter the ID [6 digits]");
            name = input.getNonZeroLenString("Enter the name");
            description = input.getNonZeroLenString("Enter the description");
            cost = input.getRangedDouble("Enter the cost", 0, 100000);

            Product p = new Product(name, description, ID, cost);
            products.add(p);

            done = input.getYNConfirm("Are you done?");

        } while (!done);

        for (Product p : products) {
            System.out.println(p.toString());
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Product p : products) {
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