/**
 * May 12, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern;

import java.util.Properties;

import org.maker_pattern.LivingBeingMaker.MakerHook;
import org.maker_pattern.animals.Dog;

/**
 * A hook for LivingBeingMaker, overriding instance creation definitions
 * @author Ramiro.Serrato
 *
 */
public enum LivingBeingMakerHook implements MakerHook {
	YELLOW_LABRADOR (LivingBeingMaker.LABRADOR) {
		@Override
		public Dog makeInstance(Properties properties) {
			Dog yellowLabrador = new Dog();
			yellowLabrador.setName("Yellow Labrador");
			return yellowLabrador; 
		}
	};
	
	private LivingBeingMakerHook(LivingBeingMaker otherMaker) {
		otherMaker.setHook(this);
	}
}
