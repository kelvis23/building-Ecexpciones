package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Apartament {
    private Integer floor ;
    private String door ;
    private List<Owner>ownerList;

}
