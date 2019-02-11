import dto.intervall.IntervallDTO;
import java.util.*;

public class Main {
    /**
     *
     * Unit test the {@code IntervallDTO} Data type
     */
    public static void main(String[] args) {
        long startTime = System.nanoTime();


        IntervallDTO x = new IntervallDTO(3,6);
        List<IntervallDTO> intervalle = new ArrayList<>();
        intervalle.add(new IntervallDTO(25,30));
        intervalle.add(new IntervallDTO(2,19));
        intervalle.add(new IntervallDTO(14,23));
        intervalle.add(new IntervallDTO(4,8));
        intervalle = MERGE(intervalle);

        for (IntervallDTO intervallDTO : intervalle)
        {
            System.out.println(intervallDTO.toString());
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Die Laufzeit des Programs = " +totalTime +" Nanosekunden");
    }

    /**
     *
     * The result is a list intervals after has been merged when they are overlapped
     * @param givenList is the List that should merge its intervals
     * @return the List with intervals after merging
     */

    public static List<IntervallDTO> MERGE (List<IntervallDTO> givenList)
    {
        if(givenList.size() == 0 || givenList.size() == 1)
            return givenList;

        List<IntervallDTO> result = new ArrayList<>();

        givenList.sort(Comparator.comparingInt(IntervallDTO::getMin));
        IntervallDTO first = givenList.get(0);
        int min = first.getMin();
        int max = first.getMax();

        for (int i = 1; i < givenList.size(); i++) {
            IntervallDTO current = givenList.get(i);
            if (current.getMin() <= max) {
                max = Math.max(current.getMax(), max);
            } else {
                result.add(new IntervallDTO(min, max));
                min = current.getMin();
                max = current.getMax();
            }
        }
        result.add(new IntervallDTO(min, max));
        return result;
    }

}


