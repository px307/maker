/**
 * Mar 19, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.animals;

public class DogFamily extends AnimalFamily<Dog> {
	@Override
	public void newMember(Dog dog) {
		offspring.add(dog);
		System.out.println(parent1.getName() +" and "+ parent2.getName() +" have a new dog in the family !!!");
	}
}
