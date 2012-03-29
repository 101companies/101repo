mobl.provides('mobl.ui.ios');
mobl.load('mobl.js');

mobl.ui.ios.header = function(text, onclick, elements, callback) {
  var root130 = $("<span>");
  
  var node94 = $("<div class=\"header\">");
  
  var val42 = onclick.get();
  if(val42 !== null) {
    node94.tap(val42);
  }
  
  
  var node95 = $("<div class=\"headerContainer\">");
  
  
  var node96 = $("<div class=\"headerText\">");
  
  var ref56 = text;
  node96.text(ref56.get().toString());
  var ignore24 = false;
  ref56.addEventListener('change', function(_, ref, val) {
    if(ignore24) return;
    if(ref === ref56) {
      node96.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref56.rebind();
  
  
  node95.append(node96);
  node94.append(node95);
  var nodes70 = $("<span>");
  node94.append(nodes70);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl37();
  });
  
  function renderControl37() {
    (elements)(function(elements, callback) {
      var root131 = $("<span>");
      callback(root131); return;
    }, function(node) {
      var oldNodes = nodes70;
      nodes70 = node.contents();
      oldNodes.replaceWith(nodes70);
    });
  }
  renderControl37();
  root130.append(node94);
  callback(root130); return;
  
  
  
  
};

mobl.ui.ios.button = function(text, onclick, elements, callback) {
  var root132 = $("<span>");
  
  var node97 = $("<span class=\"button\">");
  
  var ref57 = text;
  node97.text(ref57.get().toString());
  var ignore25 = false;
  ref57.addEventListener('change', function(_, ref, val) {
    if(ignore25) return;
    if(ref === ref57) {
      node97.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref57.rebind();
  
  
  var val43 = onclick.get();
  if(val43 !== null) {
    node97.tap(val43);
  }
  
  root132.append(node97);
  callback(root132); return;
  
};

mobl.ui.ios.sideButton = function(text, onclick, elements, callback) {
  var root133 = $("<span>");
  
  var node98 = $("<span class=\"sideButton\">");
  
  var ref58 = text;
  node98.text(ref58.get().toString());
  var ignore26 = false;
  ref58.addEventListener('change', function(_, ref, val) {
    if(ignore26) return;
    if(ref === ref58) {
      node98.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref58.rebind();
  
  
  var val44 = onclick.get();
  if(val44 !== null) {
    node98.tap(val44);
  }
  
  root133.append(node98);
  callback(root133); return;
  
};

mobl.ui.ios.backButton = function(text, onclick, elements, callback) {
  var root134 = $("<span>");
  
  var node99 = $("<a href=\"javascript:void(0)\" class=\"backButton\" id=\"back-button\">");
  
  var ref59 = text;
  node99.text(ref59.get().toString());
  var ignore27 = false;
  ref59.addEventListener('change', function(_, ref, val) {
    if(ignore27) return;
    if(ref === ref59) {
      node99.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref59.rebind();
  
  
  var val45 = onclick.get();
  if(val45 !== null) {
    node99.tap(val45);
  }
  
  root134.append(node99);
  callback(root134); return;
  
};

mobl.ui.ios.group = function(elements, callback) {
  var root135 = $("<span>");
  
  var node100 = $("<ul >");
  
  var nodes71 = $("<span>");
  node100.append(nodes71);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl38();
  });
  
  function renderControl38() {
    (elements)(function(elements, callback) {
      var root136 = $("<span>");
      callback(root136); return;
    }, function(node) {
      var oldNodes = nodes71;
      nodes71 = node.contents();
      oldNodes.replaceWith(nodes71);
    });
  }
  renderControl38();
  root135.append(node100);
  callback(root135); return;
  
  
};

mobl.ui.ios.item = function(onclick, onswipe, elements, callback) {
  var root137 = $("<span>");
  
  var node101 = $("<li >");
  
  var val46 = onclick.get();
  if(val46 !== null) {
    node101.tap(val46);
  }
  
  var val47 = onswipe.get();
  if(val47 !== null) {
    node101.bind('swipe', val47);
  }
  
  var nodes72 = $("<span>");
  node101.append(nodes72);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl39();
  });
  
  function renderControl39() {
    (elements)(function(elements, callback) {
      var root138 = $("<span>");
      callback(root138); return;
    }, function(node) {
      var oldNodes = nodes72;
      nodes72 = node.contents();
      oldNodes.replaceWith(nodes72);
    });
  }
  renderControl39();
  root137.append(node101);
  callback(root137); return;
  
  
};

mobl.ui.ios.itemArrow = function(onclick, onswipe, elements, callback) {
  var root139 = $("<span>");
  
  var node102 = $("<li class=\"arrow\">");
  
  var val48 = onclick.get();
  if(val48 !== null) {
    node102.tap(val48);
  }
  
  var nodes73 = $("<span>");
  node102.append(nodes73);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl40();
  });
  
  function renderControl40() {
    (elements)(function(elements, callback) {
      var root140 = $("<span>");
      callback(root140); return;
    }, function(node) {
      var oldNodes = nodes73;
      nodes73 = node.contents();
      oldNodes.replaceWith(nodes73);
    });
  }
  renderControl40();
  root139.append(node102);
  callback(root139); return;
  
  
};

mobl.ui.ios.checkBox = function(b, label, elements, callback) {
  var root141 = $("<span>");
  
  var node103 = $("<span >");
  
  var val49 = function(event) {
                if(event && event.stopPropagation) event.stopPropagation();
                var result__ = b.get() ? false : true;
                b.set(result__);
                
              };
  if(val49 !== null) {
    node103.tap(val49);
  }
  
  
  var node104 = $("<img class=\"checkbox\">");
  
  var ref61 = mobl.ref(b.get() ? "mobl/ui/ios/checkbox-checked.png" : "mobl/ui/ios/checkbox.png");
  if(ref61.get() !== null) {
    node104.attr('src', ref61.get());
    ref61.addEventListener('change', function(_, ref, val) {
      if(ref === ref61) {
        node104.attr('src', val);
      } else {
        console.log("Garbage!");
      }
    });
    b.addEventListener('change', function() {
      node104.attr('src', b.get() ? "mobl/ui/ios/checkbox-checked.png" : "mobl/ui/ios/checkbox.png");
    });
    
  }
  ref61.rebind();
  
  node103.append(node104);
  
  var node105 = $("<span >");
  
  var ref60 = label;
  node105.text(ref60.get().toString());
  var ignore28 = false;
  ref60.addEventListener('change', function(_, ref, val) {
    if(ignore28) return;
    if(ref === ref60) {
      node105.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref60.rebind();
  
  
  node103.append(node105);
  root141.append(node103);
  callback(root141); return;
  
  
  
};

mobl.ui.ios.textField = function(s, placeholder, label, onchange, elements, callback) {
  var root142 = $("<span>");
  
  var node106 = $("<input type=\"text\">");
  
  var ref62 = placeholder;
  if(ref62.get() !== null) {
    node106.attr('placeholder', ref62.get());
    ref62.addEventListener('change', function(_, ref, val) {
      if(ref === ref62) {
        node106.attr('placeholder', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref62.rebind();
  
  var ref63 = s;
  node106.val(ref63.get().toString());
  var ignore29 = false;
  ref63.addEventListener('change', function(_, ref, val) {
    if(ignore29) return;
    if(ref === ref63) {
      node106.val(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref63.rebind();
  
  node106.keyup(function() {
    ignore29 = true;
    s.set(mobl.stringTomobl__String(node106.val()));
    ignore29 = false;
  });
  
  
  var val50 = onchange.get();
  if(val50 !== null) {
    node106.bind('change', val50);
  }
  
  root142.append(node106);
  callback(root142); return;
  
};

mobl.ui.ios.numField = function(n, placeholder, onchange, elements, callback) {
  var root143 = $("<span>");
  
  var node107 = $("<input type=\"text\">");
  
  var ref64 = placeholder;
  if(ref64.get() !== null) {
    node107.attr('placeholder', ref64.get());
    ref64.addEventListener('change', function(_, ref, val) {
      if(ref === ref64) {
        node107.attr('placeholder', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref64.rebind();
  
  var ref65 = n;
  node107.val(ref65.get().toString());
  var ignore30 = false;
  ref65.addEventListener('change', function(_, ref, val) {
    if(ignore30) return;
    if(ref === ref65) {
      node107.val(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref65.rebind();
  
  node107.keyup(function() {
    ignore30 = true;
    n.set(mobl.stringTomobl__Num(node107.val()));
    ignore30 = false;
  });
  
  
  var val51 = onchange.get();
  if(val51 !== null) {
    node107.bind('change', val51);
  }
  
  root143.append(node107);
  callback(root143); return;
  
};

mobl.ui.ios.promptString = function(question, callback, screenCallback) {
  var root144 = $("<div>");
  
  var answer = mobl.ref("");
  
  var tmp69 = mobl.ref(null);
  
  var nodes74 = $("<span>");
  root144.append(nodes74);
  (mobl.ui.ios.header)(question, tmp69, function(_, callback) {
    var root145 = $("<span>");
    callback(root145); return;
  }, function(node) {
    var oldNodes = nodes74;
    nodes74 = node.contents();
    oldNodes.replaceWith(nodes74);
  });
  var nodes75 = $("<span>");
  root144.append(nodes75);
  (mobl.ui.ios.group)(function(_, callback) {
    var root146 = $("<span>");
    
    var tmp74 = mobl.ref(null);
    
    
    var tmp73 = mobl.ref(null);
    
    var nodes76 = $("<span>");
    root146.append(nodes76);
    (mobl.ui.ios.item)(tmp73, tmp74, function(_, callback) {
      var root147 = $("<span>");
      
      var tmp72 = mobl.ref(null);
      
      
      var tmp71 = mobl.ref(null);
      
      
      var tmp70 = mobl.ref(null);
      
      var nodes77 = $("<span>");
      root147.append(nodes77);
      (mobl.ui.ios.textField)(answer, tmp70, tmp71, tmp72, function(_, callback) {
        var root148 = $("<span>");
        callback(root148); return;
      }, function(node) {
        var oldNodes = nodes77;
        nodes77 = node.contents();
        oldNodes.replaceWith(nodes77);
      });
      callback(root147); return;
      
    }, function(node) {
      var oldNodes = nodes76;
      nodes76 = node.contents();
      oldNodes.replaceWith(nodes76);
    });
    callback(root146); return;
    
  }, function(node) {
    var oldNodes = nodes75;
    nodes75 = node.contents();
    oldNodes.replaceWith(nodes75);
  });
  
  var tmp76 = mobl.ref(function(event) {
                       if(event && event.stopPropagation) event.stopPropagation();
                       var result__ = answer.get();
                       if(screenCallback) screenCallback(result__);
                       return;
                       
                     });
  
  
  var tmp75 = mobl.ref("Ok");
  
  var nodes78 = $("<span>");
  root144.append(nodes78);
  (mobl.ui.ios.button)(tmp75, tmp76, function(_, callback) {
    var root149 = $("<span>");
    callback(root149); return;
  }, function(node) {
    var oldNodes = nodes78;
    nodes78 = node.contents();
    oldNodes.replaceWith(nodes78);
  });
  callback(root144); return;
  
  
  
};

mobl.ui.ios.searchBox = function(s, placeholder, onsearch, elements, callback) {
  var root150 = $("<span>");
  
  var node108 = $("<div class=\"searchbox\">");
  
  
  var node109 = $("<input type=\"text\">");
  
  var ref66 = placeholder;
  if(ref66.get() !== null) {
    node109.attr('placeholder', ref66.get());
    ref66.addEventListener('change', function(_, ref, val) {
      if(ref === ref66) {
        node109.attr('placeholder', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref66.rebind();
  
  var ref67 = s;
  node109.val(ref67.get().toString());
  var ignore31 = false;
  ref67.addEventListener('change', function(_, ref, val) {
    if(ignore31) return;
    if(ref === ref67) {
      node109.val(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref67.rebind();
  
  node109.keyup(function() {
    ignore31 = true;
    s.set(mobl.stringTomobl__String(node109.val()));
    ignore31 = false;
  });
  
  
  var val52 = onsearch.get();
  if(val52 !== null) {
    node109.bind('change', val52);
  }
  
  node108.append(node109);
  root150.append(node108);
  callback(root150); return;
  
  
};

mobl.ui.ios.textarea = function(s, placeholder, onchange, elements, callback) {
  var root151 = $("<span>");
  
  var node110 = $("<textarea >");
  
  var ref68 = placeholder;
  if(ref68.get() !== null) {
    node110.attr('placeholder', ref68.get());
    ref68.addEventListener('change', function(_, ref, val) {
      if(ref === ref68) {
        node110.attr('placeholder', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref68.rebind();
  
  var ref69 = s;
  node110.val(ref69.get().toString());
  var ignore32 = false;
  ref69.addEventListener('change', function(_, ref, val) {
    if(ignore32) return;
    if(ref === ref69) {
      node110.val(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref69.rebind();
  
  node110.keyup(function() {
    ignore32 = true;
    s.set(mobl.stringTomobl__String(node110.val()));
    ignore32 = false;
  });
  
  
  var val53 = onchange.get();
  if(val53 !== null) {
    node110.bind('change', val53);
  }
  
  root151.append(node110);
  callback(root151); return;
  
};

mobl.ui.ios.basicView = function(title, toolBar, elements, callback) {
  var root152 = $("<span>");
  
  var tmp77 = mobl.ref(null);
  
  var nodes79 = $("<span>");
  root152.append(nodes79);
  (mobl.ui.ios.header)(title, tmp77, function(_, callback) {
    var root153 = $("<span>");
    callback(root153); return;
  }, function(node) {
    var oldNodes = nodes79;
    nodes79 = node.contents();
    oldNodes.replaceWith(nodes79);
  });
  
  var node111 = $("<div id=\"scrollwrapper\">");
  
  
  var node113 = $("<div id=\"content\">");
  
  var nodes81 = $("<span>");
  node113.append(nodes81);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl42();
  });
  
  function renderControl42() {
    (elements)(function(elements, callback) {
      var root155 = $("<span>");
      callback(root155); return;
    }, function(node) {
      var oldNodes = nodes81;
      nodes81 = node.contents();
      oldNodes.replaceWith(nodes81);
    });
  }
  renderControl42();
  node111.append(node113);
  root152.append(node111);
  
  var node112 = $("<div id=\"footer\">");
  
  var nodes80 = $("<span>");
  node112.append(nodes80);
  toolBar.addEventListener('change', function() {
    renderControl41();
  });
  
  function renderControl41() {
    (toolBar.get())(function(elements, callback) {
      var root154 = $("<span>");
      callback(root154); return;
    }, function(node) {
      var oldNodes = nodes80;
      nodes80 = node.contents();
      oldNodes.replaceWith(nodes80);
    });
  }
  renderControl41();
  root152.append(node112);
  callback(root152); return;
  
  
  
  
  
  
};

mobl.ui.ios.table = function(elements, callback) {
  var root156 = $("<span>");
  
  var node114 = $("<table >");
  
  var nodes82 = $("<span>");
  node114.append(nodes82);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl43();
  });
  
  function renderControl43() {
    (elements)(function(elements, callback) {
      var root157 = $("<span>");
      callback(root157); return;
    }, function(node) {
      var oldNodes = nodes82;
      nodes82 = node.contents();
      oldNodes.replaceWith(nodes82);
    });
  }
  renderControl43();
  root156.append(node114);
  callback(root156); return;
  
  
};

mobl.ui.ios.row = function(elements, callback) {
  var root158 = $("<span>");
  
  var node115 = $("<tr >");
  
  var nodes83 = $("<span>");
  node115.append(nodes83);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl44();
  });
  
  function renderControl44() {
    (elements)(function(elements, callback) {
      var root159 = $("<span>");
      callback(root159); return;
    }, function(node) {
      var oldNodes = nodes83;
      nodes83 = node.contents();
      oldNodes.replaceWith(nodes83);
    });
  }
  renderControl44();
  root158.append(node115);
  callback(root158); return;
  
  
};

mobl.ui.ios.cell = function(width, elements, callback) {
  var root160 = $("<span>");
  
  var node116 = $("<td >");
  
  var ref70 = width;
  if(ref70.get() !== null) {
    node116.attr('width', ref70.get());
    ref70.addEventListener('change', function(_, ref, val) {
      if(ref === ref70) {
        node116.attr('width', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref70.rebind();
  
  var nodes84 = $("<span>");
  node116.append(nodes84);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl45();
  });
  
  function renderControl45() {
    (elements)(function(elements, callback) {
      var root161 = $("<span>");
      callback(root161); return;
    }, function(node) {
      var oldNodes = nodes84;
      nodes84 = node.contents();
      oldNodes.replaceWith(nodes84);
    });
  }
  renderControl45();
  root160.append(node116);
  callback(root160); return;
  
  
};

mobl.ui.ios.image = function(url, onclick, elements, callback) {
  var root162 = $("<span>");
  
  var node117 = $("<img >");
  
  var ref71 = url;
  if(ref71.get() !== null) {
    node117.attr('src', ref71.get());
    ref71.addEventListener('change', function(_, ref, val) {
      if(ref === ref71) {
        node117.attr('src', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref71.rebind();
  
  var val54 = onclick.get();
  if(val54 !== null) {
    node117.tap(val54);
  }
  
  root162.append(node117);
  callback(root162); return;
  
};

mobl.ui.ios.altButton = function(text, onclick, elements, callback) {
  var root163 = $("<span>");
  
  var node118 = $("<a href=\"javascript:void(0)\" class=\"whiteButton\">");
  
  var ref72 = text;
  node118.text(ref72.get().toString());
  var ignore33 = false;
  ref72.addEventListener('change', function(_, ref, val) {
    if(ignore33) return;
    if(ref === ref72) {
      node118.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref72.rebind();
  
  
  var val55 = onclick.get();
  if(val55 !== null) {
    node118.tap(val55);
  }
  
  root163.append(node118);
  callback(root163); return;
  
};

mobl.ui.ios.toolbarButton = function(type, onclick, elements, callback) {
  var root164 = $("<span>");
  
  var node119 = $("<img width=\"30\" height=\"30\" class=\"toolbarButton\">");
  
  var ref73 = mobl.ref("lib/toolbar/icon_" + type.get() + ".png");
  if(ref73.get() !== null) {
    node119.attr('src', ref73.get());
    ref73.addEventListener('change', function(_, ref, val) {
      if(ref === ref73) {
        node119.attr('src', val);
      } else {
        console.log("Garbage!");
      }
    });
    type.addEventListener('change', function() {
      node119.attr('src', "lib/toolbar/icon_" + type.get() + ".png");
    });
    
  }
  ref73.rebind();
  
  var val56 = onclick.get();
  if(val56 !== null) {
    node119.tap(val56);
  }
  
  root164.append(node119);
  callback(root164); return;
  
};

mobl.ui.ios.tabSet = function(tabs, elements, callback) {
  var root165 = $("<span>");
  
  var activeTabName = mobl.ref(tabs.get().get(0)._1);
  
  var node120 = mobl.loadingSpan();
  root165.append(node120);
  var list10;
  var renderList10 = function() {
    list10 = tabs.get();
    list10.list(function(results10) {
      node120.empty();
      for(var i10 = 0; i10 < results10.length; i10++) {
        (function() {
          var iternode10 = $("<span>");
          node120.append(iternode10);
          var tabName;var tabIcon;var tabControl;
          tabName = mobl.ref(mobl.ref(mobl.ref(results10), i10), "_1");tabIcon = mobl.ref(mobl.ref(mobl.ref(results10), i10), "_2");tabControl = mobl.ref(mobl.ref(mobl.ref(results10), i10), "_3");
          
          var node121 = $("<div >");
          
          var ref74 = mobl.ref(activeTabName.get() == tabName.get() ? "activeTab" : "inActiveTab");
          if(ref74.get() !== null) {
            node121.attr('class', ref74.get());
            ref74.addEventListener('change', function(_, ref, val) {
              if(ref === ref74) {
                node121.attr('class', val);
              } else {
                console.log("Garbage!");
              }
            });
            activeTabName.addEventListener('change', function() {
              node121.attr('class', activeTabName.get() == tabName.get() ? "activeTab" : "inActiveTab");
            });
            tabName.addEventListener('change', function() {
              node121.attr('class', activeTabName.get() == tabName.get() ? "activeTab" : "inActiveTab");
            });
            
          }
          ref74.rebind();
          
          
          var node122 = $("<div id=\"scrollwrapper\">");
          
          
          var node123 = $("<div id=\"content\">");
          
          var nodes85 = $("<span>");
          node123.append(nodes85);
          tabControl.addEventListener('change', function() {
            renderControl46();
          });
          
          function renderControl46() {
            (tabControl.get())(function(elements, callback) {
              var root166 = $("<span>");
              callback(root166); return;
            }, function(node) {
              var oldNodes = nodes85;
              nodes85 = node.contents();
              oldNodes.replaceWith(nodes85);
            });
          }
          renderControl46();
          node122.append(node123);
          node121.append(node122);
          iternode10.append(node121);
          
          var oldNodes = iternode10;
          iternode10 = iternode10.contents();
          oldNodes.replaceWith(iternode10);
          
          
          
          
          
        }());
      }
      mobl.delayedUpdateScrollers();
    });
  };
  renderList10();
  list10.addEventListener('change', function() { renderList10(true); });
  tabs.addEventListener('change', function() { renderList10(true); });
  
  
  var node124 = $("<div id=\"tabbar\">");
  
  
  var node125 = mobl.loadingSpan();
  node124.append(node125);
  var list11;
  var renderList11 = function() {
    list11 = tabs.get();
    list11.list(function(results11) {
      node125.empty();
      for(var i11 = 0; i11 < results11.length; i11++) {
        (function() {
          var iternode11 = $("<span>");
          node125.append(iternode11);
          var tabName;var tabIcon;var tabControl;
          tabName = mobl.ref(mobl.ref(mobl.ref(results11), i11), "_1");tabIcon = mobl.ref(mobl.ref(mobl.ref(results11), i11), "_2");tabControl = mobl.ref(mobl.ref(mobl.ref(results11), i11), "_3");
          
          var node126 = $("<div >");
          
          var val57 = function(event) {
                        if(event && event.stopPropagation) event.stopPropagation();
                        var result__ = tabName.get();
                        activeTabName.set(result__);
                        var result__ = mobl.ui.ios.updateScrollers();
                        
                      };
          if(val57 !== null) {
            node126.tap(val57);
          }
          
          var ref76 = mobl.ref(activeTabName.get() == tabName.get() ? "activeTabButton" : "inActiveTabButton");
          if(ref76.get() !== null) {
            node126.attr('class', ref76.get());
            ref76.addEventListener('change', function(_, ref, val) {
              if(ref === ref76) {
                node126.attr('class', val);
              } else {
                console.log("Garbage!");
              }
            });
            activeTabName.addEventListener('change', function() {
              node126.attr('class', activeTabName.get() == tabName.get() ? "activeTabButton" : "inActiveTabButton");
            });
            tabName.addEventListener('change', function() {
              node126.attr('class', activeTabName.get() == tabName.get() ? "activeTabButton" : "inActiveTabButton");
            });
            
          }
          ref76.rebind();
          
          
          var node127 = $("<img width=\"25\" height=\"25\">");
          
          var ref75 = tabIcon;
          if(ref75.get() !== null) {
            node127.attr('src', ref75.get());
            ref75.addEventListener('change', function(_, ref, val) {
              if(ref === ref75) {
                node127.attr('src', val);
              } else {
                console.log("Garbage!");
              }
            });
            
          }
          ref75.rebind();
          
          node126.append(node127);
          
          var node128 = $("<br >");
          
          node126.append(node128);
          
          var tmp78 = mobl.ref(null);
          
          var nodes86 = $("<span>");
          node126.append(nodes86);
          (mobl.label)(tabName, tmp78, function(_, callback) {
            var root167 = $("<span>");
            callback(root167); return;
          }, function(node) {
            var oldNodes = nodes86;
            nodes86 = node.contents();
            oldNodes.replaceWith(nodes86);
          });
          iternode11.append(node126);
          
          var oldNodes = iternode11;
          iternode11 = iternode11.contents();
          oldNodes.replaceWith(iternode11);
          
          
          
          
          
        }());
      }
      mobl.delayedUpdateScrollers();
    });
  };
  renderList11();
  list11.addEventListener('change', function() { renderList11(true); });
  tabs.addEventListener('change', function() { renderList11(true); });
  
  root165.append(node124);
  callback(root165); return;
  
  
  
};
mobl.ui.ios.contextMenu = function(elements, callback) {
                            var root = $("<span>");
                            var img = $("<img src='mobl/ui/generic/contextmenu.png' style='float: right;'/>");
                            root.append(img);
                            img.tap(function(event) {
                                      var target = img.parent();
                                      var item = $("<div class='contextMenu'>");
                                      img.fadeOut();
                                      item.css('right', "0");
                                      item.css('top', target.position().top + 8 + "px");
                                      elements(function(elements, callback) {
                                                 var root5175 = $("<span>");
                                                 callback(root5175);
                                                 return;
                                               }, function(node) {
                                                    item.append(node);
                                                  });
                                      target.append(item);
                                      item.hide().fadeIn();
                                      function removeMenu ( ) {
                                        item.fadeOut().remove();
                                        img.show();
                                        $("body").unbind('click', removeMenu);
                                        $("body").unbind('touchstart', removeMenu);
                                      }
                                      setTimeout(function() {
                                                   $("body").bind('click', removeMenu);
                                                   $("body").bind('touchstart', removeMenu);
                                                 }, 0);
                                    });
                            callback(root);
                          };
mobl.scrollTop = function() {
                   var scrollers = $("div#scrollwrapper div#content");
                   for(var i = 0; i < scrollers.length; i++)
                   {
                     var scroller = scrollers.eq(i).data("scroller");
                     scroller.scrollTo(0, 0);
                   }
                 };
mobl.ui.ios.updateScrollers = function() {
                                mobl.delayedUpdateScrollers();
                              };