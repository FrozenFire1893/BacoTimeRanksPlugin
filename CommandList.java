package frozenfire1893.timedranks;

import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandList {
    public static CommandSpec TimedRanks = CommandSpec.builder()
            .description(Text.of("Display Baco Timed ranks with their color!"))
            .arguments(
                    GenericArguments.optional(GenericArguments.string(null)))
            .executor(new TimedRanksCommand()).build();
}
