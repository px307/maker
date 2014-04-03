/**
 * Mar 17, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.plants;

public class Daisy implements Plant {
	private String kind;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public void grow() {
		System.out.println(kind+"...growing fast");
	}
}
