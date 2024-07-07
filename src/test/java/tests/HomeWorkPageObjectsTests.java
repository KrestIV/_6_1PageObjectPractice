package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class HomeWorkPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Pupa")
                .setLastName("Lupa")
                .setEmail("lupa@mail.hr")
                .setGender("Male")
                .setUserNumber("9005001234")
                .setDateOfBirth("15", "May", "1988")
                .setSubject("Math")
                .setHobby("Reading")
                .uploadProfilePicture("profilePicture.png")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit()

                .checkResult("Student Name", "Pupa Lupa")
                .checkResult("Student Email", "lupa@mail.hr")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9005001234")
                .checkResult("Date of Birth", "15 May,1988")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "profilePicture.png")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulMinimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Pupa")
                .setLastName("Lupa")
                .setGender("Male")
                .setUserNumber("9005001234")
                .submit()

                .checkResult("Student Name", "Pupa Lupa")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9005001234");
    }

    @Test
    void negativeFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Pupa")
                .setLastName("Lupa")
                .setEmail("lupamailhr")
                .setGender("Male")
                .setUserNumber("9005001234")
                .submit()

                .checkForError();
    }
}