package com.emailService.service;

import com.emailService.domain.PaymentOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface EmailService {

    String sendOrderByEmail(PaymentOrder paymentOrder, List<String> to) throws Exception;
}
