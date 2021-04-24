package java_basics.heroes_game;

import java.util.Random;

public class King extends King_Knight{
    public King() {
        this.name = "King";
        this.power = new Random().nextInt((15 - 5) + 1) + 5;
        this.hp = new Random().nextInt((15 - 5) + 1) + 5;
    }
}
