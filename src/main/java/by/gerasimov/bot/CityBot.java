package by.gerasimov.bot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:telegram.properties")
public class CityBot extends TelegramLongPollingBot {

    @Value("${by.gerasimov.bot.name}")
    private String botName;

    @Value("${by.gerasimov.bot.token}")
    private String botToken;

    @Autowired
    private BotContext context;

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText() || update.getMessage().isCommand()) {
            return;
        }
        long chatId = update.getMessage().getChatId();
        context.collectUserData(chatId);
        String input = update.getMessage().getText();
        List<String> infos = context.getInfoListByCityName(input);
        for (String info : infos) {
            sendMessage(chatId, info);
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage(chatId, text);
        message.setParseMode("HTML");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
