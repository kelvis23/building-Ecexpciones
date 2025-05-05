package org.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApartmentNotFoundException  extends  Exception{
    private final  Integer floor;
    private final  String door;

}
