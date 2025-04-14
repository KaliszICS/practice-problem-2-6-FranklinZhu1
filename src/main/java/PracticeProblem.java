public class PracticeProblem {

	public static int[] bubbleSort(double[] nums) {
		boolean swapped;
		double temp;
		int arr[] = new int[2];
		for (int i = 0; i < nums.length - 1; ++i) {
			swapped = false;
			for (int j = 0; j < nums.length - 1 - i; ++j) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
					arr[0] += 3; // swap done
					swapped = true;
				}
				++arr[1]; // if condition
			}
			if (!swapped) break;
		}
		return arr;
	}

	public static int[] selectionSort (double[] nums) {
		int lowest;
		double temp;
		int arr[] = new int[2];
		for (int i = 0; i < nums.length - 1; ++i) {
			lowest = i;
			// ++arr[0]; // variable reassignment
			// ^ this isn't included (initialization sorta ig)
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[j] < nums[lowest]) {
					lowest = j;
					++arr[0]; // variable reassignment
				}
				++arr[1]; // if condition
			}
			temp = nums[i];
			nums[i] = nums[lowest];
			nums[lowest] = temp;
			arr[0] += 3; // swap done
		}
		return arr; // arr[1] will always be (nums.length)(nums.length - 1)/2
	}

	public static int[] insertionSort(double[] nums) {
		int index;
		double key;
		int arr[] = new int[2];
		for (int i = 1; i < nums.length; ++i) {
			key = nums[i];
			index = i - 1;
			arr[0] += 2; // 2 variable reassignments
			while (index >= 0 && nums[index] > key) {
				++arr[1]; // while condition
				nums[index + 1] = nums[index--];
				++arr[0]; // variable reassignment
			}
			// if (index == i - 1) ++arr[1]; // if broken out of the while loop based on comparison SPECIFICALLY when the element is already sorted (edge case, fine)
			nums[index + 1] = key;
			// ++arr[0]; // variable reassignment
			// ^ this isn't included?????????
		}
		return arr;
	}

	public static String leastSwaps(double[] nums) {
		int[] swapNum = new int[3]; // stores number of swaps for bubble, insertion, selection sort in that order
		String[] sortNames = {"Bubble", "Insertion", "Selection"}; // parallel array to store the names of each algorithm
		double[] numsCopy = new double[nums.length];
		for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
		swapNum[0] = bubbleSort(numsCopy)[0];
		for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
		swapNum[1] = insertionSort(numsCopy)[0];
		for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
		swapNum[2] = selectionSort(numsCopy)[0];
		int lowestNum = Integer.MAX_VALUE, lowestIndex = 0;
		for (int i = 0; i < 3; ++i) {
			if (swapNum[i] < lowestNum) { // check if sort produces least swaps
				lowestNum = swapNum[i];
				lowestIndex = i; // store index of optimal sort
			}
		}
		return sortNames[lowestIndex];
	}

	public static String leastIterations(double[] nums) {
		int[] itNum = new int[3]; // stores number of iterations for bubble, insertion, selection sort in that order
		String[] sortNames = {"Bubble", "Insertion", "Selection"}; // parallel array to store the names of each algorithm
		double[] numsCopy = new double[nums.length];
		for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
		itNum[0] = bubbleSort(numsCopy)[1];
		for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
		itNum[1] = insertionSort(numsCopy)[1];
		for (int i = 0; i < nums.length; ++i) numsCopy[i] = nums[i];
		itNum[2] = selectionSort(numsCopy)[1];
		int lowestNum = Integer.MAX_VALUE, lowestIndex = 0;
		for (int i = 0; i < 3; ++i) {
			if (itNum[i] < lowestNum) { // check if sort produces least swaps
				lowestNum = itNum[i];
				lowestIndex = i; // store index of optimal sort
			}
		}
		return sortNames[lowestIndex];
	}

}
