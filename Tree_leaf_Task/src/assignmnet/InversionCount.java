package assignmnet;


/*
 * @author : rabin
 */

public class InversionCount {

    // Merges two subarrays and counts inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left;    // Starting index for merged array
        int invCount = 0;

        // Merge two sorted subarrays and count inversions
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // Count inversions
            }
        }

        // Copy remaining elements of left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged subarray back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    // Sorts the array and counts inversions
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }

        return invCount;
    }

    // Driver function to count inversions
    public static int countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 4, 5};
        int inversions = countInversions(arr);
        System.out.println("Number of inversions: " + inversions);
    }
}
