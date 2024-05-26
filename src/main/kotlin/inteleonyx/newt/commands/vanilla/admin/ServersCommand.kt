package inteleonyx.newt.commands.vanilla.admin

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class ServersCommand : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message.contentRaw
        if (message.startsWith(".servers")) {
            if (event.author.isBot) return
            if (event.author.id == "1012456421641703555") {
                val guilds = event.jda.guilds
                val guildInfo = guilds.joinToString("\n") { "`${it.name}` (${it.id})" }
                event.channel.sendMessage(guildInfo).queue()
            }
            else return
        }
    }
}