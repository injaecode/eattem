package com.mysite.eattem.Myeattem;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EattemSearchDto {
    private String searchDateType;

    private SellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";

}
