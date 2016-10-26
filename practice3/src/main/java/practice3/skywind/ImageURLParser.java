package practice3.skywind;

public class ImageURLParser {
    public static String BIGBIGDEALS_DOMAIN = "bigbigdeals.com";

    public String changeDomainToBigbigdeals(String url) {
        return url.replaceFirst("://[a-zA-Z0-9.]+", "://" + BIGBIGDEALS_DOMAIN);
    }

    /**
     * Returns URL in form of {@code domain/relativePath/image}
     *
     * @param url
     * @param relativePath
     * @return
     */
    public String changeDomainToBigbigdeals(String url, String relativePath) {

        StringBuilder urlBbd = new StringBuilder(changeDomainToBigbigdeals(url));

        int indexOfSlashAfterDomain = urlBbd.toString().replaceFirst("/", "0").replaceFirst("/", "0").indexOf("/");
        String domain = urlBbd.substring(0, indexOfSlashAfterDomain);
        urlBbd.reverse();
        int indexOfSlashBeforeImage = urlBbd.indexOf("/");
        //Back reverse
        urlBbd.reverse();
        String image = urlBbd.substring(urlBbd.length() - indexOfSlashBeforeImage);

        return new StringBuilder(domain).append("/").append(relativePath).append("/").append(image).toString();
    }

    public String getImage(String url) {

        StringBuilder urlBbd = new StringBuilder(changeDomainToBigbigdeals(url));
        urlBbd.reverse();
        int indexOfSlashBeforeImage = urlBbd.indexOf("/");
        urlBbd.reverse();
        return urlBbd.substring(urlBbd.length() - indexOfSlashBeforeImage);
    }

    public String getRelativePathToImage(String url) {

        StringBuilder urlBbd = new StringBuilder(changeDomainToBigbigdeals(url));
        int indexOfSlashAfterDomain = urlBbd.toString().replaceFirst("/", "0").replaceFirst("/", "0").indexOf("/");
        return urlBbd.substring(indexOfSlashAfterDomain, urlBbd.length());
    }

    public static void main(String[] args) {
        System.out.println("App start");

        ImageURLParser uc = new ImageURLParser();
        String urlNew = uc.changeDomainToBigbigdeals("http://sdfdsdf.sdfsdf.323.dsf/sdfsd.sdfs/s234");
        System.out.println(urlNew);

        String urlNew2 = uc.changeDomainToBigbigdeals("http://sdfdsdf.sdfsdf.23423ssdf");
        System.out.println(urlNew2);

        String urlNew3 = uc
                .changeDomainToBigbigdeals("https://static01.nyt.com/images/2016/10/25/us/25TRUMPTAPES1/25TRUMPTAPES1-superJumbo.jpg");
        System.out.println(urlNew3);


        int indexOfThirdSlash = urlNew3.replaceFirst("/", "0").replaceFirst("/", "0").indexOf("/");
        String domain = urlNew3.substring(0, indexOfThirdSlash);
        int imageSlash = new StringBuilder(urlNew3).reverse().indexOf("/");
        String image = urlNew3.substring(urlNew3.length() - imageSlash);

        System.out.println(domain);
        System.out.println(image);
        System.out.println(uc.changeDomainToBigbigdeals(urlNew3, "relative/amazone"));
    }
}
