package org.telegram.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ZalupaMessage {
    public static SendMessage getMessage() {
        SendMessage answer = new SendMessage();
        StringBuilder messageTextBuilder = new StringBuilder("4 яйця змішуємо з 4 ложками крохмалю, додаємо трохи солі та " +
                "збиваємо, щоб не було грудочок. Потім доводимо до кипіння склянку молока і додаємо ту суміш, щоб " +
                "заварилася. Якщо сім'я була багата, додавали ще й  олії. Але можна й без неї. Заварюємо " +
                "це все, а зверху додаємо засмажене сало. Готово. У залупянку мачали млинці чи хліб. Дуже смачно.");

        answer.setText(messageTextBuilder.toString());

        return answer;
    }
}
