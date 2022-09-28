package ammunition;

public class Armor extends Ammunition {
    private String name;
    private int damage;
    private String size;


    public Armor(float price, int weight, String name, int damage, String size) {
        super(price, weight);
        this.name = name;
        this.damage = damage;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {

        return "\n" + "#Armor." + name + ". It can take " + damage
                + " damage. Size: " + size + ". " + super.toString();

    }
}
