//package com.archibald.chapter3.test;
//
//import java.util.Scanner;
//
///**
// * @author: Archibald.
// * @Description:
// * @version:
// * @time: 9/9/2017.
// */
//public class wtest1 {
//    public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    while (in.hasNext()) {
//        int scan_num = in.nextInt();
//        String[] arr_temp = new String[scan_num];
//        for (int i = 0; i < scan_num; i++) {
//            int num = in.nextInt();
//            int[] arr = new int[num];
//            for (int j = 0; j < num; j++) {
//                arr[j] = in.nextInt();
//            }
//            int count1 = 0;
//            int count2 = 0;
//            int count3 = 0;
//            for (int temp : arr) {
//                if (temp %2 ==0){
//                    count3++;
//                }
//                if (temp % 2 == 1) {
//                    count1++;
//                } else {
//                    if (temp %4 == 0) {
//                        count2++;
//                    }
//                }
//            }
//            if (num-count2 == count2 +1 || count3) {
//                arr_temp[i] = "Yes";
//            } else {
//                arr_temp[i] = "No";
//            }
//        }
//        for (String temp : arr_temp) {
//            System.out.println(temp);
//        }
//    }
//}
//}
