package com.cyt.controller;

/**
 * @ClassName Test
 * @Description 添加描述
 * @Author CYT
 * @LastChangeDate 2023/3/4 13:01
 * @Version v2.0.1
 */
public class Test {
    public static void main(String[] args) {
        /**
         * x=公鸡
         * y=母鸡
         * z=小鸡
         */
        int z= 0;
        for (int x = 0; x <=20; x++) {
            for (int y = 0; y <=33 ; y++) {
                z=100-x-y;
                if (5*x+3*y+z/3.0==100){
                    System.out.println("z:"+z);
                    System.out.println("x:"+x);
                    System.out.println("y:"+y);
                    System.out.println("--------");
                }
            }
        }

    }
}
