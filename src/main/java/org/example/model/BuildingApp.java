package org.example.model;

import lombok.extern.log4j.Log4j;
import org.example.componenetes.BuildingReader;
import org.example.exception.ApartmentNotFoundException;
import java.util.Scanner;
@Log4j
public class BuildingApp {
    private final Scanner scanner;
    private final BuildingReader buildingReader;

    public BuildingApp(Scanner scanner, BuildingReader buildingReader) {
        this.scanner = scanner;
        this.buildingReader = buildingReader;
    }
    public void  run() throws ApartmentNotFoundException {
        Building building = buildingReader.read();
        int opt ;
        do {
            System.out.println("1.Ver apartamento");
            System.out.println("2.Ver propietarios de apartamento");
            System.out.println("3,salir");
            opt = getOpt(building);
        }while (opt !=0);
    }

    private int getOpt(Building building) throws ApartmentNotFoundException {
        int opt;
        opt = scanner.nextInt();
        scanner.nextLine();
        if (opt ==1){
            try {
            System.out.println("introduce el piso");
            int num = scanner.nextInt();
            scanner.nextLine();
            System.out.println("introduse la puerta");
            String door = scanner.nextLine();
                building.getApartment(num,door);
            }catch (ApartmentNotFoundException e){
                log.info("no se ha encontrado el apatamento ");
            }

        } else if (opt == 2) {
            try {


                System.out.println("introduce el piso");
                int num = scanner.nextInt();
                scanner.nextLine();
                System.out.println("introduse la puerta");
                String door = scanner.nextLine();
                building.getOwners(num, door);
            }catch (ApartmentNotFoundException e){
                log.info("no se ha encontrado el apatamento ");
            }
        }else {
            System.out.println("el numero introducio es incorecto");
        }
        return opt;
    }
}
