package com.emailService.domain;

import com.emailService.mapping.BeneficiaryDeserializer;
import com.emailService.mapping.LocalDateDeserializer;
import com.emailService.mapping.RemitterDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PaymentOrder {

    @JsonProperty("customerNumber")
    private String customerNumber;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty("remitter")
    @JsonDeserialize(using = RemitterDeserializer.class)
    private Remitter remitter;

    @JsonProperty("beneficiary")
    @JsonDeserialize(using = BeneficiaryDeserializer.class)
    private Beneficiary beneficiary;

    @JsonProperty("paymentInformation")
    private PaymentInformation paymentInformation;

    @Override
    public String toString() {
        return String.format("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>EmailTemplate</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1>Payment Order</h1>\n" +
                        "    <p>%s</p>\n" +
                        "    <h2>Remitter</h2>\n" +
                        "    %s\n" +
                        "    <h2>Beneficiary</h2>\n" +
                        "    %s\n" +
                        "    <h2>Payment Information</h2>\n" +
                        "    %s\n" +
                        "</body>\n" +
                        "</html>\n",
                "customerNumber" + customerNumber,
                remitter,
                beneficiary,
                paymentInformation
        );
    }
}
