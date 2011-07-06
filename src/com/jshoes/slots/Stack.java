package com.jshoes.slots;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.jshoes.JShoes;
import com.jshoes.internal.ShoesStackLayout;

public class Stack extends Slot {

	public Stack(JShoes shoes) {
		super(shoes);
		composite = new Composite(shoes.getCurrentSlot().getComposite(), SWT.NONE);
		composite.setLayout(new ShoesStackLayout());
//		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		composite.setLayoutData(layoutData);
	}
	
	@Override
	public void width(String width) {
		layoutData.width(width);
//		composite.setSize(Integer.parseInt(width), composite.getSize().y);
	}
}
