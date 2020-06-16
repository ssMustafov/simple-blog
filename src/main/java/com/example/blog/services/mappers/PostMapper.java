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
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    void updateEntity(Post post, @MappingTarget PostEntity postEntity);

}
