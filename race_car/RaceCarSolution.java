import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class RaceCarSolution {
    List<int[]> variantsOfMoveList = new ArrayList<>();
    HashSet<int[]> visitedPositionSpeadSet = new HashSet<>();
    int moveCounter = 0;
    int position = 0;
    int speed = 1;

    public int raceCar(int target) {
        variantsOfMoveList.add(new int[]{moveCounter, position, speed});

        while (!variantsOfMoveList.isEmpty()) {
            moveCounter = variantsOfMoveList.get(0)[0];
            position = variantsOfMoveList.get(0)[1];
            speed = variantsOfMoveList.get(0)[2];
            variantsOfMoveList.remove(0);
            if (position == target) {
                return moveCounter;
            }
            if (!visitedPositionSpeadSet.contains(new int[]{position, speed})) {
                variantsOfMoveList.add(new int[]{moveCounter + 1, position + speed, speed * 2});
                if ((position + speed > target && speed > 0) || (position + speed < target && speed < 0)) {
                    variantsOfMoveList.add(new int[]{moveCounter + 1, position, speed > 0 ? -1 : 1});
                }
                visitedPositionSpeadSet.add(new int[]{position, speed});
            }
        }
        return moveCounter;
    }
}


class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Target value should exist");
        } else if (Integer.parseInt(args[0]) <= 0) {
            System.out.println("Target value should be above 0");
        } else {
            int result = new RaceCarSolution().raceCar(Integer.parseInt(args[0]));
            System.out.println(Integer.toString(result));
        }
    }
}   
   
