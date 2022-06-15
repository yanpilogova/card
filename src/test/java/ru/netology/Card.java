package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;


import static com.codeborne.selenide.Selenide.*;

public class Card {

    @Test
    void shouldCardApplication() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1600x900";
        open("http://localhost:9999");
        $("[data-test-id = name] input").setValue("Иванова Анна");
        $("[data-test-id = phone] input").setValue("+79993331122");
        $("[data-test-id = agreement]").click();
        $("[type = button]").click();
        $("[data-test-id = order-success]").shouldHave(Condition.text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."), Duration.ofSeconds(15));
    }
}
