package stingion.json.practice1;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ievgen on 9/22/14 1:53 PM.
 */
public class MapJsonExample {
    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            String json = "";

            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "mkyong");
            map.put("age", "29");

            //convert map to JSON string
            json = mapper.writeValueAsString(map);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
