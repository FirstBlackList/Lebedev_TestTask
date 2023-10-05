package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ElementsPage {

    private final SelenideElement elementTextBox = $x("//li/span[text()='Text Box']");
    private final SelenideElement nameField = $("[id='userName']");
    private final SelenideElement emailField = $("[id='userEmail']");
    private final SelenideElement currentAddressField = $("[id='currentAddress']");
    private final SelenideElement permanentAddressField = $("[id='permanentAddress']");
    private final SelenideElement button = $x("//button[@id='submit']");
    private final SelenideElement dataForm = $("[id='output']");
    private final ElementsCollection collection = $$x("//div//p");

    public void fillingOutTheFormAndSending(String name, String email, String currentAs, String permanentAs) {
        elementTextBox.click();
        nameField.val(name);
        emailField.val(email);
        currentAddressField.val(currentAs);
        permanentAddressField.val(permanentAs);
        button.scrollTo().click();
        dataForm.scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(5));
    }

    private List<String> actualResultOfTheFormFields() {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < collection.size(); i++) {
            output.add(collection.get(i).getText());
        }
        return output;
    }

    public String actualResultFieldName() {
        List<String> actualData = actualResultOfTheFormFields();
        String name = actualData.get(0);
        return name.substring(name.indexOf(':') + 1);
    }

    public String actualResultFieldEmail() {
        List<String> actualData = actualResultOfTheFormFields();
        String email = actualData.get(1);
        return email.substring(email.indexOf(':') + 1);
    }

    public String actualResultFieldCurrentAddress() {
        List<String> actualData = actualResultOfTheFormFields();
        String currentAddress = actualData.get(2);
        return currentAddress.substring(currentAddress.indexOf(':') + 1);
    }

    public String actualResultFieldPermanentAddress() {
        List<String> actualData = actualResultOfTheFormFields();
        String permanentAddress = actualData.get(3);
        return permanentAddress.substring(permanentAddress.indexOf(':') + 1);
    }

}
