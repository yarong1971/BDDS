package java_basics.heroes_game;

public class KingFactory extends HeroFactory {
    @Override
    protected Hero makeHero(){
        Hero hero = new King();
        return hero;
    }
}
