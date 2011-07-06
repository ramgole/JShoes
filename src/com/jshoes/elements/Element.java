package com.jshoes.elements;

import org.eclipse.swt.widgets.Composite;

import com.jshoes.JShoes;
import com.jshoes.Style;

public class Element {
	
	protected final JShoes shoes;
	protected final Composite composite;
	protected final Style style = new Style();

	public Element(JShoes shoes, Composite composite) {
		this.shoes = shoes;
		this.composite = composite;
	}
	
	public Style style() {
		return style;
	}
}
