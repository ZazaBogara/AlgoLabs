public class RabinKarp {
    private String text;
    private String pattern;

    public RabinKarp(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public int search() {
        int alphabet = 256;
        int num = 2048;
        int patternH = 0;
        int textH = 0;
        int firstH = 1;
        int out = 0;
        for (int i = 0; i < pattern.length() - 1; i++) {
            firstH = (firstH * alphabet) % num;
        }
        for (int i = 0; i < pattern.length(); i++) {
            patternH = (alphabet * patternH + pattern.charAt(i)) % num;
            textH = (alphabet * textH + text.charAt(i)) % num;
        }

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (patternH == textH) {
                boolean isGood = true;
                for (int j = 0; j < pattern.length(); j++)
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        isGood = false;
                        break;
                    }
                if (isGood) {
                    out++;
                }
            }
            if (i < text.length() - pattern.length()) {
                textH = (alphabet * (textH - text.charAt(i) * firstH) + text.charAt(i + pattern.length())) % num;
                if (textH < 0) {
                    textH = (textH + num);
                }
            }
        }
        return out;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}