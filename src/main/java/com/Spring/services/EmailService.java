package com.Spring.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {
    public String sendTextEmail(String email, String user) throws IOException {
        // the sender email should be the same as we used to Create a Single Sender Verification
        Email from = new Email("miguelberrioh@hotmail.com");
        String subject = "The subject";
        Email to = new Email(email);
        Content content = new Content("text/plain", "Bienvenido a nuestra aplicacion " + user + ".\nMabMab^^ - Miguel Berrio");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            return response.getBody();
        } catch (IOException ex) {
            throw ex;
        }
    }
}
