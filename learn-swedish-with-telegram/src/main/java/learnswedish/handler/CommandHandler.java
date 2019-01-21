package learnswedish.handler;

import learnswedish.domain.Lesson;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface CommandHandler {
    SendMessage executeCommand(Update update, List<Lesson> lesson);
}
