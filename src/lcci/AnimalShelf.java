package lcci;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelf {
    
    private Queue<int[]> catQueue;
    private Queue<int[]> dogQueue;

    public AnimalShelf() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
        if (animal[1] == 0) catQueue.offer(animal);
        else dogQueue.offer(animal);
    }
    
    public int[] dequeueAny() {
        if (catQueue.isEmpty() && dogQueue.isEmpty()) return new int[] {-1, -1};
        if (catQueue.isEmpty() || dogQueue.isEmpty()) return catQueue.isEmpty() ? dogQueue.poll() : catQueue.poll();
        return catQueue.peek()[0] < dogQueue.peek()[0] ? catQueue.poll() : dogQueue.poll();
    }
    
    public int[] dequeueDog() {
        return dogQueue.isEmpty() ? new int[] {-1, -1} : dogQueue.poll();
    }
    
    public int[] dequeueCat() {
        return catQueue.isEmpty() ? new int[] {-1, -1} : catQueue.poll();
    }

    public static void main(String[] args) {
        AnimalShelf obj = new AnimalShelf();
        obj.enqueue(new int[] {0, 0});
        obj.enqueue(new int[] {1, 0});
        int[] result = obj.dequeueCat();
        System.out.printf("[%d, %d]\n", result[0], result[1]);
        result = obj.dequeueDog();
        System.out.printf("[%d, %d]\n", result[0], result[1]);
        result = obj.dequeueAny();
        System.out.printf("[%d, %d]", result[0], result[1]);
    }

}
