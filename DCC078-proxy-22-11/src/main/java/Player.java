import java.util.Arrays;
import java.util.List;

public class Player implements IPlayer {
    private Integer id;
    private String name;
    private Float damage;
    private Float hp;
    private Float currentMoney;

    public Player(int id){
        this.id = id;
        Player object = Database.getPlayer(id);
        this.name = object.name;
        this.hp = object.hp;
        this.currentMoney = object.currentMoney;
        this.damage = object.damage;
    }

    public Player(Integer id, String name, Float damage, Float hp, Float currentMoney){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.currentMoney = currentMoney;
        this.hp = hp;
    }

    @Override
    public List<String> getAttributes(){
        return Arrays.asList(this.name, this.damage.toString(), this.hp.toString());
    }

    @Override
    public Float getCurrentMoney(Staff staff){
        return this.currentMoney;
    }

    public Integer getId() {
        return id;
    }
}
