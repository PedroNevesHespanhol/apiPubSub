package com.pedroneves.apipubsub.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CategoryResponse {
    private String id;
    private SubCategoryResponse subCategory;
}
