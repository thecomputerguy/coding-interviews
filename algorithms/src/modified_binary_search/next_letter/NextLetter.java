class NextLetter {

  public static char searchNextLetter(char[] letters, char key) {
    int n = letters.length;
    int start = 0; int end = n-1;
    if(key < letters[0] || key > letters[n-1]) return letters[0];
    while(start <= end){
        int mid = start + (end - start) / 2;

        if(key < letters[mid]){
            end = mid - 1;            
        }else{
            start = start + 1;
        }
    }
    return letters[start%n];
  }

  public static void main(String[] args) {
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
    System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
  }
}