import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> bookingIds = new ArrayList<>();
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<String> roomTypes = new ArrayList<>();
        ArrayList<Integer> roomNumbers = new ArrayList<>();
        ArrayList<Integer> nightsList = new ArrayList<>();
        ArrayList<Double> totalBills = new ArrayList<>();

        int bookingId = 1001;

        while (true) {

            System.out.println("\n================================");
            System.out.println("       HOTEL RESERVATION SYSTEM");
            System.out.println("================================");
            System.out.println("1. Book a Room");
            System.out.println("2. View All Bookings");
            System.out.println("3. Search Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.println("\n--- Room Types ---");
                System.out.println("1. Single Room - Rs. 1500/night");
                System.out.println("2. Double Room - Rs. 2500/night");
                System.out.println("3. Deluxe Room - Rs. 4000/night");

                System.out.print("Enter room type: ");
                int type = sc.nextInt();
                sc.nextLine();

                String roomType;
                double price;

                if (type == 1) {
                    roomType = "Single";
                    price = 1500;
                } else if (type == 2) {
                    roomType = "Double";
                    price = 2500;
                } else if (type == 3) {
                    roomType = "Deluxe";
                    price = 4000;
                } else {
                    System.out.println("Invalid room type!");
                    continue;
                }

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

                System.out.print("Enter room number: ");
                int roomNumber = sc.nextInt();

                boolean alreadyBooked = false;

                for (int room : roomNumbers) {
                    if (room == roomNumber) {
                        alreadyBooked = true;
                        break;
                    }
                }

                if (alreadyBooked) {
                    System.out.println("Sorry! This room is already booked.");
                    continue;
                }

                System.out.print("Enter number of nights: ");
                int nights = sc.nextInt();

                if (nights <= 0) {
                    System.out.println("Invalid number of nights!");
                    continue;
                }

                double total = price * nights;

                bookingIds.add(bookingId);
                customerNames.add(name);
                roomTypes.add(roomType);
                roomNumbers.add(roomNumber);
                nightsList.add(nights);
                totalBills.add(total);

                System.out.println("\n--- Booking Confirmed ---");
                System.out.println("Booking ID: " + bookingId);
                System.out.println("Customer Name: " + name);
                System.out.println("Room Number: " + roomNumber);
                System.out.println("Room Type: " + roomType);
                System.out.println("Number of Nights: " + nights);
                System.out.println("Total Bill: Rs. " + total);

                bookingId++;

            } else if (choice == 2) {

                System.out.println("\n--- All Bookings ---");

                if (bookingIds.size() == 0) {
                    System.out.println("No bookings available.");
                } else {

                    for (int i = 0; i < bookingIds.size(); i++) {

                        System.out.println("\nBooking ID: "
                                + bookingIds.get(i));

                        System.out.println("Customer: "
                                + customerNames.get(i));

                        System.out.println("Room Number: "
                                + roomNumbers.get(i));

                        System.out.println("Room Type: "
                                + roomTypes.get(i));

                        System.out.println("Nights: "
                                + nightsList.get(i));

                        System.out.println("Total Bill: Rs. "
                                + totalBills.get(i));
                    }
                }

            } else if (choice == 3) {

                System.out.print("\nEnter Booking ID to search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < bookingIds.size(); i++) {

                    if (bookingIds.get(i) == searchId) {

                        System.out.println("\n--- Booking Details ---");
                        System.out.println("Booking ID: "
                                + bookingIds.get(i));
                        System.out.println("Customer Name: "
                                + customerNames.get(i));
                        System.out.println("Room Number: "
                                + roomNumbers.get(i));
                        System.out.println("Room Type: "
                                + roomTypes.get(i));
                        System.out.println("Number of Nights: "
                                + nightsList.get(i));
                        System.out.println("Total Bill: Rs. "
                                + totalBills.get(i));

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Booking not found.");
                }

            } else if (choice == 4) {

                System.out.print("\nEnter Booking ID to cancel: ");
                int cancelId = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < bookingIds.size(); i++) {

                    if (bookingIds.get(i) == cancelId) {

                        bookingIds.remove(i);
                        customerNames.remove(i);
                        roomTypes.remove(i);
                        roomNumbers.remove(i);
                        nightsList.remove(i);
                        totalBills.remove(i);

                        System.out.println("Booking cancelled successfully.");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Booking not found.");
                }

            } else if (choice == 5) {

                System.out.println(
                        "\nThank you for using Hotel Reservation System!");
                break;

            } else {

                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
