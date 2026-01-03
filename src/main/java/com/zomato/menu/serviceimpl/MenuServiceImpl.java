package com.zomato.menu.serviceimpl;

import com.zomato.menu.dto.MenuDto;
import com.zomato.menu.entity.MenuEntity;
import com.zomato.menu.repository.MenuRepository;
import com.zomato.menu.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl  implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MenuEntity addMenuItem(MenuDto dto) {
        MenuEntity entity = modelMapper.map(dto, MenuEntity.class);
      return   menuRepository.save(entity);

    }

    @Override
    public List<MenuEntity> getMenuByRestaurant(Long restaurantId) {
      return   menuRepository.findByRestaurant_RestaurantId(restaurantId);
    }

    @Override
    public List<MenuEntity> getVegItems() {
        return null;
    }

    @Override
    public List<MenuEntity> getAvailableItems() {
        return null;
    }
}
