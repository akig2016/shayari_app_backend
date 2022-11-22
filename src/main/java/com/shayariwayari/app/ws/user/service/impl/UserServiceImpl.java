package com.shayariwayari.app.ws.user.service.impl;

import com.shayariwayari.app.ws.exception.UserServiceException;
import com.shayariwayari.app.ws.user.io.document.UserDocumentModel;
import com.shayariwayari.app.ws.user.io.repositories.UserAuthenticationRepository;
import com.shayariwayari.app.ws.user.service.UserService;
import com.shayariwayari.app.ws.user.dto.UserDto;
import com.shayariwayari.app.ws.user.ui.model.response.ErrorMessagesEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserAuthenticationRepository userAuthenticationRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto createUser(UserDto user) {
        UserDocumentModel userDocumentModel = new UserDocumentModel();
        BeanUtils.copyProperties(user,userDocumentModel);
        userDocumentModel.setEncryptedPassword(bCryptPasswordEncoder.encode((user.getPassword())));
        UserDocumentModel savedUserDetails = userAuthenticationRepository.save(userDocumentModel);
        UserDto returnUserDto = new UserDto();
        BeanUtils.copyProperties(savedUserDetails,returnUserDto);
        return returnUserDto;
    }
    //Interface Implementation for Login. Spring will call it automatically while authentication.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDocumentModel user = userAuthenticationRepository.findByEmail(email);
        System.out.println("Repo Check ----------------------"+user.toString() );
        if(user ==null) throw new UsernameNotFoundException(email);
        return new User(user.getEmail(), user.getEncryptedPassword(),new ArrayList<>());
    }
    @Override
    public UserDto getUserByEmail(String email) {
        UserDocumentModel userDocumentModel = userAuthenticationRepository.findByEmail(email);
        if(userDocumentModel ==null) throw new UsernameNotFoundException(email);
        UserDto returnUserDto = new UserDto();
        BeanUtils.copyProperties(userDocumentModel,returnUserDto);
        return returnUserDto;
    }

    @Override
    public UserDto getUserById(String id) {
        Optional<UserDocumentModel> userData =  userAuthenticationRepository.findById(id);
        if(!userData.isPresent())throw new UsernameNotFoundException("user with ID: "+id + " not found.");
        UserDto returnUserDto = new UserDto();
        BeanUtils.copyProperties(userData.get(),returnUserDto);
        return returnUserDto;
    }

    @Override
    public UserDto updateUserDetails(String id, UserDto userUpdatedData) {
        Optional<UserDocumentModel> user =  userAuthenticationRepository.findById(id);
        if(!user.isPresent())throw new UserServiceException(ErrorMessagesEnum.NO_RECORD_FOUND.getErrorMessage());
        UserDto returnValue = new UserDto();
        UserDocumentModel userData = user.get();
        userData.setFirstName(userUpdatedData.getFirstName());
        userData.setLastName(userUpdatedData.getLastName());
        UserDocumentModel savedUser = userAuthenticationRepository.save(userData);
        BeanUtils.copyProperties(savedUser,returnValue);
        return returnValue;
    }
    @Override
    public void deleteUserDetails(String id) {
        Optional<UserDocumentModel> user =  userAuthenticationRepository.findById(id);
        if(!user.isPresent())throw new UserServiceException(ErrorMessagesEnum.NO_RECORD_FOUND.getErrorMessage());
        userAuthenticationRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {
        List<UserDto> returnValue = new ArrayList<>();
        Pageable paging = PageRequest.of(page, limit);
        Page<UserDocumentModel> userPage =  userAuthenticationRepository.findAll(paging);

        List<UserDocumentModel> users = userPage.getContent();
        for (UserDocumentModel userDocumentModel:users){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userDocumentModel,userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }

}
