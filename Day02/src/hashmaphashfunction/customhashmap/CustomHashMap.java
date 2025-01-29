package hashmaphashfunction.customhashmap;
import java.util.HashMap;
import java.util.Map;

public class CustomHashMap {
    private static final int SIZE = 16;
    private Entry table[] = new Entry[SIZE];

    class Entry {
        final String key;
        String value;
        Entry next;

        Entry(String k, String v) {
            key = k;
            value = v;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }
    }

    public void put(String k, String v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        if (e != null) {
            if (e.key.equals(k)) {
                e.value = v;
            } else {
                while (e.next != null) {
                    e = e.next;
                }
                Entry newEntry = new Entry(k, v);
                e.next = newEntry;
            }
        } else {
            Entry newEntry = new Entry(k, v);
            table[hash] = newEntry;
        }
    }

    public String get(String k) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.key.equals(k)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }
    public void remove(String k) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        if (e.key.equals(k)) {
            table[hash] = e.next;
            return;
        }

        Entry prev = null;
        while (e != null) {
            if (e.key.equals(k)) {
                prev.next = e.next;
                return;
            }
            prev = e;
            e = e.next;
        }
    }
}
