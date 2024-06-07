import java.util.HashMap;
import java.util.Map;

public class Preference {
    private static Preference instance;
    private Map<String, String> preferences = new HashMap<>();

    public void setPreference(String key, String value) {
        preferences.put(key, value);
    }

    public String getPreference(String key) throws PreferenceNotFoundException {
        if (!preferences.containsKey(key)) {
            throw new PreferenceNotFoundException("Preference key not found: " + key);
        }
        return preferences.get(key);
    }

    private Preference() {} 

    public static Preference getInstance() {
        if (instance == null) {
            instance = new Preference();
        }
        return instance;
    }

   
    public static class PreferenceNotFoundException extends Exception {
        public PreferenceNotFoundException(String message) {
            super(message);
        }
    }
}
