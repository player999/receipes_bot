package org.telegram.commands;

import org.apache.commons.codec.binary.StringUtils;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
public class StartCommand extends BotCommand {
    public StartCommand() {
        super("start", "With this command you can start the Bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Привіт, ").append(user.getUserName()).append("! ");
        messageBuilder.append("Це бот з рецептами, розроблений в процесі вивчення ознайомчого курсу по Java в GoIT. ");
        messageBuilder.append("На разі у для вас є тільки один рецепт. Рецепт залупянки. ");
        messageBuilder.append("Ви можете його отримати надрукувавши репліку \"залупянка\" або виконавши команду /zalupa");

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText(messageBuilder.toString());

        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            System.out.println(e);
        }
    }
}