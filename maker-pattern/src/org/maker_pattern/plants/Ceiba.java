/**
 * Mar 17, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.plants;

public class Ceiba implements Plant {
	private Integer age;
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public void grow() {
		System.out.println("Ceiba " +age+ " years old ...growing slowly");
	}
}
