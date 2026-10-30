package com.ecom.users.service.impl;

import com.ecom.users.dto.request.AddressRequest;
import com.ecom.users.dto.request.RegisterUserRequest;
import com.ecom.users.dto.response.AddressResponse;
import com.ecom.users.dto.response.UserResponse;
import com.ecom.users.entity.Address;
import com.ecom.users.entity.User;
import com.ecom.users.enums.Role;
import com.ecom.users.enums.Status;
import com.ecom.users.exception.custom.EmailAlreadyExistsException;
import com.ecom.users.repository.UserRepository;
import com.ecom.users.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder){
        this.userRepository =  userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserResponse registerUser(RegisterUserRequest registerUserRequest) {

        if(userRepository.findByEmail(registerUserRequest.email()).stream().findFirst().isPresent()){
            throw new EmailAlreadyExistsException(registerUserRequest.email());
        }

        return toUserResponse(userRepository.save(toUserEntity(registerUserRequest)));
    }

    @Override
    public List<UserResponse> fetchCustomers() {
        return userRepository.findByRole(Role.CUSTOMER).stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }

    public User toUserEntity(RegisterUserRequest userRequest){
        User user= new User();
        user.setEmail(userRequest.email());
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.CUSTOMER);
        user.setPasswordHash(this.bCryptPasswordEncoder.encode(userRequest.password()));
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setAddress(toAddressEntity(userRequest.address()));
        return user;
    }

    public Address toAddressEntity(AddressRequest addressRequest){
        Address address = new Address();
        address.setRecipientName(addressRequest.recipientName());
        address.setLine1(addressRequest.line1());
        address.setLine2(addressRequest.line2());
        address.setCity(addressRequest.city());
        address.setStateOrProvince(addressRequest.stateOrProvince());
        address.setCountry(addressRequest.country());
        address.setPostalCode(addressRequest.postalCode());

        return address;
    }

    public UserResponse toUserResponse(User userEntity){

        return new UserResponse(userEntity.getId(),userEntity.getEmail(),userEntity.getFirstName(),
                userEntity.getLastName(),userEntity.getPhoneNumber(),userEntity.getRole(),userEntity.getStatus(),
                userEntity.getCreatedAt(),userEntity.getUpdatedAt(),toAddressResponse(userEntity.getAddress()));

    }

    public AddressResponse toAddressResponse(Address addressEntity){
        return new AddressResponse(addressEntity.getId(),addressEntity.getRecipientName(),
                addressEntity.getLine1(),addressEntity.getLine2(),addressEntity.getCity(),
                addressEntity.getStateOrProvince(),addressEntity.getPostalCode(),addressEntity.getCountry(),
                addressEntity.getCreatedAt(),addressEntity.getUpdatedAt());
    }
}
