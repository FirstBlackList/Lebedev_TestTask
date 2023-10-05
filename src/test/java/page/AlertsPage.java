package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AlertsPage {
    private final SelenideElement AFW_Element = $x("//div[@class='left-pannel']//div[contains(text(), '& Windows')]");
    private final SelenideElement tabAlert = $x("//li/span[text()='Alerts']");
    private final SelenideElement alertButton = $("[id='alertButton']");
    private final SelenideElement timeAlertButton = $("[id='timerAlertButton']");
    private final SelenideElement confirmButton = $("[id='confirmButton']");
    private final SelenideElement successMessageConfirm = $x("//span[@id='confirmResult']");
    private final SelenideElement promtButton = $("[id='promtButton']");
    private final SelenideElement successMessagePromt = $x("//span[@id='promptResult']");

    private void clickCardAlertsFrameWindows() {
        AFW_Element.scrollIntoView(true).click();
    }

    private void clickElementAlert() {
        clickCardAlertsFrameWindows();
        tabAlert.scrollIntoView(true).click();
    }

    public void clickAlertButtonAndCloseAlert_() {
        clickElementAlert();
        alertButton.click();
        Selenide.switchTo().alert().accept();
    }

    public void clickTimeAlertButtonAndCloseAlert() {
        clickElementAlert();
        timeAlertButton.click();
        Selenide.switchTo().alert(Duration.ofSeconds(7)).accept();
    }

    public void clickConfirmButtonAndSuccessMessage() {
        clickElementAlert();
        confirmButton.click();
        Selenide.switchTo().alert().accept();
        successMessageConfirm.shouldHave(Condition.text("You selected Ok"),
                Duration.ofSeconds(4));
    }

    public void clickPromtButtonAndInputText(String message) {
        clickElementAlert();
        promtButton.click();
        Selenide.switchTo().alert().sendKeys(message);
        Selenide.switchTo().alert().accept();
        successMessagePromt.shouldHave(Condition.text("You entered " + message),
                Duration.ofSeconds(4));
    }

}
