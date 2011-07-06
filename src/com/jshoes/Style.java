package com.jshoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Style {
	
	private String width;
	private String height;
	private String margin;
	private String marginLeft;
	private String marginTop;
	private String marginRight;
	private String marginBottom;
	
	public Length width() {
		if(width == null)
			return null;
		return new Length(width);
	}
	
	public Style width(String width) {
		this.width = width;
		return this;
	}
	
	public Length height() {
		if(height == null)
			return null;
		return new Length(height);
	}
	
	public Style height(String height) {
		this.height = height;
		return this;
	}
	
	public String margin() {
		return margin;
	}
	
	public Style margin(String margin) {
		this.margin = margin;
		return this;
	}

	public int marginLeft() {
		return getMarginInIntegers(marginLeft);
	}

	public Style marginLeft(String marginLeft) {
		this.marginLeft = marginLeft;
		return this;
	}

	public int marginTop() {
		return getMarginInIntegers(marginTop);
	}

	public Style marginTop(String marginTop) {
		this.marginTop = marginTop;
		return this;
	}

	public int marginRight() {
		return getMarginInIntegers(marginRight);
	}

	public Style marginRight(String marginRight) {
		this.marginRight = marginRight;
		return this;
	}

	public int marginBottom() {
		return getMarginInIntegers(marginBottom);
	}

	public Style marginBottom(String marginBottom) {
		this.marginBottom = marginBottom;
		return this;
	}
	
	private int getMarginInIntegers(String marginSpecific) {
		int marginToReturn = 0;
		if (marginSpecific != null)
			marginToReturn = Integer.parseInt(marginSpecific);
		else if (margin != null)
			marginToReturn = Integer.parseInt(margin);
		return marginToReturn;
	}
	
	/**
	 * Represents length in px, or fractions or percentages etc.
	 * Also negative values are allowed
	 */
	public class Length {
		private boolean negative;
		private boolean fractional;
		private double number;
		private final String length;

		public Length(String length) {
			this.length = length;
			String regexPattern = "^((\\-?)(\\d*(\\.)?\\d*))((%)?|(px)?)$";
			Matcher matcher = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE).matcher(length);
			negative = false;
			fractional = false;
			boolean asPercentage = false;
			
			if (matcher.find()) {
				if (matcher.group(2).equals("-")) {
					negative = true;
				}
				number = Double.parseDouble(matcher.group(1));
				if (matcher.group(4) != null) {
					fractional = true;
				}
				if (matcher.group(5) != null) {
					if (matcher.group(6) != null)
						asPercentage = true;
					/*else
						asPixels = true;*/
				} /*else if (!fractional)
					asPixels = true;*/
				if (fractional && !(number <= 1 && number > -1))
					throw new IllegalArgumentException(length + " is not a valid width. fractional values can't be more than 1.0 which is 100%");
			} else
				throw new IllegalArgumentException(length + " is not a valid width. Valid values are like 80, -80, 80px, -80px, 1.0, .2, 20% etc.");

			if (asPercentage) {
				number = number / 100;
				fractional = true;
				asPercentage = false;
			}
			
			if(negative && fractional) {
				negative = false;
				number = 1.0 - number;
			}
		}

		public boolean isNegative() {
			return negative;
		}

		public boolean isFractional() {
			return fractional;
		}

		public double getNumber() {
			return number;
		}
		
		@Override
		public String toString() {
			return length;
		}
	}
}
