package com.jshoes.elements;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.jshoes.CodeBlock;
import com.jshoes.JShoes;

public class ShoesButton extends Element {

	private Button button;

	public ShoesButton(final JShoes shoes, Composite composite, String message,
			final CodeBlock block) {
		this(shoes, composite, message);
		click(block);
	}

	public ShoesButton click(final CodeBlock block) {
		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					block.run(shoes);
					break;
				}
			}
		});
		return this;
	}

	public ShoesButton(JShoes shoes, Composite composite, String message) {
		super(shoes, composite);
		button = new Button(composite, SWT.PUSH);
		button.setText(message);
		button.setLayoutData(style);
	}
}
