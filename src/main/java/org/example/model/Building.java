package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.example.exception.ApartmentNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Log4j
@Data
@AllArgsConstructor
public class Building {
    private String direcion;
    private String municipio;
    private Integer zipcode;
    private List<Apartament> apartamentList;

    //   getApartment(int floor, String door): devuelve el apartamento en esa planta y esa puerta.
    //   Si no encuentra el apartamento, lanza la excepción ApartmentNotFoundException

    public Apartament getApartment(int floor, String door) throws ApartmentNotFoundException {
        for (var apartament : apartamentList) {
            if (apartament.getFloor() == floor && apartament.getDoor().equals(door)) {
                return apartament;
            }
        }
        throw new ApartmentNotFoundException(floor, door);
    }
    // getOwners(int floor, String door):
    // devuelve los propietarios del apartamento en esa planta y puerta.
    // Si no encuentra el apartamento, lanza la excepción ApartmentNotFoundException

    public List<Owner> getOwners(int floor, String door) throws ApartmentNotFoundException {
        for (var apartament : apartamentList) {
            if (apartament.getFloor() == floor && apartament.getDoor().equals(door)){
                   return apartament.getOwnerList();
            }

        }
        throw new ApartmentNotFoundException(floor, door);
    }
}
