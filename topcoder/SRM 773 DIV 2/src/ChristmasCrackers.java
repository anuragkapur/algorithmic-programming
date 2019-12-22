import java.util.*;

public class ChristmasCrackers {

	Set<Integer> attendeeList = new HashSet<>();
	List<Integer> peopleList = new ArrayList<>();
	int originalK = 0;

	public int[] crack(int N, int K) {
		for (int i = 0; i < N; i++) {
			attendeeList.add(i);
		}
		originalK = K;
		return crack(N, K, 0);
	}

	private int[] crack(int N, int K, int personIndex) {
		if (done(peopleList)) {
			return toIntArray(peopleList);
		} else {
			for (int i = 0; i < N; i = i + 2) {
				if (done(peopleList)) {
					break;
				}
				peopleList.add(personIndex % N);
				personIndex ++;
				peopleList.add(personIndex % N);
				personIndex ++;
			}
			K --;
			return crack(N, K, personIndex % N);
		}
	}

	private boolean done(List<Integer> peopleList) {
		for (Integer attendee : attendeeList) {
			if (Collections.frequency(peopleList, attendee) < originalK) {
				return false;
			}
		}
		return true;
	}

	private int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for(int i = 0;i < ret.length;i++)
			ret[i] = list.get(i);
		return ret;
	}
}
