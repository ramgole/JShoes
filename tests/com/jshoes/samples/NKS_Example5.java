package com.jshoes.samples;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;

public class NKS_Example5 {
	
	public static void main(String[] args) {
		JShoes.app(new CodeBlock() {
			public void run(JShoes shoes) {
				shoes.stack(new CodeBlock() {
					public void run(JShoes shoes) {
						shoes.title("Title");
						shoes.subtitle("Subtitle");
						shoes.tagline("Tagline");
						shoes.caption("Caption");
						shoes.para("Para");
						shoes.inscription("Inscription");
					}
				});
			}
		});
	}

}
