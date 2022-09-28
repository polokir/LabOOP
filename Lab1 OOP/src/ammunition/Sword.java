package ammunition;

public class Sword extends Ammunition {
    private String name;
    private int damage;


    public Sword(float price, int weight, String name, int damage) {
        super(price, weight);
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    @Override
    public String toString() {

        return "\n" + "#Armor." + name + ". It can take " + damage
                + " damage. " + super.toString();

    }
}
