package tamagoshis.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import tamagoshis.model.Tamagoshis;

public class Round {

    private final int round;
    private final List<Tamagoshis> aliveTamagoshis;
    private BufferedReader reader;

    /**
     * Constructor of Round
     * 
     * @param round           the number of the round
     * @param aliveTamagoshis the list of alive tamagoshis
     */
    public Round(int round, List<Tamagoshis> aliveTamagoshis) {
        this.round = round;
        this.aliveTamagoshis = aliveTamagoshis;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Makes the tamagoshis play the round
     */
    public void playRound() {
        System.out.println("\n------------ Tour n°" + this.round + " -------------\n");
        for (Tamagoshis tamagoshi : aliveTamagoshis)
            System.out.println(tamagoshi.getName() + " : " + tamagoshi.getState() + " ");

        int choiceEat = this.getUserChoiceForEating();
        aliveTamagoshis.get(choiceEat).eat();

        int choicePlay = this.getUserChoiceForPlaying();
        aliveTamagoshis.get(choicePlay).play();
    }

    /**
     * Returns the tamagoshi chosen by the user to eat
     * 
     * @return the tamagoshi chosen by the user to eat
     */
    public int getUserChoiceForEating() {
        int choiceEat = -1;
        while (choiceEat < 0 || choiceEat >= aliveTamagoshis.size()) {
            System.out.println("\nNourrir quel tamagoshi ?");
            choiceEat = getChoice(choiceEat);
        }
        return choiceEat;
    }

    /**
     * Returns the tamagoshi chosen by the user to play with
     * 
     * @return the tamagoshi chosen by the user to play with
     */
    public int getUserChoiceForPlaying() {
        int choicePlay = -1;
        while (choicePlay < 0 || choicePlay >= aliveTamagoshis.size()) {
            System.out.println("\nJouer avec quel tamagoshi ?");
            choicePlay = getChoice(choicePlay);
        }
        return choicePlay;
    }

    /**
     * Returns the choice of the user
     * 
     * @param choice the variable to store the choice of the user
     * @return the choice of the user
     */
    private int getChoice(int choice) {
        for (int i = 0; i < aliveTamagoshis.size(); i++)
            System.out.print("(" + i + ") " + aliveTamagoshis.get(i).getName() + " ");
        System.out.println("\nEntrez un choix :");
        try {
            choice = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Veuillez saisir un nombre valide.");
        } catch (IOException e) {
            System.out.println("Erreur de lecture. Veuillez réessayer.");
        }
        return choice;
    }

    /**
     * Returns the number of the round
     * 
     * @return the number of the round
     */
    public int getRound() {
        return this.round;
    }

    /**
     * Sets the reader
     * 
     * @param reader the reader
     */
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

}
