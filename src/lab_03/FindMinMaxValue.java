package lab_03;

import java.util.*;
import java.util.stream.Collectors;

public class FindMinMaxValue {

    public static void main(String[] args) {
        Integer[] arr1 = {100, 1, 55, 30, 201, 6, 7, 11, 201};
        Integer[] arr2 = {11, 388, 122, 6, 11, 201, 999};

        List<Integer> dumpList = getDuplicateList_Way2(arr1, arr2);
        System.out.println("Cac gia tri duplicate: " + dumpList);
    }

    public static void getMinMaxValue(int[] arr) {
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int index = 1; index < arr.length; index++) {
            if (arr[index] < minValue) {
                minValue = arr[index];
            }
            if (arr[index] > maxValue) {
                maxValue = arr[index];
            }
        }
        System.out.printf("Min value is: %d\n", minValue);
        System.out.printf("Max value is: %d\n", maxValue);
    }

    public static void find2ndMaxValue_Way1(Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        Set<Integer> set = new HashSet<>(list);
        List<Integer> sortedList = new ArrayList<>(set);
        System.out.println("Phan tu lon thu 2 la: " + sortedList.get(1));
    }

    public static int find2ndMaxValue_Way2(Integer[] arr) {
        int minValue = 0;
        int maxValue = arr[0];
        int _2ndMaxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= maxValue) {
                minValue = maxValue;
                maxValue = arr[i];
            } else if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > _2ndMaxValue) {
                _2ndMaxValue = arr[i];
            }
        }
        return _2ndMaxValue;
    }

    public static List<Integer> getDuplicateList_Way1(Integer[] arr1, Integer[] arr2) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));

        List<Integer> list1 = new ArrayList<>(set1);
        List<Integer> list2 = new ArrayList<>(set2);

        list1.addAll(list2);

        Set<Integer> set = new HashSet<Integer>();
        List<Integer> dumpList = new ArrayList<>();

        for (int i : list1) {
            if (set.contains(i)) {
                dumpList.add(i);
            }
            ;
            set.add(i);
        }
        return dumpList;
    }

    public static List<Integer> getDuplicateList_Way2(Integer[] arr1, Integer[] arr2) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));

        Map<Integer, Integer> map = set1.stream().collect(Collectors.toMap(a -> a, o -> o));
        List<Integer> duplicateList = new ArrayList<>();

        for (Integer i : set2) {
            if (i.equals(map.get(i))) {
                duplicateList.add(i);
            }
        }
        return duplicateList;
    }
}

