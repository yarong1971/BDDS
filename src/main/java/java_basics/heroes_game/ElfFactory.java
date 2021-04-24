package java_basics.heroes_game;

public class ElfFactory extends HeroFactory {
    @Override
    protected Hero makeHero(){
        Hero hero = new Elf();
        return hero;
    }
}
