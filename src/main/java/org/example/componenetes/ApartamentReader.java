package org.example.componenetes;

import lombok.extern.log4j.Log4j;
import org.example.Reade;
import org.example.model.Apartament;
import org.example.model.Owner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
@Log4j
public class ApartamentReader implements Reade<Apartament> {
    private final Scanner scanner ;
    private final OwnerReader ownerReader;

    public ApartamentReader(Scanner scanner, OwnerReader ownerReader) {
        this.scanner = scanner;
        this.ownerReader = ownerReader;
    }

    @Override
    public Apartament read() {
        System.out.println("datos del apartamento");
        System.out.println("planta");

         int floor = askfloor();
        System.out.println("puerta");
        String door = scanner.nextLine();
        System.out.println("numero de propietarios");
        int size = scanner.nextInt();
        scanner.nextLine();
        List<Owner>ownerList = new ArrayList<>(size);
        return new Apartament(
                floor,
                door,
                ownerList

        );
    }

    private Integer askfloor() {
        Integer floor = null;
        do {
            try {
                log.info("introduce la planta");
                floor = scanner.nextInt();
            }catch  (InputMismatchException e){
                log.error("el valor introducido  no cumple lo requisitos");
            }
            scanner.nextLine();
        }while (floor==null);
        return floor;
    }
}
