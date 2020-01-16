package frozenfire.bacotimeranksplugin;

import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandList {
    public static CommandSpec TimedRanks = CommandSpec.builder()
            .description(Text.of("Display Baco Timed ranks with their color!"))
            .executor(new TimedRanksCommand()).build();
}