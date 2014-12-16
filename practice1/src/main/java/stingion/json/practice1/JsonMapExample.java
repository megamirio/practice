package stingion.json.practice1;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ievgen on 9/22/14 1:51 PM.
 */
public class JsonMapExample {

    public static void main(String[] args) {
        String json = "{\"name\":\"mkyong\", \"age\":\"29\"}";

        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            //convert JSON string to Map
            map = mapper.readValue(json, new TypeReference<HashMap<String,String>>(){});

            System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
