import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> phoneBook = new HashMap<String, HashMap<String, String>>();
        phoneBook.put("친구", new HashMap<String, String>());
        HashMap<String, String> group = phoneBook.get("친구");
        group.put("010-1111-1111", "김자바");
        group.put("010-1111-1111", "강자바");
        group.put("010-3333-3333", "이자바");

        HashMap<String, HashMap<String, String>> map = new HashMap<>();
        map.put("aa", new HashMap<>());

        HashMap<String, String> map2 = map.get("aa");
        map2.put("1", "hh1");
        map2.put("1", "hh2");
        map2.put("2", "aas1");
        map2.put("3", "dds2");

        System.out.println(map);
        System.out.println(phoneBook.entrySet());
    }

    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap group = (HashMap) phoneBook.get(groupName);
        group.put(tel, name); // 이름은 중복될 수 있으니 전화번호를 key로 한다.
        System.out.println(phoneBook.entrySet());
    }

    static void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName))
            phoneBook.put(groupName, new HashMap());
    }
}