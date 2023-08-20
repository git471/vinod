package com.example.demo.email;

// Java program to send email

import com.example.demo.entity.Employee;
import com.example.demo.entity.Tasks;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;


public class SendEmail
{

    public SendEmail(Employee employee, Tasks tasks)
    {
        // email ID of Recipient.
        String recipient = employee.getEmail();

        // email ID of Sender.
        String sender = "sender@gmail.com";

        // using host as localhost
        String host = "127.0.0.1";

        // Getting system properties
        Properties properties = System.getProperties();

        // Setting up mail server
        properties.setProperty("mail.smtp.host", host);

        // creating session object to get properties
        Session session = Session.getDefaultInstance(properties);

        try
        {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject("Task Assigned");

            // set body of the email.
            message.setText("The Task with id "+tasks.getId()+ "is assigned for you at "+new Date(System.currentTimeMillis()));

            // Send email.
            Transport.send(message);
            System.out.println("Mail successfully sent");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}

