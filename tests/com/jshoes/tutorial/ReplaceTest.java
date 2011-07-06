package com.jshoes.tutorial;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;
import com.jshoes.elements.ShoesButton;
import com.jshoes.elements.TextBlock;

public class ReplaceTest {
	
	public static void main(String[] args) {
		JShoes.app("Hey there", new CodeBlock() {
			private ShoesButton button;
			private TextBlock para;
			
			public void run(JShoes shoes) {
				button = shoes.button("Push me");
				para = shoes.para("Nothing pushed so far");
				
				button.click(new CodeBlock() {
					@Override
					public void run(JShoes shoes) {
						para.replace("Aha! Click!");
					}
				});
			}
		});
	}
}
