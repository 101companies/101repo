package org.softlang.action;

import org.softlang.context.Context;

public interface Action<X, Y> {

	public void execute(Context context, X param);

	public Y getResult();
}
