package timus;

import java.util.Scanner;
public class t1293 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();
        long result = 2L*N*A*B;
        System.out.println(result);
    }
}
