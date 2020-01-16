package frozenfire.bacotimeranksplugin;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.pagination.PaginationService;

@Plugin(
        id = "bacotimeranksplugin",
        name = "BacoTimeRanksPlugin",
        description = "Shiny ranks",
        authors = {
                "Frozen"
        }
)
public class BacoTimeRanksPlugin {

    public static BacoTimeRanksPlugin instance;

    @Inject
    private Logger logger;

    @Inject
    Game game;

    //make commands
    public void makeCommands()
    {
        Sponge.getCommandManager().register(instance, CommandList.TimedRanks, "timedranks");
    }

    //on game initialization
    @Listener
    public void onInit(GameInitializationEvent event) {
        instance = this;
    }

    //on game stop
    @Listener
    public void onServerStopping(GameStoppedServerEvent event) {
        logger.info("Stopped Timed Ranks successfully");
    }

    //on game start
    @Listener
    public void onServerStarting(GameStartedServerEvent event) {
        logger.info("Timed Ranks started successfully");
        makeCommands();
    }

}
