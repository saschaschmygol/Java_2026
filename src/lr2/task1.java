package lr2;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args){
        Scanner id = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = id.nextInt();
        System.out.println("Размер массива равен "+ size);
        int[] nums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(200);
            System.out.println("Array element ["+i+"] = "+ nums[i]);
        }
        Arrays.sort(nums);
        System.out.println("Промзведена сортировка массива");

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Элемент массива ["+i+"] посе сортировки = " + nums[i]);
        }
    }
}
