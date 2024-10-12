// Brute Force
// TC: O(N2)
// SC: O(1)

import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) cnt++;
            }
        }
        return cnt;
    }
}

// Optimal Approach
// TC: O(N logN)
// SC: O(N)

import java.util.*;
import java.io.*;
public class Solution {

    public static long merge(long arr[], int left, int mid, int right) {
        int cnt = 0;

        ArrayList<Long> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid & j <= right) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                cnt += mid - i + 1;
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }

        return cnt;
    }

    public static long mergeSort(long arr[], int left, int right) {
        long cnt = 0;

        if (left < right) {

            int mid = (left + right) / 2;

            cnt += mergeSort(arr, left, mid);
            cnt += mergeSort(arr, mid + 1, right);

            cnt += merge(arr, left, mid, right);

        }
        return cnt;

    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return mergeSort(arr, 0, n - 1);
    }
}