package ammunition;

public abstract class Ammunition {

    private float price;
    private int weight;

    public Ammunition(float price,int weight){
        this.price=price;
        this.weight=weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Price: " + price + ". Weight: " + weight + ".";
    }
}




