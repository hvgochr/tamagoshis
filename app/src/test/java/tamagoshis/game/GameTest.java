package tamagoshis.game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;

public class GameTest {

    @Mock
    private BufferedReader reader;

    private Game game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game = spy(new Game());
        game.setReader(this.reader);
    }

    @Test
    public void testInitGame() throws IOException {
        when(this.reader.readLine()).thenReturn("3").thenReturn("Pierre").thenReturn("Paul").thenReturn("Jacques");
        this.game.setIsRunning(false);
        this.game.play();
        verify(this.reader, times(4)).readLine();
        assertAll("GameInit",
                () -> assertEquals(1, this.game.getRound()),
                () -> assertEquals(3, this.game.getAliveTamagoshis().size()),
                () -> assertEquals(0, this.game.getDeadTamagoshis().size()),
                () -> assertEquals(3, this.game.getNbTamagoshis()),
                () -> assertEquals("Pierre", this.game.getAliveTamagoshis().get(0).getName()),
                () -> assertEquals("Paul", this.game.getAliveTamagoshis().get(1).getName()),
                () -> assertEquals("Jacques", this.game.getAliveTamagoshis().get(2).getName()));
    }

}
