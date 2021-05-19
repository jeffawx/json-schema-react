package demo;

import javax.validation.constraints.NotNull;

/**
 * Created by Ki-Lok on 3/3/2017.
 */
public class BankDetailsDto {
    public String bankName;
    @NotNull
    public String bankCountryCode;
    public String bankStreetAddress;
    public String swiftCode;
    public String iban;
    public String accountName;
    public String accountNumber;
    @NotNull
    public String accountCurrency;
    public String accountRoutingType1;
    public String accountRoutingValue1;
    public String accountRoutingType2;
    public String accountRoutingValue2;
    public String bindingMobileNumber;
    public String bankBranch;
    public String localClearingSystem;
}
