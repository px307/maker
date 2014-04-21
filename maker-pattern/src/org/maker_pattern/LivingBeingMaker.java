/**
 * Mar 14, 2014 File created by Ramiro.Serrato
 */
package org.maker_pattern;

import java.io.IOException;
import java.util.Properties;

import org.maker_pattern.animals.Animal;
import org.maker_pattern.animals.Cat;
import org.maker_pattern.animals.CatFamily;
import org.maker_pattern.animals.Dog;
import org.maker_pattern.animals.DogFamily;
import org.maker_pattern.plants.Ceiba;
import org.maker_pattern.plants.Daisy;
import org.maker_pattern.plants.Plant;

/**
 * A very basic, light-weight, pragmatic programmatic alternative to DI frameworks 
 *  Maker Pattern versions: 
 *  0.1 First version using an external class that included a Map storing the singleton instances and getInstance method, supporting 
 *      singleton and prototype beans
 *  0.2 Redesigned the pattern, now everything is in a single class (enum) and uses kind of factory methods for retrieving instances
 *  	This version is also capable of wiring beans inside the same enum and cross enum wiring too, allowing us to separate the beans
 *      by domain or responsibility in different files and wire them if needed
 *  0.3 Added init, start, shutdown, clear and clearAll life cycle methods
 *  0.4 Added Properties parameter to getInstance method for supporting initialization properties
 *  0.5 Removed init method as it was not really useful
 * @author Ramiro.Serrato
 *
 */
public enum LivingBeingMaker {
	
	/*** Object configuration, definition, wiring ***/
	//  Pattern:   NAME (isSingleton) { createInstance() { <object creation logic > } }

	SPARKY_DOG (true) {
		@Override
		public Dog createInstance(Properties properties) {
			Dog sparky = new Dog();
			sparky.setName(properties.getProperty("sparky.name"));
			return sparky;
		}
	},

	PINKY_DOG (true) {
		@Override
		public Dog createInstance(Properties properties) {
			Dog pinky = new Dog();
			pinky.setName(properties.getProperty("pinky.name"));
			return pinky;
		}
	},
	
	SPARKY_FAMILY (true) {  // A wired object
		@Override
		public DogFamily createInstance(Properties properties) {
			DogFamily dogFamily = new DogFamily();
			dogFamily.setParent1(getDog(SPARKY_DOG));
			dogFamily.setParent2(getDog(PINKY_DOG));
			return dogFamily;
		}
	},
		
	SIAMESE (false)  { @Override public Cat createInstance(Properties properties) { return new Cat(); } },
	LABRADOR (false) { @Override public Dog createInstance(Properties properties) { return new Dog(); } },
	
	DAISY (false) { 
		@Override	
		public Plant createInstance(Properties properties) {	
			Daisy daisy = new Daisy();
			daisy.setKind(properties.getProperty("daisy_kind"));
			return daisy;	
		} 
	},
	
	CEIBA (false) { 
		@Override 
		public Plant createInstance(Properties properties) { 
			Ceiba ceiba = new Ceiba();
			ceiba.setAge(new Integer(properties.getProperty("ceiba_age")));
			return ceiba;	
		} 
	};
	
	/** Here define factory methods **/
	
	public static Dog getDog(LivingBeingMaker livingBeingMaker) {
		return (Dog) livingBeingMaker.getInstance(generalProperties);
	}
	
	public static Cat getCat(LivingBeingMaker livingBeingMaker) {
		return (Cat) livingBeingMaker.getInstance(generalProperties);
	}
	
	public static DogFamily getDogFamily(LivingBeingMaker livingBeingMaker) {
		return (DogFamily) livingBeingMaker.getInstance(generalProperties);
	}
	
	public static CatFamily getCatFamily(LivingBeingMaker livingBeingMaker) {
		return (CatFamily) livingBeingMaker.getInstance(generalProperties);
	}
	
	public static Animal getAnimal(LivingBeingMaker livingBeingMaker) {
		return (Animal) livingBeingMaker.getInstance(generalProperties);
	}
	
	public static Plant getPlant(LivingBeingMaker livingBeingMaker) {
		return (Plant) livingBeingMaker.getInstance(generalProperties);
	}
	
	/**** From here and down generic code, change this only if you know what you are doing ****/
	static {  // here you can define static stuff like properties or xml loaded configuration 
	    Properties livingBeingroperties = new Properties();
		
		try { // load plant and animal configuration from xml and properties files
			livingBeingroperties.loadFromXML(LivingBeingMaker.class.getResourceAsStream("resources/plant-config.xml"));
			livingBeingroperties.load(LivingBeingMaker.class.getResourceAsStream("resources/animal-config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
		
		generalProperties = livingBeingroperties;
	}
	
	protected static Properties generalProperties;
	
	private LivingBeingMaker(Boolean singleton) {
		this.singleton = singleton;
	}
	
	private Boolean singleton;
	private Object instance;
	
	public Boolean isSingleton() {
		return singleton;
	}
	
	/**
	 * This is the method that handles the creation of instances based on the flag singleton it 
	 *  will create a singleton or a prototype instance
	 * @param properties A Properties object that may contain information needed for the instance creation
	 * @return The instance as an Object
	 */
	private Object getInstance(Properties properties) {
		if (singleton) {
			if (instance == null) {
				synchronized (this) {
					if (instance == null) {
						instance = this.createInstance(properties);
					}
				}
			}
		} 
	
		Object localInstance = (instance == null) ? this.createInstance(properties) : instance;
		start(localInstance);
		
		return localInstance;
	}
	
	/**
	 * Similar to {@link #init()} method, the difference is that the logic here will be executed each time an instance
	 *  is created, for prototypes that means every time the getInstance method is called, for singletons only the first
	 *  time the getInstance method is called
	 */
	protected void start(Object object) {
		;
	}
	
	/**
	 * You can put some shutdown logic here, this method can be overriden inside the enum value definition. 
	 *  Shutdown logic can be: external resources release, clear chache, etc. 
	 */
	public void shutdown(Object object) {
		;
	}
	
	/**
	 * This method will call the {@link #shutdown()} method for all the enums in the maker
	 */
	public void shutdownAll() {
		;
	}
	
	/**
	 * This method will set the instance to null, useful for reseting singleton instances
	 */
	public void clear() {
		instance = null;
	}
	
	/**
	 * Will call the {@link #clear()} method for all the enums defined in the maker
	 */
	public void clearAll() {
		for (LivingBeingMaker value : LivingBeingMaker.values()) {
			  value.clear();
		}
	}
	
	/**
	 * This method contains the logic for creating the instance, it receives a Properties
	 *  object as a parameter that my contain initial properties for creating the instances
	 * @param properties a Properties object
	 * @return The created instance as an Object
	 */
	public abstract Object createInstance(Properties properties);
}
