/**
 * May 12, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern.hook;

import org.maker_pattern.LivingBeingMaker;
import org.maker_pattern.LivingBeingMaker.MakerHook;
import org.maker_pattern.animals.Dog;

/**
 * A hook for LivingBeingMaker, overriding instance creation definitions
 * @author Ramiro.Serrato
 *
 */
public enum LivingBeingMakerHook implements MakerHook {
	
	LONG_COAT_AKITA (LivingBeingMaker.AKITA) {
		@Override
		public Dog makeInstance() {
			Dog longCoatAkita = new Dog();
			longCoatAkita.setName("Long coat akita");
			return longCoatAkita; 
		}
	},
	
	YELLOW_LABRADOR (LivingBeingMaker.LABRADOR) {
		@Override
		public Dog makeInstance() {
			Dog yellowLabrador = new Dog();
			yellowLabrador.setName("Yellow Labrador");
			return yellowLabrador; 
		}
	};
	
	private LivingBeingMakerHook(LivingBeingMaker otherMaker) {
		otherMaker.setHook(this);
	}
}
