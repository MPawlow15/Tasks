package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MimeMessage {

    private final JavaMailSender javaMailSender;
    @Autowired
    private MailCreatorService mailCreatorService;

    public void send (final Mail mail) {
        log.info("Preparing to send an email");
        try {
            javaMailSender.send(createMimeMessage(mail));
            log.info("Email successfully sent.");
        } catch (MailException e) {
            log.error("Failed to process email sending: " + e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMessage(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail.getReceiverEmail());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMessage());
        Optional.ofNullable(mail.getToCc()).ifPresent(simpleMailMessage::setCc);
        return simpleMailMessage;
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getReceiverEmail());
            messageHelper.setSubject(mail.getSubject());
            if (mail.getSubject().contains("Trello")) {
                messageHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()), true);
            }
            if (mail.getSubject().contains("Once")) {
                messageHelper.setText(mailCreatorService.buildDailyTaskCountEmail(mail.getMessage()), true);
            }
        };
    }

}