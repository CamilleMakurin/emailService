package com.emailService.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PaymentOrderTest {


    @Test
    void name() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String s = "{\n" +
                "    \n" +
                "    \"customerNumber\": \"customerNumber\",\n" +
                "    \"date\": \"12 03 2021\",\n" +
                "    \"remitter\": {\n" +
                "      \"name\": \"remitterName\",\n" +
                "      \"personalIdNumber\": \"remitterId\",\n" +
                "      \"accountNumber\": \"remitterAccountNumber\"\n" +
                "    },\n" +
                "    \"beneficiary\": {\n" +
                "      \"companyName\": \"beneficiaryName\",\n" +
                "      \"registrationNumber\": \"beneficiaryId\",\n" +
                "      \"accountNumber\": \"beneficiaryAccountNumber\",\n" +
                "      \"bankCode\": \"beneficiaryBankCode\",\n" +
                "      \"beneficiaryBank\": \"beneficiaryBank\",\n" +
                "      \"residenceCountry\": \"beneficiaryResidenceCountry\"\n" +
                "    },\n" +
                "    \"paymentInformation\": {\n" +
                "      \"amountInFigures\": 22.12,\n" +
                "      \"amountInWords\": \"twenty two euro twelve cents\",\n" +
                "      \"currency\": \"EURO\",\n" +
                "      \"bankFee\": 1.14,\n" +
                "      \"valueDate\": \"12 03 2021\",\n" +
                "      \"paymentType\": \"somePaymentType\",\n" +
                "      \"paymentDetails\": \"testPaymentDetails\",\n" +
                "      \"exchangeRate\": 0.89,\n" +
                "      \"codeOfExternalPayment\": \"testCodeOfExternalPayment\"\n" +
                "    }\n" +
                "  }";



        PaymentOrder order1 = mapper.readValue(s, PaymentOrder.class);
        System.out.println(order1);
    }
}