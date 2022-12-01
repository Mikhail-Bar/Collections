import java.util.PriorityQueue;
import java.util.Queue;

public class GaintTurnip {
    public static void main(String[] args) {
    FairyTale fairyTale = new FairyTale();

    fairyTale.tell();
    }
}

class Personage implements Comparable{
    private String name;
    private int strength;

    public Personage(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int compareTo(Object o) {
        return -(this.getStrength()- ((Personage)o).getStrength());
    }
}

class FairyTale{
    private Queue<Personage> queue = new PriorityQueue<>();
    public FairyTale(){
        queue.add(new Personage("Old Woman", 7));
        queue.add(new Personage("Old Man", 10));
        queue.add(new Personage("Turnip", 29));
        queue.add(new Personage("Mouse", 1));
        queue.add(new Personage("Grand daughter", 5));
        queue.add(new Personage("Dog", 3));
        queue.add(new Personage("Cat", 2));
    }
    public void tell(){
        int sum = 0;
        Personage prev = queue.poll();
        Personage next = null;
        int strength = prev.getStrength();
        while (!queue.isEmpty()){
            next = queue.poll();
            sum+= next.getStrength();
            System.out.println("The "+next.getName()+" took hold of the "+ prev.getName());
            prev = next;
        }
        if (sum>=strength) System.out.println("They pulled and pulled - and finally out came the turnip");
        else System.out.println("They pulled and pulled. But still they could not pull the turnip out");
    }
}