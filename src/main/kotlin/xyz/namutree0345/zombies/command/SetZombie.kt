package xyz.namutree0345.zombies.command

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import xyz.namutree0345.zombies.humanTeam
import xyz.namutree0345.zombies.superZombieTeam
import xyz.namutree0345.zombies.teams
import xyz.namutree0345.zombies.zombieTeam

class SetZombie : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if(args.isNotEmpty()) {
            if (sender.isOp) {
                if (humanTeam?.hasEntry(args[0]) == true) {
                    humanTeam?.removeEntry(args[0])
                    zombieTeam?.addEntry(args[0])
                    sender.sendMessage(Component.text("성공적으로 설정되었습니다!", NamedTextColor.RED))
                }
                if (superZombieTeam?.hasEntry(args[0]) == true) {
                    superZombieTeam?.removeEntry(args[0])
                    zombieTeam?.addEntry(args[0])
                    sender.sendMessage(Component.text("성공적으로 설정되었습니다!", NamedTextColor.RED))
                }
                teams[Bukkit.getPlayerUniqueId(args[0])!!] = "zombie"
            }

        }

        return true

    }
}