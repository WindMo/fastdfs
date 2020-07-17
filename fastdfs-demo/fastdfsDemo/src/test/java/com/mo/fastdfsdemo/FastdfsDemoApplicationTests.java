package com.mo.fastdfsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class FastdfsDemoApplicationTests {

    @Test
    void contextLoads() {


    }

    static void sort(int[] A){

        for (int i = 0; i < A.length-1; i++) {

            for (int j=0; j < A.length-i-1; j++) {

                if (A[j] > A[j+1]){

                    int t = A[j];
                    A[j] = A[j+1];
                    A[j+1] = t;
                }
            }
        }

        System.out.println(Arrays.toString(A));
    }


    public static void main(String[] args) {

        int[] A = {5,1,6,8,9,0,2,4};
        sort(A);
    }
}
