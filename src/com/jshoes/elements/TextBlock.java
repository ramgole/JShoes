package com.jshoes.elements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.jshoes.JShoes;

public class TextBlock extends Element {

	private final Label label;

	public TextBlock(JShoes shoes, Composite composite, Object... messages) {
		super(shoes, composite);
		for (Object object : messages) {
			if(!(object instanceof String || object instanceof TextClass))
				throw new IllegalArgumentException("in the arguments you can use String or TextClass");
		}
		label = new Label(composite, SWT.WRAP);
		String message="";
		for (Object object : messages) {
			if(object instanceof String)
				message += (String) object;
		}
		label.setText(message);
		label.setLayoutData(style);
		composite.layout();
	}

	public TextBlock append(String string) {
		label.setText(label.getText() + string);
		return this;
	}
	
	public TextBlock replace(String string) {
		label.setText(string);
		return this;
	}

	public TextBlock size(int size) {
		if (shoes.getFontRegistry().get("para "+size) == shoes.getFontRegistry().defaultFont()) {
			FontData[] fontData = label.getFont().getFontData();
			for (int i = 0; i < fontData.length; i++) {
				FontData fontDataEntry = fontData[i];
				fontDataEntry.setHeight(size); //hard code banner size
			}
			shoes.getFontRegistry().put("para "+size, fontData);
		}
		label.setFont(shoes.getFontRegistry().get("para "+size));
		composite.layout();
		return this;
	}
}
