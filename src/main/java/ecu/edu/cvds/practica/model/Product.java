package ecu.edu.cvds.practica.model;

public class Product {
    private String name;
    private Integer price;
    private Integer units;
    private String category;

    public Product(String name,Integer price, Integer units, String category){
        this.name = name;
        this.price = price;
        this.units = units;
        this.category = category;
    }

    public String getName(){
        return name;
    }

    public Integer getPrice(){
        return price;
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    public Integer getUnits(){
        return units;
    }

    public void setUnits(int newUnits){
        this.units=newUnits;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
