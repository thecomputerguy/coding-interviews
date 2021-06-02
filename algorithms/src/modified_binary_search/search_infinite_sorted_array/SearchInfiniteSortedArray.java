class ArrayReader{
    int[] array;
    public ArrayReader(int[] arr){
        this.array = arr;
    }

    public int get(int index){
        if(index >= array.length){
            return Integer.MAX_VALUE;
        }
        return array[index];
    }
}

public class SearchInfiniteSortedArray {
    
    public static int search(ArrayReader reader, int key){
        if(reader == null) return -1;
        //find the searchable bounds...
        int start = 0; int end = 1;
        while(reader.get(end) < key){
            int windowLength = end - start + 1;
            start = end + 1;
            end = windowLength * 2;
        }

        return binarySearch(reader, key, start, end);
    }

    private static int binarySearch(ArrayReader reader, int key, int start, int end){
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(reader.get(mid) == key){
                return mid;
            }

            if(key < reader.get(mid)){
                end = mid - 1;
            }else if(key > reader.get(mid)){
                start = start + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}
