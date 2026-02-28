public class mergesort {
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int q = (start + end) / 2;
            mergeSort(array, start, q);
            mergeSort(array, q + 1, end);
            merge(array, start, q, end);
        }
    }
    
    public static void merge(int[] array, int start, int q, int end) {
        int n1 = q - start + 1;
        int n2 = end - q;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = array[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[q + 1 + j];
        }

        int i = 0, j = 0;
        int k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
