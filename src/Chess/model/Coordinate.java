package Chess.model;

import java.io.Serializable;

/**
 * Clase Coordinate encargada de la creacion y funcionamiento de las coordenadas del tablero y piezas
 * @author Pau Bigorra
 * @version 1.0
 */
public class Coordinate implements Comparable<Coordinate>, Serializable {

	private char letter;
	private int number;

	/**
	 * Constructor de las coordenadas
	 * @param letter Letra de la coordenada
	 * @param number Numero de la coordenada
	 */
	public Coordinate(char letter, int number) {
		String letterAsString = String.valueOf(letter);
		this.letter = (letterAsString.toUpperCase()).charAt(0);
		this.number = number;
	}


	/**
	 * Getter de la letra de la coordenada
	 * @return Devuelve la letra que coresponde a la coordenada
	 */
    public char getLetter() {
		return letter;
	}

	/**
	 * Getter de el numero al que corresponde la coordenada
	 * @return Devuelve el numero
	 */
	public int getNumber() {
		return number;
	}


	public int getLetterAsPosition() {
		return letter - 'A';
	}

	public int getNumberAsPosition() {
		return number - 1;
	}

	/**
	 * Reduce el numero de la coordenada
	 * @return Devuelve la coordenada con el numero disminuido
	 */
	public Coordinate up() {
		return new Coordinate(letter, number - 1);
	}

	/**
	 * Aumenta el numero de la coordenada
	 * @return Devuelve la coordenada con el numero incrementado
	 */
	public Coordinate down() {
		return new Coordinate(letter, number + 1);
	}

	/**
	 * Reduce la letra de la coordenada
	 * @return Devuelve la coordenada con la letra disminuida
	 */
	public Coordinate left() {
		return new Coordinate((char) (letter - 1), number);
	}

	/**
	 * Aumenta la letra de la coordenada
	 * @return Devuelve la coordenada con la letra incrementada
	 */
	public Coordinate right() {
		return new Coordinate((char) (letter + 1), number);
	}

	/**
	 * Desplaza la pieza en diagonal arriba-izquierda
	 * @return Devuelve la coordenada desplazada
	 */
	public Coordinate diagonalUpLeft() {
		return up().left();
	}

	/**
	 * Desplaza la pieza en diagonal arriba-derecha
	 * @return Devuelve la coordenada desplazada
	 */
	public Coordinate diagonalUpRight() {
		return up().right();
	}

	/**
	 * Desplaza la pieza en diagonal abajo-izquierda
	 * @return Devuelve la coordenada desplazada
	 */
	public Coordinate diagonalDownLeft() {
		return down().left();
	}

	/**
	 * Desplaza la pieza en diagonal abajo-derecha
	 * @return Devuelve la coordenada desplazada
	 */
	public Coordinate diagonalDownRight() {
		return down().right();
	}

	/**
	 * Sobreescribe el metodo por defecto Equals de la coordenada
	 * @param o Coordenada a comparar
	 * @return Devuelve verdadero si son la misma coordenada
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Coordinate))	return false;
		return ((Coordinate) o).getLetter() == this.letter && ((Coordinate) o).getNumber() == this.number;
	}

	/**
	 * Sobreescribe el compareTo para poder comparar correctamente la coordenada
	 * @param c Coordenada a comparar con esta
	 * @return Devuelve la diferencia entre las coordenadas
	 */
	@Override
	public int compareTo(Coordinate c) {
		if (c.getLetter() != this.letter) return c.getLetter() - this.letter;
		return (c.getNumber() != this.number) ? c.getNumber() - this.number: 0;
	}

	/**
	 * Sobreescribe el hashCode por defecto
	 * @return Devuelve la suma de los valores de la coordenada
	 */
	@Override
	public int hashCode() {

		return number+letter;
	}

//	@Override
//	public String toString() {
//		return "Letter: " + letter + " - Number: " + number;
//	}


	/**
	 * Sobreescribe el toSting por defecto de la coordenada
	 * @return Devuelve un String con como se mostrara la coordenada
	 */
	@Override
	public String toString() {
		return "(" + letter + "," + number+")";
	}
}
