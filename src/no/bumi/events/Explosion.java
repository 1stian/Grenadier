package events;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.entity.player.PlayerDropItemEvent;
import org.spongepowered.api.event.entity.player.PlayerEvent;
import org.spongepowered.api.text.Texts;
import util.HashLists;

/**
 * Created by Stian on 07.06.2015.
 */
public class Explosion {

    @Subscribe
    public void Explosion(PlayerDropItemEvent e){
        //This void will contain all the explosion code!
        Player player = e.getUser();
        String stringPlayer = e.getUser().getName().toString();
        if (HashLists.checkMap(stringPlayer)){
            player.sendMessage(Texts.of("You just dropped something??!"));
        }
    }
}
