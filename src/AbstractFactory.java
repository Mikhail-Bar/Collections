public class AbstractFactory {
    public static void main(String[] args) {
    ElfBarrack elfBarrack = new ElfBarrack();
    Warrior warrior = elfBarrack.createWarrior();
    warrior.attack();
    }
}

abstract class Barrack{
    abstract ElfWarrior createWarrior();
    abstract ElfArcher createArcher();
    abstract ElfMage createMage();

}

class ElfBarrack extends Barrack{
    @Override
    ElfWarrior createWarrior() {
        return new ElfWarrior();
    }

    @Override
    ElfArcher createArcher() {
        return new ElfArcher();
    }

    @Override
    ElfMage createMage() {
        return new ElfMage();
    }
}
abstract class Warrior{
   public abstract void attack();
}
abstract class Archer{
   public abstract void shot();
}
abstract class Mage{
   public abstract void cast();
}
class ElfMage extends Mage{
    public void cast(){
        System.out.println("cast");
    }
}
class ElfWarrior extends Warrior{
    public void attack(){
        System.out.println("attack");
    }
}
class ElfArcher extends Archer{
    public void shot(){
        System.out.println("shot");
    }
}

