package com.archibald.chapter3.test;

import java.util.Scanner;

/**
 * @author: Archibald.
 * @Description:
 * @version:
 * @time: 9/18/2017.
 */
public class M_test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String init = in.next();
            char[] initChar = init.toCharArray();
            String temp = "_";
            for (int i = 0; i < initChar.length;i++){
                if (initChar[i] == '.'){
                    if (temp.endsWith("_")){
                        continue;
                    }
                    initChar[i] = '_';
                    temp = temp + initChar[i];
                    continue;
                }
                if (i < initChar.length -1) {
                    if ( (48 > initChar[i] || initChar[i] > 57) && (48 <= initChar[i + 1] && initChar[i + 1] <= 57)){
                        if (65 <= initChar[i] && initChar[i] <= 90){
                            temp = temp + initChar[i]+"_";
                            continue;
                        }
                        if (97 <= initChar[i] && initChar[i] <= 122){
                            initChar[i] = (char) ((int)initChar[i] - 32);
                            temp = temp + initChar[i]+"_";
                            continue;
                        }
                    }
                }
                if (i < initChar.length -2) {
                    if ((65 <= initChar[i] && initChar[i] <= 90) && (65 <= initChar[i + 1] && initChar[i + 1] <= 90) && (65 <= initChar[i + 2] && initChar[i + 2] <= 90)) {
                        temp = temp + initChar[i];
                        continue;
                    }
                    if ((65 <= initChar[i] && initChar[i] <= 90) && (65 <= initChar[i + 1] && initChar[i + 1] <= 90) && (97 <= initChar[i + 2] && initChar[i + 2] <= 122)) {
                        temp = temp + initChar[i] + "_";
                        continue;
                    }
                }
                if (65 <= initChar[i] && initChar[i] <= 90){
                    temp = temp + initChar[i];
                    continue;
                }
                if (97 <= initChar[i] && initChar[i] <= 122){
                    initChar[i] = (char) ((int)initChar[i] - 32);
                    temp = temp + initChar[i];
                    continue;
                }
                if (i < initChar.length -1) {
                    if ((48 <= initChar[i] && initChar[i] <= 57) && (48 <= initChar[i + 1] && initChar[i + 1] <= 57) ) {
                        temp = temp + initChar[i];
                        continue;
                    }
                    if ((48 <= initChar[i] && initChar[i] <= 57) && (48 > initChar[i+1] || initChar[i+1] > 57) ) {
                        temp = temp + initChar[i]+"_";
                        continue;
                    }
                }
                if (48 <= initChar[i] && initChar[i] <= 57) {
                    temp = temp + initChar[i];
                    continue;
                }
            }
            if (!(temp.endsWith("_"))){
                temp = temp + "_";
            }
            System.out.println(temp);
        }
    }
}
