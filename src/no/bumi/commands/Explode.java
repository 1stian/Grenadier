package commands;

import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.spec.CommandExecutor;
import util.HashLists;

/**
 * Created by Stian on 07.06.2015.
 */
public class Explode implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        String player = src.getName().toString();

        if (HashLists.checkMap(player)){
            HashLists.explodePut(player);
            src.sendMessage(Texts.of("Grenadier has been disabled!"));
        }else{
            HashLists.explodePut(player);
            src.sendMessage(Texts.of("Grenadier has been enabled!"));
        }
        return  CommandResult.success();
    }
}
