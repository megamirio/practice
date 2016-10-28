package practice3.skywind.good;

import practice3.skywind.UploadImageToAmazoneS3;

import java.io.IOException;

/**
 * Created by eugene on 26.10.16.
 */
public class TestAUS {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");

        int millisecOverall = 0;
        int sleep_duration = 1 * 60 * 1000;
        int stop_sleep_time = 60 * 60 * 1000;

        String imageURL = "https://habrastorage.org/getpro/habr/post_images/c03/e8e/392/c03e8e39256cfc42e43df04df9f5318d.png";
        UploadImageToAmazonS3ServiceImpl upload = new UploadImageToAmazonS3ServiceImpl();

        do {
            String imageURLNew = upload.upload(imageURL);
            System.out.println(imageURLNew);

            Thread.sleep(sleep_duration);
            millisecOverall += sleep_duration;
            if (millisecOverall / stop_sleep_time > 0) {
                break;
            }
        } while (true);
    }
}
