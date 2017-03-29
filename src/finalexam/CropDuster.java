package finalexam;

import java.applet.Applet;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CropDuster extends Applet {
	Field field[] = new Field[25];
	ArrayList ar = new ArrayList();
	ArrayList di = new ArrayList();
	ArrayList ar1 = new ArrayList();
	ArrayList di1 = new ArrayList();
	String str[] = new String[30];

	public void init() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		int fc = 1, minpath = 0, pathcount = 0, p = 0;
		double mindist = 100.0, dist = 0.0, time = 0.6;
		double totdist = 0.0, totfcost = 0.0, totccost = 0.0;
		int tottime = 0, totfuel = 0, totchem = 0, tothours = 0;
		double totdist1 = 0.0, totfcost1 = 0.0, totccost1 = 0.0;
		int tottime1 = 0, totfuel1 = 0, totchem1 = 0, tothours1 = 0;
		int[] path = new int[30];
		int[] trav = new int[30];
		for (int i = 1; i < 10; i++) {
			trav[i] = 0;
		}
		int mon[][] = { { 64, 90 }, { 20, 79 }, { 14, 89 }, { 50, 67 }, { 91, 64 }, { 51, 31 }, { 1, 71 }, { 43, 43 },
				{ 78, 88 } };
		int tue[][] = { { 25, 14 }, { 72, 48 }, { 88, 94 }, { 89, 76 }, { 16, 27 }, { 36, 72 }, { 20, 38 }, { 72, 59 },
				{ 29, 80 } };

		int load[][] = { { 20, 25 }, { 70, 80 } };

		field[0] = new Field(load[0][0], load[0][1]);
		field[10] = new Field(load[1][0], load[1][1]);
		for (int f = 0; f < mon.length; f++) {
			for (int g = 0; g < 1; g++) {
				field[fc] = new Field(mon[f][g], mon[f][g + 1]);
				fc++;
			}
		}
		fc = 11;
		for (int f = 0; f < tue.length; f++) {
			for (int g = 0; g < 1; g++) {
				field[fc] = new Field(tue[f][g], tue[f][g + 1]);
				fc++;
			}
		}

		Field start = field[0];
		// For Monday

		int count = 0, a = 0;
		for (int j = 1; j <= 9; j++) {

			while (pathcount < 9) {
				count++;
				if (count == 1) {
					tottime = tottime + 35;
					totfcost = totfcost + (5 * 50);
					totccost = totccost + (16 * 100);
					totfuel = totfuel + 50;
					totchem = totchem + 100;
				}
				tottime = tottime + 90;
				if (pathcount != 0) {
					start = field[minpath];
					mindist = 100.0;
				}

				for (a = 1; a < 10; a++) {

					if (trav[a] != 1) {
						dist = start.distanceTo(field[a]);
						if (dist < mindist && dist != 0.0) {
							mindist = dist;
							minpath = a;
							totdist = totdist + mindist;
						}
					}

				} // main path calc
				ar.add(minpath);
				di.add(mindist);
				trav[minpath] = 1;
				pathcount++;
				if (count == 3 || count == 6) {
					tottime = tottime + 35;
					totfuel = totfuel + 50;
					totchem = totchem + 100;
					double dist1, dist2;
					dist1 = field[minpath].distanceTo(field[0]);
					dist2 = field[minpath].distanceTo(field[10]);
					if (dist1 < dist2) {
						totfcost = totfcost + (5 * 50);
						totccost = totccost + (16 * 100);
						mindist = dist1;
						minpath = 0;
						ar.add(0);
						di.add(mindist);
					} else {
						totfcost = totfcost + (6 * 50);
						totccost = totccost + (15 * 100);
						mindist = dist2;
						minpath = 10;
						ar.add(10);
						di.add(mindist);
					}
				} // count 3 or 6
				if (count == 9) {
					ar.add(0);
					di.add(field[minpath].distanceTo(field[0]));
				} // count 9
			} // pathcount

		} // loop for

		// For Tuesday
		count = 0;
		mindist = 100.0;
		pathcount = 0;
		start = field[0];
		for (int j = 1; j <= 9; j++) {

			while (pathcount < 9) {
				count++;
				if (count == 1) {
					tottime1 = tottime1 + 35;
					totfcost1 = totfcost1 + (5 * 50);
					totccost1 = totccost1 + (16 * 100);
					totfuel1 = totfuel1 + 50;
					totchem1 = totchem1 + 100;
				}
				tottime1 = tottime1 + 90;
				if (pathcount != 0) {
					start = field[minpath];
					mindist = 100.0;
				}

				for (a = 11; a < 20; a++) {

					if (trav[a] != 1) {
						dist = start.distanceTo(field[a]);
						if (dist < mindist && dist != 0.0) {
							mindist = dist;
							minpath = a;
							totdist1 = totdist1 + mindist;
						}
					}

				} // main path calc
				ar1.add(minpath);
				di1.add(mindist);
				trav[minpath] = 1;
				pathcount++;
				if (count == 3 || count == 6) {
					tottime1 = tottime1 + 35;
					totfuel1 = totfuel1 + 50;
					totchem1 = totchem1 + 100;
					double dist1, dist2;
					dist1 = field[minpath].distanceTo(field[0]);
					dist2 = field[minpath].distanceTo(field[10]);
					if (dist1 < dist2) {
						totfcost1 = totfcost1 + (5 * 50);
						totccost1 = totccost1 + (16 * 100);
						mindist = dist1;
						minpath = 0;
						ar1.add(0);
						di1.add(mindist);
					} else {
						totfcost1 = totfcost1 + (6 * 50);
						totccost1 = totccost1 + (15 * 100);
						mindist = dist2;
						minpath = 10;
						ar1.add(10);
						di1.add(mindist);
					}
				} // count 3 or 6
				if (count == 9) {
					ar1.add(0);
					di1.add(field[minpath].distanceTo(field[0]));
				} // count 9
			} // pathcount

		} // loop for

		// To display points visited
		str[0] = "Monday";
		str[1] = "20,25";
		for (int i = 0; i < ar.size(); i++) {
			str[1] = str[1] + " --> " + field[(int) ar.get(i)];
		}
		str[2] = "Total Distance - " + formatter.format(totdist) + " miles";
		tothours = (int) (((time * totdist) / 60) + (tottime / 60));
		str[3] = "Total Flight Hours - " + tothours + " hrs";
		str[4] = "Total Fuel and its Cost - " + totfuel + " : $" + totfcost;
		str[5] = "Total Chemical and its Cost - " + totchem + " : $" + totccost;
		str[6] = "Total Time - " + tottime / 60 + " hrs";
		str[7] = "Tuesday";
		str[8] = "20,25";
		for (int i = 0; i < ar1.size(); i++) {
			str[8] = str[8] + " --> " + field[(int) ar1.get(i)];
		}
		str[9] = "Total Distance - " + formatter.format(totdist1) + " miles";
		tothours1 = (int) (((time * totdist1) / 60) + (tottime1 / 60));
		str[10] = "Total Flight Hours - " + tothours1 + " hrs";
		str[11] = "Total Fuel and its Cost - " + totfuel1 + " : $" + totfcost1;
		str[12] = "Total Chemical and its Cost - " + totchem1 + " : $" + totccost1;
		str[13] = "Total Time - " + tottime1 / 60 + " hrs";

	}

	public void paint(Graphics g) {
		g.drawString("Monday", 10, 10);

		for (int i = 0; i < ar.size(); i++) {
			g.drawLine(field[i].getX(), field[i].getY(), field[i + 1].getX(), field[i + 1].getY());
		}
		g.drawString("Tuesday", 120, 100);

		for (int i = 11; i < 19; i++) {
			g.drawLine(field[i].getX() + 100, field[i].getY() + 100, field[i + 1].getX() + 100,
					field[i + 1].getY() + 100);
		}
		int num = 220;
		for (int m = 0; m < 14; m++) {
			g.drawString(str[m], 10, num);
			num = num + 20;
		}

	}

}
