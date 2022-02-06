public class Cat extends Animal {


    Cat (String name) {
        super(name,200,0);
    }

    @Override
    protected void swim(int distance) {
        System.out.println("коты не умеют плавать");
    }
}
