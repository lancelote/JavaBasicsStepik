package week3.hw5;

public class Main {
    Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label check = analyzer.processText(text);
            if (check != Label.OK) {
                return check;
            }
        }
        return Label.OK;
    }
}
