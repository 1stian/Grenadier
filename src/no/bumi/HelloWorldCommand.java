        import org.spongepowered.api.text.Texts;
        import org.spongepowered.api.util.command.CommandException;
        import org.spongepowered.api.util.command.CommandResult;
        import org.spongepowered.api.util.command.CommandSource;
        import org.spongepowered.api.util.command.args.CommandContext;
        import org.spongepowered.api.util.command.spec.CommandExecutor;

/**
 * Created by Stian on 03.06.2015.
 */
public class HelloWorldCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException{
        src.sendMessage(Texts.of("Hello World!"));
        return  CommandResult.success();
    }
}
