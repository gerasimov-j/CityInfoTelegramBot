package by.gerasimov.bot;

import by.gerasimov.model.City;
import by.gerasimov.model.User;
import by.gerasimov.service.CityService;
import by.gerasimov.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BotContext {

    public static final String MESSAGE_NOT_INFO = "Про этот город нет ничего интересного";
    public static final String MESSAGE_NOT_FOUND = "Извините, такой город не найден в нашей базе. Проверьте, скорее всего такого города не существует";
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;

    public List<String> getInfoListByCityName(String cityName) {
        List<City> cities = cityService.findAllByName(cityName);
        List<String> infos = new ArrayList<>();
        if (cities.isEmpty()) {
            infos.add(toFormatMessage(cityName, MESSAGE_NOT_FOUND));
        } else {
            for (City city : cities) {
                infos.add(getFormatInfo(city));
            }
        }
        return infos;
    }

    public String getFormatInfo(City city) {
        StringBuilder title = new StringBuilder();
        String info = city.getInfo();
        if (info == null || info.trim().equals("")) {
            info = BotContext.MESSAGE_NOT_INFO;
        }
        title.append(city.getName()).append(", ").append(city.getCountryName()).append(city.getCountryEmojiCode());
        return toFormatMessage(title.toString(), info);
    }

    private String toFormatMessage(String title, String text) {
        StringBuilder out = new StringBuilder();
        out.append("<b>").append(title).append("</b>").append('\n').append(text);
        return out.toString();
    }

    public void collectUserData(long chatId) {
        User user = userService.findByChatId(chatId);
        if (user == null) {
            user = new User();
            user.setChatId(chatId);
        }
        user.increaseQueryCount();
        userService.save(user);
    }
}
