package udemy.collection;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {-5, -1, 4, 7, 10, 15, 17, 20, 24, 30, 54, 100};
        System.out.println(binarySearch(arr, 4));

    }

    public static int binarySearch(int[] arr, int searchValue) {

        if (searchValue < arr[0] || arr[arr.length - 1] < searchValue) {
            return -1;
        }

        if (searchValue == arr[0]) {
            return 0;
        }

        if (searchValue == arr[arr.length - 1]) {
            return arr.length - 1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;

        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (searchValue < arr[mid]) {
                right = mid - 1;
            } else if (searchValue > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
