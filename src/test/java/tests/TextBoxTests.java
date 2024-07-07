package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void successfulFormSubmitTest(){
        textBoxPage.openPage()
                .setFullName("Frodo Baggins")
                .setEmail("fbaggins@weed.sr")
                .setCurrentAddress("Doom mt")
                .setPermanentAddress("Shire")
                .submit()

                .checkResult("Name","Frodo Baggins")
                .checkResult("Email","fbaggins@weed.sr")
                .checkResult("Current Address ","Doom mt")
                .checkResult("Permananet Address ","Shire");
    }
}
