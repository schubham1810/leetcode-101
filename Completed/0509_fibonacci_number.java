class Solution {
    public int fib(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        for(int i=2;i<=n;i++){
            arr.add(arr.get(i-1)+arr.get(i-2));
        }
        return arr.get(n);
    }
}