package knight;


import ammunition.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Knight extends Human {
    private String nickname;
    private ArrayList<Ammunition> ammunitions;
    private int health;
    public Knight(String name, int age, int weight, int height, String nickname, ArrayList<Ammunition> ammunitions, int health) {
        super(name, age, weight, height);
        this.nickname = nickname;
        this.ammunitions = ammunitions;
        this.health = health;
    }

    public String getNickname() {
        return nickname;
    }

    public ArrayList<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public int getHealth() {
        return health;
    }

    public void setAmmunitions(ArrayList<Ammunition> ammunitions) {
        this.ammunitions = ammunitions;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void sortAmmunitionsByCost() {
        Collections.sort(ammunitions, new Comparator() {
            public int compare(Object o1, Object o2) {
                Ammunition a1 = (Ammunition) o1;
                Ammunition a2 = (Ammunition) o2;
                if (a1.getPrice() > a2.getPrice()) {
                    return 1;
                }
                if (a2.getPrice() > a1.getPrice()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void sortAmmunitionsByWeight() {
        Collections.sort(ammunitions, new Comparator() {
            public int compare(Object o1, Object o2) {
                Ammunition a1 = (Ammunition) o1;
                Ammunition a2 = (Ammunition) o2;
                if (a1.getWeight() > a2.getWeight()) {
                    return 1;
                }
                if (a2.getWeight() > a1.getWeight()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void buyItem(ArrayList<Ammunition> tools, String... item){
        Ammunition temp;
        for (int i = 0; i < item.length; i++) {
            temp = desk(item[i]);
            if (temp != null) {
                tools.add(temp);
            }
        }

    }

    private Ammunition desk (String type){
        switch (type) {
            case "Armor":
                return new Armor(500,20,"Original",0,"L");
            case "Helm":
                return new Helm(100,3,"Kratos",0,"L");
            case "Lance":
                return new Lance(800,5,"Celtic",50);
            case "Shield":
                return new EasyСhain(50,9,"Medival",0,"L");
            case "Sword":
                return new Sword(5000,10,"King",50);
            default:
                System.out.println("Sir, I haven`t " + type + ".");
                return null;
        }
    }
    @Override
    public String toString() {
        StringBuilder knightDescription = new StringBuilder(super.toString() + " Nick: " + nickname
                + ". Health: " + health + ".");
        if (!ammunitions.isEmpty()) {
            knightDescription.append("\n" + "----------AMMUNITIONS----------");
            for (Ammunition ammunition : ammunitions) {
                knightDescription.append(new StringBuilder(ammunition.toString()));
            }
        }
        return new String(knightDescription);
    }

}
