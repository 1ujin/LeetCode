package lcci;

public class TripleInOne {
    
    private int[] array;
    private int[] top;
    
    public TripleInOne(int stackSize) {
        array = new int[stackSize * 3];
        top = new int[] {-3, -2, -1};
    }
    
    public void push(int stackNum, int value) {
        if (top[stackNum] + 3 >= array.length) return;
        top[stackNum] += 3;
        array[top[stackNum]] = value;
    }
    
    public int pop(int stackNum) {
        if (top[stackNum] < 0) return -1;
        top[stackNum] -= 3;
        return array[top[stackNum] + 3];
    }
    
    public int peek(int stackNum) {
        return top[stackNum] < 0 ? -1 : array[top[stackNum]];
    }
    
    public boolean isEmpty(int stackNum) {
        return top[stackNum] < 0;
    }

    public static void main(String[] args) {
         TripleInOne obj = new TripleInOne(1);
         obj.push(0, 1);
         obj.push(0, 2);
         System.out.println(obj.pop(0));
         System.out.println(obj.pop(0));
         System.out.println(obj.pop(0));
         System.out.println(obj.isEmpty(0));
    }

}
