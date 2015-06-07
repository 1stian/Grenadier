/**
 * Created by Stian on 03.06.2015.
 */
import com.google.inject.Inject;
import commands.Explode;
import events.Explosion;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.spec.CommandSpec;

@Plugin(id = "Grenadier", name = "Grenadier", version = "1.0")
public class Grenadier {
    @Inject
    public Logger logger;

    @Inject
    private Game game;

    @Subscribe
    public void onServerStart(ServerStartedEvent event) {
        startPrint();
        loadCommands();
        registerEvents();
    }

    public void loadCommands(){
        CommandService cmd = game.getCommandDispatcher();

        CommandSpec cmdHello = CommandSpec.builder()
                .description(Texts.of("Hello world command"))
                .executor(new HelloWorldCommand())
                .build();

        CommandSpec cmdGrenade = CommandSpec.builder()
                .description(Texts.of("Enables or disables snowball explosions."))
                .permission("grenadier.explode")
                .executor(new Explode()).build();


        cmd.register(this, cmdHello, "helloworld", "hello", "Test");
        cmd.register(this, cmdGrenade, "grenadier", "grenade");
    }

    public void registerEvents(){
        game.getEventManager().register(this, new Explosion());
    }

    public void startPrint(){
        logger.info("Grenadier has started.");
        logger.info("<--------------------------------------->");
        logger.info("Grenadier was created by MightyBumi");
        logger.info("<--------------------------------------->");
    }
}
