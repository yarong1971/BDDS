package java_basics.heroes_game;

import java.util.Random;

public class Knight extends King_Knight{
    public Knight() {
        this.name = "Knight";
        this.power = new Random().nextInt((12 - 2) + 1) + 2;
        this.hp = new Random().nextInt((12 - 2) + 1) + 2;
    }
}
