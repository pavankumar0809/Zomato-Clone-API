package com.example.zomato.mapping;

import com.example.zomato.entity.Address;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.responsedtos.AddressRespone;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address mapToAddress(AddressRequest addressRequest, Address address) {
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setLandmark(addressRequest.getLandmark());
        address.setArea(addressRequest.getArea());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setPincode(addressRequest.getPincode());
        address.setLatitude(addressRequest.getLatitude());
        address.setLongitude(addressRequest.getLongitude());
        return address;
    }

    public AddressRespone mapToAddressResponse(Address address) {
        AddressRespone addressRespone = new AddressRespone();
        addressRespone.setAddress_id(address.getAddress_id());
        addressRespone.setAddressLine1(address.getAddressLine1());
        addressRespone.setAddressLine2(address.getAddressLine2());
        addressRespone.setLandmark(address.getLandmark());
        addressRespone.setArea(address.getArea());
        addressRespone.setCity(address.getCity());
        addressRespone.setState(address.getState());
        addressRespone.setPincode(address.getPincode());
        addressRespone.setLatitude(address.getLatitude());
        addressRespone.setLongitude(address.getLongitude());
        return addressRespone;
    }
}
