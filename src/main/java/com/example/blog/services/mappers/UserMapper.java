package com.example.blog.services.mappers;

import com.example.blog.entity.UserEntity;
import com.example.blog.models.User;
import com.example.blog.models.UserSecureDetails;
import com.example.blog.models.request.UserCreateRequest;
import org.mapstruct.Mapper;

/**
 * @author smustafov
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromEntity(UserEntity userEntity);

    UserEntity toEntity(UserCreateRequest createRequest);

    UserSecureDetails toUserDetailsFromEntity(UserEntity userEntity);

}
