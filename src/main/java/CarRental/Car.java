package CarRental;

import jakarta.persistence.*;

@Entity
@Table
public class Car {

    //Klasa POJO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String registrNumber;


    public Car(){

    }

    public Car(String brand, String model, String registrNumber) {
        this.brand = brand;
        this.model = model;
        this.registrNumber = registrNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel(String model) {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrNumber(String registrNumber) {
        return this.registrNumber;
    }

    public void setRegistrNumber(String registrNumber) {
        this.registrNumber = registrNumber;
    }

}
