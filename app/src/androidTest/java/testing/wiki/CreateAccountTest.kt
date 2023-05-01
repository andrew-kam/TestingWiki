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
class CreateAccountTest {

    private val passWord = "pass56"
    private val userName = "name"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun openLoginPage() =
        MainPage().goToLoginPage()

    @Test
    fun testPasswordVisibilitySwitching() {
        LogInPage()
            .apply {
                typeTextPassword(passWord)
                pressIconEyePassword()
                checkEnteredPassword(passWord)
                pressIconEyePassword()
                checkEnteredPassword(transformPassword(passWord))
            }
    }

    @Test
    fun testEnteredPasswordLength() {
        LogInPage()
            .apply {
                typeTextUsername(userName)
                typeTextPassword(passWord)
                pressButtonNext()
                checkCreateAccountPasswordErrorIsCompletelyDisplayed()
                checkCreateAccountPasswordErrorColorRed()
            }
    }
}
