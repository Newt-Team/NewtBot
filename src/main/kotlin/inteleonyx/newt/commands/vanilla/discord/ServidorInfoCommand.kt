package inteleonyx.newt.commands.vanilla.discord

import inteleonyx.newt.NewtBot.Companion.NewtClient
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.format.DateTimeFormatter

class ServidorInfoCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val command = event.name
        if (command == "servidor") {
            when (event.subcommandName) {
                "info" -> {
                    val guildIdOption = event.getOption("id")?.asString
                    val guildId = guildIdOption ?: event.guild?.id
                    fun getFormattedGuildCreationDate(guild: Guild): String {
                        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        return guild.timeCreated.format(formatter)
                    }
                    if (guildId != null) {
                        val guild = NewtClient.getGuildById(guildId)
                        if (guild != null) {
                            val embed = EmbedBuilder()
                                .setTitle(guild.name)
                                .setThumbnail(guild.iconUrl)
                                .addField("<:id:1244007000400990350> ID", "`${guild.id}`", true)
                                .addField(":crown: Dono", "${guild.owner?.user?.name ?: "Desconhecido"} (${guild.owner?.user?.id ?: "Desconhecido"})", true)
                                .addField(":gem: ShardID", "${event.jda.shardInfo.shardId}", true)
                                .addField(":calendar_spiral: Data em que foi criado", getFormattedGuildCreationDate(guild), true)
                                .addField(":star2: Quantidade de Membros", "${guild.memberCount}", true)
                                .addField(":rocket: Quantidade de Boosts", "${guild.boostCount} Boosts", true)
                                .setColor(11499358)
                            event.replyEmbeds(embed.build()).queue()
                        } else {
                            event.reply("❎ O servidor com o ID `${guildId}` não foi encontrado.").setEphemeral(true).queue()
                        }
                    } else {
                        event.reply("❎ O ID do servidor não foi fornecido e o evento não foi executado em um servidor.").setEphemeral(true).queue()
                    }
                }
            }
        }
    }
}