import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class NailingABanner {

	/**
	 * Status: Passed all system tests
	 *
	 * Total nails at coordinates after Round 0: 0 ... 1
	 * Total nails at coordinates after Round 1: 0/2, 1/2, 1/1
	 * Total nails at coordinates after Round 2: 0/4, 1/4, 2/4, 3/4, 4/4
	 * Total nails at coordinates after Round 3: 0/8, 1/8, ... , 7/8, 8/8
	 *
	 * @see <a href="../resource/NailingABanner-Visualisation.jpeg">NailingABanner-Visualisation</a>
	 *
	 * @param N
	 * @return
	 */
	public long coordinate(long N) {
		if (N == 1) {
			return 0;
		}

		if (N == 2) {
			return (long) Math.pow(2, 60);
		}

		// Nth nail is added in round number: `round`, where 1st round is the one in which nail number#3 is added
		long count = 2;
		long round = 1;
		while (true) {
			count = count + (long) Math.pow(2, round-1);
			if (N <= count) {
				break;
			}
			round ++;
		}

		// Nth nail is new (**added in this round**) nail number: `positionInRound` in the round: `round`
		// Ex: 3/8 is the 2nd nail added in round 3. Calculated as: (numberOfElementsInRound[4] - (count[9] - N[7]) = 2)
		long numberOfElementsInRound = (long) Math.pow(2, round) / 2;
		long positionInRound = numberOfElementsInRound - (count - N);

		// Value of nail number: `diff` in round: `round`
		return (long) Math.pow(2, 60) / (long) Math.pow(2, round) * (positionInRound * 2 - 1);
	}

	/**
	 * Works with the example test cases provided but fails (times out / runs out of memory) for large Ns in system
	 * tests. Not an optimal solution.
	 *
	 * @param N
	 * @return
	 */
	public long coordinate1(long N) {
		long count = 2;
		Queue<AdjacentPair> pairs = new LinkedList<>();

		if (N == 1) {
			return 0L;
		}

		if (N == 2) {
			return (long) Math.pow(2, 60);
		}

		AdjacentPair adjacentPair = new AdjacentPair(BigInteger.ZERO, BigInteger.valueOf((long)Math.pow(2, 60)));
		pairs.add(adjacentPair);
		while (!pairs.isEmpty()) {
			AdjacentPair pair = pairs.poll();
			BigInteger first = pair.first;
			BigInteger last = pair.last;
			BigInteger mid = first.add(last.subtract(first).divide(BigInteger.valueOf(2L)));
			count ++;
			if (count == N) {
				return mid.longValueExact();
			}
			AdjacentPair adjacentPair1 = new AdjacentPair(first, mid);
			AdjacentPair adjacentPair2 = new AdjacentPair(mid, last);
			pairs.add(adjacentPair1);
			pairs.add(adjacentPair2);
		}

		return -1;
	}

	private static class AdjacentPair {
		BigInteger first;
		BigInteger last;
		public AdjacentPair(BigInteger first, BigInteger last) {
			this.first = first;
			this.last = last;
		}
	}
}
