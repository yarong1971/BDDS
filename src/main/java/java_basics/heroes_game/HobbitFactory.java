package java_basics.heroes_game;

public class HobbitFactory extends HeroFactory {
    @Override
    protected Hero makeHero(){
        Hero hero = new Hobbit();
        return hero;
    }
}
