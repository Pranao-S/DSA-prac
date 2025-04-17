public class palindrome{
    public boolean isPalindrome(int x){
        if(x<0 || (x%10 == 0 && x!= 0)) return false;
            //for negative numbers or multiple of 10 (both positive and negative it should return false)
        
            int half = 0;
            while (x>half){
                half = half * 10 + x%10;
                x/=10; //removes the last digit from the expression
            }
            return x == half || x == half/10;
        }

        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
    
            // Create an object to call the non-static method
            palindrome checker = new palindrome();
            boolean result = checker.isPalindrome(number);
            scanner.close();
            System.out.println("Is " + number + " a palindrome? " + result);
        }
}
