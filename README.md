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

## Add some dependencies 


```
repositories {
    mavenCentral()
}

dependencies {
  compile group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.14.0'
  compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.14.0'
}
```

## Do some logging 

```
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

	static Logger logger = LogManager.getLogger(HelloWorld.class);

	// This is the main method.
	public static void main(String[] args) {

		logger.debug("Hello world.");

	}
}
```

You shall need to configure debug to write to console also. 

```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>

  <Appenders>
    <Console name="LogToConsole" target="SYSTEM_OUT">
      <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
  </Appenders>

  <Loggers>

  	<Logger name="org.foo" level="debug" additivity="false">
  		<AppenderRef ref="LogToConsole"/> 
  	</Logger>

    <Root level="error">
      <AppenderRef ref="LogToConsole"/>
    </Root>

  </Loggers>
</Configuration>
```

This will work for both run as java program. 
And 

```
gradle clean build run
```