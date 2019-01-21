package learnswedish.handler;

import learnswedish.domain.Lesson;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class ShowLessonsHandler implements CommandHandler {

    private static final String WELCOME_MSG = "Wellcome ,Select the lesson you want to start";

    @Override
    public SendMessage executeCommand(Update update, List<Lesson> lessons) {
        SendMessage message = new SendMessage();
        message.setText(WELCOME_MSG);
        message.setChatId(update.getMessage().getChatId());
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        for (Lesson lesson : lessons) {
            List<InlineKeyboardButton> rowInline = new ArrayList<>();
            rowInline.add(new InlineKeyboardButton().setText("Lesson " + lesson.getId() + ": " + lesson.getName()).
                    setCallbackData(lesson.getId()));
            rowsInline.add(rowInline);
            markupInline.setKeyboard(rowsInline);
            message.setReplyMarkup(markupInline);
        }
        return message;
    }


}
