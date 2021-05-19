package demo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * DTO to serialize/deserialize beneficiary details as part of Platform API.
 */
public class BeneficiaryDto {
    @NotNull
    public String entityType;
    public String companyName;
    public String firstName;
    public String lastName;
    public String dateOfBirth;
    @NotNull
    @Valid
    public BeneficiaryAddressDto address;
    @NotNull
    @Valid
    public BankDetailsDto bankDetails;
    public BeneficiaryAdditionalInfoDto additionalInfo;
}
