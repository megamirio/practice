package practice3.skywind;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by eugene on 26.10.16.
 */
public class UploadImageToAmazoneS3 {

    private static final Logger LOG = Logger.getLogger(UploadImageToAmazoneS3.class);

    private String bucketName;
    private AmazonS3 s3client;

    public UploadImageToAmazoneS3(AmazonS3 s3client, String bucketName) {
        this.s3client = s3client;
        this.bucketName = bucketName;
    }

    public UploadImageToAmazoneS3(String awsAccessKeyId, String awsSecretAccessKey, String bucketName) {
        AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        this.s3client = new AmazonS3Client(credentials);
        this.bucketName = bucketName;
    }

    public void upload(String imageURL) throws Exception {
        try {
            AmazonS3ImageURLParts amazonS3ImageURLParts = AmazonS3ImageURLParts.getInstance(imageURL);
            File file = new File(amazonS3ImageURLParts.getImageWithUniqueSuffix());
            FileUtils.copyURLToFile(new URL(imageURL), file);

            s3client.putObject(new PutObjectRequest(
                    bucketName, amazonS3ImageURLParts.getNewRelativePathWithImage(), file));

            FileUtils.forceDelete(file);

        } catch (AmazonServiceException ase) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Caught an AmazonServiceException, which means your request made it " +
                    "to Amazon S3, but was rejected with an error response for some reason.").append("\n");
            errorMessage.append("Error Message:    " + ase.getMessage()).append("\n");
            errorMessage.append("HTTP Status Code: " + ase.getStatusCode()).append("\n");
            errorMessage.append("AWS Error Code:   " + ase.getErrorCode()).append("\n");
            errorMessage.append("Error Type:       " + ase.getErrorType()).append("\n");
            errorMessage.append("Request ID:       " + ase.getRequestId()).append("\n");
            LOG.error(errorMessage.toString());
        } catch (AmazonClientException ace) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Caught an AmazonClientException, which means the client encountered " +
                    "an internal error while trying to communicate with S3, " +
                    "such as not being able to access the network.").append("\n");
            errorMessage.append("Error Message: " + ace.getMessage()).append("\n");
        }
    }
}
