package com.jshoes.samples;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;

public class ButtonSample {

	public static void main(String[] args) {
		JShoes.app(new CodeBlock() {
			public void run(JShoes shoes) {
				shoes.stack(new CodeBlock() {
					@Override
					public void run(JShoes shoes) {
						shoes.para("Hello There fdsaj fjdsa fkds a fdsa  fd sa fdsa  fdsaf f dsfdsa f ds fdsa fdsa f dsa ds fdsa ");
						shoes.para("Hello There fdsaj fjdsa fkds a fdsa  fd sa fdsa  fdsaf f dsfdsa f ds fdsa fdsa f dsa ds fdsa ");
						shoes.button("Click Me!", new CodeBlock() {
							public void run(JShoes shoes) {
								shoes.alert("Good Job");
								shoes.alert("You said "+(shoes.ask("what?")));
								shoes.para("Hey");
							}
						});
					}
				});
			}
		});
	}
}