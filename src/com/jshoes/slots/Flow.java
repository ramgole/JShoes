package com.jshoes.slots;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.jshoes.JShoes;
import com.jshoes.internal.FlowLayout;

public class Flow extends Slot {

	public Flow(JShoes shoes) {
		super(shoes);
		if(shoes.getCurrentSlot() == null) {
			//shells already have flow layout
			composite = shoes.getShell();
		} else {
			composite = new Composite(shoes.getCurrentSlot().getComposite(), SWT.NONE);
//			composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		}
		composite.setLayout(new FlowLayout());
		composite.setLayoutData(layoutData);
	}

	@Override
	public void width(String width) {
		layoutData.width(width);
	}
}
