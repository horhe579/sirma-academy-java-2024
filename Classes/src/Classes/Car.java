package Classes;

import static java.lang.StringTemplate.STR;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public Car(String brand)
    {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public  Car(String brand, String model)
    {
        this.brand = brand;
        this.model = model;
        this.horsepower = -1;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String printCarInfo()
    {
        return STR."The car is: \{this.brand} \{this.model} - \{this.horsepower} HP";
    }
}

