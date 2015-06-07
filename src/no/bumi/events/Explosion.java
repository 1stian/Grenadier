package events;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;
import org.spongepowered.api.data.*;
import org.spongepowered.api.data.manipulator.entity.ExplosiveRadiusData;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.entity.player.PlayerDropItemEvent;
import org.spongepowered.api.event.entity.player.PlayerEvent;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import util.HashLists;

import java.util.Collection;
import java.util.EnumSet;
import java.util.UUID;

/**
 * Created by Stian on 07.06.2015.
 */
public class Explosion {

    @Subscribe
    public void Explosion(PlayerDropItemEvent e){
        //This void will contain all the explosion code!
        final Player player = e.getUser();
        String stringPlayer = e.getUser().getName().toString();
        ProjectileSource ps;




        if (HashLists.checkMap(stringPlayer)){
            player.sendMessage(Texts.of("You just dropped something??!"));
            Location loc = player.getLocation();
            //ex.detonate();
        }
    }
}
