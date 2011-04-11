package org.softlang;

import org.softlang.operations.Cut;
import org.softlang.operations.Total;

public class OperationRunner {
	public static void main(String[] args) throws Exception{
		if(args.length < 1){
			printUsage();
			System.exit(1);
		}
		String[] newArgs = new String[args.length-1];
		for(int i = 0; i < newArgs.length; i++){
			newArgs[i] = args[i+1];
		}
		if(args[0].equals("Total")){
			Total.run(newArgs);
		}else if(args[0].equals("Cut")){
			Cut.run(newArgs);
		}else{
			printUsage();
		}
	}

	private static void printUsage() {
		Total.printUsage();
		Cut.printUsage();
	}
}
