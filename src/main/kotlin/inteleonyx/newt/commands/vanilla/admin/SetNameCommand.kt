package inteleonyx.newt.commands.vanilla.admin

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SetNameCommand : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message.contentRaw
        if (message.startsWith(".setname")) {
            if (event.author.id == "1012456421641703555") {
                val newName = message.replace(".setname", "").trim()

                if (newName.isNotEmpty()) {
                    event.jda.selfUser.manager.setName(newName).queue {
                        event.channel.sendMessage("Nome do bot alterado para `$newName`.").queue()
                    }
                } else {
                    event.channel.sendMessage("Por favor, forneça um novo nome para o bot.").queue()
                }
            }
        }
    }
}