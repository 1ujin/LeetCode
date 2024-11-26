package huawei;

import java.util.*;

/**
 * 手机 App 防沉迷系统
 */
public class OD411 {

    private static class App {
        public String name;
        public int level;
        public String begin;
        public String end;

        public App(String name, int level, String begin, String end) {
            this.name = name;
            this.level = level;
            this.begin = begin;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        App[] apps = new App[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int level = scanner.nextInt();
            String begin = scanner.next();
            String end = scanner.next();
            apps[i] = new App(name, level, begin, end);
        }
        String query = scanner.next();
        scanner.close();
        System.out.println(solution(apps, query));
    }

    private static String solution(App[] apps, String query) {
        Set<App> pq = new TreeSet<>(Comparator.comparing(a -> a.begin));
        for (App app : apps)
            insert(pq, app);
        for (App app : pq)
            if (query.compareTo(app.begin) >= 0 && query.compareTo(app.end) < 0)
                return app.name;
        return "NA";
    }

    private static void insert(Set<App> pq, App app) {
        List<App> remove = new ArrayList<>();
        boolean flag = true;
        for (App old : pq) {
            if (app.begin.compareTo(old.end) >= 0)
                continue;
            if (app.end.compareTo(old.begin) <= 0)
                break;
            if (app.begin.compareTo(old.end) < 0 && app.end.compareTo(old.begin) > 0 && app.level > old.level)
                remove.add(old);
            else
                flag = false;
        }
        if (!flag)
            return;
        for (App rm : remove)
            pq.remove(rm);
        pq.add(app);
    }
}
