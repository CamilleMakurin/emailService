package com.emailService.service;

import com.emailService.domain.PaymentOrder;
import com.emailService.transaction.EmailSendingTransactionService;
import com.emailService.transaction.domain.EmailSendingTransaction;
import com.emailService.transaction.domain.TransactionStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;


@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailSendingTransactionService transactionService;

    public EmailServiceImpl(JavaMailSender javaMailSender, EmailSendingTransactionService transactionService) {
        this.javaMailSender = javaMailSender;
        this.transactionService = transactionService;
    }

    @Override
    public String sendOrderByEmail(PaymentOrder paymentOrder, List<String> to) throws Exception {
        EmailSendingTransaction transaction = transactionService.startTransaction(paymentOrder, to);
        try {
            log.info("Sending emails to: " + String.join(",", to));
            sendEmail(paymentOrder, to);
            transaction.setStatus(TransactionStatus.COMPLETED);
            log.info("Email successfully sent");
            return transaction.getId();
        } catch (Exception e) {
            log.error("Failed to send email with error:", e);
            transaction.setStatus(TransactionStatus.COMPLETED_WITH_ERROR);
            transaction.setErrorMessage(e.getMessage());
            return transaction.getId();
        } finally {
            transactionService.completeTransaction(transaction);
        }
    }

    private void sendEmail(PaymentOrder paymentOrder, List<String> to) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(to.toArray(new String[0]));
        helper.setSubject("Payment Order");
        helper.setText(paymentOrder.toString(), true);
        javaMailSender.send(msg);
    }
}
