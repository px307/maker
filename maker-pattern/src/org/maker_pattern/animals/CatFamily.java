/**
 * Mar 19, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.animals;

public class CatFamily extends AnimalFamily<Cat> {
	@Override
	public void newMember(Cat dog) {
		offspring.add(dog);
		System.out.println(parent1.getName() +" and "+ parent2.getName() +" have a new cat in the family !!!");
	}
}
