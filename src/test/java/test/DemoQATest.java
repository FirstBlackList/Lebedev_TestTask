package test;

import data.CreateData;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import page.*;


public class DemoQATest extends PreparingForTests {

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Выполняется заполнение формы, отправка формы и проверка, что данные в блоке сохранены корректно")
    public void returnCorrectlyDisplayedDataAfterFillingOutTheForm() {

        String name = CreateData.getValidName();
        String email = CreateData.getEmail();
        String currentAddress = CreateData.getCurrentAddress();
        String permanentAddress = CreateData.getPermanentAddress();

        new FirstPage().checkedCardElements();
        new ElementsPage().fillingOutTheFormAndSending(
                name,
                email,
                currentAddress,
                permanentAddress);

        Assertions.assertEquals(new ElementsPage().actualResultFieldName(), name);
        Assertions.assertEquals(new ElementsPage().actualResultFieldEmail(), email);
        Assertions.assertEquals(new ElementsPage().actualResultFieldCurrentAddress(), currentAddress);
        Assertions.assertEquals(new ElementsPage().actualResultFieldPermanentAddress(), permanentAddress);
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Проверяется нажатие кнопок ЛКМ, ПКМ, double click и появление информационного текста после нажатия")
    public void checkingTheButtonTab() {
        new FirstPage().checkedCardElements();
        new ButtonsPage().pressingButtonsAndCheckingMessages();
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Проверяется открытие страницы в новой вкладке и её закрытие")
    public void checkingTheOpeningAndClosingOfAPageInANewTab() {
        new FirstPage().checkedCardElements();
        new BrowserWindowsPage().openingAndClosingANewPageTab();
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Проверяется открытие страницы в новом окне и его закрытие")
    public void checkingTheOpeningAndClosingOfAPageInANewWindow() {
        new FirstPage().checkedCardElements();
        new BrowserWindowsPage().openAndCloseANewWindow();
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Проверка вызова окна уведомления и его закрытие")
    public void checkingAlertButton() {
        new FirstPage().checkedCardElements();
        new AlertsPage().clickAlertButtonAndCloseAlert_();
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Проверка что окно уведомления после нажатия на кнопку появляется через 5 секунд и его закрытие")
    public void checkingTimeAlertButton() {
        new FirstPage().checkedCardElements();
        new AlertsPage().clickTimeAlertButtonAndCloseAlert();
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("Проверка, что после нажатия 'ОК' в окне уведомления, рядом с кнопкой 'Click me' появляется текст: 'You selected Ok'")
    public void checkingConfirmAlertButton() {
        new FirstPage().checkedCardElements();
        new AlertsPage().clickConfirmButtonAndSuccessMessage();
    }

    @org.junit.jupiter.api.Test
    @Owner("Сергей Л")
    @Description("При заполнении поля в открывшемся информационном окне данными 'Test name' и нажатии " +
            "ОК, рядом с кнопкой 'Click me' появляется текст: 'You entered Test name'")
    public void checkingPromtAlertButtonAndInputText() {
        new FirstPage().checkedCardElements();
        new AlertsPage().clickPromtButtonAndInputText("Test name");
    }

}
