package arrays;

public class ShearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {16,19,21,25,3,5,8,10};
		int n;
		n = 8;
		System.out.println("Index of element "+n+" : "+findElementRotatedSortedArray(arr,n));
		int arr1[] = {6,88,101,125,220,430,500,808};
		n = 101;
		System.out.println("Index of element "+n+" : "+findElementRotatedSortedArray(arr1,n));
	}
	public static int findElementRotatedSortedArray(int[] arr, int number){
		int mid;
		int low = 0, high = arr.length-1;
		
		while (low <= high){
			mid = low + ((high - low) / 2);
			if (arr[mid] == number) {
				return mid;
			}
			if (arr[mid] <= arr[high]) {
				if (number > arr[mid] && number <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (number >= arr[low] && number < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
		
	}

}
