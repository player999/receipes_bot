package java_telega;

import org.apache.commons.codec.binary.StringUtils;
import org.telegram.BotConfig;
import org.telegram.commands.ZalupaCommand;
import org.telegram.commands.HelpCommand;
import org.telegram.commands.StartCommand;
import org.telegram.commands.ZalupaMessage;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Receipes extends TelegramLongPollingCommandBot {
    public Receipes() {
        super();

        register(new ZalupaCommand());
        register(new StartCommand());
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);

        registerDefaultAction((absSender, message) -> {
            SendMessage commandUnknownMessage = new SendMessage();
            commandUnknownMessage.setChatId(message.getChatId());
            commandUnknownMessage.setText("The command '" + message.getText() + "' is not known by this bot. Here comes some help :)");
            try {
                absSender.execute(commandUnknownMessage);
            } catch (TelegramApiException e) {
                System.out.println(e);
            }
            helpCommand.execute(absSender, message.getFrom(), message.getChat(), new String[] {});
        });
    }

    @Override
    public void processNonCommandUpdate(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                SendMessage echoMessage;
                String received_text = message.getText();
                if(received_text.equalsIgnoreCase("Залупянка")) {
                    echoMessage = ZalupaMessage.getMessage();
                } else {
                    echoMessage = new SendMessage();
                    echoMessage.setText("Ось ваше повідомлення:\n" + message.getText());
                }
                echoMessage.setChatId(message.getChatId());

                try {
                    execute(echoMessage);
                } catch (TelegramApiException e) {
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public String getBotToken() {
        return BotConfig.getToken();
    }

    @Override
    public String getBotUsername() {
        return BotConfig.getUser();
    }
}