package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FirstPage {
    private final SelenideElement title = $("[class='home-content']");
    private final SelenideElement cardElement = $x("//div//h5[text()='Elements']");

    public FirstPage() {
        title.shouldHave(Condition.visible, Duration.ofSeconds(8));
    }

    public void checkedCardElements() {
        cardElement.scrollIntoView(true).click();
    }
}
