import java.util.Map;
import java.util.TreeMap;

public class Greeting {
    private int id;
    private String text;
    private Map<String,String> translations = new TreeMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }
}
