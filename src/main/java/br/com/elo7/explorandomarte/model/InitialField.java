package br.com.elo7.explorandomarte.model;

public class InitialField {

	private char[][] field;
	private int maxX;
	private int maxY;
	
	public InitialField(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.field = new char[maxX][maxY];
	}

	public char[][] getField() {
		return field;
	}

	public void setField(char[][] field) {
		this.field = field;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
}
