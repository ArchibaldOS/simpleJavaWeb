package com.archibald.chapter3.test;

import java.util.Scanner;

/**
 * @author: Archibald.
 * @Description:
 * @version:
 * @time: 9/16/2017.
 */
public class k_test2 {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            num = in.nextInt();
            char [] arr1 = new char[num];
            int[] arr2 = new int[num];
            for (int i=0;i<num;i++){
                arr1[i] = (char) in.nextInt();
                arr2[i] = in.nextInt();
            }
            boolean flag = false;
            for (int i = 0;i<num;i++){
                for (int j=0;j<num;j++){
                    if (i != j){
                        if (arr1[i] == arr1[j]){
                            System.out.println("No");
                            flag = true;
                        }
                    }
                }
            }
            if (flag){
                return;
            }
            System.out.println("YES");

         }
    }
}
