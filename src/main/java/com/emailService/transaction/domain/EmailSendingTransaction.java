package com.emailService.transaction.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TRANSACTION")
public class EmailSendingTransaction {


    @Id
    @GenericGenerator(name = "ID", strategy = "com.emailService.transaction.repository.UUIDGenerator")
    @GeneratedValue(generator = "ID")
    String id;
    @Enumerated(EnumType.STRING)
    TransactionStatus status;
    @Lob
    String payload;
    String sendTo;
    String errorMessage;

}
