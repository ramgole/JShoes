package com.jshoes.samples;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;

public class NKS_Example2 {

	public static void main(String[] args) {
		JShoes.app(new CodeBlock() {
			public void run(JShoes shoes) {
				shoes.width("280");
				shoes.height("100");
				shoes.flow(new CodeBlock() {
					public void run(JShoes shoes) {
//						shoes.width("280");
						shoes.margin("10");
						shoes.stack(new CodeBlock() {
							public void run(JShoes shoes) {
								shoes.width("100%");
								shoes.banner("A POEM");
							}
						});
						shoes.stack(new CodeBlock() {
							public void run(JShoes shoes) {
//								shoes.width(".5");
								shoes.width("80px");
								shoes.para("Goes like:");
							}
						});
						shoes.stack(new CodeBlock() {
							public void run(JShoes shoes) {
//								shoes.width(".5");
								shoes.width("-80px");
								shoes.para("the sun.\n"+"a lemon.\n"
										+"the goalie.\n"
										+"a fireplace.\n\n"
										+"I want to write\n"
										+"a poem for the\n"
										+"the kids who haven't\n"
										+"even heard one yet.\n\n"
										+"and the goalie guards\n"
										+"the fireplace.");
							}
						});
//						shoes.stack(new CodeBlock() {
//							public void run(JShoes shoes) {
//								shoes.width("100%");
//								shoes.banner("A POEM");
//							}
//						});
//						shoes.stack(new CodeBlock() {
//							public void run(JShoes shoes) {
//								shoes.width("100%");
//								shoes.banner("A POEM");
//							}
//						});
					}
				});
			}
		});
	}
}
