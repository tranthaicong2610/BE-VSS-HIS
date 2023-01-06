package com.example.bevss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchOrderDTO {

    private String name;
    private float price ;
    private String image;
    private int quantity;

}
