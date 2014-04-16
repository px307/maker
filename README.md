Maker Pattern
=====

A basic light-weight pragmatic programmatic Dependency Resolution Pattern and Micro-Framework


Taking ideas from other patterns for dependency injection like Resource Locator, Abstract Factory, Factory Methods, Spring IOC Container and the singleton pattern implementation with java enums. I tried to implement the things that I found useful from these patterns but with the goal of reducing the number of components and the overhead when loading the DI container.

I find this pattern great for java mobile applications that cannot support a heavy framework for DI like Guice or Spring.

But that doesn't mean it cannot be used for large java enterprise applications, currently we are using this pattern in the company I work for medium size enterprise production applications and it behaves well. 

It can also be used in conjunction with frameworks like Spring, this way you can for example share singleton instances between Spring managed beans and other objects that are not Spring Context aware.

To try it just clone this git project and import the maker-pattern project into eclipse, or download it in zip format using github downlad zip button in the lower right panel.

In that project you can find a very simple implementation of the patter called the Living Being Hospital that shows some of the important features of the pattern.

Enjoy.
