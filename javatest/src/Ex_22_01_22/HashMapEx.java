package Ex_22_01_22;

import java.lang.Character.Subset;
import java.security.KeyStore.Entry;
import java.util.*;

public class HashMapEx {
}

class HashMapEx1 {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");
            System.out.print("id : ");
            String id = s.nextLine();

            System.out.print("pw : ");
            String password = s.nextLine().trim();
            System.out.println();

            if (!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");

                continue;
            }
            if (!(map.get(id)).equals(password)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            } else {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
        }
    }
}

class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put("김자바", new Integer(100));
        map.put("이자바", new Integer(100));
        map.put("강자바", new Integer(80));
        map.put("안자바", new Integer(90));

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;

        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float) total / set.size());
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));
    }
}

class HashMapEx3 {
    static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<String, HashMap<String, String>>();

    public static void main(String[] args) {
        addPhoneNo("친구", "이자바", "010-111-1111");
        addPhoneNo("친구", "김자바", "010-222-2222");
        addPhoneNo("친구", "김자바", "010-333-3333");
        addPhoneNo("회사", "김대리", "010-444-4444");
        addPhoneNo("회사", "김대리", "010-555-5555");
        addPhoneNo("회사", "박대리", "010-666-6666");
        addPhoneNo("회사", "이과장", "010-777-7777");
        addPhoneNo("세탁", "010-888-8888");

        printList();
    }

    // 그룹에 전화번호 추가 메서드
    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap<String, String> group = phoneBook.get(groupName);
        group.put(tel, name); // 이름은 중복될 수 있으니 전화번호를 key로 한다.
    }

    // 그룹을 추가하는 메서드
    static void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName))
            phoneBook.put(groupName, new HashMap<String, String>());
    }

    // 그룹이 없는 경우 기타 그룹에 전화번호 추가 메서드
    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    // 전화번호부 전체 출력 메서드
    static void printList() {
        Set<Map.Entry<String, HashMap<String, String>>> set = phoneBook.entrySet();
        Iterator<Map.Entry<String, HashMap<String, String>>> it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<String, HashMap<String, String>> e = it.next();

            Set<Map.Entry<String, String>> subSet = e.getValue().entrySet();
            Iterator<Map.Entry<String, String>> subIt = subSet.iterator();

            System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");

            while (subIt.hasNext()) {
                Map.Entry<String, String> subE = subIt.next();
                String telNo = subE.getKey();
                String name = subE.getValue();
                System.out.println(name + " " + telNo);
            }
            System.out.println();
        }
    }
}