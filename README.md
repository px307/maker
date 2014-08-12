# Maker Factories

![Maker](http://www.raspacorp.com/images/Maker.png) 

## Welcome to the Maker Factory project or simply Maker

A basic light-weight pragmatic programmatic Dependency Resolution pattern and micro-framework. I call it a micro-framework because its core philosophy is about having all the framework code in a single component in a few hundreds lines of code. That way we can use it without needing to import any dependencies, the framework code lives in the same place than your bean definitions.

The advantage of having a single component framework is that you have instant access to the framework code, you can customize it and play with it to fit your needs, another approach will be to extract the framework code and use it via composition but at this stage I consider that is better to have everything in the same file.

Taking ideas from other patterns for dependency injection like Resource Locator, Abstract Factory, Factory Methods, Spring IOC Container and the singleton pattern implementation with java enums. I tried to implement the things that I found useful from these patterns but with the goal of reducing the number of components and the overhead when loading the IOC container.

One of the differences between Maker and Resource/Service Locator is the use of hard instead of weak references, it does not use a map or dictionary to register resources but enum values. Java enum types provide an easy way for creating objects called enum constants or enum values, those objects are instantiated when the enum class is loaded and initialized by the class loader in a sort of lazy initialization when one of the enum constants is referenced.

I find this pattern/framework good for java mobile applications that cannot support a heavy framework for DI like Guice or Spring.

But that doesn't mean it cannot be used for large java enterprise applications, currently we are using this pattern in the company I work for medium-size enterprise production applications and it behaves well. 

It can also be used in conjunction with frameworks like Spring, this way you can for example share singleton instances between Spring managed beans and other objects that are not Spring Context aware.

To try the framework just clone this git project and import the eclipse project maker-pattern, or download it in zip format using github downlad zip button in the lower right panel. Then import the project to Eclipse and run the class LivingBeingHospital.java.

Look at the [wiki](https://github.com/raspacorp/maker/wiki) (currently under construction) for more documentation and examples.

Enjoy.
