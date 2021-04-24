package java_basics.heroes_game;

import lombok.Data;

@Data
public class Hobbit extends Hero{
    public Hobbit() {
        this.name = "Hobbit";
        this.power =0;
        this.hp = 3;
    }

    @java.lang.Override
    public void kick(Hero enemy) {
        System.out.println(this.name + " is crying... :(");
        this.getStatus(enemy);
    }
}
