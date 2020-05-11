import java.util.Arrays;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/5 11:33
 */
public class xx {
    public static void main(String[] args) {
        String s = Arrays.toString(new String[]{"1", "2", "3"});
        System.out.println(s);
        String[] ss = s.split(",");
        System.out.println(ss);
    }
}
