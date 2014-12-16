package stingion.json.practice1;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by ievgen on 9/22/14 2:10 PM.
 */
public class PrettyPrint {

    public static void main(String[] args) throws IOException {
        String test = "{\"age\":29,\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"],\"name\":\"mkyong\"}";
        ObjectMapper mapper = new ObjectMapper();
        Object json = mapper.readValue(test, Object.class);
        System.out.println(mapper.writeValueAsString(json));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
    }
}
