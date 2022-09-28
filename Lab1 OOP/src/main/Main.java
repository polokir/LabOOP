package main;
import ammunition.*;
import knight.Knight;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight("Duke",27,90,190,
                "Scam",new ArrayList<Ammunition>(),100 );

        knight.buyItem(knight.getAmmunitions(), "Sword", "Shield", "Lance", "Armor", "Helm");
        System.out.println(knight);
        System.out.println("-----------AFTER WEIGHT SORTING------------");
        knight.sortAmmunitionsByWeight();
        System.out.println(knight);
        System.out.println("-----------AFTER COST SORTING------------");
        knight.sortAmmunitionsByCost();
        System.out.println(knight);
    }
}
