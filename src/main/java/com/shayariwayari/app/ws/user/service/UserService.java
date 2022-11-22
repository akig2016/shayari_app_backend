package com.shayariwayari.app.ws.user.service;

import com.shayariwayari.app.ws.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUserByEmail(String email);
    UserDto getUserById(String id);
    UserDto updateUserDetails(String id, UserDto userUpdatedData);
    void deleteUserDetails(String id);
    List<UserDto> getUsers(int page, int limit);
}
