import java.util.ArrayList;
import java.util.List;

class Pair{
    public int start;
    public int end;

    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}


public class MergeOverlappingIntervals {

    public static List<Pair> mergeIntervals(List<Pair> pairs){
        List<Pair> result = new ArrayList<>();
        Pair first = pairs.get(0);
        for (int i = 1; i < pairs.size(); i++) {
            Pair second = pairs.get(i);
            if(first.end >= second.start){
                //we merge intervals here
                first.end = Math.max(first.end, second.end);
            }else{
                //we add first to the result and move to second
                result.add(new Pair(first.start, first.end));
                first.start = second.start;
                first.end = second.end;
            }
        }

        result.add(new Pair(first.start, first.end));
        return result;
    }    
    
    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));

        List<Pair> result = mergeIntervals(v);

        for(int i=0; i<result.size(); i++){
        System.out.print(String.format("[%d, %d] ", result.get(i).start, result.get(i).end));
        }
    }
}
