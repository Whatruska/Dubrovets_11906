package SecondSem.ADS.Control_Work;

public class StoogeSort {
    //Лучший и средний случаи - T = O(NlogN); Худший случай - T = O(N^2)
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,1,6};
        arr = stoogeSort(arr);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void swap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] merge(int[] arr, int h1, int h2){
        int l = 0;
        int r = arr.length;
        int[] res = new int[arr.length];
        int freeIndex = 0;
        int i = l;
        int j = h1;
        int k = h2;
        while (i < h1 && j < h2 && k < r){
            if (arr[i] <= arr[j] && arr[i] <= arr[k]){
                res[freeIndex++] = arr[i++];
            } else if (arr[j] <= arr[i] && arr[j] <= arr[k]){
                res[freeIndex++] = arr[j++];
            } else if (arr[k] <= arr[i] && arr[k] <= arr[j]){
                res[freeIndex++] = arr[k++];
            }
        }

        if (i == h1){
            while (j < h2 && k < r){
                if (arr[j] <= arr[k]){
                    res[freeIndex++] = arr[j++];
                } else {
                    res[freeIndex++] = arr[k++];
                }

                while (j < h2){
                    res[freeIndex++] = arr[j++];
                }
                while (k < r){
                    res[freeIndex++] = arr[k++];
                }
            }
        } else if (j == h2){
            while (i < h1 && k < r){
                if (arr[i] <= arr[k]){
                    res[freeIndex++] = arr[i++];
                } else {
                    res[freeIndex++] = arr[k++];
                }

                while (i < h1){
                    res[freeIndex++] = arr[i++];
                }
                while (k < r){
                    res[freeIndex++] = arr[k++];
                }
            }
        } else {
            while (j < h2 && i < h1){
                if (arr[i] <= arr[j]){
                    res[freeIndex++] = arr[i++];
                } else {
                    res[freeIndex++] = arr[j++];
                }

                while (j < h2){
                    res[freeIndex++] = arr[j++];
                }
                while (i < h1){
                    res[freeIndex++] = arr[i++];
                }
            }
        }

        return res;
    }

    public static void stooge(int[] arr, int l, int r){
        int length = r - l + 1;
        if (length > 1){
            if (length == 2){
                if (arr[l] > arr[r]){
                    swap(arr, l, r);
                }
            } else if (length == 3){
                if (arr[l] > arr[r]){
                    swap(arr, l, r);
                }
                if (arr[l + 1] > arr[r]){
                    swap(arr, l + 1, r);
                }
            } else {
                int h1 = l + length/3;
                int h2 = h1 + length/3;
                stooge(arr, l, h1);
                stooge(arr, h1, h2);
                stooge(arr, h2, r);
            }
        }
    }

    public static int[] stoogeSort(int[] arr){
        int r = arr.length - 1;
        int l = 0;
        int length = r - l + 1;
        int h1 = l + length/3;
        int h2 = h1 + length/3;
        stooge(arr, l, r);
        return merge(arr, h1, h2);
    }
}
