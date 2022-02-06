package ua.lviv.lgs.first;

public class Auto {
private int horsepower;
private int age;
private Helm helm;
private Engine engine;

public Auto(int horsepower, int age, Helm helm, Engine engine) {
	super();
	this.horsepower = horsepower;
	this.age = age;
	this.helm = helm;
	this.engine = engine;
}
public int getHorsepower() {
	return horsepower;
}
public void setHorsepower(int horsepower) {
	this.horsepower = horsepower;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Auto [Horsepower=" + horsepower + ", Age=" + age + ", Diametr="
			+ helm.getDiametr() + ", Material=" + helm.getMaterial() + ", Cylindres="
			+ engine.getCylindres() + "]";
}



}
