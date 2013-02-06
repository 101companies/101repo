/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locator;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Martin
 */
public class Fragment {
        @SerializedName("class")
        private String classname;
        @SerializedName("method")
        private String method;
        @SerializedName("package")
        private String packagename;
        @SerializedName("overload")
        private String overload;

	public Fragment() { }

	public Fragment(String fragmentDescription) {
		String[] splitted = fragmentDescription.split("/");
		classname = splitted[0];
		method = splitted[1];
		if (splitted.length > 2)
			overload = splitted[2];	
	}

        public boolean isOverloaded() {
            return overload != null;
        }
        
        public String getOverload() {
            return overload;
        }

        public String getClassname() {
            return classname;
        }

        public String getMethod() {
            return method;
        }

        public String getPackagename() {
            return packagename;
        } 
}
