package java_basics.heroes_game;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    private ArrayList<HeroFactory> heroes = new ArrayList<HeroFactory>();
    private Hero c1;
    private Hero c2;

    public GameManager(){
        heroes.add(new HobbitFactory());
        heroes.add(new ElfFactory());
        heroes.add(new KingFactory());
        heroes.add(new KnightFactory());

        c1 = heroes.get(new Random().nextInt(heroes.size())).createHero();
        c2 = heroes.get(new Random().nextInt(heroes.size())).createHero();

        //c1.getStatus(c2);
    }

    /*public static void selectHeroes(){


        int randomNumber = new Random().nextInt(GameManager.heroes.size());
        System.out.println("random number : " + randomNumber + " of " + GameManager.heroes.size());
        c1 = heroes.get(randomNumber).createHero();
        randomNumber = new Random().nextInt(GameManager.heroes.size());
        System.out.println("random number : " + randomNumber);
        c2 = heroes.get(randomNumber).createHero();

        c1.getStatus(c2);
    }
*/
    public void fight(Hero c1, Hero c2){
        System.out.println("The heroes");
        System.out.println("--------------------------------------");

        c1.getStatus(c2);

        if(c1 instanceof Hobbit && c2 instanceof Hobbit) {
            System.out.println("The heroes are hobbits, there is no fight");
        } else {
            System.out.println("Start fighting...");
            System.out.println("--------------------------------------");

            int heroTurn;
            heroTurn = 1;
            while(c1.isAlive() && c2.isAlive()){
                if(heroTurn % 2 == 0)
                    c2.kick(c1);
                else
                    c1.kick(c2);

                heroTurn++;
            }

            if(c1.isAlive()){
                System.out.println(c1.name + " is alive");
                System.out.println(c2.name + " is dead");
            } else {
                System.out.println(c1.name + " is dead");
                System.out.println(c2.name + " is alive");
            }
        }
    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();

            gm.fight(gm.c1, gm.c2);
        //GameManager.selectHeroes();
        //GameManager.fight(GameManager.c1, GameManager.c2);
    }
}
