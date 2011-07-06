package com.jshoes.slots;

import org.eclipse.swt.widgets.Composite;

import com.jshoes.JShoes;
import com.jshoes.Style;

public abstract class Slot {
	
	protected final JShoes shoes;
	protected Composite composite;
	protected final Style layoutData = new Style();

	public Slot(JShoes shoes) {
		this.shoes = shoes;
	}

	public Composite getComposite() {
		return composite;
	}
	
	public Style getLayoutData() {
		return layoutData;
	}
	
	public abstract void width(String width);
}
