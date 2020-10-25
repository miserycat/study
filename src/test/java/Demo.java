import java8.java8inAction.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    @Test
    public void test1() {
        List<Person> p1 = new ArrayList<>();
        p1.add(new Person());
    }

    @Test
    public void test2() {
        int[] array = {19,10,5,3,4,6,11};

        bubbleSort(array);
//        quickSort(array, 0, array.length - 1);

        Arrays.stream(array)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        System.out.println(List.class.isAssignableFrom(LinkedList.class));
    }

    private void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(array, startIndex, endIndex);

        quickSort(array, startIndex, pivotIndex -1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    private int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && array[endIndex] > pivot) {
                right--;
            }

            while (left < right && array[startIndex] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    private void bubbleSort(int array[]) {
        int sortIndex = array.length - 1;
        int lastExchangeIndex = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < sortIndex; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    lastExchangeIndex = j;
                    sorted = false;
                }
            }
            sortIndex = lastExchangeIndex;
            if (sorted) {
                break;
            }
        }
    }

}


class A {
    private final String name;
    private final int order;

    A(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }
}