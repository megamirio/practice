package practice3.skywind.amazon;

import java.util.UUID;

/**
 * Created by royalflush on 06.12.16.
 */
public class AmazonS3ImageURLParts {
    private StringBuilder url;

    private static String URL_BASE_DIR = "images";
    private String relativePath;
    private String image;
    private String imageUniqueExtension;

    public AmazonS3ImageURLParts(String url) {
        this.url = new StringBuilder(url);
        processWithFieldAssigning();
    }

    /**
     * Method contains math. logic of processing
     */
    public void processWithFieldAssigning() {

        image = new StringBuilder(imageName()).append(".").append(imageExtension()).toString();
        imageUniqueExtension = new StringBuilder(imageName()).append("_").append(UUID.randomUUID()).append(".")
                .append(imageExtension()).toString();
        relativePath = url.substring(indexOfSlashAfterDomain() + 1, url.length() - indexOfSlashBeforeImage() - 1);
    }

    private int indexOfSlashAfterDomain() {
        final String ANY_SYMBOL = "0";

        return url.toString().replaceFirst("/", ANY_SYMBOL)
                .replaceFirst("/", ANY_SYMBOL).indexOf("/");
    }

    private int indexOfSlashBeforeImage() {
        url.reverse();
        try {
            return url.indexOf("/");
        } finally {
            url.reverse();
        }
    }

    private int indexOfDotBeforeImageExtension() {
        url.reverse();
        try {
            return url.indexOf(".");
        } finally {
            url.reverse();
        }
    }

    private String imageName() {
        int lastSlash = url.length() - indexOfSlashBeforeImage();
        int lastDot = url.length() - indexOfDotBeforeImageExtension() - 1;
        if (lastDot < lastSlash) {
            lastDot = url.length();
        }
        return url.substring(lastSlash, lastDot);
    }

    private String imageExtension() {
        int lastSlash = url.length() - indexOfSlashBeforeImage();
        int lastDot = url.length() - indexOfDotBeforeImageExtension();
        if (lastDot < lastSlash) {
            return "jpg";
        }
        return url.substring(lastDot);
    }

    /**
     * Example:
     * if image name is: http://example.com/some/dir/any.png
     * then result is: any.png
     */
    public String getImage() {
        return image;
    }

    /**
     * Example:
     * if image name is: http://example.com/some/dir/any.png
     * then result is like this: any_sdsdfAdsf23.png
     */
    public String getImageWithUniqueSuffix() {
        return imageUniqueExtension;
    }

    /**
     * Example:
     * if image name is: http://example.com/some/dir/any.png
     * then result is: some/dir
     */
    public String getRelativePath() {
        return relativePath;
    }

    public String getRelativePathWithImage() {
        return new StringBuilder(URL_BASE_DIR).append("/").append(image).toString();
    }

    public String getRelativePathWithImageUnique() {
        return new StringBuilder(URL_BASE_DIR).append("/").append(imageUniqueExtension).toString();
    }

    public static void main(String[] args) {
        String imageURL = "https://habrastorage.org/getpro/habr/post_images/c03/e8e/392/c03e8e39256cfc42e43df04df9f5318d.png";

//        long b = System.nanoTime();
//        new AmazonS3ImageURLParts(imageURL);
//        long e = System.nanoTime();
//        long r = e - b;
//        System.out.println(r);

        String a = "abc";
        long b = System.nanoTime();

        String s = a.concat("abc").concat("oo");

        long e = System.nanoTime();
        long r = e - b;
        System.out.println(r);


    }

}
