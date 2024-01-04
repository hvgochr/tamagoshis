package tamagoshis.model;

public class BigEater extends Tamagoshis {

    /**
     * Constructor of a BigEater Tamagoshis
     * 
     * @param name the name of the BigEater Tamagoshi
     */
    public BigEater(String name) {
        super(name);
    }

    /**
     * Makes the BigEater Tamagoshi pass the time
     */
    @Override
    public void passTime() {
        this.setAge(this.getAge() + 1);
        this.setEnergy(this.getEnergy() - this.randomIntGenerator(1, 3));
        this.setFun(this.getFun() - 1);
    }

    /**
     * Makes the BigEater Tamagoshi play
     */
    @Override
    public void play() {
        this.setFun(this.getFun() + 1);
    }

    /**
     * Makes the BigEater Tamagoshi eat
     */
    @Override
    public void eat() {
        this.setEnergy(this.getEnergy() + this.randomIntGenerator(1, 3));
    }

}
