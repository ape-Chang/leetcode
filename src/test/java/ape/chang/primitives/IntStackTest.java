package ape.chang.primitives;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class IntStackTest {

	@Test
	public void test() {
		IntStack stack = new IntStack();
		assertThat(stack.isEmpty(), equalTo(true));
		assertThat(stack.size(), equalTo(0));
		stack.push(1);
		assertThat(stack.isEmpty(), equalTo(false));
		assertThat(stack.top(), equalTo(1));
		for (int i = 0; i < 16; ++i) {
			stack.push(i);
		}
		assertThat(stack.top(), equalTo(15));
		for (int i = 0; i < 16; ++i) {			
			assertThat(stack.pop(), equalTo(15-i));
		}
		assertThat(stack.size(), equalTo(1));
	}
	
}
