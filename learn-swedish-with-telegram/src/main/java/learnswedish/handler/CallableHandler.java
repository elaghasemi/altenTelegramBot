package learnswedish.handler;

import learnswedish.domain.Lesson;
import learnswedish.domain.SwedishWord;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Optional;

public class CallableHandler implements CommandHandler {

    @Override
    public SendMessage executeCommand(Update update, List<Lesson> lessons) {
        String call_data = update.getCallbackQuery().getData();
        long chat_id = update.getCallbackQuery().getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
        Optional<Lesson> matchingObject = lessons.stream().filter(p -> p.getId().equals(call_data)).
                findFirst();
        Lesson lesson = matchingObject.get();
        String textMsg = lesson.getName() + ":\n-------------------------\n";
        int index = 1;
        for (SwedishWord swedishWord : lesson.getWords()) {
            textMsg += index++ + ") " + swedishWord.getSwedishWord() + " = " +
                    swedishWord.getEnglishWord() + "\n\n";

        }
        sendMessage.setText(textMsg);
        return sendMessage;
    }


}
