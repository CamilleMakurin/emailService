package com.emailService.transaction;

import com.emailService.domain.PaymentOrder;
import com.emailService.transaction.domain.EmailSendingTransaction;
import com.emailService.transaction.domain.TransactionStatus;
import com.emailService.transaction.repository.EmailSendingTransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailSendingTransactionServiceImpl implements EmailSendingTransactionService {

    private ObjectMapper mapper;
    private EmailSendingTransactionRepository repository;

    public EmailSendingTransactionServiceImpl(ObjectMapper mapper, EmailSendingTransactionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public EmailSendingTransaction startTransaction(PaymentOrder paymentOrder, List<String> to) throws JsonProcessingException {
        EmailSendingTransaction transaction = new EmailSendingTransaction();
        transaction.setPayload(mapper.writeValueAsString(paymentOrder));
        transaction.setSendTo(String.join(",", to));
        transaction.setStatus(TransactionStatus.IN_PROGRESS);
        repository.save(transaction);
        return transaction;
    }

    public void completeTransaction(EmailSendingTransaction transaction) {
        repository.save(transaction);
    }


    @Override
    public Optional<EmailSendingTransaction> getTransaction(String transactionId) {
        return repository.findById(transactionId);
    }

}
