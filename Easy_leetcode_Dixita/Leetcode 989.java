
Solution 1: tc: O(max(n,logk)) sc: O(max(n,logk))
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
      int i = num.length-1;
      int carry = 0;
      int x = 0;
      int y = 0;
      int sum = 0;
      List<Integer> list = new ArrayList<>();
      while(k>0 || i>=0 || carry>0){
          x = (i>=0)? num[i]:0;
          y = k%10;
          sum = x+y+carry;
          list.add(sum%10);
          carry = sum/10;
          k = k/10;
          i--;
      }  
      Collections.reverse(list);
      return list;
    }
}

Solution 2: Just used Deque to avoid reversal
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
      int i = num.length-1;
      int carry = 0;
      int x = 0;
      int y = 0;
      int sum = 0;
      Deque<Integer> list = new ArrayDeque<>();
      while(k>0 || i>=0 || carry>0){
          x = (i>=0)? num[i]:0;
          y = k%10;
          sum = x+y+carry;
          list.addFirst(sum%10);
          carry = sum/10;
          k = k/10;
          i--;
      }  
      return new ArrayList<>(list);
    }
}

Solution 3: O(N)   sc: O(N)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> res = new ArrayList<>();
    for(int i=num.length-1;i>=0;i--){
        res.add(0,(num[i]+k)%10);
        k=(num[i]+k)/10;
    }

    while(k>0){
        res.add(0,k%10);
        k = k/10;
    }
    return res;
}
}