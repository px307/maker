/**
 * Mar 20, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalFamily<A> {
	protected A parent1;
	protected A parent2;

	protected List<A> offspring;
	
	public AnimalFamily() {
		offspring = new ArrayList<A>();
	}
	
	public A getParent1() {
		return parent1;
	}

	public void setParent1(A parent1) {
		this.parent1 = parent1;
	}

	public A getParent2() {
		return parent2;
	}

	public void setParent2(A parent2) {
		this.parent2 = parent2;
	}

	public List<A> getOffspring() {
		return offspring;
	}

	public void setOffspring(List<A> offspring) {
		this.offspring = offspring;
	}
	
	public void newMember(A member) {
		offspring.add(member);
		System.out.println("New member in the family !!!");
	}
}
