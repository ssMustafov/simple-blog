package com.example.blog.services.mappers;

import com.example.blog.entity.PostEntity;
import com.example.blog.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * @author smustafov
 */
@Mapper(componentModel = "spring")
public interface PostMapper {

    Post fromEntity(PostEntity postEntity);

    PostEntity toEntity(Post post);

    @Mapping(target = "id", ignore = true)
    void updateEntity(Post post, @MappingTarget PostEntity postEntity);

}
