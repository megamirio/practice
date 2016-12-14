package practice3.skywind.good;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import practice3.skywind.AmazonS3ImageURLParts;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class UploadImageToAmazonS3ServiceImpl {

    private static final Logger LOG = Logger.getLogger(UploadImageToAmazonS3ServiceImpl.class);

    @Resource
    private SiteConfigService siteConfigService;

    private static final String AMAZON_ACCESS_KEY_ID = "amazon.s3.access.key.id";
    private static final String AMAZON_ACCESS_KEY_SECRET = "amazon.s3.access.key.secret";
    private static final String AMAZON_BUCKET_NAME = "amazon.s3.bucket.name";

    private AmazonS3 s3client;
    private String imageURL;

    public UploadImageToAmazonS3ServiceImpl() {
        createS3Client();
    }

    public String upload(String imageURL) throws IOException {

        try {
            this.imageURL = imageURL;
            return uploadToServer();
        } catch (AmazonClientException e) {
            return reconnectAndUpload();
        }
    }

    private String uploadToServer() throws IOException, AmazonClientException {

        String bucketName = siteConfigService.getProperty(AMAZON_BUCKET_NAME);

        AmazonS3ImageURLParts amazonS3ImageURLParts = null;// new AmazonS3ImageURLParts(imageURL);
        File file = new File(amazonS3ImageURLParts.getImageWithUniqueSuffix());
        FileUtils.copyURLToFile(new URL(imageURL), file);

//        s3client.putObject(new PutObjectRequest(
//                bucketName, amazonS3ImageURLParts.getRelativePathWithImageUnique(), file));

        FileUtils.forceDelete(file);
        return null;// new StringBuilder("https://").append(bucketName).append("/")
                //.append(amazonS3ImageURLParts.getRelativePathWithImageUnique()).toString();
    }

    private String reconnectAndUpload() throws IOException {
        createS3Client();
        try {
            System.out.println("!!!!!!!!!!!! RECONNECT !!!!!!!!!!!!");
            return uploadToServer();
        } catch (AmazonClientException e) {
            throw e;
        }
    }

    private void createS3Client() {
        String awsAccessKeyId = siteConfigService.getProperty(AMAZON_ACCESS_KEY_ID);
        String awsAccessKeySecret = siteConfigService.getProperty(AMAZON_ACCESS_KEY_SECRET);

        AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsAccessKeySecret);
        s3client = new AmazonS3Client(credentials);
    }
}

