package tamagoshis.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TamagoshisTest {

    private Tamagoshis tamagoshi;

    @Test
    void testRandomIntGenerator() {
        int random = Tamagoshis.randomIntGenerator(0, 1);
        int random2 = Tamagoshis.randomIntGenerator(0, 10);
        int random3 = Tamagoshis.randomIntGenerator(0, 0);
        assertAll("randomIntGenerator",
                () -> assertTrue(random == 0 || random == 1),
                () -> assertTrue(random2 >= 0 && random2 <= 10),
                () -> assertEquals(0, random3));
    }

    @Nested
    class TamagoshiFactoryTest {

        @Test
        void testCreateRandomTamagoshi() {
            Tamagoshis tamagoshi = TamagoshisFactory.createRandomTamagoshis("Pierre");
            assertAll("createRandomTamagoshi",
                    () -> assertNotNull(tamagoshi),
                    () -> assertTrue(tamagoshi instanceof BigEater || tamagoshi instanceof BigPlayer),
                    () -> assertEquals("Pierre", tamagoshi.getName()));
        }

        @Test
        void testCreateTamagoshiBigEater() {
            Tamagoshis tamagoshi = TamagoshisFactory.createTamagoshis("BigEater", "Paul");
            assertAll("createTamagoshi",
                    () -> assertNotNull(tamagoshi),
                    () -> assertTrue(tamagoshi instanceof BigEater),
                    () -> assertEquals("Paul", tamagoshi.getName()));
        }

        @Test
        void testCreateTamagoshiBigPlayer() {
            Tamagoshis tamagoshi = TamagoshisFactory.createTamagoshis("BigPlayer", "Pierre");
            assertAll("createTamagoshi",
                    () -> assertNotNull(tamagoshi),
                    () -> assertTrue(tamagoshi instanceof BigPlayer),
                    () -> assertEquals("Pierre", tamagoshi.getName()));
        }

    }

    @Nested
    class BigPlayerTest {

        @BeforeEach
        void setUp() {
            tamagoshi = TamagoshisFactory.createTamagoshis("BigPlayer", "Pierre");
        }

        @Test
        void testPassTime() {
            int energy = tamagoshi.getEnergy();
            int fun = tamagoshi.getFun();
            int age = tamagoshi.getAge();
            tamagoshi.passTime();
            assertAll("passTime",
                    () -> assertEquals(energy - 1, tamagoshi.getEnergy()),
                    () -> assertEquals(fun - 1, tamagoshi.getFun()),
                    () -> assertEquals(age + 1, tamagoshi.getAge()));
        }

        @Test
        void testEat() {
            int maxEnergy = tamagoshi.getMaxEnergy();
            int initialEnergy = tamagoshi.getEnergy();
            tamagoshi.eat();
            int newEnergy = tamagoshi.getEnergy();
            if (initialEnergy < maxEnergy)
                assertAll("eat",
                        () -> assertEquals(initialEnergy + 1, newEnergy),
                        () -> assertTrue(newEnergy <= maxEnergy));
            else
                assertAll("eat",
                        () -> assertEquals(initialEnergy, newEnergy));
        }

        @Test
        void testPlay() {
            int maxFun = tamagoshi.getMaxFun();
            int initialFun = tamagoshi.getFun();
            tamagoshi.play();
            int newFun = tamagoshi.getFun();
            assertAll("play",
                    () -> assertTrue(newFun >= initialFun && newFun <= initialFun + 3),
                    () -> assertTrue(newFun <= maxFun));
        }

        @Test
        void testActionIfAttributeIsMax() {
            tamagoshi.setFun(tamagoshi.getMaxFun());
            int initialFun = tamagoshi.getFun();
            tamagoshi.play();
            int newFun = tamagoshi.getFun();
            assertAll("eatIfAttributeIsMax",
                    () -> assertEquals(initialFun, newFun),
                    () -> assertTrue(newFun <= tamagoshi.getFun()));
        }

    }

    @Nested
    class BigEaterTest {

        @BeforeEach
        void setUp() {
            tamagoshi = TamagoshisFactory.createTamagoshis("BigEater", "Paul");
        }

        @Test
        void testPassTime() {
            int energy = tamagoshi.getEnergy();
            int fun = tamagoshi.getFun();
            int age = tamagoshi.getAge();
            tamagoshi.passTime();
            assertAll("passTime",
                    () -> assertEquals(energy - 1, tamagoshi.getEnergy()),
                    () -> assertEquals(fun - 1, tamagoshi.getFun()),
                    () -> assertEquals(age + 1, tamagoshi.getAge()));
        }

        @Test
        void testPlay() {
            int maxFun = tamagoshi.getMaxFun();
            int initialFun = tamagoshi.getFun();
            tamagoshi.play();
            int newFun = tamagoshi.getFun();
            if (initialFun < maxFun)
                assertAll("play",
                        () -> assertEquals(initialFun + 1, newFun),
                        () -> assertTrue(newFun <= maxFun));
            else
                assertAll("play",
                        () -> assertEquals(initialFun, newFun));
        }

        @Test
        void testEat() {
            int maxEnergy = tamagoshi.getMaxEnergy();
            int initialEnergy = tamagoshi.getEnergy();
            tamagoshi.eat();
            int newEnergy = tamagoshi.getEnergy();
            assertAll("eat",
                    () -> assertTrue(newEnergy >= initialEnergy && newEnergy <= initialEnergy + 3),
                    () -> assertTrue(newEnergy <= maxEnergy));
        }

        @Test
        void testActionIfAttributeIsMax() {
            tamagoshi.setEnergy(tamagoshi.getMaxEnergy());
            int initialEnergy = tamagoshi.getEnergy();
            tamagoshi.eat();
            int newEnergy = tamagoshi.getEnergy();
            assertAll("eatIfAttributeIsMax",
                    () -> assertEquals(initialEnergy, newEnergy),
                    () -> assertTrue(newEnergy <= tamagoshi.getEnergy()));
        }

    }

}
