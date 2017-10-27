package ape.chang.primitives;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IntSetTest {

	@Test
	public void test() {
		IntSet set = new IntSet();
		assertThat(set.isEmpty(), equalTo(true));
		for (int i = 0; i < 32; ++i) {
			set.add(i);
			assertThat(set.isEmpty(), equalTo(false));
			assertThat(set.size(), equalTo(i+1));
			assertThat(set.contains(i), equalTo(true));
		}
		for (int i = 0; i < 32; ++i) {
			set.add(i);
			assertThat(set.size(), equalTo(32));
		}
		for (int i = 0; i < 32; ++i) {
			set.remove(i);
			assertThat(set.size(), equalTo(31 - i));
		}
		assertThat(set.size(), equalTo(0));
		assertThat(set.isEmpty(), equalTo(true));
	}

}
