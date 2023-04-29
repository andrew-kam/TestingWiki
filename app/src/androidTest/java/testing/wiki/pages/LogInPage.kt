package testing.wiki.pages

import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.wikipedia.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.TypeSafeMatcher
import org.wikipedia.views.PlainPasteEditText

class LogInPage : BasePage() {

    private val matcherInputCreateAccountUsername =
        allOf(
            instanceOf((PlainPasteEditText::class.java)),
            isDescendantOfA(withId(R.id.create_account_username))
        )

    private val matcherInputCreateAccountPassword =
        allOf(
            instanceOf((PlainPasteEditText::class.java)),
            isDescendantOfA(withId(R.id.create_account_password_input))
        )

    private val matcherButtonNext =
        withId(R.id.create_account_submit_button)

    private val matcherIconEyePassword =
        allOf(
            withId(com.google.android.material.R.id.text_input_end_icon),
            isDescendantOfA(withId(R.id.create_account_password_input))
        )

    private val matcherCreateAccountPasswordError =
        withText(R.string.create_account_password_error)

    private val colorRedLightTheme =
        R.color.red700
    private val colorRedDarkTheme =
        R.color.red500
    private val matcherColorsRed =
        anyOf(
            hasTextColor(colorRedLightTheme), hasTextColor(colorRedDarkTheme)
        )

    fun typeTextUsername(text: String) =
        typeTextInField(matcherInputCreateAccountUsername, text)

    fun typeTextPassword(text: String) =
        typeTextInField(matcherInputCreateAccountPassword, text)

    fun pressIconEyePassword() =
        clickItem(matcherIconEyePassword)

    fun pressButtonNext() =
        clickItem(matcherButtonNext)

    fun checkEnteredPassword(passWord: String) =
        checkItemText(matcherInputCreateAccountPassword, passWord)

    fun transformPassword(passWord: String) =
        PasswordTransformationMethod.getInstance().getTransformation(passWord, null).toString()

    fun checkEnteredPasswordHasTransformationMethod() =
        checkTextHasTransformationMethod(matcherInputCreateAccountPassword)

    fun checkCreateAccountPasswordErrorIsCompletelyDisplayed() =
        checkItemIsCompletelyDisplayed(matcherCreateAccountPasswordError)

    fun checkCreateAccountPasswordErrorColorRed() =
        checkItemColor(matcherCreateAccountPasswordError, matcherColorsRed)


    private fun checkTextHasTransformationMethod(matcher: Matcher<View>) {
        onView(matcher)
            .check(matches(object : TypeSafeMatcher<View>() {

                override fun matchesSafely(view: View): Boolean {
                    val transformationMethod = (view as? TextView)?.transformationMethod
                    return transformationMethod is PasswordTransformationMethod
                }

                override fun describeTo(description: Description) {
                    description.appendText("Checking the EditText has password transformation method")
                }
            }))
    }
}
