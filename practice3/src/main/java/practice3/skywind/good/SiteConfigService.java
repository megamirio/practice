package practice3.skywind.good;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene on 27.10.16.
 */
public class SiteConfigService {
    private static Map<String, String> map = new HashMap<String, String>() {{
        put("amazon.s3.access.key.id", "AKIAJOQUPAS4EETO24NQ");
        put("amazon.s3.access.key.secret", "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");
        put("amazon.s3.bucket.name", "bigbigdeals.co.uk");
    }};

    public String getProperty(String key) {
        return map.get(key);
    }
}
