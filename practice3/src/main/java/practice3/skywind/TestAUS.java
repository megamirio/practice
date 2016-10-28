package practice3.skywind;

import java.io.IOException;

/**
 * Created by eugene on 26.10.16.
 */
public class TestAUS {
    public static void main(String[] args) throws IOException {
        String imageURL = "https://habrastorage.org/getpro/habr/post_images/c03/e8e/392/c03e8e39256cfc42e43df04df9f5318d.png";
        UploadImageToAmazoneS3 upload = new UploadImageToAmazoneS3("AKIAJOQUPAS4EETO24NQ",
                "QX7o10Hv9egEhfxYsDCeVT2KrVjzp5JjSTTtAGuC", "bigbigdeals.co.uk");
        upload.upload(imageURL);
    }
}
