package practice3.skywind.good;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;
import practice3.skywind.AmazonS3ImageURLParts;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by royalflush on 12.12.16.
 */
public class Uploader {

    private String bucketName = "bigbigdeals.co.uk";
    private String keyName = "AKIAJOQUPAS4EETO24NQ";
    private String imageURL = "https://habrastorage.org/getpro/habr/post_images/c03/e8e/392/c03e8e39256cfc42e43df04df9f5318d.png";
    private String keySecret = "QX7o10Hv9egEhfxYsDCeVT2KrVjzp5JjSTTtAGuC";

    private AWSCredentials credentials = new BasicAWSCredentials(keyName, keySecret);
    private AmazonS3 s3client = new AmazonS3Client(credentials);

    private List<String> listOfAddedUrl = new LinkedList<>();

    private void deleteObject() {
        for (String forDel : listOfAddedUrl) {
            s3client.deleteObject(new DeleteObjectRequest(bucketName, forDel));
        }
    }

    private List<Long> listOfRes = new LinkedList<>();

    class ThreadA implements Runnable {
        private int begin;
        private int end;

        public ThreadA(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            long b = System.nanoTime();
            for (int i = begin; i < end; i++) {
                File file = new File("/home/eugene/Downloads/s2/" + i + ".jpg");
                String sRand = UUID.randomUUID().toString();
                s3client.putObject(new PutObjectRequest(bucketName,
                        "tempo/" + i + sRand + ".png",
                        file));
                System.out.println("tempo/" + i + sRand + ".png");
            }
            long e = System.nanoTime();
            long r = e - b;
            listOfRes.add(r);
            System.out.println(Thread.currentThread() + ": >>> " + r);
        }
    }

    public void go(String[] args) throws Exception {
        System.out.println("System >>>");
        AmazonS3ImageURLParts amazoneImagesUtils = AmazonS3ImageURLParts.getInstance(imageURL);

        int amount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(amount);
        long b = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            executorService.execute(new ThreadA(i, i + 100 / amount));
        }
        long e = System.nanoTime();
        long r = e - b;

        executorService.shutdown();
    }


    public static void main(String[] args) throws Exception {
        new Uploader().go(args);
    }

    private void createFiles() {
        File file = new File("/home/eugene/Downloads/s2/0.jpg");
        for (int i = 1; i < 1000; i++) {
            File fileOut = new File("/home/eugene/Downloads/s2/" + i + ".jpg");
            try {
                FileUtils.copyFile(file, fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
