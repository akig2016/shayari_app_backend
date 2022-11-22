package com.shayariwayari.app.ws.user.ui.controller;

import com.shayariwayari.app.ws.exception.UserServiceException;
import com.shayariwayari.app.ws.user.ui.model.request.UserDetailsRequestModel;
import com.shayariwayari.app.ws.user.ui.model.response.*;
import com.shayariwayari.app.ws.user.service.UserService;
import com.shayariwayari.app.ws.user.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/status/check")
	public String status() {
		return "working";
	}

	@GetMapping("/{id}")
	public UserRest getUser(@PathVariable String id) {
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(userService.getUserById(id),returnValue);
		return returnValue;
	}

	@GetMapping("/all")
	public List<UserRest> getUsers(@RequestParam(value="page", defaultValue = "0") int page,
								   @RequestParam(value="limit", defaultValue = "25") int limit){
		List<UserDto> users = userService.getUsers(page,limit);
		List<UserRest> returnValue = new ArrayList<>();
		for(UserDto userDto:users){
			UserRest userRest = new UserRest();
			BeanUtils.copyProperties(userDto,userRest);
			returnValue.add(userRest);
		}
		return returnValue;
	}
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
		if(userDetails.getFirstName().isEmpty())throw new UserServiceException(ErrorMessagesEnum.MISSING_REQUIRED_FIELD.getErrorMessage()); // can use general Exception class too.
		if(userDetails.getEmail().isEmpty())throw new UserServiceException(ErrorMessagesEnum.MISSING_REQUIRED_FIELD.getErrorMessage());
		if(userDetails.getPassword().isEmpty())throw new UserServiceException(ErrorMessagesEnum.MISSING_REQUIRED_FIELD.getErrorMessage());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails,userDto);
		UserDto createdUser = userService.createUser(userDto);
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(createdUser,returnValue);
		return returnValue;
	}

	@PutMapping(path = "/{id}")
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails)
	{
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails,userDto);
		UserDto updatedUser = userService.updateUserDetails(id,userDto);
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(updatedUser,returnValue);
		return returnValue;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id){
		userService.deleteUserDetails(id);
		OperationStatusModel returnValue = new OperationStatusModel(RequestOperationName.DELETE.name(),
				RequestOperationStatus.SUCCESS.name());
		return  returnValue;
	}

}
