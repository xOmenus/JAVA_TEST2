import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.corba.se.impl.orb.ParserTable;

import java.util.Scanner;
import java.util.TimeZone;
import static java.lang.System.*;
import static java.util.SimpleTimeZone.getTimeZone;
import static java.util.TimeZone.getAvailableIDs;

public class myFirstApp {
    public static void main(String[] args) throws UnirestException {
        String check;
        Scanner scanner;
        String degree;
        out.println("Как вас зовут?");
        Scanner name = new Scanner(in);
        out.println("Привет " + name.nextLine());
        out.println("Набери help и узнаешь что я могу.");
        scanner = new Scanner(in);
        check = scanner.nextLine();
        if (check.contains("elp")) {
            out.println("Необходимо выбрать нужный пункт, отметив его цифрой.\n" +
                    "1 - Узнать погоду на текущий день.\n" +
                    "2 - Узнать последние новорти про коронавирус.\n" +
                    "3 - Узнать курс рубля к доллару.\n" +
                    "4 - Выйти из программы.");} else {
            out.println("Ты ввел хрень какую-то! Писать разучился!?");
            exit(0);
        }
            scanner = new Scanner(in);
            check = scanner.nextLine();
        if (check.isEmpty()) {
                out.println("Get out bustard!");
                exit(
                        0);
            }
            else if (check.contains(("1")))
                 Weather.getValue();
            else if (check.contains("2")) {
                Exchange.getValue();
            }
            else {
                out.println("Ты ввел хрень какую-то! Писать разучился!?");
                exit(0);
            }

        }
    }