import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<Integer, Player> players = new HashMap<>();

    public static Player getPlayer(Integer id){
        return players.get(id);
    }

    public static void addPlayer(Player player){
        players.put(player.getId(), player);
    }
}
