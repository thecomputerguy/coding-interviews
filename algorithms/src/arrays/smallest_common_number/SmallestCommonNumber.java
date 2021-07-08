public class SmallestCommonNumber {
    
    public static int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3){
        if(arr1 == null || arr2 == null || arr3 == null || arr1.length == 0 || arr2.length == 0 || arr3.length == 0){
            return -1;
        }

        int index1 = 0; int index2 = 0; int index3 = 0;
        while (index1 < arr1.length && index2 < arr2.length && index3 < arr3.length) {
            int el1 = arr1[index1];
            int el2 = arr2[index2];
            int el3 = arr3[index3];
            if(el1 == el2 && el2 == el3){
                return el1;
            }
            if(el1 <= el2 && el1 <= el3){
                index1++;
            }else if(el2 <= el1 && el2 <= el3){
                index2++;
            }else if(el3 <= el1 && el3 <= el2){
                index3++;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{1, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 6, 10, 14};

        Integer result = findLeastCommonNumber(v1, v2, v3);
        System.out.println("Least Common Number: " + result);    
    }
}
