package view;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import java.util.Scanner;
@Log4j
public class Menu {

    private final static Scanner scanner = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(Menu.class);

    public static void userConsole() {
        String option;

            displayMenu();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    // uzupełnić
                    logger.info("Dodano lokalizację do bazy danych");
                    break;
                case "2":
                    //uzupełnić
                    logger.info("Wyświetlono wszystkie lokalizacje z bazy danych");
                    break;
                case "3":
                    //uzupełnić
                    logger.info("Pobrano dane pogodowe");
                    break;
                case "4":
                    logger.info("Zamknięto aplikację");
                    System.exit(0);
                    break;
                default:
                    logger.info("Wprowadzono błędną wartość. Brak takiej opcji w menu.");
                    userConsole();
            }

    }

//    metoda userConsole() pobierająca od użytkownika inty
//    public static void userConsole() {
//        int option;
//        try {
//            displayMenu();
//            option = scanner.nextInt();
//            switch (option) {
//                case 1:
//                    // uzupełnić
//                    logger.info("Dodano lokalizację do bazy danych");
//                    break;
//                case 2:
//                    //uzupełnić
//                    logger.info("Wyświetlono wszystkie lokalizacje z bazy danych");
//                    break;
//                case 3:
//                    //uzupełnić
//                    logger.info("Pobrano dane pogodowe");
//                    break;
//                case 4:
//                    logger.info("Zamknięto aplikację");
//                    System.exit(0);
//                    break;
//                default:
//                    logger.info("Wprowadzono błędną wartość. Brak takiej opcji w menu.");
//                    userConsole();
//            }
//        } catch (InputMismatchException e) {
//            logger.error("Wprowadzono wartość nie będącą liczbą");
//            scanner.nextLine();
//            userConsole();
//        }
//    }

    private static void displayMenu(){
        System.out.println("************MENU************");
        System.out.println("1. Dodaj lokalizację do bazy danych");
        System.out.println("2. Wyświetl aktualnie dodane lokalizacje");
        System.out.println("3. Pobierz dane pogodowe");
        System.out.println("4. Wyjdź z aplikacji");
    }



}
