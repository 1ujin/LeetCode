package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EmployeeImportance {
    
    // Definition for Employee.
    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance =  importance;
            this.subordinates = subordinates;
        }
    };
    
    // common fields
    private int sum = 0;
    private Map<Integer, Employee> map = new HashMap<>();

    // method 1 depth-first search
    public int getImportance1(List<Employee> employees, int id) {
        for (Employee employee : employees)
            map.put(employee.id, employee);
        dfs(map.get(id));
        return sum;
    }

    private void dfs(Employee employee) {
        if (employee == null)
            return;
        sum += employee.importance;
        for (int subordinate : employee.subordinates)
            dfs(map.get(subordinate));
    }
    
    // method 2 breadth-first search
    public int getImportance2(List<Employee> employees, int id) {
        for (Employee employee : employees)
            map.put(employee.id, employee);
        Employee employee = map.get(id);
        if (employee == null)
            return 0;
        sum = employee.importance;
        Queue<Integer> queue = new LinkedList<>();
        for (int subordinate : employee.subordinates)
            queue.offer(subordinate);
        while (!queue.isEmpty()) {
            employee = map.get(queue.poll());
            sum += employee.importance;
            for (int subordinate : employee.subordinates)
                queue.offer(subordinate);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Arrays.asList()));
        employees.add(new Employee(3, 3, Arrays.asList()));
        System.out.println(new EmployeeImportance().getImportance1(employees, 1));
    }

}
