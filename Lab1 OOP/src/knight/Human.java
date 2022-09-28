package knight;

public abstract class Human {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Human(String name, int age, int weight, int height){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.height=height;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Name: " + name + ". Age: " + age + "." + "Weight " + weight
                +"." +" Height " + height;
    }
}
