package com.emailService.mapping;

import com.emailService.domain.Remitter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class RemitterDeserializer extends StdDeserializer<Remitter> {

    public RemitterDeserializer() {
        this(null);
    }

    public RemitterDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Remitter deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        return Remitter.builder().
                name(getNodeValue(PersonAttribute.NAME, node)).
                id(getNodeValue(PersonAttribute.ID, node)).
                bankAccount(getNodeValue(PersonAttribute.BANK_ACCOUNT, node)).
                type(getType(PersonAttribute.NAME, node)).
                build();
    }

    private PersonType getType(PersonAttribute attribute, JsonNode node) {
        JsonNode attributeNode = node.get(attribute.getJuridicalPersonAttribute());
        return attributeNode == null ? PersonType.PHYSICAL_PERSON : PersonType.JURIDICAL_PERSON;
    }

    private String getNodeValue(PersonAttribute attribute, JsonNode node) {
        JsonNode attributeNode = node.get(attribute.getPhysicalPersonAttribute());
        return attributeNode == null ? null : attributeNode.asText();
    }

}
