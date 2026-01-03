package com.zomato.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long menuId;
    private String itemName;
    private double price;
    private boolean veg;
    private boolean available;
}
