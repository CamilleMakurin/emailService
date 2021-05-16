package com.emailService.domain;

import com.emailService.mapping.BeneficiaryDeserializer;
import com.emailService.mapping.RemitterDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailDTO {

   List<String> sendTo;
   PaymentOrder paymentOrder;
}
