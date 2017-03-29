package finalexam;

public class Field {
	int x;
	int y;

	public Field() {

	}

	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public double distanceTo(Field f) {
		int xDistance = Math.abs(getX() - f.getX());
		int yDistance = Math.abs(getY() - f.getY());
		double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));

		return distance;
	}


	@Override
	public String toString() {
		return getX() + "," + getY();
	}
}
