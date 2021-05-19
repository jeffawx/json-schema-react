package demo;

import javax.validation.constraints.NotNull;

/**
 * Created by Ki-Lok on 3/19/2017.
 */
public class PayerAddressDto {
    public String streetAddress;
    @NotNull
    public String countryCode;
    public String postcode;
    public String state;
    public String city;
    public String fullAddress;
}
