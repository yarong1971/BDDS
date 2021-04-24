package java_basics.heroes_game;

public class Elf extends Hero{
    public Elf() {
        this.name = "Elf";
        this.power =10;
        this.hp = 10;
    }

    @java.lang.Override
    public void kick(Hero enemy) {
        if(this.power > enemy.power)
            enemy.hp = 0;
        else
            enemy.hp--;

        this.getStatus(enemy);
    }
}
