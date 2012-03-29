mobl.provides('mobl.ui.generic');
mobl.load('mobl.js');

mobl.ui.generic.header = function(text, onclick, elements, callback) {
  var root170 = $("<span>");
  
  var node130 = $("<div class=\"header\">");
  
  var val58 = onclick.get();
  if(val58 !== null) {
    node130.tap(val58);
  }
  
  
  var node131 = $("<div class=\"headerContainer\">");
  
  
  var node132 = $("<div class=\"headerText\">");
  
  var ref78 = text;
  node132.text(ref78.get().toString());
  var ignore34 = false;
  ref78.addEventListener('change', function(_, ref, val) {
    if(ignore34) return;
    if(ref === ref78) {
      node132.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref78.rebind();
  
  
  node131.append(node132);
  node130.append(node131);
  var nodes88 = $("<span>");
  node130.append(nodes88);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl48();
  });
  
  function renderControl48() {
    (elements)(function(elements, callback) {
      var root171 = $("<span>");
      callback(root171); return;
    }, function(node) {
      var oldNodes = nodes88;
      nodes88 = node.contents();
      oldNodes.replaceWith(nodes88);
    });
  }
  renderControl48();
  root170.append(node130);
  callback(root170); return;
  
  
  
  
};

mobl.ui.generic.button = function(text, onclick, elements, callback) {
  var root172 = $("<span>");
  
  var node133 = $("<span class=\"button\">");
  
  var val59 = onclick.get();
  if(val59 !== null) {
    node133.tap(val59);
  }
  
  var ref79 = text;
  node133.text(ref79.get().toString());
  var ignore35 = false;
  ref79.addEventListener('change', function(_, ref, val) {
    if(ignore35) return;
    if(ref === ref79) {
      node133.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref79.rebind();
  
  
  root172.append(node133);
  callback(root172); return;
  
};

mobl.ui.generic.sideButton = function(text, onclick, elements, callback) {
  var root173 = $("<span>");
  
  var node134 = $("<span class=\"sideButton\">");
  
  var val60 = onclick.get();
  if(val60 !== null) {
    node134.tap(val60);
  }
  
  var ref80 = text;
  node134.text(ref80.get().toString());
  var ignore36 = false;
  ref80.addEventListener('change', function(_, ref, val) {
    if(ignore36) return;
    if(ref === ref80) {
      node134.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref80.rebind();
  
  
  root173.append(node134);
  callback(root173); return;
  
};

mobl.ui.generic.backButton = function(text, onclick, elements, callback) {
  var root174 = $("<span>");
  
  var node135 = $("<span class=\"backButton\">");
  
  var val61 = onclick.get();
  if(val61 !== null) {
    node135.tap(val61);
  }
  
  var ref81 = text;
  node135.text(ref81.get().toString());
  var ignore37 = false;
  ref81.addEventListener('change', function(_, ref, val) {
    if(ignore37) return;
    if(ref === ref81) {
      node135.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref81.rebind();
  
  
  root174.append(node135);
  callback(root174); return;
  
};

mobl.ui.generic.block = function(cssClass, id, onclick, elements, callback) {
  var root175 = $("<span>");
  
  var node136 = $("<div >");
  
  var ref82 = id;
  if(ref82.get() !== null) {
    node136.attr('id', ref82.get());
    ref82.addEventListener('change', function(_, ref, val) {
      if(ref === ref82) {
        node136.attr('id', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref82.rebind();
  
  var ref83 = cssClass;
  if(ref83.get() !== null) {
    node136.attr('class', ref83.get());
    ref83.addEventListener('change', function(_, ref, val) {
      if(ref === ref83) {
        node136.attr('class', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref83.rebind();
  
  var val62 = onclick.get();
  if(val62 !== null) {
    node136.tap(val62);
  }
  
  var nodes89 = $("<span>");
  node136.append(nodes89);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl49();
  });
  
  function renderControl49() {
    (elements)(function(elements, callback) {
      var root176 = $("<span>");
      callback(root176); return;
    }, function(node) {
      var oldNodes = nodes89;
      nodes89 = node.contents();
      oldNodes.replaceWith(nodes89);
    });
  }
  renderControl49();
  root175.append(node136);
  callback(root175); return;
  
  
};

mobl.ui.generic.span = function(cssClass, id, onclick, elements, callback) {
  var root177 = $("<span>");
  
  var node137 = $("<span >");
  
  var ref84 = id;
  if(ref84.get() !== null) {
    node137.attr('id', ref84.get());
    ref84.addEventListener('change', function(_, ref, val) {
      if(ref === ref84) {
        node137.attr('id', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref84.rebind();
  
  var ref85 = cssClass;
  if(ref85.get() !== null) {
    node137.attr('class', ref85.get());
    ref85.addEventListener('change', function(_, ref, val) {
      if(ref === ref85) {
        node137.attr('class', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref85.rebind();
  
  var val63 = onclick.get();
  if(val63 !== null) {
    node137.tap(val63);
  }
  
  var nodes90 = $("<span>");
  node137.append(nodes90);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl50();
  });
  
  function renderControl50() {
    (elements)(function(elements, callback) {
      var root178 = $("<span>");
      callback(root178); return;
    }, function(node) {
      var oldNodes = nodes90;
      nodes90 = node.contents();
      oldNodes.replaceWith(nodes90);
    });
  }
  renderControl50();
  root177.append(node137);
  callback(root177); return;
  
  
};

mobl.ui.generic.group = function(elements, callback) {
  var root179 = $("<span>");
  
  var node138 = $("<ul class=\"group\">");
  
  var nodes91 = $("<span>");
  node138.append(nodes91);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl51();
  });
  
  function renderControl51() {
    (elements)(function(elements, callback) {
      var root180 = $("<span>");
      callback(root180); return;
    }, function(node) {
      var oldNodes = nodes91;
      nodes91 = node.contents();
      oldNodes.replaceWith(nodes91);
    });
  }
  renderControl51();
  root179.append(node138);
  callback(root179); return;
  
  
};

mobl.ui.generic.image = function(url, onclick, elements, callback) {
  var root181 = $("<span>");
  
  var node139 = $("<img >");
  
  var ref86 = url;
  if(ref86.get() !== null) {
    node139.attr('src', ref86.get());
    ref86.addEventListener('change', function(_, ref, val) {
      if(ref === ref86) {
        node139.attr('src', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref86.rebind();
  
  var val64 = onclick.get();
  if(val64 !== null) {
    node139.tap(val64);
  }
  
  root181.append(node139);
  callback(root181); return;
  
};

mobl.ui.generic.item = function(onclick, onswipe, elements, callback) {
  var root182 = $("<span>");
  
  var node140 = $("<li class=\"item\">");
  
  var val65 = onclick.get();
  if(val65 !== null) {
    node140.tap(val65);
  }
  
  var nodes92 = $("<span>");
  node140.append(nodes92);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl52();
  });
  
  function renderControl52() {
    (elements)(function(elements, callback) {
      var root183 = $("<span>");
      callback(root183); return;
    }, function(node) {
      var oldNodes = nodes92;
      nodes92 = node.contents();
      oldNodes.replaceWith(nodes92);
    });
  }
  renderControl52();
  root182.append(node140);
  callback(root182); return;
  
  
};

mobl.ui.generic.itemArrow = function(onclick, onswipe, elements, callback) {
  var root184 = $("<span>");
  
  var node141 = $("<li class=\"itemArrow\">");
  
  var val66 = onclick.get();
  if(val66 !== null) {
    node141.tap(val66);
  }
  
  var nodes93 = $("<span>");
  node141.append(nodes93);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl53();
  });
  
  function renderControl53() {
    (elements)(function(elements, callback) {
      var root185 = $("<span>");
      callback(root185); return;
    }, function(node) {
      var oldNodes = nodes93;
      nodes93 = node.contents();
      oldNodes.replaceWith(nodes93);
    });
  }
  renderControl53();
  root184.append(node141);
  callback(root184); return;
  
  
};

mobl.ui.generic.checkBox = function(b, label, elements, callback) {
  var root186 = $("<span>");
  
  var node142 = $("<input type=\"checkbox\">");
  
  var ref88 = b;
  node142.attr('checked', !!ref88.get());
  ref88.addEventListener('change', function(_, ref, val) {
    if(ref === ref88) node142.attr('checked', !!val);
  });
  node142.change(function() {
    b.set(!!node142.attr('checked'));
  });
  
  var val68 = function(event) {
                if(event && event.stopPropagation) event.stopPropagation();
                
              };
  if(val68 !== null) {
    node142.tap(val68);
  }
  
  root186.append(node142);
  
  root186.append(" ");
  
  var node143 = $("<span >");
  
  var ref87 = label;
  node143.text(ref87.get().toString());
  var ignore38 = false;
  ref87.addEventListener('change', function(_, ref, val) {
    if(ignore38) return;
    if(ref === ref87) {
      node143.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref87.rebind();
  
  
  var val67 = function(event) {
                if(event && event.stopPropagation) event.stopPropagation();
                var result__ = b.get() ? false : true;
                b.set(result__);
                
              };
  if(val67 !== null) {
    node143.tap(val67);
  }
  
  root186.append(node143);
  callback(root186); return;
  
  
};

mobl.ui.generic.textField = function(s, placeholder, label, onchange, elements, callback) {
  var root187 = $("<span>");
  
  var node144 = $("<span>");
  root187.append(node144);
  var renderCond7 = function() {
    var value7 = label.get();
    node144.empty();
    if(value7) {
      
      var node145 = $("<span style=\"float: left; margin-top: 0.2em; width: 5em; color: #666;\">");
      
      var ref91 = label;
      node145.text(ref91.get().toString());
      var ignore40 = false;
      ref91.addEventListener('change', function(_, ref, val) {
        if(ignore40) return;
        if(ref === ref91) {
          node145.text(val.toString());
        } else {
          console.log("Garbage!");
        }
      });
      ref91.rebind();
      
      
      node144.append(node145);
      
      var node146 = $("<span style=\"float: left\">");
      
      
      var node147 = $("<input type=\"text\">");
      
      var ref89 = placeholder;
      if(ref89.get() !== null) {
        node147.attr('placeholder', ref89.get());
        ref89.addEventListener('change', function(_, ref, val) {
          if(ref === ref89) {
            node147.attr('placeholder', val);
          } else {
            console.log("Garbage!");
          }
        });
        
      }
      ref89.rebind();
      
      var ref90 = s;
      node147.val(ref90.get().toString());
      var ignore39 = false;
      ref90.addEventListener('change', function(_, ref, val) {
        if(ignore39) return;
        if(ref === ref90) {
          node147.val(val.toString());
        } else {
          console.log("Garbage!");
        }
      });
      ref90.rebind();
      
      node147.keyup(function() {
        ignore39 = true;
        s.set(mobl.stringTomobl__String(node147.val()));
        ignore39 = false;
      });
      
      
      var val69 = onchange.get();
      if(val69 !== null) {
        node147.bind('change', val69);
      }
      
      var val70 = function(event) {
                    if(event && event.stopPropagation) event.stopPropagation();
                    var result__ = mobl.ui.generic.scrollUp();
                    
                  };
      if(val70 !== null) {
        node147.bind('blur', val70);
      }
      
      node146.append(node147);
      node144.append(node146);
      
      
      
      
    }
  };
  renderCond7();
  label.addEventListener('change', function() {
    renderCond7();
  });
  
  
  var tmp81 = mobl.ref(!label.get());
  label.addEventListener('change', function() {
    tmp81.set(!label.get());
  });
  
  
  var node148 = $("<span>");
  root187.append(node148);
  var renderCond8 = function() {
    var value8 = tmp81.get();
    node148.empty();
    if(value8) {
      
      var node149 = $("<input type=\"text\">");
      
      var ref92 = placeholder;
      if(ref92.get() !== null) {
        node149.attr('placeholder', ref92.get());
        ref92.addEventListener('change', function(_, ref, val) {
          if(ref === ref92) {
            node149.attr('placeholder', val);
          } else {
            console.log("Garbage!");
          }
        });
        
      }
      ref92.rebind();
      
      var ref93 = s;
      node149.val(ref93.get().toString());
      var ignore41 = false;
      ref93.addEventListener('change', function(_, ref, val) {
        if(ignore41) return;
        if(ref === ref93) {
          node149.val(val.toString());
        } else {
          console.log("Garbage!");
        }
      });
      ref93.rebind();
      
      node149.keyup(function() {
        ignore41 = true;
        s.set(mobl.stringTomobl__String(node149.val()));
        ignore41 = false;
      });
      
      
      var val71 = onchange.get();
      if(val71 !== null) {
        node149.bind('change', val71);
      }
      
      var val72 = function(event) {
                    if(event && event.stopPropagation) event.stopPropagation();
                    var result__ = mobl.ui.generic.scrollUp();
                    
                  };
      if(val72 !== null) {
        node149.bind('blur', val72);
      }
      
      node148.append(node149);
      
      
    }
  };
  renderCond8();
  tmp81.addEventListener('change', function() {
    renderCond8();
  });
  
  callback(root187); return;
  
  
};

mobl.ui.generic.numField = function(n, placeholder, label, onchange, elements, callback) {
  var root188 = $("<span>");
  
  var node150 = $("<span>");
  root188.append(node150);
  var renderCond9 = function() {
    var value9 = label.get();
    node150.empty();
    if(value9) {
      
      var node151 = $("<span style=\"float: left; margin-top: 0.2em; width: 5em; color: #666;\">");
      
      var ref96 = label;
      node151.text(ref96.get().toString());
      var ignore43 = false;
      ref96.addEventListener('change', function(_, ref, val) {
        if(ignore43) return;
        if(ref === ref96) {
          node151.text(val.toString());
        } else {
          console.log("Garbage!");
        }
      });
      ref96.rebind();
      
      
      node150.append(node151);
      
      var node152 = $("<span style=\"float: left\">");
      
      
      var node153 = $("<input type=\"text\">");
      
      var ref94 = placeholder;
      if(ref94.get() !== null) {
        node153.attr('placeholder', ref94.get());
        ref94.addEventListener('change', function(_, ref, val) {
          if(ref === ref94) {
            node153.attr('placeholder', val);
          } else {
            console.log("Garbage!");
          }
        });
        
      }
      ref94.rebind();
      
      var ref95 = n;
      node153.val(ref95.get().toString());
      var ignore42 = false;
      ref95.addEventListener('change', function(_, ref, val) {
        if(ignore42) return;
        if(ref === ref95) {
          node153.val(val.toString());
        } else {
          console.log("Garbage!");
        }
      });
      ref95.rebind();
      
      node153.keyup(function() {
        ignore42 = true;
        n.set(mobl.stringTomobl__Num(node153.val()));
        ignore42 = false;
      });
      
      
      var val73 = onchange.get();
      if(val73 !== null) {
        node153.bind('change', val73);
      }
      
      var val74 = function(event) {
                    if(event && event.stopPropagation) event.stopPropagation();
                    var result__ = mobl.ui.generic.scrollUp();
                    
                  };
      if(val74 !== null) {
        node153.bind('blur', val74);
      }
      
      node152.append(node153);
      node150.append(node152);
      
      
      
      
    }
  };
  renderCond9();
  label.addEventListener('change', function() {
    renderCond9();
  });
  
  
  var tmp82 = mobl.ref(!label.get());
  label.addEventListener('change', function() {
    tmp82.set(!label.get());
  });
  
  
  var node154 = $("<span>");
  root188.append(node154);
  var renderCond10 = function() {
    var value10 = tmp82.get();
    node154.empty();
    if(value10) {
      
      var node155 = $("<input type=\"text\">");
      
      var ref97 = placeholder;
      if(ref97.get() !== null) {
        node155.attr('placeholder', ref97.get());
        ref97.addEventListener('change', function(_, ref, val) {
          if(ref === ref97) {
            node155.attr('placeholder', val);
          } else {
            console.log("Garbage!");
          }
        });
        
      }
      ref97.rebind();
      
      var ref98 = n;
      node155.val(ref98.get().toString());
      var ignore44 = false;
      ref98.addEventListener('change', function(_, ref, val) {
        if(ignore44) return;
        if(ref === ref98) {
          node155.val(val.toString());
        } else {
          console.log("Garbage!");
        }
      });
      ref98.rebind();
      
      node155.keyup(function() {
        ignore44 = true;
        n.set(mobl.stringTomobl__Num(node155.val()));
        ignore44 = false;
      });
      
      
      var val75 = onchange.get();
      if(val75 !== null) {
        node155.bind('change', val75);
      }
      
      var val76 = function(event) {
                    if(event && event.stopPropagation) event.stopPropagation();
                    var result__ = mobl.ui.generic.scrollUp();
                    
                  };
      if(val76 !== null) {
        node155.bind('blur', val76);
      }
      
      node154.append(node155);
      
      
    }
  };
  renderCond10();
  tmp82.addEventListener('change', function() {
    renderCond10();
  });
  
  callback(root188); return;
  
  
};

mobl.ui.generic.tabSet = function(tabs, elements, callback) {
  var root189 = $("<span>");
  
  var activeTabName = mobl.ref(tabs.get().get(0)._1);
  
  var s = mobl.ref("");
  
  
  var tmp87 = mobl.ref("tabbar");
  
  
  var tmp89 = mobl.ref(null);
  
  
  var tmp88 = mobl.ref(null);
  
  var nodes94 = $("<span>");
  root189.append(nodes94);
  (mobl.ui.generic.block)(tmp87, tmp88, tmp89, function(_, callback) {
    var root190 = $("<span>");
    
    var node156 = mobl.loadingSpan();
    root190.append(node156);
    var list12;
    var renderList12 = function() {
      list12 = tabs.get();
      list12.list(function(results12) {
        node156.empty();
        for(var i12 = 0; i12 < results12.length; i12++) {
          (function() {
            var iternode12 = $("<span>");
            node156.append(iternode12);
            var tabName;var tabIcon;var tabControl;
            tabName = mobl.ref(mobl.ref(mobl.ref(results12), i12), "_1");tabIcon = mobl.ref(mobl.ref(mobl.ref(results12), i12), "_2");tabControl = mobl.ref(mobl.ref(mobl.ref(results12), i12), "_3");
            
            var tmp85 = mobl.ref(activeTabName.get() == tabName.get() ? "tab activeTabButton" : "tab inActiveTabButton");
            activeTabName.addEventListener('change', function() {
              tmp85.set(activeTabName.get() == tabName.get() ? "tab activeTabButton" : "tab inActiveTabButton");
            });
            tabName.addEventListener('change', function() {
              tmp85.set(activeTabName.get() == tabName.get() ? "tab activeTabButton" : "tab inActiveTabButton");
            });
            
            
            var tmp84 = mobl.ref(function(event) {
                                 if(event && event.stopPropagation) event.stopPropagation();
                                 var result__ = tabName.get();
                                 activeTabName.set(result__);
                                 
                               });
            
            
            var tmp86 = mobl.ref(null);
            
            var nodes95 = $("<span>");
            iternode12.append(nodes95);
            (mobl.ui.generic.span)(tmp85, tmp86, tmp84, function(_, callback) {
              var root191 = $("<span>");
              
              var tmp83 = mobl.ref(null);
              
              var nodes96 = $("<span>");
              root191.append(nodes96);
              (mobl.label)(tabName, tmp83, function(_, callback) {
                var root192 = $("<span>");
                callback(root192); return;
              }, function(node) {
                var oldNodes = nodes96;
                nodes96 = node.contents();
                oldNodes.replaceWith(nodes96);
              });
              callback(root191); return;
              
            }, function(node) {
              var oldNodes = nodes95;
              nodes95 = node.contents();
              oldNodes.replaceWith(nodes95);
            });
            
            var oldNodes = iternode12;
            iternode12 = iternode12.contents();
            oldNodes.replaceWith(iternode12);
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList12();
    list12.addEventListener('change', function() { renderList12(true); });
    tabs.addEventListener('change', function() { renderList12(true); });
    
    callback(root190); return;
    
  }, function(node) {
    var oldNodes = nodes94;
    nodes94 = node.contents();
    oldNodes.replaceWith(nodes94);
  });
  
  var node157 = mobl.loadingSpan();
  root189.append(node157);
  var list13;
  var renderList13 = function() {
    list13 = tabs.get();
    list13.list(function(results13) {
      node157.empty();
      for(var i13 = 0; i13 < results13.length; i13++) {
        (function() {
          var iternode13 = $("<span>");
          node157.append(iternode13);
          var tabName;var tabIcon;var tabControl;
          tabName = mobl.ref(mobl.ref(mobl.ref(results13), i13), "_1");tabIcon = mobl.ref(mobl.ref(mobl.ref(results13), i13), "_2");tabControl = mobl.ref(mobl.ref(mobl.ref(results13), i13), "_3");
          
          var tmp90 = mobl.ref(activeTabName.get() == tabName.get() ? "activeTab" : "inActiveTab");
          activeTabName.addEventListener('change', function() {
            tmp90.set(activeTabName.get() == tabName.get() ? "activeTab" : "inActiveTab");
          });
          tabName.addEventListener('change', function() {
            tmp90.set(activeTabName.get() == tabName.get() ? "activeTab" : "inActiveTab");
          });
          
          
          var tmp92 = mobl.ref(null);
          
          
          var tmp91 = mobl.ref(null);
          
          var nodes97 = $("<span>");
          iternode13.append(nodes97);
          (mobl.ui.generic.block)(tmp90, tmp91, tmp92, function(_, callback) {
            var root193 = $("<span>");
            var nodes98 = $("<span>");
            root193.append(nodes98);
            tabControl.addEventListener('change', function() {
              renderControl54();
            });
            
            function renderControl54() {
              (tabControl.get())(function(elements, callback) {
                var root194 = $("<span>");
                callback(root194); return;
              }, function(node) {
                var oldNodes = nodes98;
                nodes98 = node.contents();
                oldNodes.replaceWith(nodes98);
              });
            }
            renderControl54();
            callback(root193); return;
            
          }, function(node) {
            var oldNodes = nodes97;
            nodes97 = node.contents();
            oldNodes.replaceWith(nodes97);
          });
          
          var oldNodes = iternode13;
          iternode13 = iternode13.contents();
          oldNodes.replaceWith(iternode13);
          
          
        }());
      }
      mobl.delayedUpdateScrollers();
    });
  };
  renderList13();
  list13.addEventListener('change', function() { renderList13(true); });
  tabs.addEventListener('change', function() { renderList13(true); });
  
  callback(root189); return;
  
  
};

mobl.ui.generic.searchBox = function(s, placeholder, onsearch, elements, callback) {
  var root195 = $("<span>");
  
  var node158 = $("<div class=\"searchbox\">");
  
  
  var node159 = $("<input type=\"text\" autocorrect=\"off\" autocapitalize=\"off\" autocomplete=\"off\">");
  
  var ref99 = placeholder;
  if(ref99.get() !== null) {
    node159.attr('placeholder', ref99.get());
    ref99.addEventListener('change', function(_, ref, val) {
      if(ref === ref99) {
        node159.attr('placeholder', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref99.rebind();
  
  var ref100 = s;
  node159.val(ref100.get().toString());
  var ignore45 = false;
  ref100.addEventListener('change', function(_, ref, val) {
    if(ignore45) return;
    if(ref === ref100) {
      node159.val(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref100.rebind();
  
  node159.keyup(function() {
    ignore45 = true;
    s.set(mobl.stringTomobl__String(node159.val()));
    ignore45 = false;
  });
  
  
  var val77 = onsearch.get();
  if(val77 !== null) {
    node159.bind('change', val77);
  }
  
  node158.append(node159);
  root195.append(node158);
  callback(root195); return;
  
  
};

mobl.ui.generic.contextMenu = function(elements, callback) {
  var root196 = $("<span>");
  
  var menu = $("<div class=\"contextMenu\">");
  
  var nodes99 = $("<span>");
  menu.append(nodes99);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl55();
  });
  
  function renderControl55() {
    (elements)(function(elements, callback) {
      var root197 = $("<span>");
      callback(root197); return;
    }, function(node) {
      var oldNodes = nodes99;
      nodes99 = node.contents();
      oldNodes.replaceWith(nodes99);
    });
  }
  renderControl55();
  root196.append(menu);
  var result__ = menu.hide();
  
  var img = $("<img src=\"mobl/ui/generic/contextmenu.png\" style=\"float: right;\">");
  
  var val78 = function(event) {
                if(event && event.stopPropagation) event.stopPropagation();
                var result__ = img.parent();
                var target = result__;
                var result__ = img.hide();
                var result__ = menu.css("right", "5px");
                var result__ = menu.css("top", target.position().top + 6 + "px");
                var result__ = menu.show();
                var result__ = mobl.$("body").bind("touchstart click", removeMenu);
                
              };
  if(val78 !== null) {
    img.tap(val78);
  }
  
  root196.append(img);
  
  var removeMenu = function(evt) {
     var __this = this;
    if(mobl.$(evt.target).parents(".contextMenu").length == 0) {
      menu.hide();
      img.show();
      mobl.$("body").unbind("touchstart click", removeMenu);
    } else {
      
    }
  };
  
  
  callback(root196); return;
  
  
  
};

mobl.ui.generic.masterDetail = function(items, masterItem, detail, elements, callback) {
  var root198 = $("<span>");
  var nodes100 = $("<span>");
  root198.append(nodes100);
  (mobl.ui.generic.group)(function(_, callback) {
    var root199 = $("<span>");
    
    var node160 = mobl.loadingSpan();
    root199.append(node160);
    var list14;
    var renderList14 = function() {
      list14 = items.get();
      list14.list(function(results14) {
        node160.empty();
        for(var i14 = 0; i14 < results14.length; i14++) {
          (function() {
            var iternode14 = $("<span>");
            node160.append(iternode14);
            var it;
            it = mobl.ref(mobl.ref(results14), i14);
            
            var tmp93 = mobl.ref(function(event) {
                                 if(event && event.stopPropagation) event.stopPropagation();
                                 mobl.call('mobl.ui.generic.detailScreen', [it, detail], function(result__) {
                                 var tmp124 = result__;
                                 
                                 });
                               });
            
            
            var tmp94 = mobl.ref(null);
            
            var nodes101 = $("<span>");
            iternode14.append(nodes101);
            (mobl.ui.generic.item)(tmp93, tmp94, function(_, callback) {
              var root200 = $("<span>");
              var nodes102 = $("<span>");
              root200.append(nodes102);
              masterItem.addEventListener('change', function() {
                renderControl56();
              });
              
              function renderControl56() {
                (masterItem.get())(it, function(elements, callback) {
                  var root201 = $("<span>");
                  callback(root201); return;
                }, function(node) {
                  var oldNodes = nodes102;
                  nodes102 = node.contents();
                  oldNodes.replaceWith(nodes102);
                });
              }
              renderControl56();
              callback(root200); return;
              
            }, function(node) {
              var oldNodes = nodes101;
              nodes101 = node.contents();
              oldNodes.replaceWith(nodes101);
            });
            
            var oldNodes = iternode14;
            iternode14 = iternode14.contents();
            oldNodes.replaceWith(iternode14);
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList14();
    list14.addEventListener('change', function() { renderList14(true); });
    items.addEventListener('change', function() { renderList14(true); });
    
    callback(root199); return;
    
  }, function(node) {
    var oldNodes = nodes100;
    nodes100 = node.contents();
    oldNodes.replaceWith(nodes100);
  });
  callback(root198); return;
  
};

mobl.ui.generic.detailScreen = function(it, detail, callback, screenCallback) {
  var root202 = $("<div>");
  
  var tmp97 = mobl.ref("Detail");
  
  
  var tmp98 = mobl.ref(null);
  
  var nodes103 = $("<span>");
  root202.append(nodes103);
  (mobl.ui.generic.header)(tmp97, tmp98, function(_, callback) {
    var root203 = $("<span>");
    
    var tmp96 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         if(screenCallback) screenCallback();
                         return;
                         
                       });
    
    
    var tmp95 = mobl.ref("Back");
    
    var nodes104 = $("<span>");
    root203.append(nodes104);
    (mobl.ui.generic.backButton)(tmp95, tmp96, function(_, callback) {
      var root204 = $("<span>");
      callback(root204); return;
    }, function(node) {
      var oldNodes = nodes104;
      nodes104 = node.contents();
      oldNodes.replaceWith(nodes104);
    });
    callback(root203); return;
    
  }, function(node) {
    var oldNodes = nodes103;
    nodes103 = node.contents();
    oldNodes.replaceWith(nodes103);
  });
  var nodes105 = $("<span>");
  root202.append(nodes105);
  detail.addEventListener('change', function() {
    renderControl57();
  });
  
  function renderControl57() {
    (detail.get())(it, function(elements, callback) {
      var root205 = $("<span>");
      callback(root205); return;
    }, function(node) {
      var oldNodes = nodes105;
      nodes105 = node.contents();
      oldNodes.replaceWith(nodes105);
    });
  }
  renderControl57();
  callback(root202); return;
  
  
};

mobl.ui.generic.masterDetail = mobl.conditionalDef(mobl.ui.generic.masterDetail, function() { return mobl.getScreenWidth() > 500; }, function(items, masterItem, detail, elements, callback) {
  var root206 = $("<span>");
  
  var itemSelected = function(onclick, onswipe, elements, callback) {
    var root207 = $("<span>");
    
    var node161 = $("<li class=\"item\" style=\"background: #cccccc;\">");
    
    var val79 = onclick.get();
    if(val79 !== null) {
      node161.tap(val79);
    }
    
    var nodes106 = $("<span>");
    node161.append(nodes106);
    mobl.ref(elements).addEventListener('change', function() {
      renderControl58();
    });
    
    function renderControl58() {
      (elements)(function(elements, callback) {
        var root208 = $("<span>");
        callback(root208); return;
      }, function(node) {
        var oldNodes = nodes106;
        nodes106 = node.contents();
        oldNodes.replaceWith(nodes106);
      });
    }
    renderControl58();
    root207.append(node161);
    callback(root207); return;
    
    
  };
  items.get().one(function(result__) {
    var current = mobl.ref(result__);
    
    var node162 = $("<div width=\"100%\">");
    
    
    var node163 = $("<div style=\"float:left; width:33%; position:relative; border-right: solid 1px #cccccc;\">");
    
    var nodes108 = $("<span>");
    node163.append(nodes108);
    (mobl.ui.generic.group)(function(_, callback) {
      var root210 = $("<span>");
      
      var node165 = mobl.loadingSpan();
      root210.append(node165);
      var list15;
      var renderList15 = function() {
        list15 = items.get();
        list15.list(function(results15) {
          node165.empty();
          for(var i15 = 0; i15 < results15.length; i15++) {
            (function() {
              var iternode15 = $("<span>");
              node165.append(iternode15);
              var it;
              it = mobl.ref(mobl.ref(results15), i15);
              
              var tmp100 = mobl.ref(null);
              
              
              var tmp99 = mobl.ref(function(event) {
                                   if(event && event.stopPropagation) event.stopPropagation();
                                   var result__ = it.get();
                                   current.set(result__);
                                   
                                 });
              
              var nodes109 = $("<span>");
              iternode15.append(nodes109);
              it.addEventListener('change', function() {
                renderControl60();
              });
              current.addEventListener('change', function() {
                renderControl60();
              });
              mobl.ref(itemSelected).addEventListener('change', function() {
                renderControl60();
              });
              mobl.ref(mobl.ui.generic.item).addEventListener('change', function() {
                renderControl60();
              });
              
              function renderControl60() {
                ((it.get() == current.get() ? itemSelected : mobl.ui.generic.item))(tmp99, tmp100, function(elements, callback) {
                  var root211 = $("<span>");
                  var nodes110 = $("<span>");
                  root211.append(nodes110);
                  masterItem.addEventListener('change', function() {
                    renderControl61();
                  });
                  
                  function renderControl61() {
                    (masterItem.get())(it, function(elements, callback) {
                      var root212 = $("<span>");
                      callback(root212); return;
                    }, function(node) {
                      var oldNodes = nodes110;
                      nodes110 = node.contents();
                      oldNodes.replaceWith(nodes110);
                    });
                  }
                  renderControl61();
                  callback(root211); return;
                  
                }, function(node) {
                  var oldNodes = nodes109;
                  nodes109 = node.contents();
                  oldNodes.replaceWith(nodes109);
                });
              }
              renderControl60();
              
              var oldNodes = iternode15;
              iternode15 = iternode15.contents();
              oldNodes.replaceWith(iternode15);
              
              
            }());
          }
          mobl.delayedUpdateScrollers();
        });
      };
      renderList15();
      list15.addEventListener('change', function() { renderList15(true); });
      items.addEventListener('change', function() { renderList15(true); });
      
      callback(root210); return;
      
    }, function(node) {
      var oldNodes = nodes108;
      nodes108 = node.contents();
      oldNodes.replaceWith(nodes108);
    });
    node162.append(node163);
    
    var node164 = $("<div style=\"float:left; width:66.5%; position:relative; margin-left: 0.5%;\">");
    
    var nodes107 = $("<span>");
    node164.append(nodes107);
    detail.addEventListener('change', function() {
      renderControl59();
    });
    
    function renderControl59() {
      (detail.get())(current, function(elements, callback) {
        var root209 = $("<span>");
        callback(root209); return;
      }, function(node) {
        var oldNodes = nodes107;
        nodes107 = node.contents();
        oldNodes.replaceWith(nodes107);
      });
    }
    renderControl59();
    node162.append(node164);
    root206.append(node162);
    callback(root206); return;
    
    
    
    
    
  });
  
});

mobl.ui.generic.zoomList = function(coll, listCtrl, zoomCtrl, elements, callback) {
  var root213 = $("<span>");
  
  var selected = mobl.ref(null);
  var nodes111 = $("<span>");
  root213.append(nodes111);
  (mobl.ui.generic.group)(function(_, callback) {
    var root214 = $("<span>");
    
    var node166 = mobl.loadingSpan();
    root214.append(node166);
    var list16;
    var renderList16 = function() {
      list16 = coll.get();
      list16.list(function(results16) {
        node166.empty();
        for(var i16 = 0; i16 < results16.length; i16++) {
          (function() {
            var iternode16 = $("<span>");
            node166.append(iternode16);
            var it;
            it = mobl.ref(mobl.ref(results16), i16);
            
            var tmp103 = mobl.ref(it.get() == selected.get());
            it.addEventListener('change', function() {
              tmp103.set(it.get() == selected.get());
            });
            selected.addEventListener('change', function() {
              tmp103.set(it.get() == selected.get());
            });
            
            
            var node167 = $("<span>");
            iternode16.append(node167);
            var renderCond11 = function() {
              var value11 = tmp103.get();
              node167.empty();
              if(value11) {
                
                var tmp102 = mobl.ref(null);
                
                
                var tmp101 = mobl.ref(null);
                
                var nodes112 = $("<span>");
                node167.append(nodes112);
                (mobl.ui.generic.item)(tmp101, tmp102, function(_, callback) {
                  var root215 = $("<span>");
                  var nodes113 = $("<span>");
                  root215.append(nodes113);
                  zoomCtrl.addEventListener('change', function() {
                    renderControl62();
                  });
                  
                  function renderControl62() {
                    (zoomCtrl.get())(it, function(elements, callback) {
                      var root216 = $("<span>");
                      callback(root216); return;
                    }, function(node) {
                      var oldNodes = nodes113;
                      nodes113 = node.contents();
                      oldNodes.replaceWith(nodes113);
                    });
                  }
                  renderControl62();
                  callback(root215); return;
                  
                }, function(node) {
                  var oldNodes = nodes112;
                  nodes112 = node.contents();
                  oldNodes.replaceWith(nodes112);
                });
                
                
              }
            };
            renderCond11();
            tmp103.addEventListener('change', function() {
              renderCond11();
            });
            
            
            var tmp106 = mobl.ref(it.get() != selected.get());
            it.addEventListener('change', function() {
              tmp106.set(it.get() != selected.get());
            });
            selected.addEventListener('change', function() {
              tmp106.set(it.get() != selected.get());
            });
            
            
            var node168 = $("<span>");
            iternode16.append(node168);
            var renderCond12 = function() {
              var value12 = tmp106.get();
              node168.empty();
              if(value12) {
                
                var tmp104 = mobl.ref(function(event) {
                                     if(event && event.stopPropagation) event.stopPropagation();
                                     var result__ = it.get();
                                     selected.set(result__);
                                     
                                   });
                
                
                var tmp105 = mobl.ref(null);
                
                var nodes114 = $("<span>");
                node168.append(nodes114);
                (mobl.ui.generic.item)(tmp104, tmp105, function(_, callback) {
                  var root217 = $("<span>");
                  var nodes115 = $("<span>");
                  root217.append(nodes115);
                  listCtrl.addEventListener('change', function() {
                    renderControl63();
                  });
                  
                  function renderControl63() {
                    (listCtrl.get())(it, function(elements, callback) {
                      var root218 = $("<span>");
                      callback(root218); return;
                    }, function(node) {
                      var oldNodes = nodes115;
                      nodes115 = node.contents();
                      oldNodes.replaceWith(nodes115);
                    });
                  }
                  renderControl63();
                  callback(root217); return;
                  
                }, function(node) {
                  var oldNodes = nodes114;
                  nodes114 = node.contents();
                  oldNodes.replaceWith(nodes114);
                });
                
                
              }
            };
            renderCond12();
            tmp106.addEventListener('change', function() {
              renderCond12();
            });
            
            
            var oldNodes = iternode16;
            iternode16 = iternode16.contents();
            oldNodes.replaceWith(iternode16);
            
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList16();
    list16.addEventListener('change', function() { renderList16(true); });
    coll.addEventListener('change', function() { renderList16(true); });
    
    callback(root214); return;
    
  }, function(node) {
    var oldNodes = nodes111;
    nodes111 = node.contents();
    oldNodes.replaceWith(nodes111);
  });
  callback(root213); return;
  
};

mobl.ui.generic.stagedList = function(coll, listCtrl, initialItems, step, elements, callback) {
  var root219 = $("<span>");
  
  var n = mobl.ref(initialItems.get());
  coll.get().count(function(result__) {
    var total = mobl.ref(result__);
    var nodes116 = $("<span>");
    root219.append(nodes116);
    (mobl.ui.generic.group)(function(_, callback) {
      var root220 = $("<span>");
      
      var tmp109 = mobl.ref(coll.get().limit(n.get()));
      mobl.ref(coll.get().limit(n.get())).addEventListener('change', function() {
        tmp109.set(coll.get().limit(n.get()));
      });
      coll.addEventListener('change', function() {
        tmp109.set(coll.get().limit(n.get()));
      });
      n.addEventListener('change', function() {
        tmp109.set(coll.get().limit(n.get()));
      });
      
      
      var node169 = mobl.loadingSpan();
      root220.append(node169);
      var list17;
      var renderList17 = function() {
        list17 = tmp109.get();
        list17.list(function(results17) {
          node169.empty();
          for(var i17 = 0; i17 < results17.length; i17++) {
            (function() {
              var iternode17 = $("<span>");
              node169.append(iternode17);
              var it;
              it = mobl.ref(mobl.ref(results17), i17);
              
              var tmp107 = mobl.ref(function(event) {
                                   if(event && event.stopPropagation) event.stopPropagation();
                                   
                                 });
              
              
              var tmp108 = mobl.ref(null);
              
              var nodes117 = $("<span>");
              iternode17.append(nodes117);
              (mobl.ui.generic.item)(tmp107, tmp108, function(_, callback) {
                var root221 = $("<span>");
                var nodes118 = $("<span>");
                root221.append(nodes118);
                listCtrl.addEventListener('change', function() {
                  renderControl64();
                });
                
                function renderControl64() {
                  (listCtrl.get())(it, function(elements, callback) {
                    var root222 = $("<span>");
                    callback(root222); return;
                  }, function(node) {
                    var oldNodes = nodes118;
                    nodes118 = node.contents();
                    oldNodes.replaceWith(nodes118);
                  });
                }
                renderControl64();
                callback(root221); return;
                
              }, function(node) {
                var oldNodes = nodes117;
                nodes117 = node.contents();
                oldNodes.replaceWith(nodes117);
              });
              
              var oldNodes = iternode17;
              iternode17 = iternode17.contents();
              oldNodes.replaceWith(iternode17);
              
              
            }());
          }
          mobl.delayedUpdateScrollers();
        });
      };
      renderList17();
      list17.addEventListener('change', function() { renderList17(true); });
      tmp109.addEventListener('change', function() { renderList17(true); });
      
      
      var tmp110 = mobl.ref(n.get() < total.get());
      n.addEventListener('change', function() {
        tmp110.set(n.get() < total.get());
      });
      total.addEventListener('change', function() {
        tmp110.set(n.get() < total.get());
      });
      
      
      var node170 = $("<span>");
      root220.append(node170);
      var renderCond13 = function() {
        var value13 = tmp110.get();
        node170.empty();
        if(value13) {
          
          var node171 = $("<li class=\"loadMore\">");
          
          var val80 = function(event) {
                        if(event && event.stopPropagation) event.stopPropagation();
                        var result__ = n.get() + step.get();
                        n.set(result__);
                        
                      };
          if(val80 !== null) {
            node171.tap(val80);
          }
          
          
          node171.append("More");
          node170.append(node171);
          
          
        }
      };
      renderCond13();
      tmp110.addEventListener('change', function() {
        renderCond13();
      });
      
      callback(root220); return;
      
      
    }, function(node) {
      var oldNodes = nodes116;
      nodes116 = node.contents();
      oldNodes.replaceWith(nodes116);
    });
    callback(root219); return;
    
  });
};

mobl.ui.generic.markableList = function(items, elements, callback) {
  var root223 = $("<span>");
  var nodes119 = $("<span>");
  root223.append(nodes119);
  (mobl.ui.generic.group)(function(_, callback) {
    var root224 = $("<span>");
    
    var node172 = mobl.loadingSpan();
    root224.append(node172);
    var list18;
    var renderList18 = function() {
      list18 = items.get();
      list18.list(function(results18) {
        node172.empty();
        for(var i18 = 0; i18 < results18.length; i18++) {
          (function() {
            var iternode18 = $("<span>");
            node172.append(iternode18);
            var checked;var it;
            checked = mobl.ref(mobl.ref(mobl.ref(results18), i18), "_1");it = mobl.ref(mobl.ref(mobl.ref(results18), i18), "_2");
            
            var tmp112 = mobl.ref(null);
            
            
            var tmp111 = mobl.ref(null);
            
            var nodes120 = $("<span>");
            iternode18.append(nodes120);
            (mobl.ui.generic.item)(tmp111, tmp112, function(_, callback) {
              var root225 = $("<span>");
              var nodes121 = $("<span>");
              root225.append(nodes121);
              (mobl.ui.generic.checkBox)(checked, it, function(_, callback) {
                var root226 = $("<span>");
                callback(root226); return;
              }, function(node) {
                var oldNodes = nodes121;
                nodes121 = node.contents();
                oldNodes.replaceWith(nodes121);
              });
              callback(root225); return;
              
            }, function(node) {
              var oldNodes = nodes120;
              nodes120 = node.contents();
              oldNodes.replaceWith(nodes120);
            });
            
            var oldNodes = iternode18;
            iternode18 = iternode18.contents();
            oldNodes.replaceWith(iternode18);
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList18();
    list18.addEventListener('change', function() { renderList18(true); });
    items.addEventListener('change', function() { renderList18(true); });
    
    callback(root224); return;
    
  }, function(node) {
    var oldNodes = nodes119;
    nodes119 = node.contents();
    oldNodes.replaceWith(nodes119);
  });
  callback(root223); return;
  
};

mobl.ui.generic.selectList = function(title, coll, callback, screenCallback) {
  var root227 = $("<div>");
  
  var items = mobl.ref([]);
  
  var result__ = coll.get();
  coll.get().list(function(coll27) {
    coll27 = coll27.reverse();
    function processOne3() {
      var it;
      it = coll27.pop();
      var result__ = items.get().push(new mobl.Tuple(false, it));
      
      if(coll27.length > 0) processOne3(); else rest3();
      
    }
    function rest3() {
      
      var tmp117 = mobl.ref(null);
      
      var nodes122 = $("<span>");
      root227.append(nodes122);
      (mobl.ui.generic.header)(title, tmp117, function(_, callback) {
        var root228 = $("<span>");
        
        var tmp113 = mobl.ref(function(event) {
                             if(event && event.stopPropagation) event.stopPropagation();
                             var result__ = null;
                             if(callback && callback.apply) callback(result__);
                             return;
                             
                           });
        
        
        var tmp114 = mobl.ref("Back");
        
        var nodes123 = $("<span>");
        root228.append(nodes123);
        (mobl.ui.generic.backButton)(tmp114, tmp113, function(_, callback) {
          var root229 = $("<span>");
          callback(root229); return;
        }, function(node) {
          var oldNodes = nodes123;
          nodes123 = node.contents();
          oldNodes.replaceWith(nodes123);
        });
        
        var tmp116 = mobl.ref(function(event) {
                             if(event && event.stopPropagation) event.stopPropagation();
                             var result__ = [];
                             var selected = result__;
                             var result__ = items.get();
                             items.get().list(function(coll26) {
                               coll26 = coll26.reverse();
                               function processOne2() {
                                 var checked;var it;
                                 var tmp126 = coll26.pop();
                                 checked = tmp126._1;it = tmp126._2;
                                 var result__ = checked;
                                 if(result__) {
                                   var result__ = selected.push(it);
                                   
                                   if(coll26.length > 0) processOne2(); else rest2();
                                   
                                 } else {
                                   {
                                     
                                     if(coll26.length > 0) processOne2(); else rest2();
                                     
                                   }
                                 }
                               }
                               function rest2() {
                                 var result__ = selected;
                                 if(screenCallback) screenCallback(result__);
                                 return;
                                 
                               }
                               if(coll26.length > 0) processOne2(); else rest2();
                             });
                             
                           });
        
        
        var tmp115 = mobl.ref("Done");
        
        var nodes124 = $("<span>");
        root228.append(nodes124);
        (mobl.ui.generic.button)(tmp115, tmp116, function(_, callback) {
          var root230 = $("<span>");
          callback(root230); return;
        }, function(node) {
          var oldNodes = nodes124;
          nodes124 = node.contents();
          oldNodes.replaceWith(nodes124);
        });
        callback(root228); return;
        
        
      }, function(node) {
        var oldNodes = nodes122;
        nodes122 = node.contents();
        oldNodes.replaceWith(nodes122);
      });
      var nodes125 = $("<span>");
      root227.append(nodes125);
      (mobl.ui.generic.markableList)(items, function(_, callback) {
        var root231 = $("<span>");
        callback(root231); return;
      }, function(node) {
        var oldNodes = nodes125;
        nodes125 = node.contents();
        oldNodes.replaceWith(nodes125);
      });
      callback(root227); return;
      
      
    }
    if(coll27.length > 0) processOne3(); else rest3();
  });
  
};

mobl.ui.generic.searchList = function(Ent, masterItem, detailItem, resultLimit, elements, callback) {
  var root232 = $("<span>");
  
  var phrase = mobl.ref("");
  
  
  var tmp118 = mobl.ref("Search term");
  
  
  var tmp119 = mobl.ref(null);
  
  var nodes126 = $("<span>");
  root232.append(nodes126);
  (mobl.ui.generic.searchBox)(phrase, tmp118, tmp119, function(_, callback) {
    var root233 = $("<span>");
    callback(root233); return;
  }, function(node) {
    var oldNodes = nodes126;
    nodes126 = node.contents();
    oldNodes.replaceWith(nodes126);
  });
  
  var tmp120 = mobl.ref(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get()));
  mobl.ref(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get())).addEventListener('change', function() {
    tmp120.set(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get()));
  });
  mobl.ref(Ent.get().searchPrefix(phrase.get())).addEventListener('change', function() {
    tmp120.set(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get()));
  });
  Ent.addEventListener('change', function() {
    tmp120.set(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get()));
  });
  phrase.addEventListener('change', function() {
    tmp120.set(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get()));
  });
  resultLimit.addEventListener('change', function() {
    tmp120.set(Ent.get().searchPrefix(phrase.get()).limit(resultLimit.get()));
  });
  
  var nodes127 = $("<span>");
  root232.append(nodes127);
  (mobl.ui.generic.masterDetail)(tmp120, masterItem, detailItem, function(_, callback) {
    var root234 = $("<span>");
    callback(root234); return;
  }, function(node) {
    var oldNodes = nodes127;
    nodes127 = node.contents();
    oldNodes.replaceWith(nodes127);
  });
  callback(root232); return;
  
  
};
mobl.ui.generic.startLoading = function() {
   var __this = this;
  var loading = mobl.$("<div id='progress'>Loading...</div>");
  
  mobl.$("body").prepend(loading);
};

mobl.ui.generic.endLoading = function() {
   var __this = this;
  mobl.$("#progress").remove();
};

mobl.ui.generic.floatBox = function(top, right, bottom, left, elements, callback) {
                             var root928 = $("<span>");
                             var node280 = $("<div style=\"position: absolute;\">");
                             var nodes681 = $("<span>");
                             node280.append(nodes681);
                             mobl.ref(elements).addEventListener('change', function() {
                                                                             renderControl102();
                                                                           });
                             function renderControl102 ( ) {
                               (elements)(function(elements, callback) {
                                            var root929 = $("<span>");
                                            callback(root929);
                                            return;
                                          }, function(node) {
                                               var oldNodes = nodes681;
                                               nodes681 = node.contents();
                                               oldNodes.replaceWith(nodes681);
                                             });
                             }
                             renderControl102();
                             root928.append(node280);
                             var box = node280;
                             if(top.get() !== null)
                             box.css("top", "" + top.get() + "px");
                             if(right.get() !== null)
                             box.css("right", "" + right.get() + "px");
                             if(bottom.get() !== null)
                             box.css("top", "" + ( window.pageYOffset + window.innerHeight - box.outerHeight() - bottom.get() ) + "px");
                             if(left.get() !== null)
                             box.css("left", "" + left.get() + "px");
                             function updateLocation ( ) {
                               if(top.get() !== null)
                               {
                                 box.css("top", "" + ( window.pageYOffset + top.get() ) + "px");
                               }
                               if(bottom.get() !== null)
                               {
                                 box.css("top", "" + ( window.pageYOffset + window.innerHeight - box.outerHeight() - bottom.get() ) + "px");
                               }
                             }
                             $(window).bind('scroll', updateLocation);
                             $(window).bind('resize', updateLocation);
                             callback(root928);
                             return;
                           };mobl.ui.generic.setupFloatBox = function(id, top, right, bottom, left) {
                                  setTimeout(function() {
                                               var box = $("div#floatBox" + id);
                                               if(top !== null)
                                               box.css("top", "" + top + "px");
                                               if(right !== null)
                                               box.css("right", "" + right + "px");
                                               if(bottom !== null)
                                               box.css("top", "" + ( window.pageYOffset + window.innerHeight - box.outerHeight() - bottom ) + "px");
                                               if(left !== null)
                                               box.css("left", "" + left + "px");
                                               function updateLocation ( ) {
                                                 if(top !== null)
                                                 {
                                                   box.css("top", "" + ( window.pageYOffset + top ) + "px");
                                                 }
                                                 if(bottom !== null)
                                                 {
                                                   box.css("top", "" + ( window.pageYOffset + window.innerHeight - box.outerHeight() - bottom ) + "px");
                                                 }
                                               }
                                               $(window).bind('scroll', updateLocation);
                                               $(window).bind('resize', updateLocation);
                                             }, 200);
                                };
mobl.ui.generic.accordion = function(sections, elements, callback) {
  var root235 = $("<span>");
  
  var activeSection = mobl.ref(sections.get().get(0)._1);
  
  var node173 = $("<div class=\"accordion\">");
  
  
  var node174 = mobl.loadingSpan();
  node173.append(node174);
  var list19;
  var renderList19 = function() {
    list19 = sections.get();
    list19.list(function(results19) {
      node174.empty();
      for(var i19 = 0; i19 < results19.length; i19++) {
        (function() {
          var iternode19 = $("<span>");
          node174.append(iternode19);
          var sectionName;var sectionControl;
          sectionName = mobl.ref(mobl.ref(mobl.ref(results19), i19), "_1");sectionControl = mobl.ref(mobl.ref(mobl.ref(results19), i19), "_2");
          
          var node175 = $("<span >");
          
          var val81 = function(event) {
                        if(event && event.stopPropagation) event.stopPropagation();
                        var result__ = sectionName.get();
                        activeSection.set(result__);
                        
                      };
          if(val81 !== null) {
            node175.tap(val81);
          }
          
          var ref102 = mobl.ref(activeSection.get() == sectionName.get() ? "section activeSection" : "section inActiveSection");
          if(ref102.get() !== null) {
            node175.attr('class', ref102.get());
            ref102.addEventListener('change', function(_, ref, val) {
              if(ref === ref102) {
                node175.attr('class', val);
              } else {
                console.log("Garbage!");
              }
            });
            activeSection.addEventListener('change', function() {
              node175.attr('class', activeSection.get() == sectionName.get() ? "section activeSection" : "section inActiveSection");
            });
            sectionName.addEventListener('change', function() {
              node175.attr('class', activeSection.get() == sectionName.get() ? "section activeSection" : "section inActiveSection");
            });
            
          }
          ref102.rebind();
          
          
          var tmp121 = mobl.ref(null);
          
          var nodes129 = $("<span>");
          node175.append(nodes129);
          (mobl.label)(sectionName, tmp121, function(_, callback) {
            var root237 = $("<span>");
            callback(root237); return;
          }, function(node) {
            var oldNodes = nodes129;
            nodes129 = node.contents();
            oldNodes.replaceWith(nodes129);
          });
          iternode19.append(node175);
          
          var node176 = $("<div >");
          
          var ref101 = mobl.ref(activeSection.get() == sectionName.get() ? "activeSection" : "inActiveSection");
          if(ref101.get() !== null) {
            node176.attr('class', ref101.get());
            ref101.addEventListener('change', function(_, ref, val) {
              if(ref === ref101) {
                node176.attr('class', val);
              } else {
                console.log("Garbage!");
              }
            });
            activeSection.addEventListener('change', function() {
              node176.attr('class', activeSection.get() == sectionName.get() ? "activeSection" : "inActiveSection");
            });
            sectionName.addEventListener('change', function() {
              node176.attr('class', activeSection.get() == sectionName.get() ? "activeSection" : "inActiveSection");
            });
            
          }
          ref101.rebind();
          
          var nodes128 = $("<span>");
          node176.append(nodes128);
          sectionControl.addEventListener('change', function() {
            renderControl65();
          });
          
          function renderControl65() {
            (sectionControl.get())(function(elements, callback) {
              var root236 = $("<span>");
              callback(root236); return;
            }, function(node) {
              var oldNodes = nodes128;
              nodes128 = node.contents();
              oldNodes.replaceWith(nodes128);
            });
          }
          renderControl65();
          iternode19.append(node176);
          
          var oldNodes = iternode19;
          iternode19 = iternode19.contents();
          oldNodes.replaceWith(iternode19);
          
          
          
          
          
        }());
      }
      mobl.delayedUpdateScrollers();
    });
  };
  renderList19();
  list19.addEventListener('change', function() { renderList19(true); });
  sections.addEventListener('change', function() { renderList19(true); });
  
  root235.append(node173);
  callback(root235); return;
  
  
};

mobl.ui.generic.table = function(elements, callback) {
  var root238 = $("<span>");
  
  var node177 = $("<table >");
  
  var nodes130 = $("<span>");
  node177.append(nodes130);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl66();
  });
  
  function renderControl66() {
    (elements)(function(elements, callback) {
      var root239 = $("<span>");
      callback(root239); return;
    }, function(node) {
      var oldNodes = nodes130;
      nodes130 = node.contents();
      oldNodes.replaceWith(nodes130);
    });
  }
  renderControl66();
  root238.append(node177);
  callback(root238); return;
  
  
};

mobl.ui.generic.row = function(elements, callback) {
  var root240 = $("<span>");
  
  var node178 = $("<tr >");
  
  var nodes131 = $("<span>");
  node178.append(nodes131);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl67();
  });
  
  function renderControl67() {
    (elements)(function(elements, callback) {
      var root241 = $("<span>");
      callback(root241); return;
    }, function(node) {
      var oldNodes = nodes131;
      nodes131 = node.contents();
      oldNodes.replaceWith(nodes131);
    });
  }
  renderControl67();
  root240.append(node178);
  callback(root240); return;
  
  
};

mobl.ui.generic.cell = function(width, elements, callback) {
  var root242 = $("<span>");
  
  var node179 = $("<td >");
  
  var ref103 = width;
  if(ref103.get() !== null) {
    node179.attr('width', ref103.get());
    ref103.addEventListener('change', function(_, ref, val) {
      if(ref === ref103) {
        node179.attr('width', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref103.rebind();
  
  var nodes132 = $("<span>");
  node179.append(nodes132);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl68();
  });
  
  function renderControl68() {
    (elements)(function(elements, callback) {
      var root243 = $("<span>");
      callback(root243); return;
    }, function(node) {
      var oldNodes = nodes132;
      nodes132 = node.contents();
      oldNodes.replaceWith(nodes132);
    });
  }
  renderControl68();
  root242.append(node179);
  callback(root242); return;
  
  
};

mobl.ui.generic.col = function(width, elements, callback) {
  var root244 = $("<span>");
  
  var node180 = $("<td >");
  
  var ref104 = width;
  if(ref104.get() !== null) {
    node180.attr('width', ref104.get());
    ref104.addEventListener('change', function(_, ref, val) {
      if(ref === ref104) {
        node180.attr('width', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref104.rebind();
  
  var nodes133 = $("<span>");
  node180.append(nodes133);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl69();
  });
  
  function renderControl69() {
    (elements)(function(elements, callback) {
      var root245 = $("<span>");
      callback(root245); return;
    }, function(node) {
      var oldNodes = nodes133;
      nodes133 = node.contents();
      oldNodes.replaceWith(nodes133);
    });
  }
  renderControl69();
  root244.append(node180);
  callback(root244); return;
  
  
};

mobl.ui.generic.headerCol = function(width, elements, callback) {
  var root246 = $("<span>");
  
  var node181 = $("<td >");
  
  var ref105 = width;
  if(ref105.get() !== null) {
    node181.attr('width', ref105.get());
    ref105.addEventListener('change', function(_, ref, val) {
      if(ref === ref105) {
        node181.attr('width', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref105.rebind();
  
  
  var node182 = $("<strong >");
  
  var nodes134 = $("<span>");
  node182.append(nodes134);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl70();
  });
  
  function renderControl70() {
    (elements)(function(elements, callback) {
      var root247 = $("<span>");
      callback(root247); return;
    }, function(node) {
      var oldNodes = nodes134;
      nodes134 = node.contents();
      oldNodes.replaceWith(nodes134);
    });
  }
  renderControl70();
  node181.append(node182);
  root246.append(node181);
  callback(root246); return;
  
  
  
};

mobl.ui.generic.scroller = function(height, elements, callback) {
  var root248 = $("<span>");
  
  var node183 = $("<div class=\"scroller\">");
  
  var nodes135 = $("<span>");
  node183.append(nodes135);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl71();
  });
  
  function renderControl71() {
    (elements)(function(elements, callback) {
      var root249 = $("<span>");
      callback(root249); return;
    }, function(node) {
      var oldNodes = nodes135;
      nodes135 = node.contents();
      oldNodes.replaceWith(nodes135);
    });
  }
  renderControl71();
  root248.append(node183);
  var result__ = mobl.ui.generic.setupScrollers();
  callback(root248); return;
  
  
};
setTimeout(function() {
             scrollTo(0, -1);
           }, 250);
jQuery.fn.tap = function(callback) {
                  if(mobl.isIphone() || mobl.isAndroid() || mobl.isIpad())
                  {
                    new NoClickDelay(this[0],callback);
                  }
                  else
                  {
                    this.click(callback);
                  }
                };
mobl.ui.generic.scrollUp = function() {
                             scrollTo(0, 0);
                           };
mobl.ui.generic.setupScrollers = function() {
                                   setTimeout(function() {
                                                var allScrollers = $("div.scroller");
                                                for(var i = 0; i < allScrollers.length; i++)
                                                {
                                                  var scroller = allScrollers.eq(i);
                                                  if(!scroller.data("scroller"))
                                                  {
                                                    scroller.data("scroller", new TouchScroll(scroller[0],{
                                                                                                            elastic: true
                                                                                                          }));
                                                  }
                                                }
                                              }, 250);
                                 };
setInterval(function() {
              var allScrollers = $("div.scroller");
              for(var i = 0; i < allScrollers.length; i++)
              {
                var scroller = allScrollers.eq(i).data("scroller");
                if(scroller)
                {
                  scroller.setupScroller();
                }
              }
            }, 1000);