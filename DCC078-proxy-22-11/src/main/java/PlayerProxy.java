import java.util.List;

public class PlayerProxy implements IPlayer {
    private Player player;
    private Integer id;

    public PlayerProxy(Integer id){
        this.id= id;
    }

    @Override
    public List<String> getAttributes(){
        if(this.player == null){
            this.player = new Player(this.id);
        }
        return this.player.getAttributes();
    }

    @Override
    public Float getCurrentMoney(Staff staff){
        if(!staff.isAdmin()){
            throw new IllegalArgumentException("User not authorized");
        }
        if(this.player == null){
            this.player = new Player(this.id);
        }
        return this.player.getCurrentMoney(staff);
    }
}
