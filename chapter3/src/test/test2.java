package com.archibald.chapter3.test;

import java.util.Scanner;

/**
 * @author: Archibald.
 * @Description:
 * @version:
 * @time: 9/6/2017.
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[] arr = new int[100];
            int num = in.nextInt();
            if (num <= 1 || num >= 100){
                System.out.println("ERROR!");
            }else{
                int count = 0;
                int sum = 0;
                for (int i = 0; i < arr.length; i++)
                    arr[i] = i + 1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        count++;
                        sum++;
                    }
                    if (count % num == 0 && count != 0)
                        arr[i] = 0;
                    if (i == arr.length - 1)
                    {
                        i = -1;
                        if (sum <= num){
                            break;
                        }
                        sum = 0;
                    }
                }
                String s="";
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        s=s+arr[i]+",";
                    }
                }
                s=s.substring(0,s.length()-1);
                System.out.println(s);
            }
        }
    }
}
