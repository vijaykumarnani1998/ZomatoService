package com.zomato.restaurant.serviceimpl;

import com.zomato.exception.ResourceNotFoundException;
import com.zomato.restaurant.dto.RestaurantDto;
import com.zomato.restaurant.entity.RestaurantEntity;
import com.zomato.restaurant.repository.RestaurantRepository;
import com.zomato.restaurant.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauarantServiceImpl implements RestaurantService {


    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RestaurantEntity createRestaurant(RestaurantDto dto) {
        RestaurantEntity entity = modelMapper.map(dto, RestaurantEntity.class);
       return repository.save(entity);
    }

    @Override
    public List<RestaurantEntity> getRestaurantsByCity(String city) {
        return repository.findByAddress_City(city);
    }

    @Override
    public List<RestaurantEntity> getRestaurantsByCuisine(String cuisine) {
        return repository.findByCuisine(cuisine);
    }

    @Override
    public List<RestaurantEntity> getOpenRestaurants() {
        return repository.findByOpenTrue();
    }

    @Override
    public RestaurantEntity updateRestaurantStatus(Long id, boolean flag) {
        RestaurantEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        entity.setOpen(flag);
        return repository.save(entity);
    }

    @Override
    public RestaurantEntity getRestaurantById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

    }

    @Override
    public List<RestaurantEntity> getAllRestaurants() {
        return repository.findAll();
    }

    @Override
    public String deleteRestaurant(Long id) {
        RestaurantEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
   repository.deleteById(entity.getRestaurantId());
   return "Restaurant with id "+ id + "deleted successfully";
    }

    @Override
    public RestaurantEntity updateRestaurant(Long id, RestaurantDto dto) {
        RestaurantEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        modelMapper.map(dto,entity);
        return  repository.save(entity);
    }
}
