package tamagoshis.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import tamagoshis.model.Tamagoshis;
import tamagoshis.model.TamagoshisFactory;

public class Game {

    private BufferedReader reader;
    private List<Tamagoshis> aliveTamagoshis;
    private List<Tamagoshis> deadTamagoshis;
    private int round;
    private boolean isRunning;
    private int nbTamagoshis;

    /**
     * Constructor of Game
     */
    public Game() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.aliveTamagoshis = new ArrayList<Tamagoshis>();
        this.deadTamagoshis = new ArrayList<Tamagoshis>();
        this.round = 1;
        this.isRunning = true;
    }

    public Round createRound(int roundNumber, List<Tamagoshis> aliveTamagoshis) {
        return new Round(roundNumber, aliveTamagoshis);
    }

    /**
     * Makes the game go to the next round
     */
    public void nextRound() {
        for (Tamagoshis tamagoshi : this.aliveTamagoshis)
            tamagoshi.passTime();
        this.round++;
    }

    /**
     * Checks if any tamagoshis are dead and removes them from the aliveTamagoshis
     * list if so
     */
    public void checkAliveTamagoshis() {
        for (Tamagoshis tamagoshi : this.aliveTamagoshis)
            if (tamagoshi.getEnergy() <= 0 || tamagoshi.getFun() <= 0) {
                tamagoshi.die();
                this.deadTamagoshis.add(tamagoshi);
                if (tamagoshi.getEnergy() <= 0)
                    System.out.println("\n" + tamagoshi.getName() + " : snif, je suis mort de faim, ciao");
                else if (tamagoshi.getFun() <= 0)
                    System.out.println("\n" + tamagoshi.getName() + " : snif, je me suis ennuyé à mourir, ciao");
            }
        for (Tamagoshis tamagoshi : this.deadTamagoshis)
            this.aliveTamagoshis.remove(tamagoshi);
    }

    /**
     * Checks if the game is over and displays the results if so
     */
    public void checkEndGame() {
        if (this.aliveTamagoshis.isEmpty() || this.round == Tamagoshis.MAX_AGE) {
            this.isRunning = false;
            System.out.println("\n------------ Fin de la partie -------------\n");
            for (Tamagoshis tamagoshi : this.deadTamagoshis)
                System.out.println(tamagoshi.getCauseOfDeath());
            for (Tamagoshis tamagoshi : this.aliveTamagoshis)
                System.out.println(
                        tamagoshi.getName() + " qui était un " + tamagoshi.getClass().getSimpleName() + " a survécu");
            double score = Math.round((double) this.aliveTamagoshis.size() / this.nbTamagoshis * 100);
            System.out.println("\nNiveau de difficulté: " + this.nbTamagoshis + " Score : " + score + " %");
        }
    }

    /**
     * Makes the game start
     */
    public void play() {
        boolean validInput = false;
        while (!validInput)
            try {
                System.out.println("Entrez le nombre de tamagoshis désiré !\nSaisissez un nombre > 0:");
                this.nbTamagoshis = Integer.parseInt(this.reader.readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez saisir un nombre valide.");
            } catch (IOException e) {
                System.out.println("Erreur de lecture. Veuillez réessayer.");
            }
        for (int i = 0; i < nbTamagoshis; i++) {
            String name = null;
            while (name == null || name.isEmpty())
                try {
                    System.out.println("Entrez le nom du tamagoshi n°" + (i + 1) + " !");
                    name = this.reader.readLine();
                    if (name.isEmpty())
                        System.out.println("Le nom ne peut pas être vide. Veuillez réessayer.");
                } catch (IOException e) {
                    System.out.println("Erreur de lecture. Veuillez réessayer.");
                }
            Tamagoshis tamagoshi = TamagoshisFactory.createRandomTamagoshis(name);
            this.aliveTamagoshis.add(tamagoshi);
        }
        while (isRunning) {
            Round round = this.createRound(this.round, this.aliveTamagoshis);
            round.playRound();
            this.nextRound();
            this.checkAliveTamagoshis();
            this.checkEndGame();
        }
    }

    /**
     * Sets the reader
     * 
     * @param reader the reader
     */
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * Returns the round
     * 
     * @return the round
     */
    public int getRound() {
        return this.round;
    }

    /**
     * Returns the alive tamagoshis
     * 
     * @return the alive tamagoshis
     */
    public List<Tamagoshis> getAliveTamagoshis() {
        return this.aliveTamagoshis;
    }

    /**
     * Returns the dead tamagoshis
     * 
     * @return the dead tamagoshis
     */
    public List<Tamagoshis> getDeadTamagoshis() {
        return this.deadTamagoshis;
    }

    /**
     * Returns true if the game is running
     * 
     * @return if the game is running
     */
    public boolean isRunning() {
        return this.isRunning;
    }

    /**
     * Returns the number of tamagoshis
     * 
     * @return the number of tamagoshis
     */
    public int getNbTamagoshis() {
        return this.nbTamagoshis;
    }

    /**
     * Sets the running state of the game
     * 
     * @param nbTamagoshis the running state of the game
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

}
