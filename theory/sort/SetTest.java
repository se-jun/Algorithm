package sort;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        // 리스트는 순서가 있다 -> 자료의 중복을 허용한다.
        // 셋은 순서가없다 -> 자료의 중복을 허용하지 않느다.
        // Set<String> set = new HashSet<>();
        Set<String> set = new TreeSet<>();
        set = new TreeSet<String>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 == len2) {
                    return o1.compareTo(o2);
                } else {
                    return Integer.compare(o1.length(), o2.length());
                }
            }
        });
        set.add("Hello");
        set.add("Java");
        set.add("Dream");
        set.add("Is");
        set.add("Hello");
        System.out.println(set);

    }
}
