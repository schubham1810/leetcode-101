class Solution {
    public int reversePairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int r[] = new int[]{0};
        mergeSortAndCount(arr, 0, arr.length - 1,r);
        return r[0];
    }

    private void mergeSortAndCount(int[] arr, int left, int right,int[] r) {
        if (left < right) {            

            int mid = (left + right) / 2;

            mergeSortAndCount(arr, left, mid, r);
            mergeSortAndCount(arr, mid + 1, right, r);
            mergeAndCount(arr, left, mid, right, r);
        }
    }

    private void mergeAndCount(int[] arr, int left, int mid, int right,int[] r) {
        int j = mid + 1;

        // Counting reverse pairs
        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[i] > 2 * (long) arr[j]) {
                j++;
            }
            r[0] += (j - (mid + 1));
        }

        // Merging the two halves
        int[] temp = new int[right - left + 1];
        int i = left, k = 0;
        j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }

    }
}