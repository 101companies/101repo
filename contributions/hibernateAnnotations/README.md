This is an implementation of the 101companies System.

Headline: Object/Relational mapping for Java with Hibernate

Documentation: http://101companies.org/wiki/Contribution:hibernateAnnotations

In addition to the wiki-listed developers and reviewers, these sources are acknowledged:

* The Hibernate Tutorial by Red Hat Middleware LLC
* Christian Bauer, Gavin King: Java Persistence with Hibernate. Manning Publications, 2006

# Contribution's Documentation Changes

== Headline == 

[[Object-Relational mapping]] for [[Language:Java|Java]] with [[Technology:Hibernate|Hibernate]] and [[Technology:JPA]].

== Characteristics == 

The contribution demonstrates [[Object-Relational mapping]] or [[persistence]] on the Java platform. A mapping is definied in the object models as Java-Annotations.

== Relationships ==

[[Contribution:hibernateAnnotations|Contribution:hibernateAnnotations]] is a variation of [[Contribution:hibernateJava10|hibernateJava10]]. The variation is concerned with the realization of [[O/R mapping]]. That is, this project's object model is mapped by use of [[Technology:JPA]] annotations and used by the [[Technology:Hibernate|Hibernate framework]] instead of legacy [[Language:XML]]-mapping files for all [[Persistence|persistent]] classes.

== Illustration ==

Consider the following sketch of the class for departments:

<syntaxhighlight lang="java">
@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="DEPT_ID")
	private Set<Employee> employees;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="DEPT_ID")
	private Set<Department> subdepts;

	public Long getId() { ... }
	private void setId(Long id) { ... }
	public String getName() { ... }
	public void setName(String name) { ... }
	public Set<Employee> getEmployees() { ... }
	private void setEmployees(Set<Employee> employees) { ... }
	public Set<Department> getSubdepts() { ... }
	private void setSubdepts(Set<Department> subdepts) { ... }
}
</syntaxhighlight>

Each persistent class must provide a property (i.e., a getter and a setter) for
an ''id'' that can serve as primary key in the database. Properties of 
collection types (in fact, set types) proxy for one-to-many relationships.
Annotations are added to associate classes with a relational schema.
They can be used in addition to, but preferably as a replacement of XML mapping metadata.
Other than that, a persistent class is not much different from a regular
[[POJO]]-like class. (There are some private setters that would be missing
from a native object model. These setters are needed for object population.)

Consider the Annotations used to map class ''Department'' to table ''DEPARTMENT'':
@Entity marks the class as an entity, i.e. a persistent POJO class.
@Table takes arguments to define the table names and other properties for your
entity mapping. If no @Table is defined some default values are used.

All other properties of the class are associated with the table.
That is, the ''id'' property is directly mapped to a primary key column
by use of @Id. @GeneratedValue allows the application to set
the property itself, i.e. generate some identifier for your entity.

The ''name'' property is mapped to column ''NAME'' by the optional @Column annotation.
Further, the ''employees''
property is non-trivially associated with a foreign key ''DEPT_ID'' of the 
''EMPLOYEE'' table by use of the @OneToMany annotation. This is only
indirectly identified through the mentioning of the ''Employee'' class; likewise for sub-departments.

For further Illustration refer to [[Contribution:hibernate]]

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
