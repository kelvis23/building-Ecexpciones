package org.example.componenetes;

import org.example.Reade;
import org.example.model.Owner;

import java.util.Scanner;

public class OwnerReader implements Reade<Owner> {
 private Scanner scanner;

    public OwnerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Owner read() {
        System.out.println( "introduce los datos del propietario");
        System.out.println("introduce el nombre");
        String name = scanner.nextLine();
        System.out.println("introduce aplelido");
        String lastmame = scanner.nextLine();

        return new Owner(name,lastmame);
    }
}
