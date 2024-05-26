package inteleonyx.newt

import inteleonyx.newt.commands.CommandManager
import inteleonyx.newt.commands.vanilla.admin.LeaveCommand
import inteleonyx.newt.commands.vanilla.admin.SayCommand
import inteleonyx.newt.commands.vanilla.admin.ServersCommand
import inteleonyx.newt.commands.vanilla.admin.SetNameCommand
import inteleonyx.newt.commands.vanilla.discord.AvatarCommand
import inteleonyx.newt.commands.vanilla.discord.PingCommand
import io.github.cdimascio.dotenv.Dotenv
import inteleonyx.newt.commands.vanilla.discord.ServidorInfoCommand
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder

class NewtBot {
    companion object {
        val dotenv = Dotenv.load()
        val token = dotenv["token"]

        var NewtClient = DefaultShardManagerBuilder.createDefault(token)
            .setShardsTotal(1)
            .enableIntents(
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.GUILD_MESSAGE_TYPING,
                GatewayIntent.MESSAGE_CONTENT
            )
            .setActivity(Activity.watching("Inteleonville 🏡"))
            .addEventListeners(
                CommandManager(),
                PingCommand(),
                ServidorInfoCommand(),
                AvatarCommand(),
                ServersCommand(),
                LeaveCommand(),
                SetNameCommand(),
                SayCommand()
            )
            .build()

        @JvmStatic
        fun main(args: Array<String>) {
            NewtClient.run {  }
        }
    }
}