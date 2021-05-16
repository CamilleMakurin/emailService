package com.emailService.controller;

import com.emailService.transaction.EmailSendingTransactionService;
import com.emailService.transaction.domain.EmailSendingTransaction;
import com.emailService.transaction.domain.TransactionStatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final EmailSendingTransactionService transactionService;

    public TransactionController(EmailSendingTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionStatusResponse> sendPaymentOrder(@PathVariable String transactionId) {
        Optional<EmailSendingTransaction> transaction = transactionService.getTransaction(transactionId);
        return transaction.isPresent() ? ResponseEntity.ok(toResponse(transaction.get())) : ResponseEntity.notFound().build();
    }

    private TransactionStatusResponse toResponse(EmailSendingTransaction transaction) {
        return TransactionStatusResponse.builder().
                status(transaction.getStatus().name()).
                errorMessage(transaction.getErrorMessage()).build();
    }
}
