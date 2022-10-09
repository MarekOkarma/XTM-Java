package CarRental;

import ConnectionTest.HibernateUtil;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class RentalApp {

    public static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static EntityManager em = sessionFactory.createEntityManager();

    public static void main(String[] args) {

        RentalRepository rentalRepository = new RentalRepository();


        Scanner scanner = new Scanner(System.in);
        boolean isWorking = true;

        while (isWorking){
            System.out.printf("Enter option: " +
                    "Exit" +
                    "Add Car" +
                    "Delete Car" +
                    "Edit Car" +
                    "Finish Time");

            String text = scanner.nextLine();

            switch (text) {
                case "exit":
                    isWorking = false;
                    break;
                case "Add Car":
                    System.out.print("Enter for Car: Brand, Model, registrNumber");
                    rentalRepository.addCar(scanner.next(), scanner.next(), scanner.next());
                    break;
                case "delCar":
                    System.out.print("Enter : Id (Value");
                    rentalRepository.deleteCar(scanner.nextInt());
                    break;
                case "Edit":
                    System.out.println("Enter to edit car");
                    rentalRepository.editCar(scanner.next(), scanner.next(), scanner.next());
                case "EndTheGame":
                    System.out.println("Enter Car");
                    rentalRepository.endLoanCar(scanner.nextInt(),scanner.nextInt());

                default:
                    System.out.println("Not recognized");
            }
        }

        HibernateUtil.shutdown();

    }
}
