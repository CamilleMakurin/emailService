package com.emailService.transaction.repository;

import com.emailService.transaction.domain.EmailSendingTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSendingTransactionRepository extends CrudRepository<EmailSendingTransaction, String> {
}
