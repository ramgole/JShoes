package com.jshoes.tutorial;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;
import com.jshoes.elements.TextBlock;

public class AnimateTest {

	public static void main(String[] args) {
		JShoes.app(new CodeBlock() {
			
			private TextBlock para;

			@Override
			public void run(JShoes shoes) {
				para = shoes.para("This is frame no. 1");
				shoes.animate(24, new CodeBlock() {
					private int count = 2;
					@Override
					public void run(JShoes shoes) {
						para.replace("This is fram no. "+count);
						count++;
					}
				});
			}
		});
	}

}
