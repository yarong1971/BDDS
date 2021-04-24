package java_basics.heroes_game;

import java.util.Random;

public abstract class King_Knight extends Hero{
    @Override
    public void kick(Hero enemy) {
        int randomPower = new Random().nextInt(this.power) + 1;
        System.out.println(this.name + " kicks " + enemy.name + " with power of " + randomPower);
        enemy.hp -= randomPower;
        this.getStatus(enemy);
    }
}
