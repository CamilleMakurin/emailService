package com.emailService.domain;


import com.emailService.mapping.PersonAttribute;
import com.emailService.mapping.PersonType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Beneficiary {

    private String name;
    private String id;
    private String bankAccount;
    private String bankCode;
    private String beneficiaryBank;
    private String residenceCountry;
    private PersonType type;

    @Override
    public String toString() {
        return String.format("<table>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "        <tr><td>%s</td><td>%s</td></tr>\n" +
                        "    </table>",
                PersonAttribute.NAME.getAttributeByType(type), name,
                PersonAttribute.ID.getAttributeByType(type), id,
                PersonAttribute.BANK_ACCOUNT.getAttributeByType(type), bankAccount,
                PersonAttribute.BANK_CODE.getAttributeByType(type), bankCode,
                PersonAttribute.BENEFICIARY_BANK.getAttributeByType(type), beneficiaryBank,
                PersonAttribute.RESIDENCE_COUNTRY.getAttributeByType(type), residenceCountry);
    }
}
