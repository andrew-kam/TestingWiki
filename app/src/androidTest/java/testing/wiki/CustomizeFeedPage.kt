package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class CustomizeFeedPage : BasePage() {

    private val matcherCheckBoxes = withId(R.id.feed_content_type_checkbox)
    private val matcherRecycle = withId(R.id.content_types_recycler)

    fun checkAllCustomizeFeedBoxesAreChecked() =
        checkAllBoxesAreChecked(matcherCheckBoxes)

    fun swipeUp() =
        swipeUpRecycle(matcherRecycle)
}
