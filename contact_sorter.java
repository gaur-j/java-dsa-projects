import java.util.*;

public class contact_sorter {
    static String[] quickStrings(String[] s) {
        if (s.length <= 1)
            return s;

        String pivot = s[0];

        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();

        int i = 1;

        while (i < s.length) {

            if (s[i].compareTo(pivot) < 0) {
                left.add(s[i]);
            } else {
                right.add(s[i]);
            }
            i++;
        }

        String[] leftStrings = quickStrings(toArrStr(left));
        String[] rightStrings = quickStrings(toArrStr(right));

        int k = 0, l = 0, r = 0;

        while (l < leftStrings.length) {
            s[k] = leftStrings[l];
            l++;
            k++;
        }

        s[k] = pivot;
        k++;

        while (r < rightStrings.length) {
            s[k] = rightStrings[r];
            r++;
            k++;
        }

        return s;
    }

    static String[] toArrStr(ArrayList<String> list) {
        String[] res = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    static String[] bianrySearch(String[] s) {

        Scanner sc = new Scanner(System.in);

        System.out.print("#################################################################\n"
                + "Choice 1: Search name.\n" + "Choice 2: Exit.\n" + "choice: ");

        int choice = sc.nextInt();
        String user_search = null;

        while (true) {
            if (choice == 1) {
                System.out.print("Search Name: ");
                user_search = sc.next();

                int low = 0, high = s.length - 1;

                boolean found = false;

                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (s[mid].compareTo(user_search) == 0) {
                        found = true;
                        System.out.println("Name Found: %s, at index: ".formatted(found) + mid);
                        break;
                    } else if (s[mid].compareTo(user_search) < 0) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                if (!found) {
                    System.out.print("Name not Found: %s, at any index \n".formatted(found));
                }
                System.out.print("#################################################################\n"
                        + "Choice 1: Search name.\n" + "Choice 2: Exit.\n" + "choice: ");
                choice = sc.nextInt();

            } else {
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("#################################################################\n"
                + "Choice 1: To Enter name.\n" + "Choice 2: To Exit.\n" + "choice: ");

        int choice = sc.nextInt();

        String user_input = null;

        List name = new ArrayList();

        while (true) {

            if (choice == 1) {
                System.out.print("enter name: ");
                user_input = sc.next();

                if (user_input != "exit" && user_input != " ") {
                    name.add(user_input);
                } else {
                    break;
                }
            } else {
                break;
            }
            System.out.print("choice: ");
            choice = sc.nextInt();
        }
        System.out.println(name);

        String s[] = new String[name.size()];

        for (int i = 0; i < name.size(); i++) {
            s[i] = (String) name.get(i);
        }

        bianrySearch(quickStrings(s));
    }
}
