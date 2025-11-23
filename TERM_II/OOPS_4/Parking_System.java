// Link: https://www.scaler.com/academy/mentee-dashboard/class/469982/assignment/problems/271496?navref=cl_tt_nv

// 1. ParkingSystem(int big, int medium, int small):
// Initializes object of the ParkingSystem class.
// The number of slots for each parking space are given as part of the constructor.

// 2. bool addCar(int carType):
// Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
// carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
// A car can only park in a parking space of its carType.
// If there is no space available, return false, else park the car in that size space and return true.

package College_DSA.TERM_II.OOPS_4;
public class Parking_System {
    private int big;
    private int medium;
    private int small;

    public Parking_System(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) {
            big--;
            return big==0;
        }
        if (carType == 2) {
            medium--;
            return medium==0;
        }
        else {
            small--;
            return small==0;
        }
    }
}
