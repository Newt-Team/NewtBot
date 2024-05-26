package inteleonyx.newt.commands.vanilla.discord

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class PingCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val command = event.name
        if (command == "ping") {
            val latency = event.jda.gatewayPing
            val embed = EmbedBuilder()
            embed.setTitle("Pong! 🏓")
            embed.setDescription("Latência: `${latency}ms`")
            embed.setColor(11499358)
            event.replyEmbeds(embed.build()).queue()
        }
    }
}