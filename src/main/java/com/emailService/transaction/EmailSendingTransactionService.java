package com.emailService.transaction;

import com.emailService.domain.PaymentOrder;
import com.emailService.transaction.domain.EmailSendingTransaction;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface EmailSendingTransactionService {

    EmailSendingTransaction  startTransaction(PaymentOrder paymentOrder, List<String> to) throws JsonProcessingException;

    void completeTransaction(EmailSendingTransaction transaction);

    Optional<EmailSendingTransaction> getTransaction(String transactionId);

}

