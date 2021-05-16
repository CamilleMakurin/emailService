package com.emailService.domain;

import com.emailService.mapping.LocalDateDeserializer;
import com.emailService.mapping.PersonAttribute;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInformation {

    private Double amountInFigures;
    private String amountInWords;
    private String currency;
    private Double bankFee;
    private String paymentType;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate valueDate;
    private String paymentDetails;
    private Double exchangeRate;
    private String codeOfExternalPayment;


    @Override
    public String toString() {
        return String.format("<table>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "    </table>",
                "amountInFigures", amountInFigures,
                "amountInWords", amountInWords,
                "currency", currency,
                "bankFee", bankFee,
                "paymentType", paymentType,
                "paymentDetails", paymentDetails,
                "exchangeRate", exchangeRate,
                "codeOfExternalPayment", codeOfExternalPayment);
    }
}
