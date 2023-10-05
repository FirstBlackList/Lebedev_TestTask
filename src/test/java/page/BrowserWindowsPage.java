package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BrowserWindowsPage {
    private final SelenideElement AFW_Element = $x("//div[@class='left-pannel']//div[contains(text(), '& Windows')]");
    private final SelenideElement tabBrowserWindows = $x("//div[@class='element-list collapse show']//li[@id='item-0']");
    private final SelenideElement newTabButton = $("[id='tabButton']");
    private final SelenideElement messageNewWindow = $x("//h1");
    private final SelenideElement newWindowButton = $("[id='windowButton']");

    private void clickCardAlertsFrameWindows() {
        AFW_Element.scrollIntoView(true).click();
    }

    private void clickElementBrowserWindow() {
        clickCardAlertsFrameWindows();
        tabBrowserWindows.shouldBe(visible, Duration.ofSeconds(5)).click();
    }

    public BrowserWindowsPage openingAndClosingANewPageTab() {
        clickElementBrowserWindow();
        newTabButton.click();
        switchTo().window(1);
        messageNewWindow.shouldHave(Condition.text("This is a sample page"), Duration.ofSeconds(4));
        switchTo().window(1).close();
        switchTo().window(0);
        return this;
    }

    public void openAndCloseANewWindow() {
        clickElementBrowserWindow();
        newWindowButton.click();
        switchTo().window(1).close();
        switchTo().window(0);
    }

}
