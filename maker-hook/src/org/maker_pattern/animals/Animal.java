/**
 * Mar 14, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.animals;

public abstract class Animal {
	protected String name = "nameless";

	public Animal() {
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("...");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
