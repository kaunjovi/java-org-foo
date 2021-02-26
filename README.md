# java-org-foo
Just a generic java project. Sort of scatchpad for ideas. 


```
gradle clean build run 
```

This should do exactly as it says. Clean the crap from previous build. Rebuild. And finally run. 
For this to run some code we need to tell what our main class is. Also we need to tell that this is a java application. 

```
apply plugin: 'java'
apply plugin: 'application'

mainClassName = 'hello.HelloWorld'
```


