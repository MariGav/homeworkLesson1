public abstract class Animal {

    private String name;
    private float maxRun;
    private float maxSwim;

    Animal(String name, float maxRun, float maxSwim) {
       this.name = name;
       this.maxRun = maxRun;
       this.maxSwim = maxSwim;
    }

    protected void run (int distance) {
        if (distance <= this.maxRun) {
        System.out.println(this.name +" пробежал дистанцию ");
        } else {
            System.out.println(this.name + " отказался бежать ");
        }
    }

    protected void swim (int distance) {
        if (distance <= this.maxSwim) {
            System.out.println(this.name +" проплыл дистанцию ");
        } else {
            System.out.println(this.name + " отказался плыть ");
        }
    }

}



