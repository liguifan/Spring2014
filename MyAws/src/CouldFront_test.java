
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AWSJavaMailTransport;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesResult;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.*;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.sns.model.CreateTopicRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jets3t.service.CloudFrontService;



public class CouldFront_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AWSCredentials credentials = new ClasspathPropertiesFileCredentialsProvider().getCredentials();
		
		CloudFrontService cloudFrontService = new CloudFrontService(credentials);
		List the distributions applied to a given S3 bucket

		Distribution[] bucketDistributions = cloudFrontService.listDistributions("jets3t");
		for (int i = 0; i < bucketDistributions.length; i++) {
		    System.out.println("Bucket distribution " + (i + 1) + ": " + bucketDistributions[i]);
		}
		Create a new public distribution

		String originBucket = "jets3t.s3.amazonaws.com";
		Distribution newDistribution = cloudFrontService.createDistribution(
		    new S3Origin(originBucket),
		    "" + System.currentTimeMillis(), // Caller reference - a unique string value
		    new String[] {"test1.jamesmurty.com"}, // CNAME aliases for distribution
		    "Testing", // Comment
		    true,  // Distribution is enabled?
		    null  // Logging status of distribution (null means disabled)
		    );
		System.out.println("New Distribution: " + newDistribution);
	}

}
