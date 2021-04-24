package java_basics.heroes_game;

public class KnightFactory extends HeroFactory {
    @Override
    protected Hero makeHero(){
        Hero hero = new Knight();
        return hero;
    }
}
