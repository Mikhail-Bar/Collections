import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WiseCounting {
    public static void main(String[] args) {

        Person emperor = new Emperor("Akbar");
        List<Courtier> courtiers = new ArrayList<>();
        courtiers.add(new Courtier("first"));
        courtiers.add(new Courtier("second"));
        courtiers.add(new Courtier("third"));
        Person birbal = new Birbal("Birbal");

        ((Emperor)emperor).asks(0);
        courtiers.forEach(Courtier::thinks);
        ((Birbal)birbal).enters().asks(); // Chaining
        ((Emperor)emperor).asks(0);
        ((Birbal)birbal).answers();
        ((Emperor)emperor).asks(1);
        ((Birbal)birbal).says();
    }
}

class Person{
    private final String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Emperor extends Person{

    private final List<String> questions = new LinkedList<>();

    Emperor(String name) {
        super(name);
        questions.add("How many crows are there in this city?");
        questions.add("How can you be so sure?");
    }

    public void asks(int number){
        String s = questions.get(number);
        System.out.println(getName() +" asks: "+ questions.get(number));
    }

    public void looks(){
        System.out.println(getName() + " glanced at his courtiers.");
    }
}

class Courtier extends Person{

    Courtier(String name) {
        super(name);
    }

    public void thinks(){
        System.out.println("Courtier "+getName()+" The heads began to hang low in search of an answer.");
    }
}

class Birbal extends Person{

    Birbal(String name) {
        super(name);
    }

    public Birbal asks(){
        System.out.println(getName()+ " asks: May I know the question so that I can try for an answer.");
        return this; // Chaining
    }
    public Birbal enters(){
        System.out.println(getName()+ " entered the courtyard"); // Chaining
        return this;
    }

    public void answers(){
        System.out.println(getName()+ " said: There are fifty thousand five hundred and eighty nine crows, my lord.");
    }
    public void says(){
        System.out.println(getName()+ " said: Make you men count, My lord. If you find " +
                "more crows it means some have come to visit their relatives here. If you find less number of crows " +
                "it means some have gone to visit their relatives elsewhere");
    }
}