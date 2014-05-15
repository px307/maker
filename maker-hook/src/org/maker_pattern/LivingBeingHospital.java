/**
 * Mar 14, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern;

import static org.maker_pattern.LivingBeingMaker.*;

import org.maker_pattern.animals.Animal;

/**
 * @author Ramiro.Serrato
 *
 */
public class LivingBeingHospital {
	
	private Animal labrador1 = LivingBeingMaker.get(LABRADOR);
	private Animal labrador2 = LivingBeingMaker.get(AKITA);

	
	private void cureAnimal(Animal animal) {
		System.out.print("Curing animal..." + animal.getName()+":");
		animal.makeNoise();  // it hurts
	}
	
	private void cureAnimals() {
		cureAnimal(labrador1);
		cureAnimal(labrador2);
	}
	
	public void runHospitalDay() {
		cureAnimals();
	}
	
	public static void main(String[] args) {
		System.setProperty("maker.hooks.package", "org.maker_pattern.hook");  // setting the package where the hooks are located
		LivingBeingHospital generalHospital = new LivingBeingHospital();
		generalHospital.runHospitalDay();
	}
}
