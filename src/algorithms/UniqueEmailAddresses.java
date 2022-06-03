package algorithms;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int at = email.indexOf('@');
            String local = email.substring(0, at).split("\\+")[0].replace(".", "");
            String domain = email.substring(at);
            set.add(local + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = { "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        System.out.println(new UniqueEmailAddresses().numUniqueEmails(emails));
    }

}
