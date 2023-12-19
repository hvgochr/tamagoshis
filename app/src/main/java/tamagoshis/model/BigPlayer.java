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
     * Makes the BigPlayer Tamagoshi pass the time
     */
    @Override
    public void passTime() {
        this.setAge(this.getAge() + 1);
        this.setEnergy(this.getEnergy() - 1);
        this.setFun(this.getFun() - this.randomIntGenerator(1, 3));
    }

    /**
     * Makes the BigPlayer Tamagoshi play
     */
    @Override
    public void play() {
        this.setFun(this.getFun() + 1);
    }

    /**
     * Makes the BigPlayer Tamagoshi eat
     */
    @Override
    public void eat() {
        this.setEnergy(this.getEnergy() + 1);
    }

}
