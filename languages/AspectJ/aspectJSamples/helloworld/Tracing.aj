/*
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Matthew Webster    initial implementation
 */
package helloworld;

public aspect Tracing {

	// Toggle to enable/disable aspect
	final static boolean RUN = true;

	private pointcut mainMethod () :
		   if(RUN) 
		&& execution(public static void main(String[]));

	before () : mainMethod() {
		System.out.println("> " + thisJoinPoint);
	}

	after () : mainMethod() {
		System.out.println("< " + thisJoinPoint);
	}
}
