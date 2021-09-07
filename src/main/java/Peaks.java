import java.util.*;

public class Peaks {

    Map<String, List<Integer>> pickPeaks(List<Integer> arr) {
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        if (arr.size() > 2) {
            int candidatePos = -1;
            int candidatePeaks = -1;
            for (int i = 1; i < arr.size() - 1; i++) {
                int target = arr.get(i);
                if (target > arr.get(i - 1) && target > arr.get(i + 1)) {
                    pos.add(i);
                    peaks.add(target);
                } else if (target > arr.get(i - 1) && target == arr.get(i + 1)) {
                    candidatePos = i;
                    candidatePeaks = target;
                } else if (target == arr.get(i - 1) && target > arr.get(i + 1)) {
                    if (candidatePos != -1) {
                        pos.add(candidatePos);
                        peaks.add(candidatePeaks);
                        candidatePos = -1;
                    }
                }
            }
        }

        result.put("pos", pos);
        result.put("peaks", peaks);

        return result;
    }
}
