package ua.lviv.lgs.first;

public class Helm{
private int diametr;
private String material;



public Helm(int diametr, String material) {
	super();
	this.diametr = diametr;
	this.material = material;
}
public int getDiametr() {
	return diametr;
}
public void setDiametr(int diametr) {
	this.diametr = diametr;
}
public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
@Override
public String toString() {
	return "Helm [diametr=" + diametr + ", material=" + material + "]";
}

}
