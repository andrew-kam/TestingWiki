package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.Espresso.onView
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import androidx.test.espresso.matcher.ViewMatchers.isChecked

class CustomizeFeedPage : BasePage() {

    private val matcherCheckBoxes = withId(R.id.feed_content_type_checkbox)

    fun allBoxIsChecked() {
        onView(allOf(matcherCheckBoxes, not(isChecked())))
            .check(doesNotExist())
    }
}
