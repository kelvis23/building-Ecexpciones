package org.example;

import lombok.extern.log4j.Log4j;
import org.example.componenetes.ApartamentReader;
import org.example.componenetes.BuildingReader;
import org.example.componenetes.OwnerReader;
import org.example.exception.ApartmentNotFoundException;
import org.example.model.Apartament;
import org.example.model.Building;
import org.example.model.BuildingApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Log4j
public class Main {
    public static void main(String[] args) throws ApartmentNotFoundException {
        Scanner scanner  = new Scanner(System.in);
         var ownerReader = new OwnerReader(scanner);
         var apartamentReader = new ApartamentReader(scanner,ownerReader);
         var buildingReader = new BuildingReader(scanner,apartamentReader);
        var buildingApp = new BuildingApp(scanner,buildingReader);

        buildingApp.run();
    }


}