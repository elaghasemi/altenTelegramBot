package learnswedish.handler;

public class LookupHandler {

    public static CommandHandler getHandler(String command) {
        if (command.equals("/showlessons")) {
            return new ShowLessonsHandler();
        } else if (command.equals("/callaback")) {
            return new CallableHandler();
        }
        return null;
    }
}