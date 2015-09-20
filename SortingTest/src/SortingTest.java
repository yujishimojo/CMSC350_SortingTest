import javax.swing.JOptionPane;

public class SortingTest {
	static int numberComparisons1, numberComparisons2, numberComparisons3, numberComparisons4, numberComparisons5;
	
	public static void main(String[] args) {
		String input;
		int listSize;
		int randInt;
		long timeStart, timeEnd;
		double elapsedSeconds;
		
		input = JOptionPane.showInputDialog( "Enter number of random ints to generate" );
		listSize = Integer.parseInt(input);
		
		Integer [] intArray1 = new Integer[listSize];
		Integer [] intArray2 = new Integer[listSize];
		Integer [] intArray3 = new Integer[listSize];
		Integer [] intArray4 = new Integer[listSize];
		Integer [] intArray5 = new Integer[listSize];
		
		for (int i=0; i<=listSize-1; i++) {
		    randInt = (int)(Math.random()*listSize);  // random int between 0 and range-1
		    intArray1[i] = new Integer(randInt);
		    intArray2[i] = new Integer(randInt);
		    intArray3[i] = new Integer(randInt);
		    intArray4[i] = new Integer(randInt);
		    intArray5[i] = new Integer(randInt);
		}
		
		//*** here is the selection sorting
		timeStart = System.currentTimeMillis();   // time now
		selectionSort(intArray1);
		timeEnd = System.currentTimeMillis();   // time now
		// difference between the start and end times is the elapsed time in ms
		elapsedSeconds = (timeEnd-timeStart)/1000.0;
		System.out.println("*** Selection sort ***");
		System.out.println("Elapsed time of selection sort: " + elapsedSeconds + "s");
		System.out.println("Number of comparisons: " + numberComparisons1);
		System.out.println("Time per comparison: " + (elapsedSeconds/numberComparisons1) + "s");
		showIntArray(intArray1);
		System.out.println();

		//*** here is the insertion sorting
		timeStart = System.currentTimeMillis();
		insertionSort(intArray2);
		timeEnd = System.currentTimeMillis();
		elapsedSeconds = (timeEnd-timeStart)/1000.0;
		System.out.println("*** Insertion sort ***");
		System.out.println("Elapsed time of insertion sort: " + elapsedSeconds + "s");
		System.out.println("Number of comparisons: " + numberComparisons2);
		System.out.println("Time per comparison: " + (elapsedSeconds/numberComparisons2) + "s");
		showIntArray(intArray2);
		System.out.println();
		
		//*** here is the bubble sorting
		timeStart = System.currentTimeMillis();
		bubbleSort(intArray3);
		timeEnd = System.currentTimeMillis();
		elapsedSeconds = (timeEnd-timeStart)/1000.0;
		System.out.println("*** Bubble sort ***");
		System.out.println("Elapsed time of bubble sort: " + elapsedSeconds + "s");
		System.out.println("Number of comparisons: " + numberComparisons3);
		System.out.println("Time per comparison: " + (elapsedSeconds/numberComparisons3) + "s");
		showIntArray(intArray3);
		System.out.println();
				
		//*** here is the quick sorting
		timeStart = System.currentTimeMillis();
		quickSort(intArray4, 0, listSize-1);
		timeEnd = System.currentTimeMillis();
		elapsedSeconds = (timeEnd-timeStart)/1000.0;
		System.out.println("*** Quick sort ***");
		System.out.println("Elapsed time of quick sort: " + elapsedSeconds + "s");
		System.out.println("Number of comparisons: " + numberComparisons4);
		System.out.println("Time per comparison: " + (elapsedSeconds/numberComparisons4) + "s");
		showIntArray(intArray4);
		System.out.println();

		//*** here is the merge sorting
		timeStart = System.currentTimeMillis();
		mergeSort(intArray5, 0, listSize-1);
		timeEnd = System.currentTimeMillis();
		elapsedSeconds = (timeEnd-timeStart)/1000.0;
		System.out.println("*** Merge sort ***");
		System.out.println("Elapsed time of merge sort: " + elapsedSeconds + "s");
		System.out.println("Number of comparisons: " + numberComparisons5);
		System.out.println("Time per comparison: " + (elapsedSeconds/numberComparisons5) + "s");
		showIntArray(intArray5);		
	}
	
	   /**
	    * Sorts the specified array of integers using the selection
	    * sort algorithm.
	    *
	    * @param data  the array to be sorted
	    */	    
	   public static <T extends Comparable<? super T>> void selectionSort (T[] data)
	   {
	      int min;
	      T temp;
	      
	      for (int index = 0; index < data.length-1; index++)
	      {
	         min = index;
	         for (int scan = index+1; scan < data.length; scan++) {
             numberComparisons1++;
	            if (data[scan].compareTo(data[min])<0) {
	               min = scan;
	            }
	         }     
	         /** Swap the values */
	         temp = data[min];
	         data[min] = data[index];
	         data[index] = temp;
	      }
	   }
	   
	   /**
	    * Sorts the specified array of objects using an insertion
	    * sort algorithm.
	    *
	    * @param data  the array to be sorted
	    */
	   public static <T extends Comparable<? super T>> void insertionSort (T[] data)
	   {
	      for (int index = 1; index < data.length; index++)
	      {
	         T key = data[index];
	         int position = index;

	         /** Shift larger values to the right */
	         while (position > 0 && data[position-1].compareTo(key) > 0)
	         {
	            numberComparisons2++;
	            data[position] = data[position-1];
	            position--;
	         }
	         data[position] = key;
	      }
	   }
	   
	   /**
	    * Sorts the specified array of objects using a bubble sort
	    * algorithm.
	    *
	    * @param data  the array to be sorted
	    */
	   public static <T extends Comparable<? super T>> void bubbleSort (T[] data)
	   {
	      int position, scan;
	      T temp;

	      for (position =  data.length - 1; position >= 0; position--)
	      {
	         for (scan = 0; scan <= position - 1; scan++)
	         {
                numberComparisons3++;
	            if (data[scan].compareTo(data[scan+1]) > 0)
	            {
	               /** Swap the values */
	               temp = data[scan];
	               data[scan] = data[scan + 1];
	               data[scan + 1] = temp;
	            }
	         }
	      }
	   }
	   
 	   public static <T extends Comparable<? super T>> void quickSort (T[] data, int min, int max)
	   {
	      int indexofpartition;
	      if (max - min  > 0)
	      {
	         /** Create partitions */
	         indexofpartition = findPartition(data, min, max);

	         /** Sort the left side */
	         quickSort(data, min, indexofpartition - 1);

	         /** Sort the right side */
	         quickSort(data, indexofpartition + 1, max);
	      }
	   }

	   /**
	    * Used by the quick sort algorithm to find the partition.
	    *
	    * @param data  the array to be sorted
	    * @param min   the integer representation of the minimum value  
	    * @param max   the integer representation of the maximum value
	    */
	   private static <T extends Comparable<? super T>> int findPartition (T[] data, int min, int max)
	   {
	      int left, right;
	      T temp, partitionelement;
	      int middle = (min + max)/2;

	      partitionelement = data[middle]; // use middle element as partition
	      left = min;
	      right = max;
	   
	      while (left<right)
	      {
	         /** search for an element that is > the partitionelement */
	         while (data[left].compareTo(partitionelement) <=0 &&
	                            left < right) {
		            numberComparisons4++;
	        	    left++;
	         }

	         /** search for an element that is < the partitionelement */
	         while (data[right].compareTo(partitionelement) > 0) {
		         numberComparisons4++;
	        	 right--;
	         }

	         /** swap the elements  */
	         if (left<right)
	         {
	            temp = data[left];
	            data[left] = data[right];
	            data[right] = temp;
	         }
	      }

	      /** move partition element to partition index*/
	      temp = data[min];
	      data[min] = data[right];
	      data[right] = temp;
	         
	      return right;
	   }

	   /**
	    * Sorts the specified array of objects using the merge sort
	    * algorithm.
	    *
	    * @param data  the array to be sorted
	    * @param min   the integer representation of the minimum value 
	    * @param max   the integer representation of the maximum value
	    */
	   public static <T extends Comparable<? super T>> void mergeSort (T[] data, int min, int max)
	   {
	      T[] temp;
	      int index1, left, right;

	      /** return on list of length one */
	      if (min==max)
	         return; 

	      /** find the length and the midpoint of the list */
	      int size = max - min + 1;
	      int pivot = (min + max) / 2;
	      temp = (T[])(new Comparable[size]);
	      
	      mergeSort(data, min, pivot); // sort left half of list
	      mergeSort(data, pivot + 1, max); // sort right half of list

	      /** copy sorted data into workspace */
	      for (index1 = 0; index1 < size; index1++)
	         temp[index1] = data[min + index1];
	      
	      /** merge the two sorted lists */
	      left = 0;
	      right = pivot - min + 1;
	      for (index1 = 0; index1 < size; index1++)
	      {
	         if (right <= max - min) {
	            if (left <= pivot - min) {
	               numberComparisons5++;
	               if (temp[left].compareTo(temp[right]) > 0) {
		                  data[index1 + min] = temp[right++];
	               } else {
	                  data[index1 + min] = temp[left++];
	               }
	            } else {
	               data[index1 + min] = temp[right++];
	            }
	         } else {
	            data[index1 + min] = temp[left++];
	         }
	      }
	   }
	   
	   // show values of an int array
	   public static void showIntArray(Integer[] array) {
			for (int i=0; i<array.length; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
	   }
}
