package inteleonyx.newt.commands.vanilla.admin

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SayCommand : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message.contentRaw
        if (message.startsWith(".say")) {
            if (event.author.id == "1012456421641703555") {
                val args = message.substringAfter(".say").trim()
                if (args.isNotEmpty()) {
                    event.message.delete().queue()
                    event.channel.sendMessage(args).queue()
                }
                else {
                    event.channel.sendMessage("Você não forneceu nenhuma mensagem para repetir.").queue()
                }
            }
        }
    }
}