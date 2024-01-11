package tamagoshis.model;

import java.util.Random;

public abstract class Tamagoshis {

    private final String name;
    public static final int MAX_AGE = 10;
    private int age;
    private int energy;
    private final int maxEnergy;
    private final int alertEnergy;
    private int fun;
    private final int maxFun;
    private final int alertFun;
    private String causeOfDeath;

    /**
     * Constructor of Tamagoshis
     * 
     * @param name the name of the Tamagoshi
     */
    public Tamagoshis(String name) {
        this.name = name;
        this.age = 0;
        this.energy = randomIntGenerator(3, 5);
        this.maxEnergy = randomIntGenerator(5, 9);
        this.alertEnergy = randomIntGenerator(3, 5);
        this.fun = randomIntGenerator(3, 5);
        this.maxFun = randomIntGenerator(5, 9);
        this.alertFun = randomIntGenerator(3, 5);
    }

    /**
     * Makes the Tamagoshis play
     */
    public abstract void play();

    /**
     * Makes the Tamagoshis eat
     */
    public abstract void eat();

    /**
     * Makes the Tamagoshis pass the time
     */
    public abstract void passTime();

    /**
     * Returns the current state of the tamagoshi depending on its energy and fun
     * 
     * @return the current state of the tamagoshis
     */
    public String getState() {
        String res = "";
        if (energy < alertEnergy && fun < alertFun)
            res += "J'ai faim et je m'ennuie";
        else if (fun < alertFun)
            res += "Je m'ennuie";
        else if (energy < alertEnergy)
            res += "J'ai faim";
        else
            return "Tout va bien";
        return res;
    }

    /**
     * Makes the Tamagoshis die and sets the cause of death
     */
    public void die() {
        if (energy <= 0)
            causeOfDeath = this.name + " qui était un " + this.getClass().getSimpleName() + " est mort de faim";
        else if (fun <= 0)
            causeOfDeath = this.name + " qui était un " + this.getClass().getSimpleName() + " est mort d'ennui";
    }

    /**
     * Returns a random number between min and max
     * 
     * @param min the minimum value
     * @param max the maximum value
     * @return a random number between min and max
     */
    public static int randomIntGenerator(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

    /**
     * Returns the name of the Tamagoshi
     * 
     * @return the name of the Tamagoshi
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the Tamagoshi
     * 
     * @return the age of the Tamagoshi
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the maximum age of the Tamagoshi
     * 
     * @return the maximum age of the Tamagoshi
     */
    public int getMaxAge() {
        return MAX_AGE;
    }

    /**
     * Returns the energy of the Tamagoshi
     * 
     * @return the energy of the Tamagoshi
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Returns the maximum energy of the Tamagoshi
     * 
     * @return the maximum energy of the Tamagoshi
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Returns the alert energy of the Tamagoshi
     * 
     * @return the alert energy of the Tamagoshi
     */
    public int getAlertEnergy() {
        return alertEnergy;
    }

    /**
     * Returns the fun of the Tamagoshi
     * 
     * @return the fun of the Tamagoshi
     */
    public int getFun() {
        return fun;
    }

    /**
     * Returns the maximum fun of the Tamagoshi
     * 
     * @return the maximum fun of the Tamagoshi
     */
    public int getMaxFun() {
        return maxFun;
    }

    /**
     * Returns the alert fun of the Tamagoshi
     * 
     * @return the alert fun of the Tamagoshi
     */
    public int getAlertFun() {
        return alertFun;
    }

    /**
     * Sets the age of the Tamagoshi
     * 
     * @param age the name of the Tamagoshi
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the energy of the Tamagoshi
     * 
     * @param energy the energy of the Tamagoshi
     */
    public void setEnergy(int energy) {
        if (energy > maxEnergy)
            this.energy = maxEnergy;
        else if (energy < 0)
            this.energy = 0;
        else
            this.energy = energy;
    }

    /**
     * Sets the fun of the Tamagoshi
     * 
     * @param fun the fun of the Tamagoshi
     */
    public void setFun(int fun) {
        if (fun > maxFun)
            this.fun = maxFun;
        else if (fun < 0)
            this.fun = 0;
        else
            this.fun = fun;
    }

    /**
     * Returns the cause of death of the Tamagoshi
     * 
     * @return the cause of death of the Tamagoshi
     */
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void checkIfHungry() {
        if (energy > alertEnergy)
            System.out.println(this.name + " : j'ai pas très faim");
        else
            System.out.println(this.name + " : merci !");
    }

    public void checkIfBored() {
        if (fun > alertFun)
            System.out.println(this.name + " : je m'ennuie pas trop");
        else
            System.out.println(this.name + " : on se marre !");
    }

}
