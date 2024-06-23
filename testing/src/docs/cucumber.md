```
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
    testCompileOnly 'org.mockito:mockito-core'
    testImplementation 'org.junit.platform:junit-platform-suite:1.9.0'


    testImplementation 'io.cucumber:cucumber-java:7.0.0'
    testImplementation 'io.cucumber:cucumber-spring:7.0.0'
    testImplementation 'io.cucumber:cucumber-junit-platform-engine:7.0.0'
```

**testImplementation** : (Scope) These dependencies are available during the compilation and execution of the test code.

**testRuntimeOnly** : (Scope) These dependencies are only available at runtime for the test tasks.



```
    sourceSets {
        integrationTest {
            java {
                srcDirs 'src/integrationTest/java'
                compileClasspath += sourceSets.main.output + configurations.testRuntimeClasspath
                runtimeClasspath += output + compileClasspath + configurations.testRuntimeClasspath
            }
            resources.srcDirs 'src/integrationTest/resources'
        }
    }
```

* sourceSets { ... }: This block defines source sets **integratonTest** within your project. 
A source set groups related source code and resources for specific purposes.

* java { ... }: This block configures the Java source code aspects of the integrationTest source set. 
**srcDirs 'src/integrationTest/java'** : This line specifies the directory containing the Java source code files for integration tests.
**compileClasspath += sourceSets.main.output + configurations.testRuntimeClasspath:** This line defines the compile classpath for the integration test source code. 
**runtimeClasspath += output + compileClasspath + configurations.testRuntimeClasspath:** This line defines the runtime classpath for the integration tests when they are executed. 
**resources.srcDirs 'src/integrationTest/resources'**: This line specifies the directory containing any resource files needed for the integration tests. These resources could be data files, configuration files, etc., located at src/integrationTest/resources.

If you don't specify **compileClasspath += sourceSets.main.output + configurations.testRuntimeClasspath** in your Gradle build script for the integrationTest source set, your integration tests will likely fail to compile or run properly due to Missing Dependencies:
The **compileClasspath** defines the dependencies available during compilation.
Without including **sourceSets.main.output**, the integration test code won't have access to classes from your main application codebase.
The **configurations.testRuntimeClasspath** typically includes libraries needed for testing frameworks (e.g., JUnit).
If this is not included, the integration test code might not have access to essential testing functionalities.



```
    configurations {
        integrationTestImplementation.extendsFrom testImplementation
        integrationTestRuntimeOnly.extendsFrom testRuntimeOnly
    }
    
    OR
    
    integrationTestImplementation 'org.some:dependency:1.0'
    
```

**Dependency Configuration** : In Gradle, a dependency configuration is a named set of dependencies. The default configurations include *implementation*, *testImplementation*, *runtimeOnly*, *testRuntimeOnly*, and more.

```
    task integrationTest(type: Test) {
        description = 'Runs integration tests.'
        group = 'verification'
        testClassesDirs = sourceSets.integrationTest.output.classesDirs
        classpath = sourceSets.integrationTest.runtimeClasspath
        shouldRunAfter test
        doFirst {
            println "Detected test classes: ${sourceSets.integrationTest.output.classesDirs.asPath}"
        }
    }
    
    check.dependsOn integrationTest
    
```

**task integrationTest(type: Test)**: Declares a new task named integrationTest of type Test. The Test type is a built-in Gradle type used for running tests.


```
    tasks.processResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    
    tasks.processTestResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    
    tasks.processIntegrationTestResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    } 
```
the *processResources*, *processTestResources*, and *processIntegrationTestResources* tasks handle copying resource files (e.g., configuration files, properties files) from the source directories to the output directories.

