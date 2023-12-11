import java.util.Random;

import java.util.Scanner;

public class lab10 {

static Scanner scan = new Scanner(System.in);

public static void main(String[] args) {

Q1();

Q2();

Q3();

Q4();  // Improved variable names and game mechanics

scan.close();

}

public static void Q1() {

while (true) {

System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");

String input = scan.nextLine();

if (input.equals("q")) {
//Simplified condition to exit loop when 'q' is entered.
    

return;

}

if (input.equals("square")) {

double a;

System.out.println("Enter the length of side a: ");

a = Double.parseDouble(scan.nextLine());

System.out.println("The circumference of the square is: " + a * 4);

System.out.println("The area of the square is: " + a * a);

} else if (input.equals("rectangle")) {

double a, b;

System.out.println("Enter the length of side a: ");

a = Double.parseDouble(scan.nextLine());

System.out.println("Enter the length of side b: ");

b = Double.parseDouble(scan.nextLine());

System.out.println("The circumference of the rectangle is: " + (2 * a + 2 * b));

System.out.println("The area of the rectangle is: " + (a * b));
} else if (input.equals("circle")) {

double r;

System.out.println("Enter the radius: ");

r = Double.parseDouble(scan.nextLine());

System.out.println("The circumference of the circle is: " + (Math.PI * r * 2));

System.out.println("The area of the circle is: " + (Math.PI * r * r));

}

}

}

public static void Q2() {
    System.out.println("Q2: Enter the current day (1-31): ");
    int num = Integer.parseInt(scan.nextLine());

    System.out.println("Enter the current month: (1-12)");
    int num2 = Integer.parseInt(scan.nextLine());

    String[] suffixes = {"st", "nd", "rd"};

    // Commit 1: Validate input for day and month
    if (num < 1 || num > 31 || num2 < 1 || num2 > 12) {
        System.out.println("Invalid day or month");
        return;
    }

    System.out.printf("You selected %d%s of ", num, (num >= 11 && num <= 13) ? "th" : suffixes[num % 10 - 1]);

    // Array to store month names
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    // Commit 2: Print selected month

    System.out.println(months[num2 - 1]);
}



public static void Q3() {

System.out.println("Q3: Enter how many numbers you want to check for primality: ");

int n = Integer.parseInt(scan.nextLine());

int counter = 0;

// Commit 1: Changed the loop starting index to 2 to skip unnecessary checks for 0 and 1.

for (int i = 0; i < n; i++) {

if (i < 2)

continue;

boolean check = true;


// Commit 2: Simplified the condition for checking primality by removing unnecessary else block.
for (int j = 2; j * j <= i; j++) {


if (i % j == 0) {

check = false;

break;

} else {

}

}

if (check == true) {

counter++;

}

else {}

}

System.out.println("There are: " + counter + " primes between 0 and " + n);

}

public static void Q4() {
    Random random = new Random(); // Renamed rng to random for clarity
    String nextMove;
    int enemyHealth = 100;
    int turns = 0;
    boolean isBuffed = false;
    int buffBonus;

    System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
    System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
    System.out.println("Q4: Your damage is 2-16 (2d8)");

    while (enemyHealth > 0) {
        // Commit 1: Adjust the value of the buff to range from -5 to 5.
        buffBonus = random.nextInt(11) - 5; // Adjust the value of the buff to from -5 to 5.
        boolean doAttack = false;
        boolean validInput = false;

        while (!validInput) {
            nextMove = scan.nextLine();
            validInput = true;

            switch (nextMove.toUpperCase()) { // Convert input to uppercase for case-insensitivity
                case "A":
                    doAttack = true;
                    break;
                case "B":
                    isBuffed = true;
                    // Commit 2: Improved the output message for buffing to display the sign properly.

                    System.out.println("Buffing! " + (buffBonus >= 0 ? "+" : "") + buffBonus +
                            " to your next attack roll and damage");
                    break;
                default:
                    System.out.println("Invalid input");
                    validInput = false;
            }
        }

        if (doAttack) {
            turns++;
            int attackRoll = random.nextInt(20) + 1;
            int damage = 0;

            System.out.print("You rolled: " + attackRoll);

            if (isBuffed) {
                attackRoll += buffBonus;
                System.out.print(" + " + buffBonus + " (buff active)\n");
            } else {
                System.out.println();
            }

            if (attackRoll >= 12) {
                damage = random.nextInt(8) + 1;
                damage += random.nextInt(8) + 1;

                if (isBuffed) {
                    damage += buffBonus;
                }
            }

            if (attackRoll == 20 || (isBuffed && (attackRoll == 20 + buffBonus))) {
                damage *= 2;
                System.out.print("Critical hit! ");
            }

            System.out.print("You dealt " + damage + " damage");

            if (isBuffed) {
                System.out.print(" (buffed attack)");
                isBuffed = false; // Reset buff status after attack
            }

            enemyHealth = Math.max(0, enemyHealth - damage);
            System.out.println("\nEnemy HP: " + enemyHealth);
        } else {
            System.out.println("Miss");
        }
    }

    System.out.println("Enemy died in " + turns + " turns");
}




}


