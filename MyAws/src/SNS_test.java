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

public class SNS_test {
	
	public static void main(String[] args) throws IOException {
		String topic_name="new_topic";

		AWSCredentials credentials = new ClasspathPropertiesFileCredentialsProvider().getCredentials();
		AmazonSNSClient sns=new AmazonSNSClient(credentials);
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		sns.setRegion(usWest2);
		
		String arn="arn:aws:sns:us-west-2:921064293900:new_topic";
	
	}
	
	
	   public static void create_topic(AmazonSNSClient sns, String arn, String topic_name){
		   CreateTopicRequest name=new CreateTopicRequest(topic_name);
		   sns.createTopic(name).withTopicArn("arn:aws:sns:us-west-2:921064293900:test");
	   }
	   
	   public static void subscribe_users(AmazonSNSClient sns, String arn, String protocal){
		   	ArrayList<String> emails=new ArrayList<String>();
			emails.add("liguifan@gmail.com");
			emails.add("sy2518@columbia.edu");
			emails.add("qianchao0325@gmail.com");
			emails.add("yrcbsg@gmail.com");
			
		   	for(String e:emails){
				sns.subscribe(arn, "email", e);
			}
			System.out.println("Subscribe confirmation sent");
	   }
	   
	   public static void publish_all(AmazonSNSClient sns,String arn, String context, String subject){
		   	sns.publish(arn,context,subject);
			System.out.println("Finish publishing");
	   }

}
