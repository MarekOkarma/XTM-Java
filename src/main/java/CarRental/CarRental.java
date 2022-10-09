package CarRental;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime startPeriod;

    @Column
    private LocalDateTime endPeriod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }
    public  Car getCar(){
        return car;
    }

    public void setCar (Car car) {
        this.car = car;
    }

    public  CarRental(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartPeriod() {
        return startPeriod.withNano(0);
    }

    public void setStartPeriod(LocalDateTime startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalDateTime getEndPeriod() {
        return endPeriod.withNano(0);
    }

    public void setEndPeriod(LocalDateTime endPeriod) {
        this.endPeriod = endPeriod;
    }

    public CarRental(LocalDateTime startPeriod, LocalDateTime endPeriod, User user, Car car) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.user = user;
        this.car = car;
    }
}
