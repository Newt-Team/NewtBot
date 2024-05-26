package inteleonyx.newt.commands.vanilla.admin

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class LeaveCommand : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message.contentRaw
        if (message.startsWith(".leave")) {
            if (event.author.id == "1012456421641703555") {
                val guildId = message.replace(".leave", "").trim()
                val guild = event.jda.getGuildById(guildId)

                if (guild != null) {
                    guild.leave().queue()
                    event.channel.sendMessage("Deixei o servidor `${guild.name}`.").queue()
                } else {
                    event.channel.sendMessage("Não achei o servidor ou eu não estou nele.").queue()
                }
            }
        }
    }
}