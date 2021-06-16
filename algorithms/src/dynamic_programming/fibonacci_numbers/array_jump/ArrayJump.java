class ArrayJump {

  public int countMinJumps(int[] jumps) {
    if(jumps == null || jumps.length == 0) return Integer.MAX_VALUE;   
    return countMinJumpsRecursive(jumps , 0);
  }

  private int countMinJumpsRecursive(int[] jumps, int currentIndex){
    if(jumps.length - 1 == currentIndex){
        return 0;
    }
    if(jumps[currentIndex] == 0){
        return Integer.MAX_VALUE;
    }

    int totalJumps = Integer.MAX_VALUE;
    int start = currentIndex + 1;
    int end = currentIndex + jumps[currentIndex];
    while (start < jumps.length && start <= end) {
        int minJumps = countMinJumpsRecursive(jumps, start++); 
        if(minJumps != Integer.MAX_VALUE){
            totalJumps = Math.min(totalJumps, minJumps + 1);       
        }
    }

    return totalJumps;
  }

  public static void main(String[] args) {
    ArrayJump aj = new ArrayJump();
    int[] jumps = {2, 1, 1, 1, 4};
    System.out.println(aj.countMinJumps(jumps));
    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
    System.out.println(aj.countMinJumps(jumps));
  }
}