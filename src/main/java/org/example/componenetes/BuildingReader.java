package org.example.componenetes;

import lombok.extern.log4j.Log4j;
import org.example.Reade;
import org.example.model.Apartament;
import org.example.model.Building;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
@Log4j
public class BuildingReader implements Reade<Building> {
    private  final Scanner scanner ;
   private  final  ApartamentReader apartamentReader;

    public BuildingReader(Scanner scanner, ApartamentReader apartamentReader) {
        this.scanner = scanner;
        this.apartamentReader = apartamentReader;
    }

    @Override
    public Building read() {
        System.out.println("introduce la informasion del edificio" );
        System.out.println("direcion");
        String address = scanner.nextLine();
        System.out.println("municipio");
        String municipality = scanner.nextLine();
        System.out.println("codigo postal");
        int zipcode = askZipcode();
        int size = scanner.nextInt();
        scanner.nextLine();
        List<Apartament> apartamentList = new ArrayList<>(size);
        // falta el fori
        return new Building(address,municipality,zipcode ,apartamentList);
    }

    private  Integer askZipcode() {
        Integer zipcode = null;
        do {
            try {
                log.info("introduce el codigo postal");
                zipcode = scanner.nextInt();
            }catch (InputMismatchException e){
                log.error("el valor introducido  no cumple lo requisitos");
            }
            scanner.nextLine();
        }while (zipcode ==null);
        return zipcode;
    }
}
