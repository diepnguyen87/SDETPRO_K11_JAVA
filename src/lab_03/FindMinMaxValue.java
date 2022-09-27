package lab_03;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMaxValue {

    public static void main(String[] args) {
        Integer[] arr1 = {100, 1, 55, 30, 201, 6, 7, 11, 201, 30};
        Integer[] arr2 = {11, 388, 122, 6, 11, 201, 999};
        String[] arr = new String[3];
        //List<Integer> dumpList = getDuplicateList_Way2(arr1, arr2);
        //System.out.println("Cac gia tri duplicate: " + dumpList);
        String[] arr3 = new String[]{"true", "true", "true", "true"};
        String[] values = {"true", "false"};
        combinationNElement_Way3(4, values);

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

    public static Set<String[]> combinationNElement_Way1(String[] arr, String[] valuesInArr) {
        Set<String[]> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < valuesInArr.length; i1++) {
                for (int i2 = 0; i2 < valuesInArr.length; i2++) {
                    String[] arr4 = new String[4];
                    arr4[i] = valuesInArr[i1];
                    for (int i3 = 0; i3 < arr4.length; i3++) {
                        if (i == i3) {
                            continue;
                        }
                        arr4[i3] = valuesInArr[i2];
                    }
                    set.add(arr4);
                }
            }
        }
        return set;
    }

    public static void combinationNElement_Way2(String[] arr, String[] valuesInArr) {
        for (int i = 0; i < valuesInArr.length; i++) {
            for (int i1 = 0; i1 < valuesInArr.length; i1++) {
                for (int i2 = 0; i2 < valuesInArr.length; i2++) {
                    for (int i3 = 0; i3 < valuesInArr.length; i3++) {
                        System.out.println(Arrays.toString(new String[]{valuesInArr[i], valuesInArr[i1], valuesInArr[i2], valuesInArr[i3]}));
                    }
                }
            }
        }
    }

    public static void combinationNElement_Way3(int n, String[] valuesInArr) {
        //System.out.println();
        for (int i = 0; i < valuesInArr.length; i++) {
            if(n == 1) {
                System.out.println(valuesInArr[i] + " ");
                n = 4;
            }else{
                System.out.print(valuesInArr[i] + " ");
                --n;
            }
            combinationNElement_Way3(n, valuesInArr);
        }
    }

    public static void printValueInSetCollection(Set<String[]> set) {
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(Arrays.toString((String[]) iter.next()));
        }
    }

    public static void printIsoscelesRightTriangle(int n) {
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < row + 1; ++i) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

