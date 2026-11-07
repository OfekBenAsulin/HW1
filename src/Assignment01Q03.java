public class Assignment01Q03 {
    public static void main(String[] args) {
        int x;
        if (args.length == 0) {
            x = 0;
        }
        else {
            x = Integer.parseInt(args[0]);
        }
        System.out.println("The first " + x + " Fibonacci numbers are:");
        int numOdd = 0;
        int f1 = 1;
        int f2 = 1;
        for (int i = 0; i < x; i++) {
            System.out.print(f1);
            if(f1%2!=1){
                numOdd++;
            }
            int temp = f1;
            f1=f2;
            f2+=temp;
            if (i < x - 1)
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        System.out.println("The number of odd numbers is: " + numOdd);
        }
    }
