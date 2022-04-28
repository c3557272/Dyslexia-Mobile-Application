package com.example.dyslexialearningapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
This class is solely responsible for the reporting system in this product. This will directly email a designated email address for bugs.
 */

public class reportPage extends AppCompatActivity {

    private EditText EditTextTo,EditTextSubject,EditTextMessage;

    /*
    This onCreate override method sets the correct content layout and assigns the EditText components to their layout counterparts.
    The onClickListener for the send button is also defined here
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);

        EditTextTo = findViewById(R.id.edit_text_to);
        EditTextMessage = findViewById(R.id.edit_text_message);
        EditTextTo.setText("learn4fun_bugs@outlook.com");
        Button buttonSend = findViewById(R.id.button_send);

        /*
        This override for the onClick method sets the appropriate mail items to true and directs the message to the correct location using pre-set variables.
        A try and catch is used to gather the information inputted and send it to the correct email location.
        This code was adapted from the website: https://programmerworld.co/android/how-to-send-email-using-gmail-smtp-server-directly-from-your-android-app/
        Credit for the code goes to owner of the code posted here, the code was adapted to fit the intentions of this activity.
         */

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = "learn4fun_bugs@outlook.com";
                final String password = "Apples12345";
                String messageToSend = EditTextMessage.getText().toString();

                //Creates the properties variable
                Properties props = new Properties();

                //Sets up the server's properties
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", true);
                props.put("mail.smtp.host", "smtp.outlook.com");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props, new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(EditTextTo.getText().toString()));
                    message.setSubject("New issue found from user.");
                    message.setText(messageToSend);
                    Transport.send(message);
                    Toast.makeText(getApplicationContext(), "Email sent successfully!", Toast.LENGTH_LONG).show();
                }
                catch(MessagingException e)
                {
                    throw new RuntimeException(e);
                }

            }
        });
        ThreadPolicy policy = new ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}