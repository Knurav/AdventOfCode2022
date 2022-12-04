package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        List<Integer> elfCalTotals = new ArrayList<>();
        try (FileReader fr = new FileReader("Day1\\day1input.txt");
                BufferedReader br = new BufferedReader(fr)) {
            String str;
            int temp = 0;
            while ((str = br.readLine()) != null) {
                if (str.isEmpty()) {
                    elfCalTotals.add(temp);
                    temp = 0;
                } else {
                    temp += Integer.parseInt(str);
                }
            }
        } catch (Exception e) {
        }

        int total = elfCalTotals.stream()
                .sorted((x, y) -> Integer.compare(y, x))
                .limit(3)
                .reduce(Integer::sum).get();
        System.out.println(total);
    }

}