package learnswedish.server;

import learnswedish.config.BotConfig;
import learnswedish.domain.Lesson;
import learnswedish.handler.LookupHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class BotServer extends TelegramLongPollingBot {

    private List<Lesson> lessons;

    public BotServer(List<Lesson> lessons) {
        this.lessons = lessons;
    }


    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = null;
        if (update.hasMessage() && update.getMessage().hasText() &&
                update.getMessage().getText().equals("/showlessons")) {

            sendMessage = LookupHandler.getHandler("/showlessons").
                    executeCommand(update, lessons);

        } else if (update.hasCallbackQuery()) {
            sendMessage = LookupHandler.getHandler("/callaback").
                    executeCommand(update, lessons);
        } else {
            sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            sendMessage.setText("Enter the correct command pleas :)");
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }


}
