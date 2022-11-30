import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerProxyTest {

    @BeforeEach
    void setUp(){
        Database.addPlayer(new Player(1, "Player 1", 200.3f, 100.0f, 55.1f));
        Database.addPlayer(new Player(2, "Player 2", 400.3f, 50.0f, 300.1f));
    }

    @Test
    void shouldBeReturnAttributes() {
        PlayerProxy player = new PlayerProxy(1);

        assertEquals(Arrays.asList("Player 1", 200.3f, 100.0f), player.getAttributes());
    }

    @Test
    void shouldBeReturnCurrentMoneyPlayer() {
        Staff staff  = new Staff("Mark", true);
        PlayerProxy player = new PlayerProxy(2);

        assertEquals(300.1f, player.getCurrentMoney(staff));
    }

    @Test
    void shouldBeReturnExceptionUserNotAuthorized(){
        try{
            Staff staff = new Staff("Storm", false);
            PlayerProxy player = new PlayerProxy(2);

            player.getCurrentMoney(staff);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("User not authorized", e.getMessage());
        }
    }
}