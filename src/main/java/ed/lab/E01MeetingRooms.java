package ed.lab;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }

        //ordena los intervalos por hora de inicio
        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        //(min-heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //se liberan las salas por "antiguedad"
        for (MeetingInterval interval : meetingIntervals) {
            if (!minHeap.isEmpty() && interval.startTime() >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval.endTime()); //ocupa la sala
        }

        return minHeap.size();
    }
}
