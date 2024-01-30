package de.dhbw.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefactoringTest {

	@Test
	public void beforeRefactoring() {
		// given
		de.dhbw.demo.refactoring.BeforeRefactoring processor = new de.dhbw.demo.refactoring.BeforeRefactoring();
		StringBuilder out = new StringBuilder();
		String ERR_KEY = "invalid input";

		// when
		processor.process(ERR_KEY, 3, out, "172563.988");

		// then
		assertEquals("   invalid input: 172563.988", out.toString());
	}

	@Test
	public void afterRefactoring() {
		// given
		de.dhbw.demo.refactoring.AfterRefactoring processor = new de.dhbw.demo.refactoring.AfterRefactoring();
		String ERR_KEY = "invalid input";

		// when
		String out = processor.process(ERR_KEY, 3, "172563.988");

		// then
		assertEquals("   invalid input: 172563.988", out);
	}

}