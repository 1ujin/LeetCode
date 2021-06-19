package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {

    Map<String, List<String>> map;
    Set<String> dead;
    String kingName;

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        dead = new HashSet<>();
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        if (map.get(parentName) == null)
            map.put(parentName, new ArrayList<>());
        map.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        return preorder(kingName, new ArrayList<>());
    }

    private List<String> preorder(String name, List<String> order) {
        if (!dead.contains(name))
            order.add(name);
        if (map.get(name) != null)
            for (String childName : map.get(name))
                preorder(childName, order);
        return order;
    }

    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }

}
