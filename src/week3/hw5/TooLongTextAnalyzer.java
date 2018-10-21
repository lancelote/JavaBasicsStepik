package week3.hw5;

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    @SuppressWarnings("WeakerAccess")
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}
