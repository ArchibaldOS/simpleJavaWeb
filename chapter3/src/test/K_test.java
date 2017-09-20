package com.archibald.chapter3.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.Scanner;

/**
 * @author: Archibald.
 * @Description:
 * @version:
 * @time: 9/16/2017.
 */
public class K_test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String arr = in.next();
            char[] cArr = arr.toCharArray();
            System.out.println(stand(cArr,0));
            System.out.println(cArr);
        }
    }
    public static int stand(char[] cArr,int i){
        for (;i<cArr.length-1;i++){
            if ((cArr[i] == 'R' && cArr[i+1] == 'L')){
                if (i+2<=cArr.length-1) {
                    if (cArr[i + 1] == cArr[i + 2]) {
                        cArr[i + 1] = 'R';
                    }
                }
                cArr[i + 1] = 'L';
                for (int j = 0; j < cArr.length - 1; j++) {
                    if (j < i) {
                        cArr[j] = cArr[j];
                    } else {
                        cArr[j] = cArr[j + 1];
                    }
                    if (j == cArr.length-1){
                        cArr[j]=' ';
                    }
                }
                stand(cArr,i);
            }
        }
        return cArr.length;
    }
}
