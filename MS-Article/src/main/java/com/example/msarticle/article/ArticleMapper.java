package com.example.msarticle.article;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
    @Mapping(source = "id", target = "articleId")
    ArticleDTO toDto(Article article);
    @Mapping(source = "articleId", target = "id")
    Article toEntity(ArticleDTO articleDTO);

}
