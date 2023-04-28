package testing.wiki.pages

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R
import org.hamcrest.Matchers.allOf
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

//    private val colorMistakeRed = withId(R.color.red700)

    fun typePasteEditTextUsername(text: String) =
        typeTextInField(matcherPasteEditTextUsername, text)

    fun typePasteEditTextPassword(text: String) =
        typeTextInField(matcherPasteEditTextPassword, text)

    fun pressIconEyePassword() =
        clickItem(matcherIconEyePassword)

    fun pressButtonNext() =
        clickItem(matcherButtonNext)



//    fun checkIsDisplayedText() =
//        checkIsDisplayed(matcherPasteEditTextPassword)
}