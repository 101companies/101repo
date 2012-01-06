package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.TreeInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TreeServiceAsync {

	void getTree(AsyncCallback<TreeInfo> callback);

}
