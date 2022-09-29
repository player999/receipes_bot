package org.telegram.commands;

import org.telegram.commands.ZalupaCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ZalupaCommand extends BotCommand {
    public ZalupaCommand() {
        super("zalupa", "Отримати рецепт залупянки");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage answer = ZalupaMessage.getMessage();
        answer.setChatId(chat.getId().toString());
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            System.out.println(e);
        }
    }
}