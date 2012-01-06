package org.softlang.client.interfaces;

import org.softlang.client.guiinfos.TreeInfo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tree")
public interface TreeService extends RemoteService {
	
	public TreeInfo getTree();
	
}
