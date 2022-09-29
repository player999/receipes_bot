package org.telegram;

public class BotConfig {
    public static String getToken() {
        return System.getenv("TELEGRAM_TOKEN");
    }

    public static String getUser() {
        return System.getenv("TELEGRAM_USERNAME");
    }
}