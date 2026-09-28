package com.hotel.roomify.service.interfac;

import com.hotel.roomify.dto.LoginRequest;
import com.hotel.roomify.dto.Response;
import com.hotel.roomify.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
