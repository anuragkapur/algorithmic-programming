import java.util.*;

public class ChristmasCrackers {

	public int[] crack(int N, int K) {
		int totalElementsInResult = N * K;
		if (totalElementsInResult % 2 != 0) {
			totalElementsInResult ++;
		}

		int[] result = new int[totalElementsInResult];

		for (int i = 0; i < totalElementsInResult; i++) {
			result[i] = i % N;
		}

		return result;
	}
}
