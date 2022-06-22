package com.hacakathon.vegetable.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ToString
public class RecipeContentCreateRequest {
    private Long recipeContentId;
    private String authorName;
    private String title;
    private String mainText;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdated;

    @Builder
    public RecipeContentCreateRequest(){

    }
}
