package frozenfire1893.timedranks;

import com.google.inject.Inject;
import ninja.leaping.configurate.objectmapping.Setting;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.pagination.PaginationService;

@Plugin(
        id = "timedranks",
        name = "Timedranks",
        authors = "FrozenFire1893"
)
public class Timedranks {

    public static Timedranks instance;

    @Inject
    private Logger logger;

    @Inject
    Game game;

    //make commands
    public void makeCommands()
    {
        Sponge.getCommandManager().register(instance, CommandList.TimedRanks, "timedranks");
    }

    //pagination service builder
    public PaginationService getPaginationService() {
        return game.getServiceManager().provide(PaginationService.class).get();
    }

    //text template builder

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
