package com.caito.blogbe.mapper;

import com.caito.blogbe.entity.User;
import com.caito.blogbe.models.dto.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponse userToUserResponse(User user);
    List<UserResponse> userListToUserResponseList(List<User> users);
}
