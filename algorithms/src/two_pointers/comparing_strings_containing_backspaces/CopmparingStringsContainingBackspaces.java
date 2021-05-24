public class CopmparingStringsContainingBackspaces {
    

    public static boolean compare(String input1, String input2){
        if(input1 == null || input1.length() == 0 || input2 == null || input2.length() == 0) return false;

        int index1 = input1.length() - 1, index2 = input2.length() - 1;

        while(index1 >= 0 ||  index2 >= 0){
            int ind1 = getNextValidIndex(input1, index1);
            int ind2 = getNextValidIndex(input2, index2);

            //Both strings have reached end.
            if (ind1 < 0 && ind2 < 0) {
                return true;
            }

            if (ind1 < 0 || ind2 < 0) {
                return false;               
            }

            if (input1.charAt(ind1) != input2.charAt(ind2)) {
                return false;
            }
            index1 = ind1 - 1;
            index2 = ind2 - 1;
        }

        return true;
    }   

    private static int getNextValidIndex(String input, int index){
        int backspaceCount = 0;
        while(index  >= 0){
            if(input.charAt(index) == '#'){
                backspaceCount++;
            }else if(backspaceCount > 0){
                backspaceCount--;
            }else{
                break;
            }

            index--;
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(CopmparingStringsContainingBackspaces.compare("xy#z", "xzz#"));
        System.out.println(CopmparingStringsContainingBackspaces.compare("xy#z", "xyz#"));
        System.out.println(CopmparingStringsContainingBackspaces.compare("xp#", "xyz##"));    
        System.out.println(CopmparingStringsContainingBackspaces.compare("xywrrmp", "xywrrmu#p"));
    }
}
