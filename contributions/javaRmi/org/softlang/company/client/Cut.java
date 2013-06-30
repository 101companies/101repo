package org.softlang.company.client;

import java.rmi.RemoteException;

import org.softlang.company.shared.*;

public class Cut {

    public static void cut(Company that) throws RemoteException {
        for (Department d : that.getDepts())
            cut(d);
    }

    public static void cut(Department that) throws RemoteException {
        cut(that.getManager());
        for (Department s : that.getSubdepts())
            cut(s);
        for (Employee e : that.getEmployees())
            cut(e);
    }    

    public static void cut(Employee that) throws RemoteException {
        that.setSalary(that.getSalary() / 2);
    }

}