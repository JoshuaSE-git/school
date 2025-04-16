import java.util.Arrays;

public class ArrayMethods {

  private static int[] myArray = {7, 8, 8, 3, 4, 9, 8, 7};

  public static int count() {
    int count = 0;
    for (int i : myArray) {
      count++;
    }
    return count;
  }

  public static int sum() {
    int sum = 0;
    for (int i : myArray) {
      sum += i;
    }
    return sum;
  }

  public static double average() {
    return (double) sum() / count();
  }

  public static int findMax() {
    int max = myArray[0];
    for (int i : myArray) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  public static int findIndexOfMax() {
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

  public static int findLast(int key) {
    for (int i = myArray.length - 1; i >= 0; i--) {
      if (myArray[i] == key) {
        return i;
      }
    }
    return -1;
  }

  public static int[] findAll(int key) {
    int count = 0;
    for (int i : myArray) {
      if (i == myArray[key]) {
        count++;
      }
    }

    int[] retArr = new int[count];
    int retIndex = 0;
    for (int i = 0; i < myArray.length; i++) {
      if (myArray[i] == myArray[key]) {
        retArr[retIndex] = i;
        retIndex++;
      }
    }

    return retArr;
  }

  public static int[] getArray() {
    return myArray;
  }

  public static int[] copyArray() {
    return Arrays.copyOf(myArray, myArray.length);
  }

  public static void print(int[] a) {
    return;
  }

  public static void sortArray(int[] a) {
    return;
  }

  public static int[] reverseArray(int[] a) {
    return new int[0];
  }

  public static void genFiveByFiveRows() {
    return;
  }

  public static void genFiveByFiveCols() {
    return;
  }
}
