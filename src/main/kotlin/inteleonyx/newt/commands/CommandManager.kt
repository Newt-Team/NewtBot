package inteleonyx.newt.commands

import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData

class CommandManager : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        val commandData = mutableListOf<CommandData>()
        commandData.add(Commands.slash("ping", "Cheque a latência do Bot"))
        val infoSubcommand = SubcommandData("info", "Mostra as informações do servidor")
            .addOption(OptionType.STRING, "id", "O id do servidor que você quer ver as informações", false)
        val servidorCommand = Commands.slash("servidor", "Comandos relacionados ao servidor")
            .addSubcommands(infoSubcommand)
        commandData.add(servidorCommand)
        commandData.add(Commands.slash("avatar", "Veja o avatar de um usuário")
        .addOption(OptionType.USER, "user", "O usuário que você quer ver o avatar", false))

        event.jda.updateCommands().addCommands(commandData).queue()
    }
}
