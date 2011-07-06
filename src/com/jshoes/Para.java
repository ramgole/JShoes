package com.jshoes;

import org.eclipse.swt.widgets.Composite;

import com.jshoes.elements.TextBlock;

public class Para extends TextBlock {

	public Para(JShoes shoes, Composite composite, Object[] messages) {
		super(shoes, composite, messages);
		size(12);
	}
}
