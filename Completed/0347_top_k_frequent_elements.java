class Solution {
    class Element{
        int ele;
        int freq;
        Element(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
            public int compare(Element e1, Element e2){
                return -Integer.compare(e1.freq,e2.freq);
            }
        });

        for(Map.Entry<Integer,Integer> mapElement : hm.entrySet()){
            pq.add(new Element(mapElement.getKey(),mapElement.getValue()));
        }

        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = pq.poll().ele;
        }
        return arr;
    }
}