import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.kyori.adventure.text.Component
import net.lucypoulton.squirtgun.command.node.NodeBuilder
import net.lucypoulton.squirtgun.discord.DiscordFormatProvider
import net.lucypoulton.squirtgun.discord.DiscordPlatform
import net.lucypoulton.squirtgun.discord.DiscordUser
import net.lucypoulton.squirtgun.discord.command.DiscordConditions.DISCORD_USER
import net.lucypoulton.squirtgun.discord.command.DiscordConditions.NO_BOTS
import net.lucypoulton.squirtgun.discord.standalone.StandaloneDiscordPlatform

class Application {
    private val jda: JDA = JDABuilder.createDefault("token").build()
    private val platform: DiscordPlatform

    init {
        platform = StandaloneDiscordPlatform(jda, "-") // that last hyphen is your command prefix

        // register commands like this
        platform.registerCommand(
            // this type param isn't important in this context, just stick with DiscordUser
            NodeBuilder<DiscordUser>()
                .name("example")
                .description("Example command")
                .condition(DISCORD_USER.and(NO_BOTS)) // DO NOT FORGET THIS! - see Condition and DiscordConditions
                .executes { Component.text("hello world!") }
                .build(),
            DiscordFormatProvider.INSTANCE
        )
    }

}