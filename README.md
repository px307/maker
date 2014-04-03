maker
=====

A basic light-weight pragmatic programmatic Dependency Injection Pattern


Taking ideas from other patterns for dependency injection like Resource Locator, Abstract Factory, Factory Methods, Spring IOC Container. I tried to implement the things that I find useful from these patterns but with the goal of reducing the number of components and the overhead when loading the container.

I find this pattern great for java mobile applications that cannot support a heavy framework for DI like Guice or Spring.

But that doesn't mean it cannot be used for large java enterprise applications, currently we are using this pattern in the company I work for. 

It can also be used in conjunction with frameworks like Spring, this way you can for example share singleton instances between Spring managed beans and other objects that are not Spring Context aware.

To try it just clone this git project and import the maker-pattern project into eclipse.

Enjoy.
