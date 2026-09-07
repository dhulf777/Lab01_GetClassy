import java.util.Objects;

public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public Product(String name, String ID, double cost) {
        this(name, "", ID, cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSV() {
        return name + ", " + description + ", " + ID + ", " + cost;
    }

    public String toJSON() {
        return "{\"name\":\"" + name + "\",\"description\":\"" + description + "\",\"ID\":\"" + ID + "\",\"cost\":" + cost + "}";
    }

    public String toXML() {
        return "<Product><name>" + name + "</name><description>" + description + "</description><ID>" + ID + "</ID><cost>" + cost + "</cost></Product>";
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(ID, product.ID);
    }
}