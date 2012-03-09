@license{
  Copyright (c) 2009-2011 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Bas Basten - Bas.Basten@cwi.nl (CWI)}
@contributor{Mark Hills - Mark.Hills@cwi.nl (CWI)}
module ide::Language

import ParseTree;
import util::IDE;
import util::SyntaxHighlightingTemplates;
import Set;
import Grammar;
import AST;
import BuildAST;
import Verify;
import Message;
import ide::Outline;

public void register101() {
  	registerLanguage("101Companies", "hc", Tree (str x, loc l) {
    	return parse(#start[S_Companies], x, l);
  	});
  	
  	registerContributions("101Companies", {
  		getSolarizedLightCategories(),
  		annotator(
  			Tree (Tree pt) {
  				set[Message] msgs = verify(buildAST(pt));
  				return isEmpty(msgs) ? pt : pt[@messages = msgs];
  			}
  		),
  		outliner(buildOutline)
  	});
}

