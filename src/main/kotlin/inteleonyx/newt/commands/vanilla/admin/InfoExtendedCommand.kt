package inteleonyx.newt.commands.vanilla.admin

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.text.NumberFormat.Field.PREFIX

class InfoExtendedCommand : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message.contentRaw
        if (message.startsWith(".info_extended")) {
            if (event.author.isBot) return
            event.message.channel.sendMessage("")
        }
    }
}