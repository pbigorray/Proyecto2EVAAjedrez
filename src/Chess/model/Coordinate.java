package Chess.model;

import java.io.Serializable;

public class Coordinate implements Comparable<Coordinate>, Serializable {

	private char letter;
	private int number;

	public Coordinate(char letter, int number) {
		String letterAsString = String.valueOf(letter);
		this.letter = (letterAsString.toUpperCase()).charAt(0);
		this.number = number;
	}



    public char getLetter() {
		return letter;
	}
	public int getNumber() {
		return number;
	}

	/*
	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	 */

	public int getLetterAsPosition() {
		return letter - 'A';
	}

	public int getNumberAsPosition() {
		return number - 1;
	}

	public Coordinate up() {
		return new Coordinate(letter, number - 1);
	}

	public Coordinate down() {
		return new Coordinate(letter, number + 1);
	}

	public Coordinate left() {
		return new Coordinate((char) (letter - 1), number);
	}

	public Coordinate right() {
		return new Coordinate((char) (letter + 1), number);
	}

	public Coordinate diagonalUpLeft() {
		return up().left();
	}

	public Coordinate diagonalUpRight() {
		return up().right();
	}

	public Coordinate diagonalDownLeft() {
		return down().left();
	}

	public Coordinate diagonalDownRight() {
		return down().right();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Coordinate))	return false;
		return ((Coordinate) o).getLetter() == this.letter && ((Coordinate) o).getNumber() == this.number;
	}

	@Override
	public int compareTo(Coordinate c) {
		if (c.getLetter() != this.letter) return c.getLetter() - this.letter;
		return (c.getNumber() != this.number) ? c.getNumber() - this.number: 0;
	}

	@Override
	public int hashCode() {

		return number+letter;
	}

//	@Override
//	public String toString() {
//		return "Letter: " + letter + " - Number: " + number;
//	}



	@Override
	public String toString() {
		return "(" + letter + "," + number+")";
	}
}
