package tamagoshis.game;

public class RoundTest {

    package tamagoshis.game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tamagoshis.model.Tamagoshis;
import tamagoshis.model.TamagoshisFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoundTest {

    @Mock
    private BufferedReader reader;

    private List<Tamagoshis> aliveTamagoshis;
    private Round round;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.aliveTamagoshis = new ArrayList<Tamagoshis>();
        this.aliveTamagoshis.add(TamagoshisFactory.createTamagoshis("BigEater", "Pierre"));
        this.aliveTamagoshis.add(TamagoshisFactory.createTamagoshis("BigPlayer", "Paul"));
        this.round = new Round(1, this.aliveTamagoshis);
    }

    @Test
    public void testPlayRound() throws IOException {
        when(this.reader.readLine()).thenReturn("0").thenReturn("1");
        this.round.setReader(this.reader);
        this.round.playRound();
        verify(this.reader, times(2)).readLine();
    }

    @Test
    public void testStatsAfter1Round() throws IOException {
        int initialEnergyTamagoshi1 = this.aliveTamagoshis.get(0).getEnergy();
        int initialFunTamagoshi2 = this.aliveTamagoshis.get(1).getFun();
        when(this.reader.readLine()).thenReturn("0").thenReturn("1");
        this.round.setReader(this.reader);
        this.round.playRound();
        verify(this.reader, times(2)).readLine();
        int newEnergyTamagoshi1 = this.aliveTamagoshis.get(0).getEnergy();
        int newFunTamagoshi2 = this.aliveTamagoshis.get(1).getFun();
        assertAll("Tamagoshis",
            () -> assertTrue(newEnergyTamagoshi1 >= initialEnergyTamagoshi1 && newEnergyTamagoshi1 <= initialEnergyTamagoshi1 + 3),
            () -> assertTrue(newFunTamagoshi2 >= initialFunTamagoshi2 && newFunTamagoshi2 <= initialFunTamagoshi2 + 3)
        );
    }

}

    
}
