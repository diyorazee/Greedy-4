// Time Complexity : O(nlogk)
// Space Complexity : O(n)

public class Main {
    public static void main(String[] args) {
        System.out.println(shortestWay("xyz", "xzyxzyx")); // 5
        System.out.println(shortestWay("abc", "abcbc")); // 2
        System.out.println(shortestWay("abc", "abxbc")); // 2
    }
    public static int shortestWay(String s, String t){
        int sl = s.length();
        int tl = t.length();
        int count = 1;
        int sPtr=0, tPtr=0;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<sl; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        while(tPtr<tl){
            char tChar = t.charAt(tPtr);
            if(!map.containsKey(tChar)) return -1;
            List<Integer> li = map.get(tChar);
            int k = Collections.binarySearch(li, sPtr);
            if(k<0){
                // {1,5,8,13,17,19} - on binary search for 14 k = -4-1 = -5
                k = -k -1; // 5 -1 = 4
            }
            if(k == li.size()){
                count++;
                sPtr = li.get(0);
            } else {
                sPtr = li.get(k);
            }
            sPtr++; tPtr++;
        }
        return count;
    }
}