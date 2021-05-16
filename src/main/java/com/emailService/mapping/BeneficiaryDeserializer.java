package com.emailService.mapping;

import com.emailService.domain.Beneficiary;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class BeneficiaryDeserializer extends StdDeserializer<Beneficiary> {

    public BeneficiaryDeserializer() {
        this(null);
    }

    public BeneficiaryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Beneficiary deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        return Beneficiary.builder().
                name(getNodeValue(PersonAttribute.NAME, node)).
                id(getNodeValue(PersonAttribute.ID, node)).
                bankCode(getNodeValue(PersonAttribute.BANK_CODE, node)).
                beneficiaryBank(getNodeValue(PersonAttribute.BENEFICIARY_BANK, node)).
                bankAccount(getNodeValue(PersonAttribute.BANK_ACCOUNT, node)).
                residenceCountry(getNodeValue(PersonAttribute.RESIDENCE_COUNTRY, node)).
                type(getType(PersonAttribute.NAME, node)).
                build();
    }

    private String getNodeValue(PersonAttribute att, JsonNode node) {
        JsonNode attributeNode = node.get(att.getJuridicalPersonAttribute());
        return attributeNode == null ? null : attributeNode.asText();
    }

    private PersonType getType(PersonAttribute attribute, JsonNode node) {
        JsonNode attributeNode = node.get(attribute.getJuridicalPersonAttribute());
        return attributeNode == null ? PersonType.PHYSICAL_PERSON : PersonType.JURIDICAL_PERSON;
    }

}
