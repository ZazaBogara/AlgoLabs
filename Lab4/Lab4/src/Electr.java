import java.util.List;

public class Electr {
    private final int distance;
    private final List<Integer> pillars;

    public Electr(int distance, List<Integer> pillars) {
        this.distance = distance;
        this.pillars = pillars;
    }

    public double do_it() {
        double len = 0;
        boolean isLastOne = false;
        int i = 0;
        for (Integer pillar : pillars) {
            i++;
            if (i != pillars.size()) {
                Integer nextPillar = pillars.get(i);
                if (isLastOne) {
                    if (nextPillar > 1) {
                        len += Math.sqrt(Math.pow((nextPillar - 1), 2) + Math.pow(this.distance, 2));
                    } else {
                        len += distance;
                    }
                    isLastOne = false;
                } else {
                    double withNoChanges = Math.sqrt(Math.pow((nextPillar - pillar), 2) + Math.pow(this.distance, 2));
                    double withChanges = Math.sqrt(Math.pow((1 - pillar), 2) + Math.pow(this.distance, 2));
                    if (withChanges > withNoChanges) {
                        isLastOne = true;
                        len += withChanges;
                    } else {
                        len += withNoChanges;
                    }
                }
            }
        }
        return len;
    }
}