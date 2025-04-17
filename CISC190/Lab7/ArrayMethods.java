import java.util.Arrays;

/**
 * Class with static methods that operate on Arrays.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 4/17/2025 - (Joshua Emralino v1.0)
 */
public class ArrayMethods {

  private int[] myArray = {7, 8, 8, 3, 4, 9, 8, 7};

  /**
   * Counts the number of elements in the array.
   *
   * @return number of elements
   */
  public int count() {
    int count = 0;
    for (int i : myArray) {
      count++;
    }
    return count;
  }

  /**
   * Sums the integers in the array and returns the sum.
   *
   * @return sum of the integer elements
   */
  public int sum() {
    int sum = 0;
    for (int i : myArray) {
      sum += i;
    }
    return sum;
  }

  /**
   * Gets the average value of the array.
   *
   * @return average value in the array
   */
  public double average() {
    return (double) sum() / count();
  }

  /**
   * Finds the max value in the array and returns it.
   *
   * @return max integer value in array
   */
  public int findMax() {
    int max = myArray[0];
    for (int i : myArray) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  /**
   * Finds the max value in the array and returns its index.
   *
   * @return index of max integer value in array
   */
  public int findIndexOfMax() {
    int maxIndex = 0;
    int max = myArray[0];
    for (int i = 0; i < myArray.length; i++) {
      if (myArray[i] > max) {
        max = myArray[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  /**
   * Finds the last occurrence of specified input and returns its index.
   *
   * @param key value to search for
   * @return index of last occurrence of value
   */
  public int findLast(int key) {
    for (int i = myArray.length - 1; i >= 0; i--) {
      if (myArray[i] == key) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Finds all indexes of specified input and returns them in an array.
   *
   * @param key value to search for
   * @return reference to array of indexes of specified input
   */
  public int[] findAll(int key) {
    int count = 0;
    for (int i : myArray) {
      if (i == key) {
        count++;
      }
    }

    int[] retArr = new int[count];
    int retIndex = 0;
    for (int i = 0; i < myArray.length; i++) {
      if (myArray[i] == key) {
        retArr[retIndex] = i;
        retIndex++;
      }
    }

    return retArr;
  }

  /**
   * Getter for array field.
   *
   * @return reference for array field.
   */
  public int[] getArray() {
    return myArray;
  }

  /**
   * Returns a reference to the duplicated array field.
   *
   * @return reference to duplicated array
   */
  public int[] copyArray() {
    return Arrays.copyOf(myArray, myArray.length);
  }

  /**
   * Prints out the contents of the array.
   *
   * @param inArray the array to print out.
   */
  public void print(int[] inArray) {
    System.out.print("{");
    for (int i = 0; i < inArray.length - 1; i++) {
      System.out.printf("%d,", inArray[i]);
    }
    if (inArray.length > 0) {
      System.out.print(inArray[inArray.length - 1]);
    }
    System.out.println("}");
  }

  public void sortArray(int[] a) {
    return;
  }

  public int[] reverseArray(int[] a) {
    return new int[0];
  }

  public void genFiveByFiveRows() {
    return;
  }

  public void genFiveByFiveCols() {
    return;
  }
}
