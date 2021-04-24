package java_basics.heroes_game;

public abstract class Hero {
    protected String name;
    protected int power;
    protected int hp;

    public abstract void kick(Hero enemy);
    public boolean isAlive(){
        return this.hp > 0;
    }

    protected void getStatus(Hero enemy){
        System.out.println(this.name + " > power: " + this.power + ", hp: " + this.hp);
        System.out.println(enemy.name + " > power: " + enemy.power + ", hp: " + enemy.hp);
        System.out.println("--------------------------------------");
    }
}
