package uk.co.hoovy.scpMessage.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;
import java.util.Random;

public class PlayerDeath implements Listener {
    public PlayerDeath() {
    }

    @EventHandler
    void onPlayerDeath(PlayerDeathEvent e) {
        String DeathPrefix = "Death: ";
        Component player_Name = e.getEntity().displayName();
        String deathmsg = Objects.requireNonNull(e.deathMessage()).toString().toLowerCase();
        if (deathmsg.contains("drown")) {
            TextComponent Changed_Death_Messaged = Component.text(DeathPrefix).append(player_Name).append(Component.text(" recognized the bodies in the water").clickEvent(ClickEvent.openUrl("https://scp-wiki.wikidot.com/scp-2316")));
            e.deathMessage(Changed_Death_Messaged);
        } else if (deathmsg.contains("world")) {
            TextComponent Changed_Death_Messaged = Component.text(DeathPrefix).append(player_Name).append(Component.text(" swum with the glow-squids").clickEvent(ClickEvent.openUrl("https://hoovy.co.uk/death/")));
            e.deathMessage(Changed_Death_Messaged);
        } else if (deathmsg.contains("enderman")) {
            TextComponent Changed_Death_Messaged = Component.text(DeathPrefix).append(player_Name).append(Component.text(" Let SCP-4335 breach containment!").clickEvent(ClickEvent.openUrl("https://scp-wiki.wikidot.com/scp-4335"))); // SCP-4335
            e.deathMessage(Changed_Death_Messaged);
        }
        System.out.println("found death!");

    }
}
