package com.jshoes.samples;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;

public class NKS_Example3 {

	public static void main(String[] args) {
		JShoes.app(new CodeBlock() {
			public void run(JShoes shoes) {
				shoes.para("Testing Test test. " 
					, "Breadsticks. "
					, "Breadsticks. "
					, "Breadsticks. "
					, "Very Good. ");
			}
		});
	}
}
