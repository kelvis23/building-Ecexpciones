package org.example.componetes;

import org.example.exception.ApartmentNotFoundException;
import org.example.model.Apartament;
import org.example.model.Building;
import org.example.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractSet;
import java.util.List;


public class BuildingTests {

    @Test
    public void getApartment() throws ApartmentNotFoundException {
        var building = createTesBuilding();
        var aparment = building.getApartment(2, "a1");
        var expected = new Apartament(2, "a1",
                List.of(
                        new Owner("paco", "torres"),
                        new Owner("felipe","menedes")
                )
        );
        Assertions.assertEquals(expected,aparment);
    }
    @Test
    public void  apartmentNoTFountTes(){
        Assertions.assertThrows(
                ApartmentNotFoundException.class,
                ()->{
                    var building =createTesBuilding();
                    building.getApartment(3,"q3");
                }
        );
    }
    @Test
    public void getOwners() throws ApartmentNotFoundException {
        var building = createTesBuilding();
        var owner = building.getOwners(2,"d1");
        var expected = List.of(new Owner("ana", "maria"));
        Assertions.assertEquals(expected,owner);
    }


    private Building createTesBuilding() {

        List<Apartament> apartamentList;
        apartamentList = List.of(
                new Apartament(2, "a1",
                        List.of(
                                new Owner("paco", "torres"),
                                new Owner("felipe","menedes")
                        )
                ),
                new Apartament(2, "d1", List.of(new Owner("ana", "maria")))
        );
        return new Building("perdido", "Madrid", 2056, apartamentList);
    }
}

