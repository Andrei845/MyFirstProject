package Fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressCardFragment {

    @FindBy(xpath = ".//button[contains(@class, 'action-links removeAddress')]")
    public WebElement xToRemoveTheAddress;

    @FindBy(xpath =".//div[@class = 'address-card-inner']")
    public WebElement textInsideAddress;


}
