package practice3.skywind;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmazonS3ImageURLParts {

    public static final String URL_PATTERN_MASK =
            "(?<domain>http[s]{0,1}://[A-Za-z0-9.]+)/(?<path>[A-Za-z0-9-_/]+/(?<image>(?<imageName>[A-Za-z0-9-_]+)[.](?<imageExt>[A-Za-z0-9]+)))";

    public static String URL_BASE_DIR = "tempo";

    protected static Pattern URL_PATTERN = Pattern.compile(URL_PATTERN_MASK);

    private String newRelativePathWithImage;
    private String imageWithUniqueSuffix;

    private AmazonS3ImageURLParts(String url) throws Exception {
        Matcher matcher = URL_PATTERN.matcher(url);
        if (!matcher.matches()) {
            throw new Exception("url: " + url);
        }

        imageWithUniqueSuffix = new StringBuilder(matcher.group("imageName")).append("_").append(UUID.randomUUID())
                .append(".").append(matcher.group("imageExt")).toString();

        newRelativePathWithImage = new StringBuilder(URL_BASE_DIR).append("/").append(matcher.group("image")).toString();
    }

    public static AmazonS3ImageURLParts getInstance(String url) throws Exception {
        return new AmazonS3ImageURLParts(url);
    }

    /**
     * Example:
     * if image name is: http://example.com/some/dir/any.png
     * then result is like this: any_sdsdfAdsf23.png
     */
    public String getImageWithUniqueSuffix() {
        return imageWithUniqueSuffix;

    }

    public String getNewRelativePathWithImage() {
        return newRelativePathWithImage;
    }
}
