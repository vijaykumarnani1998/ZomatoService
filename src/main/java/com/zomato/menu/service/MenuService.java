package com.zomato.menu.service;

import com.zomato.menu.dto.MenuDto;
import com.zomato.menu.entity.MenuEntity;

import java.util.List;

public interface MenuService {

    MenuEntity addMenuItem(MenuDto dto);

    List<MenuEntity> getMenuByRestaurant(Long restaurantId);

    List<MenuEntity> getVegItems();

    List<MenuEntity> getAvailableItems();
}
