import java.util.Scanner;

// HOUSEHOLD CLASS
class Household {

    int id;
    String name;
    double usage;

    // Constructor
    public Household(int id, String name, double usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }
}


public class WaterBillingMonitor1 {

    // METHOD: Calculate water bill
    public static double calculateBill(double usage) {

        double bill;

        if (usage <= 10) {

            bill = usage * 5;

        } else if (usage <= 20) {

            bill = (10 * 5) + (usage - 10) * 8;

        } else if (usage <= 30) {

            bill = (10 * 5)
                 + (10 * 8)
                 + (usage - 20) * 12;

        } else {

            bill = (10 * 5)
                 + (10 * 8)
                 + (10 * 12)
                 + (usage - 30) * 15;
        }

        // Fixed charge
        bill = bill + 50;

        return bill;
    }


    // METHOD: Display household details
    public static void displayHouseholds(Household[] households,int count) {

        System.out.println("\n--- HOUSEHOLD DETAILS ---");

        for (int i = 0; i < count; i++) {

            double bill = calculateBill(
                households[i].usage
            );

            System.out.println((i + 1) + ". ID: "
                + households[i].id
                + " | Name: "
                + households[i].name
                + " | Usage: "
                + households[i].usage
                + " KL"
                + " | Bill: Rs."
                + bill
            );
        }
    }


    // METHOD: Display usage analysis
    public static void analyzeUsage(Household[] households,int count) {

        if (count == 0) {

            System.out.println(
                "No households added."
            );

            return;
        }

        double total = 0;

        // Calculate total usage
        for (int i = 0; i < count; i++) {

            total = total + households[i].usage;
        }

        double average = total / count;

        System.out.println("\n--- USAGE ANALYSIS ---");

        System.out.println(
            "Total Usage: "
            + total + " KL"
        );

        System.out.println(
            "Average Usage: "
            + average + " KL"
        );

        // IF-ELSE for usage status
        if (average > 30) {

            System.out.println(
                "Status: High Water Usage"
            );

        } else if (average > 20) {

            System.out.println(
                "Status: Medium Water Usage"
            );

        } else {

            System.out.println(
                "Status: Low Water Usage"
            );
        }
    }


    public static void main(String[] args) {

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Array of Household objects
        Household[] households = new Household[20];

        int count = 0;

        boolean running = true;

        System.out.println(
            "=== HOUSEHOLD WATER BILLING MONITOR ==="
        );


        // WHILE LOOP
        while (running) {

            System.out.println("\nChoose an option:");

            System.out.println("1. Add Household");
            System.out.println("2. Enter Water Usage");
            System.out.println("3. View Households");
            System.out.println("4. Calculate Bill");
            System.out.println("5. Analyze Usage");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();


            // SWITCH
            switch (choice) {

                case 1:

                    System.out.print(
                        "Enter Household ID: "
                    );

                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                        "Enter Owner Name: "
                    );

                    String name =
                        scanner.nextLine();


                    if (count < households.length) {

                        households[count] =
                            new Household(id, name, 0);

                        count++;

                        System.out.println(
                            "Household added successfully!"
                        );

                    } else {

                        System.out.println(
                            "Household limit reached!"
                        );
                    }

                    break;


                case 2:

                    if (count == 0) {

                        System.out.println(
                            "Please add a household first."
                        );

                        break;
                    }

                    System.out.print(
                        "Enter Household ID: "
                    );

                    int id2 = scanner.nextInt();

                    boolean found = false;


                    // SEARCH USING FOR LOOP
                    for (int i = 0; i < count; i++) {

                        if (households[i].id == id2) {

                            System.out.print(
                                "Enter Water Usage in KL: "
                            );

                            double usage =
                                scanner.nextDouble();

                            households[i].usage =
                                usage;

                            System.out.println(
                                "Water usage added successfully!"
                            );

                            found = true;

                            break;
                        }
                    }


                    if (found == false) {

                        System.out.println(
                            "Household not found!"
                        );
                    }

                    break;


                case 3:

                    displayHouseholds(households,count);

                    break;


                case 4:

                    if (count == 0) {

                        System.out.println(
                            "Please add a household first."
                        );

                        break;
                    }

                    System.out.print(
                        "Enter Household ID: "
                    );

                    int id3 = scanner.nextInt();

                    found = false;


                    for (int i = 0; i < count; i++) {

                        if (households[i].id == id3) {

                            double bill =
                                calculateBill(
                                    households[i].usage
                                );

                            System.out.println(
                                "\n--- WATER BILL ---"
                            );

                            System.out.println(
                                "Household ID: "
                                + households[i].id
                            );

                            System.out.println(
                                "Owner: "
                                + households[i].name
                            );

                            System.out.println(
                                "Water Usage: "
                                + households[i].usage
                                + " KL"
                            );

                            System.out.println(
                                "Total Bill: Rs."
                                + bill
                            );

                            found = true;

                            break;
                        }
                    }


                    if (found == false) {

                        System.out.println(
                            "Household not found!"
                        );
                    }

                    break;


                case 5:

                    analyzeUsage(
                        households,
                        count
                    );

                    break;


                case 6:

                    running = false;

                    System.out.println(
                        "Thank you for using the Water Billing Monitor!"
                    );

                    break;


                default:

                    System.out.println(
                        "Invalid choice!"
                    );
            }
        }

        scanner.close();
    }
}