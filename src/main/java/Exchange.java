import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Scanner;

import static java.lang.System.*;

public class Exchange {
    public static void getValue() throws UnirestException {
        String[] array = new String[]{"USD", "AUD", "CAD", "PLN", "MXN"};
        int i;
        String ret;
        out.println("ВВедите пожалуйста интересующую вас валюту:\n");
        for (i = 0; i < 5; i++) {
            out.println(i + " = " + array[i]);
        }
        Scanner scan = new Scanner(in);
        String money = scan.nextLine();
        if (money.isEmpty()) {
            out.println("Get out Bastard!");
        } else if (money.contains("USD") || money.contains("AUD") || money.contains("CAD") || money.contains("PLN") || money.contains("MXN")) {
            HttpResponse<JsonNode> response = Unirest.get("http://data.fixer.io/api/latest")
                    .queryString("access_key", "88d05c9b618a117298e8f4870e2e3c95")
                    .queryString("symbols", money).asJson();
            ret = response.getBody().getObject().getJSONObject("rates").get(money).toString();
            if (money.contains("USD")) {
                out.println("Курс доллара к евро: " + ret);
            } else if (money.contains("AUD")) {
                out.println("Курс австралийского доллара к евро: " + ret);
            } else if (money.contains("CAD")) {
                out.println("Курс канадского доллара к евро: " + ret);
            } else if (money.contains("PLN")) {
                out.println("Курс польского злотого к евро: " + ret);
            } else if (money.contains("MXN")) {
                out.println("Курс мексиканского пессо к евро: " + ret);
            }
        }
        else {
            out.println("Выбрал что-то не то, будь внимателен!");
            exit(0);
        }
    }
}
