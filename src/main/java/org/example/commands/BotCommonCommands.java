package org.example.commands;

public class BotCommonCommands {
    @AppBotCommand(name = "/hello", description = "when request hello", showInHelp = true)
    String hello () {
        return "Hello! Haven't seen you for ages!";
    }
    @AppBotCommand(name = "/bye", description = "when request bye", showInHelp = true)
    String bye() {
        return "Are you going? Return soon)";
    }
    @AppBotCommand(name = "/help", description = "when request help", showInKeyboard = true)
    String help() {
        return "You have used /help command. Later here might be all available bot commands";
    }

}
