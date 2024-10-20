package com.example.zomato.service;

import com.example.zomato.entity.Address;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.AddressCannotAddedException;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapping.AddressMapper;
import com.example.zomato.mapping.RestaurantMapper;
import com.example.zomato.repository.AddressRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.responsedtos.AddressRespone;
import com.example.zomato.util.AppResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final RestaurantRepository restaurantRepository;

    public AddressRespone addAddress(String restaurantId,AddressRequest addressRequest) {
        Optional<Restaurant> optional= restaurantRepository.findById(restaurantId);
        if (optional.isPresent()) {
            Restaurant restaurant= optional.get();
            if (restaurant.getAddress()==null){
                Address address =addressRepository.save(addressMapper.mapToAddress(addressRequest, new Address()));
                restaurant.setAddress(address);
                restaurantRepository.save(restaurant);
                return addressMapper.mapToAddressResponse(address);
            }
            throw new AddressCannotAddedException("Failed to add address");
        }
        throw  new RestaurantNotFoundByIdException("Failed to add address");
    }
}
