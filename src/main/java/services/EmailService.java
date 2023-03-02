package services;

import com.codeup.springblog.Controllers.Model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailService {
    @Autowired
    public JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    private String from;

    @Value("${CUSTOM_KEY")
    private String customKey;

    public void preparedAndSendAd(Ad ad) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(ad.getUser().getEmail());
        message.setSubject("Ad created");
        message.setText(String.format("Title of ad: '%s'%n Description of Ad: '%s'", ad.getTitle(), ad.getDescription()));
        try {
            this.javaMailSender.send(message);
        } catch(MailException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
