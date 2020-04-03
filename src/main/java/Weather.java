import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Scanner;
import static java.lang.System.*;


public class Weather {

    public static void getValue() throws UnirestException {
        String ret;
        System.out.println("Введите пожалуйста интересующий город (на английском языке):");
        Scanner check = new Scanner(in);
        String gorod = check.nextLine();
        System.out.println("Выран город: " + gorod);
        System.out.println("Введите пожалуйста интересующее поле:\n" +
                "Доступно:\n" +
                "   -- temperature \n" +
                "   -- observation_time (Время в GMT)");
        Scanner check1 = new Scanner(in);
        String query = check1.nextLine();
        if (query.contains("temperature") || query.contains("observation_time")) {
            System.out.println("Вырано поле: " + query);
            HttpResponse<JsonNode> response = Unirest.get("http://api.weatherstack.com/current")
                    .queryString("access_key", "d891f27929cb752cb66caeb1127e8b16")
                    .queryString("query", gorod).asJson();
            ret = response.getBody().getObject().getJSONObject("current").get(query).toString();
            if (query.contains("temperature")) {
                out.println("Текущая температура в городе " + gorod + " " + ret + " градусов С");
            }
            else {
                out.println("Текущее время в городе "+ gorod + ret + " по Гринвичу");
            }

        } else out.println("Get Out Bustard!");

    }
}