This is an implementation of the 101companies System.

Headline: Object/Relational mapping for Java with Hibernate

Documentation: http://101companies.org/wiki/Contribution:hibernate

In addition to the wiki-listed developers and reviewers, these sources are acknowledged:

* The Hibernate Tutorial by Red Hat Middleware LLC
* Christian Bauer, Gavin King: Java Persistence with Hibernate. Manning Publications, 2006

# Contribution Documentation Changes

== Headline ==

[[Object-Relational mapping]] for [[Language:Java|Java]] with [[Technology:Hibernate|Hibernate]].

== Characteristics ==

The contribution demonstrates [[Object-Relational mapping]] or [[persistence]] on the Java platform. A mapping is defined in additional XML files.

== Relationships ==

[[Contribution:hibernateJava10|Contribution:hibernateJava10]] is a variation of [[Contribution:hibernate|hibernate]]. The variation is concerned with the addition of [[Technology:Gradle]] and the modernization of [[Feature:Total]], [[Feature:Cut]], [[Feature:Mentoring]].

== Usage ==

Please follow these steps carefully.

'''Start from a clean setup'''
Upon checking out the implementation, you are clean.

For further testing,
it is recommended to execute *clean* and *populate* to reset the database state.

'''Build the project'''
This is a Gradle Project.
Everything is included.

The project should build fine in any IDE that supports Gradle.
Eclipse and IntelliJ support Gradle natively in their latest versions.

We have 4 different Gradle tasks for you to easily run the tests and you therefore don't need to care about the database server as much.

'''Gradle tasks'''

You can find the Gradle tasks in the group 'database'.

'''*start*'''
This task starts the database in the background.

'''*stop*'''
As the name says, this task will stop the database server.

'''*clear*'''
This command clears the database completely.

'''*populate*'''
This will fill the database with all the sample data provided and is required for the tests.
To reset the data it is recommended to execute *clear* and then *populate* to start fresh.

'''*openDbManager*'''
This will open the Database Manager so you can verify or debug various things.

'''Proper testing'''
Several test cases are collected in package org.softlang.tests:

* Run the JUnit test *Check* for checking for the ranking constraint. This test does not modify the state of the database. This test succeeds repeatedly (since even the cut transformation does not end up violating the constraint).
* Run the JUnit test *Query* for computing the salary total. This test does not modify the state of the database. This test succeeds repeatedly for as long as the computed total equals the baseline that is hard-coded in that test.
* Run the JUnit test *TransformNoSave* for cutting all salaries. This test does not modify the state of the database. This test succeeds repeatedly (since the totals before and after cut are compared without using any hard-coded baseline for total).
* Run the JUnit test *TransformAndSave* for cutting all salaries. This test modifies the state of the database and thus makes fail test *Query*. This test succeeds repeatedly (since the totals before and after cut are compared without using any hard-coded baseline for total).

'''Finish off'''
Just execute *stop* and quit the database monitor.

== Metadata == 

* [[memberOf::Theme:Java mapping]]
* [[uses::Language:Java]]
* [[uses::Language:SQL]]
* [[uses::Language:HSQLDialect]]
* [[uses::Language:HQL]]
* [[uses::Language:XML]]
* [[uses::Technology:Hibernate]]
* [[uses::Technology:HSQLDB]]
* [[uses::Technology:jpa]]
* [[uses:Technology]:Gradle]
* [[implements::Feature:Hierarchical company]]
* [[implements::Feature:Total]]
* [[implements::Feature:Cut]]
* [[implements::Feature:Mentoring]]
* [[implements::Feature:Persistence]]
* [[implements::Feature:Mapping]]
