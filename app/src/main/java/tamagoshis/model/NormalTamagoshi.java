package tamagoshis.model;

public class NormalTamagoshi extends Tamagoshis {

    /**
     * Constructor of a NormalTamagoshi Tamagoshis
     * 
     * @param name the name of the BigEater Tamagoshi
     */
    public NormalTamagoshi(String name) {
        super(name);
    }

    /**
     * Makes the NormalTamagoshi Tamagoshi play
     */
    @Override
    public void play() {
        this.checkIfBored();
        this.setFun(this.getFun() + 1);
    }

    /**
     * Makes the NormalTamagoshi Tamagoshi eat
     */
    @Override
    public void eat() {
        this.checkIfHungry();
        this.setEnergy(this.getEnergy() + 1);
    }

}
