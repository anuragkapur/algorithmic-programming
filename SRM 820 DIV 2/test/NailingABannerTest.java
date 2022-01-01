import org.junit.Test;
import static org.junit.Assert.*;

public class NailingABannerTest {

	@Test(timeout=2000)
	public void test0() {
		long N = 1L;
		assertEquals(0L, new NailingABanner().coordinate(N));
	}

	@Test(timeout=2000)
	public void test1() {
		long N = 3L;
		assertEquals(576460752303423488L, new NailingABanner().coordinate(N));
	}

	@Test(timeout=2000)
	public void test2() {
		long N = 4L;
		assertEquals(288230376151711744L, new NailingABanner().coordinate(N));
	}

	@Test(timeout=2000)
	public void test3() {
		long N = 24L;
		assertEquals(468374361246531584L, new NailingABanner().coordinate(N));
	}

	@Test(timeout=2000)
	public void test4() {
		long N = 65537L;
		assertEquals(1152903912420802560L, new NailingABanner().coordinate(N));
	}

	@Test(timeout=2000)
	public void test5() {
		long N = 1152921504606846977L;
		assertEquals(1152921504606846975L, new NailingABanner().coordinate(N));
	}
}
