import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Corona {
    public static void getValue() throws UnirestException {
        int i;
        JSONObject res;
        HttpResponse<JsonNode> resp = Unirest
                .get("https://api.covid19api.com/country/Russia/status/confirmed/live").asJson();
        JSONObject result = new JSONObject(resp.getBody());
       // String status = (String) result.get("Status");
        JSONArray result1 = result.getJSONArray("array");
        //JSONObject today = result1.getJSONObject(result1.length()-1);
        List<ObjectCorona> nocList = new ArrayList<ObjectCorona>();
        for (i=0; i<result1.length()-1; i++) {
            ObjectCorona noc  = new ObjectCorona();
            System.out.println(result1.getJSONObject(i));
            noc.cases = Integer.parseInt(result1.getJSONObject(i).get("Cases").toString());
            noc.country = result1.getJSONObject(i).get("Country");
            noc.countrycode = result1.getJSONObject(i).get("CountryCode");
            noc.setDate(Date.from(Instant.parse(result1.getJSONObject(i).get("Date").toString())));
            noc.latitude = result1.getJSONObject(i).get("Lat");
            noc.longitude = result1.getJSONObject(i).get("Lon");
            noc.status = result1.getJSONObject(i).get("Status");
            nocList.add(noc);
        }
        System.out.println("LOOOOOOOOOOOOOOOOL");
        System.out.println(nocList.get(1).getDate());
        System.out.println("33333333333333");
        //System.out.println(nocList.stream().filter(e->e.cases > 100).findFirst().get().date);
        System.out.println(nocList.stream().filter(e->e.cases > 100)
                .findFirst()
                .map(e->"Дата: " + e.getDate() + ", количетсво зараженных: " + e.cases).get());
        System.out.println(nocList.get(0).getDate().compareTo(nocList.stream()
                .filter(s->s.date.equals(nocList.get(nocList.size()-1).getDate()))
                .collect(Collectors.toList()).get(0).getDate()));
    }

    static class ObjectCorona {
        Object status;
        Object country;
        Object longitude;
        Object countrycode;
        Object latitude;
        Integer cases;
        Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
