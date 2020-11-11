package Models;

public class Watch {
    private int id;
    private String nameWatch;
    private String typeWatch;
    private double price;
    private int count;
    private String manufacturer;
    private String country;

    public Watch()
    {
        this.id = -1;
        this.nameWatch = null;
        this.typeWatch = null;
        this.price = -1;
        this.count = -1;
        this.manufacturer = null;
        this.country = null;
    }

    public Watch(int id, String nameWatch, String typeWatch, double price, int count, String manufacturer, String country)
    {
        this.id = id;
        this.nameWatch = nameWatch;
        this.typeWatch = typeWatch;
        this.price = price;
        this.count = count;
        this.manufacturer = manufacturer;
        this.country = country;
    }

    public Watch(String nameWatch, String typeWatch, double price, int count, String manufacturer, String country)
    {
        this.nameWatch = nameWatch;
        this.typeWatch = typeWatch;
        this.price = price;
        this.count = count;
        this.manufacturer = manufacturer;
        this.country = country;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setNameWatch (String nameWatch) { this.nameWatch = nameWatch; }
    public String getNameWatch() { return nameWatch; }

    public void setTypeWatch(String typeWatch) { this.typeWatch = typeWatch; }
    public String getTypeWatch() { return this.typeWatch; }

    public void setPrice(double price) { this.price = price; }
    public double getPrice() { return this.price; }

    public void setCount(int count) { this.price = price; }
    public int getCount() {return this.count; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getManufacturer() { return this.manufacturer; }

    public void setCountry(String country) {this.country = country;}
    public String getCountry() {return this.country;}

}
