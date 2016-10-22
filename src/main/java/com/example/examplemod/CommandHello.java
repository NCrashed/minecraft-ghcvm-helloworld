package com.example.examplemod;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by ncrashed on 9/29/16.
 */
public class CommandHello implements ICommand {
    private final List aliases;

    public CommandHello() {
        aliases = new ArrayList();
        aliases.add("hello");
    }

    @Override
    public String getCommandName() {
        return "hello";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "hello name";
    }

    @Override
    public List<String> getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();

        if (!world.isRemote) {
            String v = ExampleMod.HASKELL.sayHello("NCrashed");
            sender.addChatMessage(new TextComponentString(v));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return new ArrayList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand iCommand) {
        return 0;
    }
}
