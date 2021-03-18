package algorithms;

class ParkingSystem {
    int[] count;

    public ParkingSystem(int big, int medium, int small) {
        count = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        return count[carType - 1]-- > 0;
    }
}

public class DesignParkingSystem {

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }

}
