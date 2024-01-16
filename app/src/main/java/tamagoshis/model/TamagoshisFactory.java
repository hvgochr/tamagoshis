package tamagoshis.model;

public class TamagoshisFactory {

    /**
     * Generates a random Tamagoshis
     * 
     * @return a random Tamagoshis of type BigEater or BigPlayer
     */
    public static Tamagoshis createRandomTamagoshis(String name) {
        int random = Tamagoshis.randomIntGenerator(0, 1);
        return switch (random) {
            case 0 -> new BigEater(name);
            case 1 -> new BigPlayer(name);
            default -> null;
        };
    }

    /**
     * Generates a Tamagoshis of the given type
     * 
     * @param type the type of the Tamagoshis
     * @return a Tamagoshis of the given type
     */
    public static Tamagoshis createTamagoshis(String type, String name) {
        return switch (type) {
            case "BigEater" -> new BigEater(name);
            case "BigPlayer" -> new BigPlayer(name);
            default -> null;
        };
    }

}
