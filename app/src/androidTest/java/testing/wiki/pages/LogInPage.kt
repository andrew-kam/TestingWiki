package testing.wiki.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.instanceOf
import org.wikipedia.views.PlainPasteEditText

class LogInPage : BasePage() {

//    private val matcherFieldUsername = withId(R.id.create_account_username)
//    private val matcherFieldPassword = withId(R.id.create_account_password_input)
    private val matcherButtonNext = withId(R.id.create_account_submit_button)

    private val matcherIconEyePassword = allOf(
        withId(com.google.android.material.R.id.text_input_end_icon),
        isDescendantOfA(withId(R.id.create_account_password_input))
    )

    private val matcherPasteEditTextUsername = allOf(
        instanceOf((PlainPasteEditText::class.java)),
        isDescendantOfA(withId(R.id.create_account_username))
    )

    private val matcherPasteEditTextPassword = allOf(
        instanceOf((PlainPasteEditText::class.java)),
        isDescendantOfA(withId(R.id.create_account_password_input))
    )

    private val matcherHintPassword = withHint(R.string.account_creation_password_hint)

    private val matcherCreateAccountPasswordError = withText(R.string.create_account_password_error)

    private val matcherCreateAccountPasswordErrorColorRed = anyOf(hasTextColor(R.color.red700), hasTextColor(R.color.red500))

//    private val colorMistakeRed = withId(R.color.red700)

    fun typePasteEditTextUsername(text: String) =
        typeTextInField(matcherPasteEditTextUsername, text)

    fun typePasteEditTextPassword(text: String) =
        typeTextInField(matcherPasteEditTextPassword, text)

    fun pressIconEyePassword() =
        clickItem(matcherIconEyePassword)

    fun pressButtonNext() =
        clickItem(matcherButtonNext)

    fun checkHintPasswordIsCompletelyDisplayed() =
        checkItemIsCompletelyDisplayed(matcherHintPassword)

    fun checkCreateAccountPasswordErrorIsCompletelyDisplayed() =
        checkItemIsCompletelyDisplayed(matcherCreateAccountPasswordError)

    fun checkCreateAccountPasswordErrorColorRed() =
        checkItemColor(matcherCreateAccountPasswordError, matcherCreateAccountPasswordErrorColorRed)

}