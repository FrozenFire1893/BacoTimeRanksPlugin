package frozenfire1893.timedranks;

import javafx.scene.control.Pagination;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

import java.util.ArrayList;
import java.util.List;

public class TimedRanksCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof ConsoleSource) {
            throw new CommandException(Text.of(TextColors.RED, "You need to be a player to run this command!"));
        }

        Player player = (Player) src;

        String[] Ranks = {"Amateur", "Experienced", "Well-Known", "Addicted", "Overlord", "Omega", "No-Life", "Hacks"};
        String[] Hours = {"10 Hours", "20 Hours", "50 Hours", "150 hours", "200 Hours", "500 Hours", "800 Hours", "1500 Hours"};
        TextColor[] RankColors = {TextColors.LIGHT_PURPLE, TextColors.GREEN, TextColors.RED, TextColors.YELLOW, TextColors.BLUE, TextColors.DARK_GREEN, TextColors.DARK_RED, TextColors.DARK_PURPLE};

        List<Text> texts = new ArrayList<>();
        //We defined the builder here
        for (int i = 0; i < Ranks.length; i++) {
            texts.add(Text.builder()
                    .append(Text.builder()
                            .color(RankColors[i])
                            .append(Text.of(" - " + Hours[i]))
                            .build())
                    .build());
        }
        return CommandResult.success();
    }
}

