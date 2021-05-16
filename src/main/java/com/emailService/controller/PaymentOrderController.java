package com.emailService.controller;

import com.emailService.domain.EmailDTO;
import com.emailService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/paymentorder")
public class PaymentOrderController {

    private final EmailService emailService;

    public PaymentOrderController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity sendPaymentOrder(HttpServletRequest request, @RequestBody EmailDTO emailDTO) {
        try {
            String transactionId = emailService.sendOrderByEmail(emailDTO.getPaymentOrder(), emailDTO.getSendTo());
            return ResponseEntity.ok().body("Email sending submitted. Please check status here: " +
                    "http://" + request.getServerName() + ":" + request.getServerPort() + "/transaction/" + transactionId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
