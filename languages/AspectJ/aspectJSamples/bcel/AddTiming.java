package bcel;

import java.io.*;

import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;
import org.apache.bcel.Constants;

public class AddTiming {
	/**
	 * Add timing wrapper to method of class. The method can accept any
	 * arguments and return any type (including void), but must be a normal
	 * (non-static, non-initializer) method to be used with this code as
	 * currently implemented. Handling the other types of methods would not
	 * involve any fundamental changes to the code.
	 * 
	 * @param cgen
	 *            generator for class being modified
	 * @param method
	 *            current method to be enhanced with timing wrapper
	 */

	private static void addWrapper(ClassGen cgen, Method method) {

		// set up the construction tools
		InstructionFactory ifact = new InstructionFactory(cgen);
		InstructionList ilist = new InstructionList();
		ConstantPoolGen pgen = cgen.getConstantPool();
		String cname = cgen.getClassName();
		MethodGen wrapgen = new MethodGen(method, cname, pgen);
		wrapgen.setInstructionList(ilist);

		// rename a copy of the original method
		MethodGen methgen = new MethodGen(method, cname, pgen);
		cgen.removeMethod(method);
		String iname = methgen.getName() + "$impl";
		methgen.setName(iname);
		cgen.addMethod(methgen.getMethod());

		// compute the size of the calling parameters
		Type[] types = methgen.getArgumentTypes();
		int slot = methgen.isStatic() ? 0 : 1;
		for (int i = 0; i < types.length; i++) {
			slot += types[i].getSize();
		}

		// save time prior to invocation
		ilist.append(ifact.createInvoke("java.lang.System",
				"currentTimeMillis", Type.LONG, Type.NO_ARGS,
				Constants.INVOKESTATIC));
		ilist.append(InstructionFactory.createStore(Type.LONG, slot));

		// call the wrapped method
		int offset = 0;
		short invoke = Constants.INVOKESTATIC;
		if (!methgen.isStatic()) {
			ilist.append(InstructionFactory.createLoad(Type.OBJECT, 0));
			offset = 1;
			invoke = Constants.INVOKEVIRTUAL;
		}
		for (int i = 0; i < types.length; i++) {
			Type type = types[i];
			ilist.append(InstructionFactory.createLoad(type, offset));
			offset += type.getSize();
		}
		Type result = methgen.getReturnType();
		ilist.append(ifact.createInvoke(cname, iname, result, types, invoke));

		// store result for return later
		if (result != Type.VOID) {
			ilist.append(InstructionFactory.createStore(result, slot + 2));
		}

		// print time required for method call
		ilist.append(ifact.createFieldAccess("java.lang.System", "out",
				new ObjectType("java.io.PrintStream"), Constants.GETSTATIC));
		ilist.append(InstructionConstants.DUP);
		ilist.append(InstructionConstants.DUP);
		String text = "Call to method " + methgen.getName() + " took ";
		ilist.append(new PUSH(pgen, text));
		ilist
				.append(ifact.createInvoke("java.io.PrintStream", "print",
						Type.VOID, new Type[] { Type.STRING },
						Constants.INVOKEVIRTUAL));
		ilist.append(ifact.createInvoke("java.lang.System",
				"currentTimeMillis", Type.LONG, Type.NO_ARGS,
				Constants.INVOKESTATIC));
		ilist.append(InstructionFactory.createLoad(Type.LONG, slot));
		ilist.append(InstructionConstants.LSUB);
		ilist.append(ifact.createInvoke("java.io.PrintStream", "print",
				Type.VOID, new Type[] { Type.LONG }, Constants.INVOKEVIRTUAL));
		ilist.append(new PUSH(pgen, " ms."));
		ilist
				.append(ifact.createInvoke("java.io.PrintStream", "println",
						Type.VOID, new Type[] { Type.STRING },
						Constants.INVOKEVIRTUAL));

		// return result from wrapped method call
		if (result != Type.VOID) {
			ilist.append(InstructionFactory.createLoad(result, slot + 2));
		}
		ilist.append(InstructionFactory.createReturn(result));

		// finalize the constructed method
		wrapgen.stripAttributes(true);
		wrapgen.setMaxStack();
		wrapgen.setMaxLocals();
		cgen.addMethod(wrapgen.getMethod());
		ilist.dispose();
	}

	public static void main(String[] argv) {
		String className = "bcel" + File.separator + "StringBuilder.class";
		String methodName = "buildString";
		try {
			JavaClass jclas = new ClassParser(className).parse();
			ClassGen cgen = new ClassGen(jclas);
			Method[] methods = jclas.getMethods();
			int index;
			for (index = 0; index < methods.length; index++) {
				if (methods[index].getName().equals(methodName)) {
					break;
				}
			}
			if (index < methods.length) {
				addWrapper(cgen, methods[index]);
				FileOutputStream fos = new FileOutputStream(className);
				cgen.getJavaClass().dump(fos);
				fos.close();
			} else {
				System.err.println("Method " + methodName + " not found in "
						+ className);
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
		System.out.println("BCEL job completed.");
	}
}
