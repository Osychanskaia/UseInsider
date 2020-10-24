package com.useinsider.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PetDto {

    private int id;
    private String name;
    private String status;
    private CategoryDto category;
    private List<String> photoUrls;
    private List<TagDto> tags;
}
