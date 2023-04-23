package testing.wiki

class SettingsPage : BasePage() {

    private val matcherButtonCustomizeExploreFeed = MatcherTextViewUniqueDrawingId(288)

    fun pressButtonCustomizeExploreFeed() =
        clickButton(matcherButtonCustomizeExploreFeed)
}
