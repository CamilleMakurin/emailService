package com.emailService.mapping;

import java.util.function.Function;

public enum PersonAttribute {

    NAME("name", "companyName"),
    ID("personalIdNumber", "registrationNumber"),
    BANK_ACCOUNT("accountNumber", "accountNumber"),
    BENEFICIARY_BANK("beneficiaryBank", "beneficiaryBank"),
    BANK_CODE("bankCode", "bankCode"),
    RESIDENCE_COUNTRY("residenceCountry", "residenceCountry");

    private String physicalPersonAttribute;
    private String juridicalPersonAttribute;

    PersonAttribute(String physicalPersonAttribute, String juridicalPersonAttribute) {
        this.physicalPersonAttribute = physicalPersonAttribute;
        this.juridicalPersonAttribute = juridicalPersonAttribute;
    }

    public String getPhysicalPersonAttribute() {
        return physicalPersonAttribute;
    }

    public String getJuridicalPersonAttribute() {
        return juridicalPersonAttribute;
    }

    public String getAttributeByType(PersonType type) {
        return type == PersonType.PHYSICAL_PERSON ? getPhysicalPersonAttribute() : getJuridicalPersonAttribute();
    }
}
