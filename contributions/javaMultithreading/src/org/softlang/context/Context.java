package org.softlang.context;

import org.softlang.action.Action;

public interface Context {
	<X, Y> void execute(Action<X, Y> action, X param);
}
