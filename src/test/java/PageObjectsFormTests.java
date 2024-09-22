import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PageObjectsFormTests extends FormTest {


    RegistrationPage registrationPage = new RegistrationPage();

    private String firstName = "Stas",
            lastName = "Erohov",
            userEmail = "example@example.com",
            genderUser = "Male",
            userNumber = "8901234567",
            dayOfBirth = "07", monthOfBirth = "October", yearOfBirth = "1993",
            subjects = "Arts",
            hobbies = "Reading",
            picture = "Pika-pika.jpg",
            currentAddres = "Saint-Petersburg, Parfenovsk. street, 7",
            state = "NCR",
            city = "Noida";

    @Test
    void fillFieldsTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenterWrapper(genderUser)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(subjects)
                .setHobbiesWrapperInput(hobbies)
                .setUploadPicture(picture)
                .setCurrentAddress(currentAddres)
                .setChooseState(state)
                .setChooseCity(city)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderUser)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddres)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void partCompleteFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenterWrapper(genderUser)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genderUser)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeCompleteFormTest() {

        registrationPage.openPage()
                .pressSubmit()
                .checkNotCompleteForm();
    }
}