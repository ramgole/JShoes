package com.jshoes.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

import com.jshoes.Style;
import com.jshoes.Style.Length;

public class FlowLayout extends Layout {

	private Point[] sizes;
	private Style[] layoutDatas;
	private int totalWidth;
	private int totalHeight;
	private Style myLayout;
	private Rectangle[] childrenBounds;

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
//		System.out.println("YO " + composite + " " + wHint + " " + hHint + " " + flushCache);
		Control children[] = composite.getChildren();
		if (flushCache || sizes == null || sizes.length != children.length) {
			initialize(composite, wHint, hHint);
		}
		return new Point(totalWidth, totalHeight);
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
//		System.out.println("YO1 " + composite + " " + flushCache + composite.getSize());
		Control children[] = composite.getChildren();
		Rectangle clientArea = composite.getClientArea();
		if (flushCache || sizes == null || sizes.length != children.length || clientArea.width != totalWidth || clientArea.height != totalHeight) {
			initialize(composite, clientArea.width, clientArea.height);
		}
		// Rectangle rect = composite.getClientArea();
		for (int i = 0; i < children.length; i++) {
			children[i].setBounds(childrenBounds[i]);
		}
	}

	private void initialize(Composite composite, int wHint, int hHint) {
//		System.out.println("size we got is 11111111111 "+wHint+" "+hHint);
        
        sizes = new Point[composite.getChildren().length];
        layoutDatas = new Style[composite.getChildren().length];
        childrenBounds = new Rectangle[composite.getChildren().length];
        myLayout = (Style) composite.getLayoutData();
        
        int marginTop = myLayout.marginTop();
        int marginBottom = myLayout.marginBottom();
        int marginLeft = myLayout.marginLeft();
        int marginRight = myLayout.marginRight();
        
        totalWidth = marginLeft + marginRight;
        totalHeight = marginTop + marginBottom;
        
        int currentX = marginLeft, currentY = marginTop;
        
        boolean startNewRow = true;
        double remainingFraction = 1.0;
        int remainingWidthPixels = totalWidth - marginLeft - marginRight;
        
        if (wHint != SWT.DEFAULT) {
        	remainingWidthPixels = wHint - marginLeft - marginRight;
        }
        
        for (int i = 0; i < composite.getChildren().length; i++) {
        	layoutDatas[i] = (Style) composite.getChildren()[i].getLayoutData();
        	
        	int suggestedWidth = SWT.DEFAULT, suggestedHeight = SWT.DEFAULT;
        	
        	//width calculations
        	if (layoutDatas[i] != null && layoutDatas[i].width() != null) {
        		Length width = layoutDatas[i].width();
        		if(!width.isFractional() && !width.isNegative()) {
        			suggestedWidth = (int) width.getNumber();
        			startNewRow = false;
        			remainingWidthPixels -= suggestedWidth;
        			if (wHint != SWT.DEFAULT) {
        	        	if(remainingWidthPixels<=0) {
            				startNewRow = true;
            			}
        	        }
        		} else if (width.isNegative()) {
        			//if a new row has just started a negative width doesn't make sense
        			if(startNewRow) {
        				System.err.println("Warning : we have to start a new row; so negative widths don't make sense. You entered "+width);
        				startNewRow = false;
        			} else {
        				startNewRow = true;
//        				suggestedWidth = (int) (totalWidth - marginLeft - marginRight - width.getNumber());
        				suggestedWidth = remainingWidthPixels;
        			}
        		} else if (width.isFractional()) { // only remaining case
        			//place where ever
        			remainingFraction -= width.getNumber();
        			startNewRow = false;
        			if(wHint!=SWT.DEFAULT || totalWidth > marginLeft + marginRight) {
        				suggestedWidth = (int) (width.getNumber() * (Math.max(wHint, totalWidth) - marginLeft - marginRight));
        				remainingWidthPixels -= suggestedWidth;
        			}
        			if(remainingFraction<=0) {
        				startNewRow = true;
        				if(remainingFraction<0) {
        					System.err.println("Warning : the sum of fractions exceeded 100%. Some portions might be cutoff. "+width);
        				}
        			}
        		}
//        		System.out.println("suggesting "+suggestedWidth+ " "+suggestedHeight);
        		sizes[i] = composite.getChildren()[i].computeSize(suggestedWidth, suggestedHeight, true);
        	} else {
//        		System.out.println("suggesting "+suggestedWidth+ " "+suggestedHeight);
        		sizes[i] = composite.getChildren()[i].computeSize(suggestedWidth, suggestedHeight, true);
        		if(wHint!=SWT.DEFAULT) {
        			//we can suggest something
					if (remainingWidthPixels < sizes[i].x) {
						//we don't have that kind of width
						//either ask this one to fit or move to next line
						if(startNewRow) {
							//we are starting a new row. Will have to ask this composite to try to fit
							sizes[i] = composite.getChildren()[i].computeSize(remainingWidthPixels, suggestedHeight, true);
						} else {
							//we should try and fit to the next row
							remainingWidthPixels = Math.max(wHint, totalWidth) - marginLeft - marginRight;
							if (remainingWidthPixels > sizes[i].x)
								suggestedWidth = SWT.DEFAULT;
							else
								suggestedWidth = remainingWidthPixels;
							sizes[i] = composite.getChildren()[i].computeSize(suggestedWidth, suggestedHeight, true);
							currentX = marginLeft;
							currentY = totalHeight - marginBottom;
							remainingFraction = 1.0;
						}
					}
        		}
        		remainingWidthPixels -= sizes[i].x;
        		startNewRow = false;
        	}
        	
//            System.out.println("getting "+sizes[i].x+ " "+sizes[i].y);
            childrenBounds[i] = new Rectangle(currentX, currentY, sizes[i].x, sizes[i].y);
            
            if(startNewRow) {
            	totalWidth = Math.max(totalWidth, currentX + sizes[i].x + marginRight);
            	currentX = marginLeft;
            	totalHeight = Math.max(totalHeight, currentY + sizes[i].y + marginBottom);
            	currentY = totalHeight - marginBottom;
            	remainingFraction = 1.0;
            	remainingWidthPixels = Math.max(wHint, totalWidth) - marginLeft - marginRight;
            } else {
            	currentX += sizes[i].x;
            	totalWidth = Math.max(totalWidth, currentX + marginRight);
            	totalHeight = Math.max(totalHeight, currentY + sizes[i].y + marginBottom);
            }
        }
    }
}
