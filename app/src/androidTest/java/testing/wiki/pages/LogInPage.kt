package testing.wiki.pages

import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.wikipedia.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.wikipedia.views.PlainPasteEditText

class LogInPage {

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

    private val matcherRedColorLightTheme =
        hasTextColor(R.color.red700)

    private fun typeTextInField(matcher: Matcher<View>, text: String) {
        GeneralPageFunctions().checkItemIsClickable(matcher)
        onView(matcher).perform(typeText(text))
    }

    fun typeTextUsername(text: String) =
        typeTextInField(matcherInputCreateAccountUsername, text)

    fun typeTextPassword(text: String) =
        typeTextInField(matcherInputCreateAccountPassword, text)

    fun pressIconEyePassword() =
        GeneralPageFunctions().clickItem(matcherIconEyePassword)

    fun pressButtonNext() =
        GeneralPageFunctions().clickItem(matcherButtonNext)

    fun checkEnteredPassword(passWord: String) {
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherInputCreateAccountPassword)
        onView(matcherInputCreateAccountPassword).check(matches(withText(passWord)))
    }

    fun transformPassword(passWord: String) =
        PasswordTransformationMethod.getInstance().getTransformation(passWord, null).toString()

    fun checkCreateAccountPasswordErrorIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherCreateAccountPasswordError)

    fun checkCreateAccountPasswordErrorColorRed() {
        onView(matcherCreateAccountPasswordError).check(matches(matcherRedColorLightTheme))
    }
}
