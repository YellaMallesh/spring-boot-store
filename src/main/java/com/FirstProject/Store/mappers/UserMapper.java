package com.FirstProject.Store.mappers;

import com.FirstProject.Store.dtos.RegisterUserRequest;
import com.FirstProject.Store.dtos.UpdateUserRequest;
import com.FirstProject.Store.dtos.UserDto;
import com.FirstProject.Store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request,@MappingTarget User user);
}
