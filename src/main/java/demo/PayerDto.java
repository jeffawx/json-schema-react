package demo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * DTO to serialize/deserialize payer details as part of Platform API.
 * <p>
 * Created by Sergey on 2/6/2017.
 */
public class PayerDto {
    @NotNull
    public String entityType;
    public String companyName;
    public String firstName;
    public String lastName;
    public String dateOfBirth;
    @NotNull
    @Valid
    public PayerAddressDto address;
    public PayerAdditionalInfoDto additionalInfo;
}
