package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonsPage {
    private final SelenideElement buttonElement = $x("//li/span[text()='Buttons']");
    private final SelenideElement dynamicButton = $x("//div[@class='mt-4']/button[not(contains(text(),'Right'))]");
    private final SelenideElement messageDynamic = $("[id='dynamicClickMessage']");
    private final SelenideElement rightMouseClick = $("[id='rightClickBtn']");
    private final SelenideElement messageRight = $("[id='rightClickMessage']");
    private final SelenideElement doubleClickButton = $("[id='doubleClickBtn']");
    private final SelenideElement messageDouble = $("[id='doubleClickMessage']");

    private void clickCardButton() {
        buttonElement.scrollIntoView(true).click();
    }

    public void pressingButtonsAndCheckingMessages() {
        clickCardButton();
        dynamicButton.click();
        messageDynamic.shouldHave(Condition.text("You have done a dynamic click")
                , Duration.ofSeconds(5));
        rightMouseClick.contextClick();
        messageRight.shouldHave(Condition.text("You have done a right click")
                , Duration.ofSeconds(5));
        doubleClickButton.doubleClick();
        messageDouble.shouldHave(Condition.text("You have done a double click")
                , Duration.ofSeconds(5));
    }

}
