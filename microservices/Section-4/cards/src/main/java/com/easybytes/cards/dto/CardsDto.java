package com.easybytes.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CardsDto {
    private String mobileNumber;

    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "CardNumber must be 12 digits")

    private String cardNumber;

    @NotEmpty(message = "CardType can not be a null or empty")

    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")

    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")

    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;
}
