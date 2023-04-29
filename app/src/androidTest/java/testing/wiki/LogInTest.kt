package testing.wiki

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import testing.wiki.pages.LogInPage
import testing.wiki.pages.MainPage

@RunWith(AndroidJUnit4::class)
class LogInTest {

    private val passWord = "pass"
    private val userName = "name"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun goToLoginPage() {
        MainPage()
            .apply {
                pressButtonSkip()
                pressButtonMenuMore()
                pressButtonLogInWikipediaInMenuMore()
            }
    }

    @Test
    fun testLogInEyePassword() {
        LogInPage().typePasteEditTextPassword(passWord)
        Thread.sleep(3000)
        LogInPage().pressIconEyePassword()
        Thread.sleep(3000)
        LogInPage().pressIconEyePassword()
        Thread.sleep(3000)
    }

    @Test
    fun testLogInLengthUsername() {

        LogInPage().typePasteEditTextUsername(userName)
        LogInPage().typePasteEditTextPassword(passWord)
        LogInPage().pressButtonNext()
        LogInPage().checkCreateAccountPasswordErrorIsCompletelyDisplayed()
        LogInPage().checkCreateAccountPasswordErrorColorRed()
//        LogInPage().checkHintPasswordIsCompletelyDisplayed()
    }
}

