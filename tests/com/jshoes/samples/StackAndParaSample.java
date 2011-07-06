package com.jshoes.samples;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;

public class StackAndParaSample {
	public static void main(String[] args) {
		JShoes.app(new CodeBlock() {
			public void run(JShoes shoes) {
				shoes.stack(new CodeBlock() {
					public void run(JShoes shoes) {
						shoes.para("First");
						shoes.para("second");
						shoes.para("third");
					}
				});
			}
		});
	}
}
