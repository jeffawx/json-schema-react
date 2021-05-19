package demo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Payment create/update request DTO.
 */
public class PaymentRequestDto {
    @NotNull
    public String requestId;
    @NotNull
    public String paymentCurrency;
    public String paymentAmount;
    public String sourceAmount;
    public String feePaidBy;
    public String paymentDate;
    @NotNull
    public String reason;
    @NotNull
    public String reference;
    @Valid
    public PayerDto payer;
    public String payerId;
    @Valid
    public BeneficiaryDto beneficiary;
    public String beneficiaryId;
    @NotNull
    public String paymentMethod;
    public String swiftChargeOption;
    public String sourceCurrency;
    public String clientData;
    public String requestSource;
    public PaymentAdditionalInfoDto additionalInfo;

    /**
     * No formatting, validation rules should check if they are all numbers and let them pass
     */
    public static class PaymentAdditionalInfoDto {
        public List<OrderInfoType1> orderInfoType1 = new LinkedList<>();

        public static class OrderInfoType1 {
            public String mchOrderId;
            public String mchPurchaserId;
            public String orderDatetime;
            public String description;
            public List<Item> items = new LinkedList<>();
            public List<Shipment> shipments = new LinkedList<>();
            public String currency;
        }

        public static class Item {
            public String sku;
            public String category;
            public String name;
            public BigDecimal quantity;
            public BigDecimal unitPrice;
            public BigDecimal lineTotal;
            public String itemUrl;
        }

        public static class Shipment {
            public String provider;
            public String trackingNumber;
        }
    }
}
