package CarRental;


import jakarta.persistence.Query;

import java.util.List;

import static CarRental.RentalApp.em;


public class RentalRepository {

//    public void loadInitialData(){
//
//        em.getTransaction().begin();
//
//        User user1 = new User("Teddy", "Roosevelt");
//        User user2 = new User("Katarzyna", "Medycejska");
//        User user3 = new User("Ghandi","King of NUKE");
//
//        Car car1 = new Car("Toyota", "Corolla", "PO HG142");
//        Car car2 = new Car("Volvo", "V40", "PO 458OP");
//        Car car3 = new Car("Mercedes", "S500", "PO 236WZ");
//
//
//        CarRental period1 = new CarRental(
//                LocalDateTime.of(2022,12,12,10,01,10),
//                LocalDateTime.of(2020,10,18,10,50,00),user1,car2);
//
//        CarRental period2 = new CarRental(
//                LocalDateTime.of(2022, 04, 20, 21, 00),
//                LocalDateTime.of(2022, 04, 20, 23, 30), user1, car2);
//
//        em.getTransaction().commit();
//    }

    public void addCar(String brand, String model,String registrNumber){
        em.getTransaction().begin();

        Car car = new Car();
        car.setBrand(brand);
        car.getModel(model);
        car.getRegistrNumber(registrNumber);

        em.getTransaction().commit();
    }

    public void deleteCar(int rowsDelete){

        em.getTransaction().begin();

        Query query = em.createQuery("delete from Car c where c.id=:id");
        query.setParameter("id", rowsDelete);
        query.executeUpdate();
        System.out.println("Deleted car of value Id: " + rowsDelete);

        em.getTransaction().commit();
    }

    public void editCar (String brand, String model, String registrNumber){
        em.getTransaction().begin();

        Car car = new Car();

        Query query = em.createQuery("Edit Car from Car where c.id=:id");
        query.setParameter("id",car);
        query.executeUpdate();
        System.out.println("Edit Car of Value Id" + car);

        em.getTransaction().commit();
    }

    public void endLoanCar (int valueUserId, int valueCarId){
        em.getTransaction().begin();

        Query queryUser = em.createQuery("from User as u where u.id=:id");
        queryUser.setParameter("id",valueUserId);
        List<User> usersList = queryUser.getResultList();


        List<CarRental> carRentalList = em.createQuery("select r from CarRental r"
        + "join fetch r.car "
        + "where r.car.id =:id", CarRental.class )
                .setParameter("id", valueCarId)
                .getResultList();

        Query queryCar= em.createQuery("from User as u where u.id=:id");
        queryCar.setParameter("id",valueCarId);
        List<Car> carList = queryCar.getResultList();

        if(usersList.size()==0  || carRentalList.size()>0 || carList.size() == 0);
        System.out.println("Own Car isunavailable ");

    }

    public void finishLoan(String endTheGame){

        Query query = em.createQuery("delete CarRental where id=id:id");
        query.setParameter("id",endTheGame);
        int rowsDelate = query.executeUpdate();
        System.out.println("Delete car of value Id " + endTheGame);
    }
}
