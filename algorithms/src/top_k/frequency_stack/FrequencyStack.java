import java.util.*;

class Element{
    int number;
    int frequency;
    int sequence;

    public Element(int number, int frequency, int sequence){
        this.number = number;
        this.frequency = frequency;
        this.sequence = sequence;
    } 
} 

class ElementComparator implements Comparator<Element>{
    
    
    public int compare(Element a, Element b){
        if(a.frequency != b.frequency){
            return b.frequency - a.frequency;
        }

        return b.sequence - a.sequence;
    }
}

class FrequencyStack {
    int sequence = 0;
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());

  public void push(int num) {
    frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    maxHeap.offer(new Element(num, frequencyMap.get(num), sequence++));
}

  public int pop() {
      int num = maxHeap.poll().number;
    if(frequencyMap.get(num) > 1){
        frequencyMap.put(num, frequencyMap.get(num) - 1);
    }else{
        frequencyMap.remove(num);
    }
    return num;
  }

  public static void main(String[] args) {
    FrequencyStack frequencyStack = new FrequencyStack();
    frequencyStack.push(1);
    frequencyStack.push(2);
    frequencyStack.push(3);
    frequencyStack.push(2);
    frequencyStack.push(1);
    frequencyStack.push(2);
    frequencyStack.push(5);
    System.out.println(frequencyStack.pop());
    System.out.println(frequencyStack.pop());
    System.out.println(frequencyStack.pop());
  }
}
