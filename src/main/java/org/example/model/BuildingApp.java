package org.example.model;

import org.example.componenetes.BuildingReader;
import org.example.exception.ApartmentNotFoundException;

import java.util.Scanner;

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
            opt = scanner.nextInt();
            scanner.nextLine();
            if (opt ==1){
                System.out.println("introduce el piso");
                int num = scanner.nextInt();
                scanner.nextLine();
                System.out.println("introduse la puerta");
                String door = scanner.nextLine();
                building.getApartment(num,door);
            } else if (opt == 2) {

                System.out.println("introduce el piso");
                int num = scanner.nextInt();
                scanner.nextLine();
                System.out.println("introduse la puerta");
                String door = scanner.nextLine();
                building.getOwners(num,door);
            }else {
                System.out.println("el numero introducio es incorecto");
            }
        }while (opt !=0);
    }
}
