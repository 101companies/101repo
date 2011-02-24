package org.softlang.alpha.tests;

import java.lang.reflect.Field;
import java.util.LinkedList;

import org.softlang.company.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * We do a round-tripping test for de-/serialization.
 * That is, first, we create an object in memory.
 * Then, we write (say, serialize) the object.
 * Then, we read (say, de-serialize) the object.
 * Finally, we compare original and read object for structural equality.
 */
public class Serialization {

	public static Company createCompany() {
		Company company = new Company();
		
		company.setName("meganalysis");

		Person craig = new Person();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		Person erik = new Person();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		Person ralf = new Person();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		Person ray = new Person();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		Person klaus = new Person();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		Person karl = new Person();
		karl.setName("Karl");
		karl.setAddress("Riga");
		Person joe = new Person();
		joe.setName("Joe");
		joe.setAddress("Wifi City");

		Employee CraigE = new Employee();
		Employee erikE = new Employee();
		Employee ralfE = new Employee();
		Employee rayE = new Employee();
		Employee klausE = new Employee();
		Employee karlE = new Employee();
		Employee joeE = new Employee();

		CraigE.setPerson(craig);
		erikE.setPerson(erik);
		ralfE.setPerson(ralf);
		rayE.setPerson(ray);
		klausE.setPerson(klaus);
		karlE.setPerson(karl);
		joeE.setPerson(joe);

		CraigE.setSalary(123456);
		erikE.setSalary(12345);
		ralfE.setSalary(1234);
		rayE.setSalary(234567);
		klausE.setSalary(23456);
		karlE.setSalary(2345);
		joeE.setSalary(2344);

		Dept research = new Dept();
		Subunit researchS1 = new Subunit();
		Subunit researchS2 = new Subunit();

		research.setManager(CraigE);
		research.setName("Research");
		researchS1.setPu(erikE);
		researchS2.setPu(ralfE);
		research.getSubunits().add(researchS1);
		research.getSubunits().add(researchS2);


		Dept development = new Dept();
		development.setManager(rayE);
		development.setName("Development");
		Subunit developmentS1 = new Subunit();
		development.getSubunits().add(developmentS1);
		Dept dev1 = new Dept();
		dev1.setName("Dev1");
		dev1.setManager(klausE);
		developmentS1.setDu(dev1);
		Subunit dev1S1 = new Subunit();
		dev1.getSubunits().add(dev1S1);
		Dept dev11 = new Dept();
		dev11.setName("Dev1.1");
		dev11.setManager(karlE);
		dev1S1.setDu(dev11);
		Subunit dev11S1 = new Subunit();
		dev11S1.setPu(joeE);
		dev11.getSubunits().add(dev11S1);

		company.getDepts().add(research);
		company.getDepts().add(development);


		return company;
	}


	@Test
	public void testLoadAndCreate() {
		Company sampleCompany = createCompany(); 
		sampleCompany.writeObject("sampleCompany.ser");
		Company loadedCompany = Company.readObject("sampleCompany.ser");
		assertTrue(structurallyEqual(sampleCompany, loadedCompany));
	}
	
	public static boolean structurallyEqual(Object o1, Object o2) {

		try {
			if (o1.getClass().getName().equals(o2.getClass().getName())) {
				for (Class<?> obj = o1.getClass(); !obj.equals(Object.class); obj = obj
						.getSuperclass()) {

					Field[] f1 = obj.getDeclaredFields();
					Field[] f2 = obj.getDeclaredFields();

					for (int i = 0; i < f1.length; i++) {

						f1[i].setAccessible(true);
						f2[i].setAccessible(true);

						// check if fields are primitive types and compare
						if ((f1[i].getType().isPrimitive() && f2[i].getType()
								.isPrimitive())) {
							if (!(f1[i].getName().equals(f2[i].getName())))
								return false;
							else {
								if (!(f1[i].get(o1).equals(f2[i].get(o2)))) {
									return false;
								}
							}
							// otherwise, they must be objects
						} else {
							// to be equal, both can not be null
							if (f1[i].get(o1) != null && f2[i].get(o2) != null) {
								// check, if they are of the same class
								if (f1[i]
										.get(o1)
										.getClass()
										.getName()
										.equals(f2[i].get(o2).getClass()
												.getName())) {
									// check if the class is Double,Integer or
									// String
									if (check(f1[i].get(o1).getClass()
											.getName())) {
										// compare values
										if (!(f1[i].get(o1).equals(f2[i]
												.get(o2)))) {
											return false;
										}
									} else {
										// special case, if the object is an
										// linked
										// list
										if (f1[i].get(o1).getClass().getName()
												.equals("java.util.LinkedList")) {
											if (!(handleLinkedList(f1[i],
													o1, f2[i], o2))) {
												return false;
											}
										} else {
											// otherwise, compare the objects
											structurallyEqual(f1[i].get(o1),
													f2[i].get(o2));
										}
									}
								} else {
									return false;
								}
							} else {
								// if one of them is null, the objects can not
								// be
								// equal
								if (f1[i].get(o1) == null
										&& f2[i].get(o2) != null) {
									return false;
								}
								if (f1[i].get(o1) != null
										&& f2[i].get(o2) == null) {
									return false;
								}
							}

						}
					}
				}
			} else {
				return false;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static boolean check(String s) {
		return (s.equals("java.lang.String") || s.equals("java.lang.Integer")
				|| s.equals("java.lang.Double") || s.equals("java.lang.Float"));

	}

	private static boolean handleLinkedList(Field f1, Object o1, Field f2, Object o2) {
		try {
			LinkedList<?> l1 = (LinkedList<?>) f1.get(o1);
			LinkedList<?> l2 = (LinkedList<?>) f2.get(o2);
			int length = l1.size();
			for (int i = 0; i < length; i++) {
				if (!(structurallyEqual(l1.get(i), l2.get(i)))) {
					return false;
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return true;
	}	
}
