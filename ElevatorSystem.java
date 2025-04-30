import java.util.LinkedList;
import java.util.Queue;

class Request {
    private int floor;

    public Request(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }
}


class Elevator {
    private int currentFloor;
    private Queue<Request> requestQueue;

    public Elevator() {
        this.currentFloor = 0; 
        this.requestQueue = new LinkedList<>();
    }

    public void addRequest(Request request) {
        requestQueue.add(request);
    }

    public void move() {
        while (!requestQueue.isEmpty()) {
            Request request = requestQueue.poll();
            int targetFloor = request.getFloor();
            System.out.println("Moving from floor " + currentFloor + " to floor " + targetFloor);
            currentFloor = targetFloor;
            System.out.println("Arrived at floor " + currentFloor);
        }
    }
}


class Building {
    private Elevator elevator;

    public Building() {
        this.elevator = new Elevator();
    }

    public void requestElevator(int floor) {
        System.out.println("Requesting elevator to floor " + floor);
        elevator.addRequest(new Request(floor));
    }

    public void operateElevator() {
        elevator.move();
    }
}


public class ElevatorSystem {
    public static void main(String[] args) {
        Building building = new Building();

       
        building.requestElevator(3);
        building.requestElevator(1);
        building.requestElevator(5);
        building.requestElevator(2);

       
        building.operateElevator();
    }
}
