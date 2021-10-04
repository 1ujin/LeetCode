package algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths)
            set.add(path.get(0));
        for (List<String> path : paths)
            if (!set.contains(path.get(1)))
                return path.get(1);
        return "";
    }

    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("London", "New York"),
                List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"));
        System.out.println(new DestinationCity().destCity(paths));
    }

}
