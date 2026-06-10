class Ratio implements Comparable<Ratio>{
    int pass;
    int total;
    double addOn;
    Ratio(int pass, int total){
        this.pass = pass;
        this.total = total;
        this.addOn = ((double)(pass+1)/(double)(total+1)) - ((double)(pass)/(double)(total));
    }

    @Override
    public int compareTo(Ratio other) {
        return Double.compare(this.addOn, other.addOn);
    }
}

class Solution {
    
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Ratio> pq = new PriorityQueue<Ratio>(Collections.reverseOrder());

        for(int i=0;i<classes.length;i++){
            pq.add(new Ratio(classes[i][0],classes[i][1]));
        }

        while(extraStudents>0){
            Ratio r = pq.poll();
            int p = r.pass;
            int t = r.total;
            pq.add(new Ratio(p+1,t+1));
            extraStudents--;
        }

        double sum = 0.0;
        while(!pq.isEmpty()){
            Ratio r = pq.poll();
            sum += ((double)(r.pass)/(double)(r.total));
        }

        return sum/classes.length;
    }
}