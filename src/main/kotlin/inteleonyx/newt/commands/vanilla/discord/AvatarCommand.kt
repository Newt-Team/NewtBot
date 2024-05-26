package inteleonyx.newt.commands.vanilla.discord

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class AvatarCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val command = event.name
        if (command == "avatar") {
            val avatarOption = event.getOption("user")?.asUser
            if (avatarOption != null) {
                val embed = EmbedBuilder()
                embed.setTitle("Avatar de ${avatarOption.name}")
                embed.setImage(avatarOption.avatarUrl)
                embed.setColor(11499358)
                event.replyEmbeds(embed.build()).queue()
            }
            else {
                val user = event.user
                val embed = EmbedBuilder()
                embed.setTitle("Avatar de ${user.name}")
                embed.setImage(user.avatarUrl)
                embed.setColor(11499358)
                event.replyEmbeds(embed.build()).queue()
            }
        }
    }
}