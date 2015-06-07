package events;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import org.spongepowered.api.Game;
import org.spongepowered.api.data.*;
import org.spongepowered.api.data.manipulator.entity.ExplosiveRadiusData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.entity.ProjectileLaunchEvent;
import org.spongepowered.api.event.entity.player.PlayerDropItemEvent;
import org.spongepowered.api.event.entity.player.PlayerEvent;
import org.spongepowered.api.item.ItemBlock;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import util.HashLists;

/**
 * Created by Stian on 07.06.2015.
 */
public class Explosion {
    @Inject
    Game game;

    @Subscribe
    public void Explosion(ProjectileLaunchEvent e){
        //This void will contain all the explosion code!
        String player = e.getSource().toString();
        Optional<Player> plr = game.getServer().getPlayer(player);
        Player findPlayer = plr.get();

        Explosive ex = null;

        Projectile ps = e.getLaunchedProjectile();
        EntityType ball = EntityTypes.SNOWBALL;
        EntityType snow = ps.getType();

        findPlayer.sendMessage(Texts.of(ball.toString()));
        findPlayer.sendMessage(Texts.of(snow.toString()));
        findPlayer.sendMessage(Texts.of("Test from projectileEvent"));

        if (plr.isPresent()){
            findPlayer.sendMessage(Texts.of("Player is present"));
            if (HashLists.checkMap(player)){
                findPlayer.sendMessage(Texts.of("In hash"));
                if (snow == ball){
                    Location proLoc = ps.getLocation();
                    ex.setLocation(proLoc);
                    ex.detonate();
                }
            }
        }else{
            findPlayer.sendMessage(Texts.of("Not in hash"));
        }
    }
}
