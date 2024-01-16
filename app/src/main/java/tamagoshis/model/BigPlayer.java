package tamagoshis.model;

public class BigPlayer extends Tamagoshis {

    /**
     * Constructor of a BigPlayer Tamagoshis
     * 
     * @param name the name of the BigEater Tamagoshi
     */
    public BigPlayer(String name) {
        super(name);
    }

    /**
     * Makes the BigPlayer Tamagoshi play
     */
    @Override
    public void play() {
        this.checkIfBored();
        this.setFun(this.getFun() + Tamagoshis.randomIntGenerator(1, 3));
    }

    /**
     * Makes the BigPlayer Tamagoshi eat
     */
    @Override
    public void eat() {
        this.checkIfHungry();
        this.setEnergy(this.getEnergy() + 1);
    }

}
