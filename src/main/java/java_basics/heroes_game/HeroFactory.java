package java_basics.heroes_game;

public abstract class HeroFactory {
    protected abstract Hero makeHero();

    public Hero createHero(){
        return this.makeHero();
    }
}
