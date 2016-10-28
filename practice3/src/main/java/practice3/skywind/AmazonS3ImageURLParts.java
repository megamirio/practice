package practice3.skywind;

import java.util.UUID;

public class AmazonS3ImageURLParts {

    private StringBuilder url;

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
        return url.substring(url.length() - indexOfSlashBeforeImage(),
                url.length() - indexOfDotBeforeImageExtension() - 1);
    }

    private String imageExtension() {
        return url.substring(url.length() - indexOfDotBeforeImageExtension());
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
        return new StringBuilder(relativePath).append("/").append(image).toString();
    }

    public String getRelativePathWithImageUnique() {
        return new StringBuilder(relativePath).append("/").append(imageUniqueExtension).toString();
    }
}
