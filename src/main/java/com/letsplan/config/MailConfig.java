package com.letsplan.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("letsplanMiage@gmail.com");
        mailSender.setPassword("miage2020");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return mailSender;
    	
//        MailjetClient client;
//        MailjetRequest request;
//        MailjetResponse response;
//        client = new MailjetClient(System.getenv("0764aa6cdca1fde7faa45248bfd420af"), System.getenv("a44e4993b1de0b119f8b271316a00e7e"), new ClientOptions("v3.1"));
//        request = new MailjetRequest(Emailv31.resource)
//        .property(Emailv31.MESSAGES, new JSONArray()
//        .put(new JSONObject()
//        .put(Emailv31.Message.FROM, new JSONObject()
//        .put("Email", "le.minhtri230999@gmail.com")
//        .put("Name", "Lets"))
//        .put(Emailv31.Message.TO, new JSONArray()
//        .put(new JSONObject()
//        .put("Email", "le.minhtri230999@gmail.com")
//        .put("Name", "Lets")))
//        .put(Emailv31.Message.SUBJECT, "Greetings from Mailjet.")
//        .put(Emailv31.Message.TEXTPART, "My first Mailjet email")
//        .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
//        .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
//        try {
//			response = client.post(request);
//			System.out.println(response.getStatus());
//			System.out.println(response.getData());
//		} catch (MailjetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MailjetSocketTimeoutException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
	
}
