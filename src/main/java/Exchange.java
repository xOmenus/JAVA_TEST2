import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.w3c.dom.UserDataHandler;

import java.util.Arrays;

import static java.lang.System.*;

public class Exchange {
    public static void getValue() {
        String[] array = new String[] {"USD", "AUD", "CAD", "PLN", "MXN"} ;
        for (i=0;i<5;i++){
            out.println("ВВедите пожалуйста интересующую вас валюту:\n" + array[i]);
        }

        String money;
        HttpResponse<JsonNode> response = Unirest.get("http://data.fixer.io/api/latest")
                .queryString("access_key", "88d05c9b618a117298e8f4870e2e3c95")
                .queryString("symbols", money).asJson();
        ret = response.getBody().getObject().getJSONObject("current").get(query).toString();
    }
}
