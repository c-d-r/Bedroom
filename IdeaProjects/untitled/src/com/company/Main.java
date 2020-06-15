package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("North");
        Wall wall4 = new Wall("South");

        Ceiling ceiling = new Ceiling("White", 55);

        Bed bed = new Bed( "Modern", 4 , 3 ,2 , 0);

        Lamp lamp = new Lamp("Classic", false, 76);

        Bedroom bedroom = new Bedroom("JC's bed", wall1, wall2, wall3, wall4, ceiling, bed, lamp);


        System.out.println("Is the light on or off? True for on, false for off.");
        Scanner s = new Scanner(System.in);
        boolean bs = s.nextBoolean();

        if (bs == true) {
            bedroom.getLamp().turnOn();
        }
        else {
            bedroom.getLamp().turnOff();
        }
    }
}
