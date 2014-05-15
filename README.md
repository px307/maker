Maker Factory Pattern
=====

A basic light-weight pragmatic programmatic Dependency Resolution Pattern and Micro-Framework. I call it Micro-Framework because it is a single component framework, that is its main philosophy.

Taking ideas from other patterns for dependency injection like Resource Locator, Abstract Factory, Factory Methods, Spring IOC Container and the singleton pattern implementation with java enums. I tried to implement the things that I found useful from these patterns but with the goal of reducing the number of components and the overhead when loading the DI container.

One of the differences between Maker and Resource/Service Locator is the use of hard instead of weak references, it does not use a map or dictionary to register resources but enum values. Java enum types provide an easy way for creating objects called enum constants or enum values, those objects are instantiated when the enum class is loaded and initialized by the class loader in a sort of lazy initialization when one of the enum constants is referenced.

I find this pattern/framework good for java mobile applications that cannot support a heavy framework for DI like Guice or Spring.

But that doesn't mean it cannot be used for large java enterprise applications, currently we are using this pattern in the company I work for medium-size enterprise production applications and it behaves well. 

It can also be used in conjunction with frameworks like Spring, this way you can for example share singleton instances between Spring managed beans and other objects that are not Spring Context aware.

To try the basic version just clone this git project and import the maker-pattern project into eclipse, or download it in zip format using github downlad zip button in the lower right panel. Then import the project to Eclipse and run the class LivingBeingHospital.java.

There is another project called the maker-hook which is an eclipse project as well, that example is an extension of the framework that adds a feature that brings the possibility of overriding the logic for instantiating objects, for example when you have your Maker factory inside a library but you want to have a particular way of instantiating your object in the application that is importing the library whithout modifying the Maker factory code, a common use case of that will be a DataSource definition that may be different for each application that will use a common Maker factory definition.

Those two projects implement a simple application called LivingBeingHospital which shows some of the important features of this micro-framework

Enjoy.
