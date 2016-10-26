package practice3.skywind;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;

public class UploadObjectSingleOperation {
    private static String bucketName     = "bigbigdeals.co.uk";
    private static String keyName        = "AKIAJOQUPAS4EETO24NQ";
    private static String imageURL = "https://habrastorage.org/getpro/habr/post_images/c03/e8e/392/c03e8e39256cfc42e43df04df9f5318d.png";
    //return "https://bigbigdeals.co.uk/images/c03e8e39256cfc42e43df04df9f5318d.png";

    private static ImageURLParser amazoneImagesUtils = new ImageURLParser();

    public static void main(String[] args) throws IOException {

        AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
//        AWSCredentials credentials = new BasicAWSCredentials("AKIAJOQUPAS4EETO24NQ", "QX7o10Hv9egEhfxYsDCeVT2KrVjzp5JjSTTtAGuC");
        AmazonS3 s3client = new AmazonS3Client(credentials);

        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(amazoneImagesUtils.getImage(imageURL));
            FileUtils.copyURLToFile(new URL(imageURL), file);
            s3client.putObject(new PutObjectRequest(
                    bucketName, amazoneImagesUtils.getRelativePathToImage(imageURL), file));
            FileUtils.forceDelete(file);

        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
    }
}
