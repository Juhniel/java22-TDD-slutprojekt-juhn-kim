# java22-TDD-slutprojekt-juhn-kim

# Overview
This project we are testing code according to the TDD-principles. The program is similar to our final project in advanced Java where 
we created a "producer consumer" program. A producer produces an "item" object and the "item" gets placed in the buffer.
A consumer consumes the "item" from the buffer.

# Key Features
* Construction Behavior
* Getter and Setter verification 
* Exception Handling
* Null Value testing
* Mocking
* Helper classes
* TDD Principles

## The tests covers the following features of the 'Buffer' class:
### Constructor Tests
There aren't specific constructor tests for the Buffer class as it mainly involves initializing a
Queue<Item> without specific parameters. However, the effective functioning of the constructor is
implicitly tested through the behavior of the add and remove methods from the Producer and Consumer.

**Adding Items:** Tests ensure that items can be successfully added to the buffer.

**Removing Items:** Tests verify that items can be removed correctly, following the expected behavior.

**Handling Empty Buffer:** Tests confirm that the remove() method behaves as expected when the buffer is empty, including waiting behavior and exception handling.

**Thread Safety:** Multi-threaded tests check the thread safety and synchronization aspects of the buffer, particularly important in a producer-consumer context.

**FIFO Behavior:** This is crucial as it ensures that items are processed in the order they are added, a fundamental feature for many buffering mechanisms.


## The tests covers the following features of the 'Item' class:

### Constructor Tests
**Handling Different Input Cases:** Ensures the constructor correctly handles various input strings, including null, empty string, upper case, and mixed case, converting them to lowercase as required.
Getters Tests

**ID Retrieval:** Tests that the getId() method returns the correct, lowercase ID of the item.

**Set ID:** Verifies that the setId() method updates the item's ID correctly and converts it to lowercase.

**Null Handling:** Confirms that the class throws NullPointerException when null is used for the ID, both in the constructor and the setId() method.

**Empty String Handling:** Tests how the class handles an empty string as an ID.

# Reflection and Conclusion
The approach I had for this project was to understand how the project was structured and what classes 
were needed to be mocked. 

The key part of the test classes were to implement Mock classes since we do not have a Producer and Consumer class.
Then by using Producer and Consumer to be able to produce or remove an item through our Buffer.

It was confusing at first especially for the names described for the Interface classes
where I think ProducerInterface and ConsumerInterface would be a better name fit. But working with a code 
that was written by someone else is always a good practise but at first glance it can be confusing. If
the Consumer and Producer are interfaces what would the actual classes be named for Producer and Consumers that 
implements these two interfaces? I also think that it could perhaps but slightly redundant to have the same methods practically for both of these classes.
Perhaps it would be better to combine the Consumer and Producer interface.

After getting a hang of how the code should be tested it was easier to understand the logic and how the program
should actually work. 

What I found difficult and most confusing was the producer-consumer interactions where the producer notifies the
consumer and the consumer waits for a response. The complexity of ensuring that the consumer thread properly
waits when the buffer is empty and resumes its behavior is of importance in this project. 
I realized during my first tests that the consumer was stuck waiting for a response that 
would never occur in the test. There were a lot of things going through my mind here, like 
creating new threads to be able to interact with one and another.

InterruptedException was another detail that required us to essentially trigger the catch block. To do this
we could interrupt the actual thread to trigger the InterruptedException.

Overall it was a great experience to learn about implementing mock classes, understanding Java's multithreading 
tools and the complexity of testing threads. However, I feel like I have evolved and been able to deepen my knowledge
in this field for future work. I've also gained some valuable insights during testing, reading and understanding 
other developers code.




# Test case
![slutprojekt_test.png](slutprojekt_test.png)