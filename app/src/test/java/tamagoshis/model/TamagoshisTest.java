package tamagoshis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TamagoshisTest {

    @Test
    void testRandomIntGeneratorBigEater() {
        Tamagoshis tamagoshi = new BigEater("test");
        int min = 0;
        int max = 10;
        int random = tamagoshi.randomIntGenerator(min, max);
        assertTrue(random >= min && random <= max);
    }

    @Test
    void testRandomIntGeneratorBigPlayer() {
        Tamagoshis tamagoshis = new BigPlayer("test");
        int min = 0;
        int max = 10;
        int random = tamagoshis.randomIntGenerator(min, max);
        assertTrue(random >= min && random <= max);
    }

    @Test
    void testConstructBigEater() {
        Tamagoshis tamagoshi = new BigEater("test");
        assertEquals("test", tamagoshi.getName());
        assertEquals(0, tamagoshi.getAge());
        assertTrue(tamagoshi.getEnergy() >= 3 && tamagoshi.getEnergy() <= 5);
        assertTrue(tamagoshi.getMaxEnergy() >= 5 && tamagoshi.getMaxEnergy() <= 9);
        assertTrue(tamagoshi.getAlertEnergy() >= 3 && tamagoshi.getAlertEnergy() <= 5);
        assertTrue(tamagoshi.getFun() >= 3 && tamagoshi.getFun() <= 5);
        assertTrue(tamagoshi.getMaxFun() >= 5 && tamagoshi.getMaxFun() <= 9);
        assertTrue(tamagoshi.getAlertFun() >= 3 && tamagoshi.getAlertFun() <= 5);
    }

    @Test
    void testConstructBigPlayer() {
        Tamagoshis tamagoshi = new BigPlayer("test");
        assertEquals("test", tamagoshi.getName());
        assertEquals(0, tamagoshi.getAge());
        assertTrue(tamagoshi.getEnergy() >= 3 && tamagoshi.getEnergy() <= 5);
        assertTrue(tamagoshi.getMaxEnergy() >= 5 && tamagoshi.getMaxEnergy() <= 9);
        assertTrue(tamagoshi.getAlertEnergy() >= 3 && tamagoshi.getAlertEnergy() <= 5);
        assertTrue(tamagoshi.getFun() >= 3 && tamagoshi.getFun() <= 5);
        assertTrue(tamagoshi.getMaxFun() >= 5 && tamagoshi.getMaxFun() <= 9);
        assertTrue(tamagoshi.getAlertFun() >= 3 && tamagoshi.getAlertFun() <= 5);
    }

    @Test
    void testBigEaterPassTime() {
        Tamagoshis tamagoshi = new BigEater("test");
        int energy = tamagoshi.getEnergy();
        int fun = tamagoshi.getFun();
        int age = tamagoshi.getAge();
        tamagoshi.passTime();
        assertTrue(energy - 1 >= tamagoshi.getEnergy() && energy - 3 <= tamagoshi.getEnergy());
        assertEquals(fun - 1, tamagoshi.getFun());
        assertEquals(age + 1, tamagoshi.getAge());
    }

    @Test
    void testBigPlayerPassTime() {
        Tamagoshis tamagoshi = new BigPlayer("test");
        int energy = tamagoshi.getEnergy();
        int fun = tamagoshi.getFun();
        int age = tamagoshi.getAge();
        tamagoshi.passTime();
        assertEquals(age + 1, tamagoshi.getAge());
        assertEquals(energy - 1, tamagoshi.getEnergy());
        assertTrue(fun - 1 >= tamagoshi.getFun() && fun - 3 <= tamagoshi.getFun());
    }

}
