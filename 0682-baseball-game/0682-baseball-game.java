import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                record.add(record.get(record.size() - 1) + record.get(record.size() - 2));
            } else if (op.equals("D")) {
                record.add(2 * record.get(record.size() - 1));
            } else if (op.equals("C")) {
                record.remove(record.size() - 1);
            } else {
                record.add(Integer.parseInt(op));
            }
        }
        
        int totalSum = 0;
        for (int score : record) {
            totalSum += score;
        }
        return totalSum;
    }
}