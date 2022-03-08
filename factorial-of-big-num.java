class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        int fact=1;
        ArrayList<Integer> al = new ArrayList<Integer>();
        //java.math.BigInteger num = new java.math.BigInteger("1");
        if(N>=1 && N<=1000){
            java.math.BigInteger num = new java.math.BigInteger("1");

       for (int i = 2; i <= N; i++) {
           num = num.multiply(java.math.BigInteger.valueOf(i));
       }

       char[] charArray = num.toString().toCharArray();

       for (char c : charArray) {
           int i = Integer.parseInt(String.valueOf(c));
           al.add(i);
       }
        }
        return al;
    }
}
