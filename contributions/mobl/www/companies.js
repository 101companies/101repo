mobl.provides('companies');
persistence.debug = false;mobl.load('mobl.js');
mobl.load('init.js');
mobl.load('data.js');
mobl.load('scenarios.js');
mobl.load('mobl/ui/generic.js');

companies.root = function(callback, screenCallback) {
  var root49 = $("<div>");
  
  var tmp81 = mobl.ref("101 companies");
  
  
  var tmp82 = mobl.ref(null);
  
  var nodes45 = $("<span>");
  root49.append(nodes45);
  (mobl.ui.generic.header)(tmp81, tmp82, function(_, callback) {
    var root50 = $("<span>");
    
    var tmp79 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         mobl.resetDatabase(function(result__) {
                           var tmp145 = result__;
                           var result__ = init.initialData();
                           var result__ = mobl.reload();
                           
                         });
                       });
    
    
    var tmp78 = mobl.ref("Initialize Application");
    
    var nodes46 = $("<span>");
    root50.append(nodes46);
    (mobl.ui.generic.button)(tmp78, tmp79, function(_, callback) {
      var root51 = $("<span>");
      callback(root51); return;
    }, function(node) {
      var oldNodes = nodes46;
      nodes46 = node.contents();
      oldNodes.replaceWith(nodes46);
    });
    callback(root50); return;
    
  }, function(node) {
    var oldNodes = nodes45;
    nodes45 = node.contents();
    oldNodes.replaceWith(nodes45);
  });
  var nodes47 = $("<span>");
  root49.append(nodes47);
  (mobl.ui.generic.group)(function(_, callback) {
    var root52 = $("<span>");
    
    var tmp87 = mobl.ref(data.Company.all().order("name", true));
    mobl.ref(data.Company).addEventListener('change', function() {
      tmp87.set(data.Company.all().order("name", true));
    });
    
    
    var node4 = mobl.loadingSpan();
    root52.append(node4);
    var list4;
    var renderList4 = function() {
      list4 = tmp87.get();
      list4.list(function(results4) {
        node4.empty();
        for(var i4 = 0; i4 < results4.length; i4++) {
          (function() {
            var iternode4 = $("<span>");
            node4.append(iternode4);
            var company;
            company = results4[i4];
            
            var tmp83 = mobl.ref("<h3>Start here:</h3>");
            
            var nodes48 = $("<span>");
            iternode4.append(nodes48);
            (mobl.html)(tmp83, function(_, callback) {
              var root53 = $("<span>");
              callback(root53); return;
            }, function(node) {
              var oldNodes = nodes48;
              nodes48 = node.contents();
              oldNodes.replaceWith(nodes48);
            });
            
            var tmp85 = mobl.ref(function(event) {
                                 if(event && event.stopPropagation) event.stopPropagation();
                                 mobl.call('companies.viewCompany', [mobl.ref(company)], function(result__) {
                                 var tmp146 = result__;
                                 
                                 });
                               });
            
            
            var tmp86 = mobl.ref(null);
            
            var nodes49 = $("<span>");
            iternode4.append(nodes49);
            (mobl.ui.generic.item)(tmp85, tmp86, function(_, callback) {
              var root54 = $("<span>");
              
              var tmp84 = mobl.ref(null);
              
              var nodes50 = $("<span>");
              root54.append(nodes50);
              (mobl.label)(mobl.ref(mobl.ref(company), 'name'), tmp84, function(_, callback) {
                var root55 = $("<span>");
                callback(root55); return;
              }, function(node) {
                var oldNodes = nodes50;
                nodes50 = node.contents();
                oldNodes.replaceWith(nodes50);
              });
              callback(root54); return;
              
            }, function(node) {
              var oldNodes = nodes49;
              nodes49 = node.contents();
              oldNodes.replaceWith(nodes49);
            });
            
            var oldNodes = iternode4;
            iternode4 = iternode4.contents();
            oldNodes.replaceWith(iternode4);
            
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList4();
    list4.addEventListener('change', function() { renderList4(true); });
    tmp87.addEventListener('change', function() { renderList4(true); });
    
    callback(root52); return;
    
  }, function(node) {
    var oldNodes = nodes47;
    nodes47 = node.contents();
    oldNodes.replaceWith(nodes47);
  });
  callback(root49); return;
  
  
};

companies.viewCompany = function(c, callback, screenCallback) {
  var root56 = $("<div>");
  
  var tmp91 = mobl.ref(null);
  
  var nodes51 = $("<span>");
  root56.append(nodes51);
  (mobl.ui.generic.header)(mobl.ref(c, 'name'), tmp91, function(_, callback) {
    var root57 = $("<span>");
    
    var tmp89 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         {
                           scenarios.cut(function(result__) {
                             var tmp147 = result__;
                             mobl.call('companies.viewCompany', [c], function(result__) {
                             var tmp148 = result__;
                             
                             });
                           });
                         }
                       });
    
    
    var tmp88 = mobl.ref("Cut");
    
    var nodes52 = $("<span>");
    root57.append(nodes52);
    (mobl.ui.generic.button)(tmp88, tmp89, function(_, callback) {
      var root58 = $("<span>");
      callback(root58); return;
    }, function(node) {
      var oldNodes = nodes52;
      nodes52 = node.contents();
      oldNodes.replaceWith(nodes52);
    });
    callback(root57); return;
    
  }, function(node) {
    var oldNodes = nodes51;
    nodes51 = node.contents();
    oldNodes.replaceWith(nodes51);
  });
  var nodes53 = $("<span>");
  root56.append(nodes53);
  (mobl.ui.generic.group)(function(_, callback) {
    var root59 = $("<span>");
    
    var tmp94 = mobl.ref(null);
    
    
    var tmp93 = mobl.ref(null);
    
    var nodes54 = $("<span>");
    root59.append(nodes54);
    (mobl.ui.generic.item)(tmp93, tmp94, function(_, callback) {
      var root60 = $("<span>");
      var result__ = "<b>Total = ";
      var result17 = result__;
      scenarios.total(function(result__) {
        op('+', result17, result__, function(result__) {
          var result16 = result__;
          var result__ = "</b>";
          op('+', result16, result__, function(result__) {
            var result15 = result__;
            var result__ = " / ";
            op('+', result15, result__, function(result__) {
              var result14 = result__;
              var result__ = "<b>Depth = ";
              op('+', result14, result__, function(result__) {
                var result13 = result__;
                scenarios.depth(c.get(), function(result__) {
                  op('+', result13, result__, function(result__) {
                    var result12 = result__;
                    var result__ = "</b>";
                    op('+', result12, result__, function(result__) {
                      var tmp92 = mobl.ref(result__);
                      c.addEventListener('change', function() {
                        tmp92.set("<b>Total = " + scenarios.total() + "</b>" + " / " + "<b>Depth = " + scenarios.depth(c.get()) + "</b>");
                      });
                      
                      var nodes55 = $("<span>");
                      root60.append(nodes55);
                      (mobl.html)(tmp92, function(_, callback) {
                        var root61 = $("<span>");
                        callback(root61); return;
                      }, function(node) {
                        var oldNodes = nodes55;
                        nodes55 = node.contents();
                        oldNodes.replaceWith(nodes55);
                      });
                      callback(root60); return;
                      
                    });
                    
                  });
                  
                });
              });
              
            });
            
          });
          
        });
        
      });
    }, function(node) {
      var oldNodes = nodes54;
      nodes54 = node.contents();
      oldNodes.replaceWith(nodes54);
    });
    callback(root59); return;
    
  }, function(node) {
    var oldNodes = nodes53;
    nodes53 = node.contents();
    oldNodes.replaceWith(nodes53);
  });
  var nodes56 = $("<span>");
  root56.append(nodes56);
  (mobl.ui.generic.group)(function(_, callback) {
    var root62 = $("<span>");
    
    var tmp95 = mobl.ref("<h4>Top Departments:</h4>");
    
    var nodes57 = $("<span>");
    root62.append(nodes57);
    (mobl.html)(tmp95, function(_, callback) {
      var root63 = $("<span>");
      callback(root63); return;
    }, function(node) {
      var oldNodes = nodes57;
      nodes57 = node.contents();
      oldNodes.replaceWith(nodes57);
    });
    
    var tmp100 = mobl.ref(c.get().departments.order("name", true));
    mobl.ref(c, 'departments').addEventListener('change', function() {
      tmp100.set(c.get().departments.order("name", true));
    });
    
    
    var node5 = mobl.loadingSpan();
    root62.append(node5);
    var list5;
    var renderList5 = function() {
      list5 = tmp100.get();
      list5.list(function(results5) {
        node5.empty();
        for(var i5 = 0; i5 < results5.length; i5++) {
          (function() {
            var iternode5 = $("<span>");
            node5.append(iternode5);
            var deptartment;
            deptartment = results5[i5];
            
            var tmp98 = mobl.ref(function(event) {
                                 if(event && event.stopPropagation) event.stopPropagation();
                                 mobl.call('companies.viewDepartment', [mobl.ref(deptartment)], function(result__) {
                                 var tmp149 = result__;
                                 
                                 });
                               });
            
            
            var tmp99 = mobl.ref(null);
            
            var nodes58 = $("<span>");
            iternode5.append(nodes58);
            (mobl.ui.generic.item)(tmp98, tmp99, function(_, callback) {
              var root64 = $("<span>");
              
              var tmp96 = mobl.ref("- " + deptartment.name);
              mobl.ref(mobl.ref(deptartment), 'name').addEventListener('change', function() {
                tmp96.set("- " + deptartment.name);
              });
              
              
              var tmp97 = mobl.ref(null);
              
              var nodes59 = $("<span>");
              root64.append(nodes59);
              (mobl.label)(tmp96, tmp97, function(_, callback) {
                var root65 = $("<span>");
                callback(root65); return;
              }, function(node) {
                var oldNodes = nodes59;
                nodes59 = node.contents();
                oldNodes.replaceWith(nodes59);
              });
              callback(root64); return;
              
            }, function(node) {
              var oldNodes = nodes58;
              nodes58 = node.contents();
              oldNodes.replaceWith(nodes58);
            });
            
            var oldNodes = iternode5;
            iternode5 = iternode5.contents();
            oldNodes.replaceWith(iternode5);
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList5();
    list5.addEventListener('change', function() { renderList5(true); });
    tmp100.addEventListener('change', function() { renderList5(true); });
    
    callback(root62); return;
    
    
  }, function(node) {
    var oldNodes = nodes56;
    nodes56 = node.contents();
    oldNodes.replaceWith(nodes56);
  });
  callback(root56); return;
  
  
  
};

companies.viewDepartment = function(d, callback, screenCallback) {
  var root66 = $("<div>");
  
  var tmp105 = mobl.ref(null);
  
  var nodes60 = $("<span>");
  root66.append(nodes60);
  (mobl.ui.generic.header)(mobl.ref(d, 'name'), tmp105, function(_, callback) {
    var root67 = $("<span>");
    
    var tmp102 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         if(screenCallback) screenCallback();
                         return;
                         
                       });
    
    
    var tmp101 = mobl.ref("Back");
    
    var nodes61 = $("<span>");
    root67.append(nodes61);
    (mobl.ui.generic.backButton)(tmp101, tmp102, function(_, callback) {
      var root68 = $("<span>");
      callback(root68); return;
    }, function(node) {
      var oldNodes = nodes61;
      nodes61 = node.contents();
      oldNodes.replaceWith(nodes61);
    });
    
    var tmp104 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         {
                           scenarios.cutDept(d.get(), function(result__) {
                             var tmp151 = result__;
                             mobl.call('companies.viewDepartment', [d], function(result__) {
                             var tmp152 = result__;
                             
                             });
                           });
                         }
                       });
    
    
    var tmp103 = mobl.ref("Cut");
    
    var nodes62 = $("<span>");
    root67.append(nodes62);
    (mobl.ui.generic.button)(tmp103, tmp104, function(_, callback) {
      var root69 = $("<span>");
      callback(root69); return;
    }, function(node) {
      var oldNodes = nodes62;
      nodes62 = node.contents();
      oldNodes.replaceWith(nodes62);
    });
    callback(root67); return;
    
    
  }, function(node) {
    var oldNodes = nodes60;
    nodes60 = node.contents();
    oldNodes.replaceWith(nodes60);
  });
  var nodes63 = $("<span>");
  root66.append(nodes63);
  (mobl.ui.generic.group)(function(_, callback) {
    var root70 = $("<span>");
    
    var tmp108 = mobl.ref(null);
    
    
    var tmp107 = mobl.ref(null);
    
    var nodes64 = $("<span>");
    root70.append(nodes64);
    (mobl.ui.generic.item)(tmp107, tmp108, function(_, callback) {
      var root71 = $("<span>");
      var result__ = "<b>Total = ";
      var result23 = result__;
      scenarios.totalDept(d.get(), function(result__) {
        op('+', result23, result__, function(result__) {
          var result22 = result__;
          var result__ = "</b>";
          op('+', result22, result__, function(result__) {
            var result21 = result__;
            var result__ = " / ";
            op('+', result21, result__, function(result__) {
              var result20 = result__;
              var result__ = "<b>Depth = ";
              op('+', result20, result__, function(result__) {
                var result19 = result__;
                scenarios.depthDept(d.get(), function(result__) {
                  op('+', result19, result__, function(result__) {
                    var result18 = result__;
                    var result__ = "</b>";
                    op('+', result18, result__, function(result__) {
                      var tmp106 = mobl.ref(result__);
                      d.addEventListener('change', function() {
                        tmp106.set("<b>Total = " + scenarios.totalDept(d.get()) + "</b>" + " / " + "<b>Depth = " + scenarios.depthDept(d.get()) + "</b>");
                      });
                      
                      var nodes65 = $("<span>");
                      root71.append(nodes65);
                      (mobl.html)(tmp106, function(_, callback) {
                        var root72 = $("<span>");
                        callback(root72); return;
                      }, function(node) {
                        var oldNodes = nodes65;
                        nodes65 = node.contents();
                        oldNodes.replaceWith(nodes65);
                      });
                      callback(root71); return;
                      
                    });
                    
                  });
                  
                });
              });
              
            });
            
          });
          
        });
        
      });
    }, function(node) {
      var oldNodes = nodes64;
      nodes64 = node.contents();
      oldNodes.replaceWith(nodes64);
    });
    callback(root70); return;
    
  }, function(node) {
    var oldNodes = nodes63;
    nodes63 = node.contents();
    oldNodes.replaceWith(nodes63);
  });
  var nodes66 = $("<span>");
  root66.append(nodes66);
  (mobl.ui.generic.group)(function(_, callback) {
    var root73 = $("<span>");
    
    var tmp109 = mobl.ref("<h4>Manager:</h4>");
    
    var nodes67 = $("<span>");
    root73.append(nodes67);
    (mobl.html)(tmp109, function(_, callback) {
      var root74 = $("<span>");
      callback(root74); return;
    }, function(node) {
      var oldNodes = nodes67;
      nodes67 = node.contents();
      oldNodes.replaceWith(nodes67);
    });
    
    var tmp113 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         mobl.call('companies.viewEmployee', [mobl.ref(d, 'manager')], function(result__) {
                         var tmp153 = result__;
                         
                         });
                       });
    
    
    var tmp114 = mobl.ref(null);
    
    var nodes68 = $("<span>");
    root73.append(nodes68);
    (mobl.ui.generic.item)(tmp113, tmp114, function(_, callback) {
      var root75 = $("<span>");
      
      var tmp111 = mobl.ref("- " + d.get().manager.name);
      mobl.ref(mobl.ref(d, 'manager'), 'name').addEventListener('change', function() {
        tmp111.set("- " + d.get().manager.name);
      });
      
      
      var tmp112 = mobl.ref(null);
      
      var nodes69 = $("<span>");
      root75.append(nodes69);
      (mobl.label)(tmp111, tmp112, function(_, callback) {
        var root76 = $("<span>");
        callback(root76); return;
      }, function(node) {
        var oldNodes = nodes69;
        nodes69 = node.contents();
        oldNodes.replaceWith(nodes69);
      });
      callback(root75); return;
      
    }, function(node) {
      var oldNodes = nodes68;
      nodes68 = node.contents();
      oldNodes.replaceWith(nodes68);
    });
    callback(root73); return;
    
    
  }, function(node) {
    var oldNodes = nodes66;
    nodes66 = node.contents();
    oldNodes.replaceWith(nodes66);
  });
  var nodes70 = $("<span>");
  root66.append(nodes70);
  (mobl.ui.generic.group)(function(_, callback) {
    var root77 = $("<span>");
    
    var tmp115 = mobl.ref("<h4>Sub Deparments:</h4> ");
    
    var nodes71 = $("<span>");
    root77.append(nodes71);
    (mobl.html)(tmp115, function(_, callback) {
      var root78 = $("<span>");
      callback(root78); return;
    }, function(node) {
      var oldNodes = nodes71;
      nodes71 = node.contents();
      oldNodes.replaceWith(nodes71);
    });
    
    var tmp121 = mobl.ref(d.get().departments.order("name", true));
    mobl.ref(d, 'departments').addEventListener('change', function() {
      tmp121.set(d.get().departments.order("name", true));
    });
    
    
    var node6 = mobl.loadingSpan();
    root77.append(node6);
    var list6;
    var renderList6 = function() {
      list6 = tmp121.get();
      list6.list(function(results6) {
        node6.empty();
        for(var i6 = 0; i6 < results6.length; i6++) {
          (function() {
            var iternode6 = $("<span>");
            node6.append(iternode6);
            var subDept;
            subDept = results6[i6];
            
            var tmp118 = mobl.ref(function(event) {
                                 if(event && event.stopPropagation) event.stopPropagation();
                                 mobl.call('companies.viewDepartment', [mobl.ref(subDept)], function(result__) {
                                 var tmp154 = result__;
                                 
                                 });
                               });
            
            
            var tmp119 = mobl.ref(null);
            
            var nodes72 = $("<span>");
            iternode6.append(nodes72);
            (mobl.ui.generic.item)(tmp118, tmp119, function(_, callback) {
              var root79 = $("<span>");
              
              var tmp116 = mobl.ref("- " + subDept.name);
              mobl.ref(mobl.ref(subDept), 'name').addEventListener('change', function() {
                tmp116.set("- " + subDept.name);
              });
              
              
              var tmp117 = mobl.ref(null);
              
              var nodes73 = $("<span>");
              root79.append(nodes73);
              (mobl.label)(tmp116, tmp117, function(_, callback) {
                var root80 = $("<span>");
                callback(root80); return;
              }, function(node) {
                var oldNodes = nodes73;
                nodes73 = node.contents();
                oldNodes.replaceWith(nodes73);
              });
              callback(root79); return;
              
            }, function(node) {
              var oldNodes = nodes72;
              nodes72 = node.contents();
              oldNodes.replaceWith(nodes72);
            });
            
            var oldNodes = iternode6;
            iternode6 = iternode6.contents();
            oldNodes.replaceWith(iternode6);
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList6();
    list6.addEventListener('change', function() { renderList6(true); });
    tmp121.addEventListener('change', function() { renderList6(true); });
    
    callback(root77); return;
    
    
  }, function(node) {
    var oldNodes = nodes70;
    nodes70 = node.contents();
    oldNodes.replaceWith(nodes70);
  });
  var nodes74 = $("<span>");
  root66.append(nodes74);
  (mobl.ui.generic.group)(function(_, callback) {
    var root81 = $("<span>");
    
    var tmp122 = mobl.ref("<h4>Employees:</h4>");
    
    var nodes75 = $("<span>");
    root81.append(nodes75);
    (mobl.html)(tmp122, function(_, callback) {
      var root82 = $("<span>");
      callback(root82); return;
    }, function(node) {
      var oldNodes = nodes75;
      nodes75 = node.contents();
      oldNodes.replaceWith(nodes75);
    });
    
    var tmp127 = mobl.ref(d.get().employees.order("name", true));
    mobl.ref(d, 'employees').addEventListener('change', function() {
      tmp127.set(d.get().employees.order("name", true));
    });
    
    
    var node7 = mobl.loadingSpan();
    root81.append(node7);
    var list7;
    var renderList7 = function() {
      list7 = tmp127.get();
      list7.list(function(results7) {
        node7.empty();
        for(var i7 = 0; i7 < results7.length; i7++) {
          (function() {
            var iternode7 = $("<span>");
            node7.append(iternode7);
            var employee;
            employee = results7[i7];
            
            var tmp125 = mobl.ref(function(event) {
                                 if(event && event.stopPropagation) event.stopPropagation();
                                 mobl.call('companies.viewEmployee', [mobl.ref(employee)], function(result__) {
                                 var tmp155 = result__;
                                 
                                 });
                               });
            
            
            var tmp126 = mobl.ref(null);
            
            var nodes76 = $("<span>");
            iternode7.append(nodes76);
            (mobl.ui.generic.item)(tmp125, tmp126, function(_, callback) {
              var root83 = $("<span>");
              
              var tmp123 = mobl.ref("- " + employee.name);
              mobl.ref(mobl.ref(employee), 'name').addEventListener('change', function() {
                tmp123.set("- " + employee.name);
              });
              
              
              var tmp124 = mobl.ref(null);
              
              var nodes77 = $("<span>");
              root83.append(nodes77);
              (mobl.label)(tmp123, tmp124, function(_, callback) {
                var root84 = $("<span>");
                callback(root84); return;
              }, function(node) {
                var oldNodes = nodes77;
                nodes77 = node.contents();
                oldNodes.replaceWith(nodes77);
              });
              callback(root83); return;
              
            }, function(node) {
              var oldNodes = nodes76;
              nodes76 = node.contents();
              oldNodes.replaceWith(nodes76);
            });
            
            var oldNodes = iternode7;
            iternode7 = iternode7.contents();
            oldNodes.replaceWith(iternode7);
            
            
          }());
        }
        mobl.delayedUpdateScrollers();
      });
    };
    renderList7();
    list7.addEventListener('change', function() { renderList7(true); });
    tmp127.addEventListener('change', function() { renderList7(true); });
    
    callback(root81); return;
    
    
  }, function(node) {
    var oldNodes = nodes74;
    nodes74 = node.contents();
    oldNodes.replaceWith(nodes74);
  });
  callback(root66); return;
  
  
  
  
  
};

companies.viewEmployee = function(e, callback, screenCallback) {
  var root85 = $("<div>");
  
  var tmp131 = mobl.ref(null);
  
  var nodes78 = $("<span>");
  root85.append(nodes78);
  (mobl.ui.generic.header)(mobl.ref(e, 'name'), tmp131, function(_, callback) {
    var root86 = $("<span>");
    
    var tmp129 = mobl.ref(function(event) {
                         if(event && event.stopPropagation) event.stopPropagation();
                         if(screenCallback) screenCallback();
                         return;
                         
                       });
    
    
    var tmp128 = mobl.ref("Back");
    
    var nodes79 = $("<span>");
    root86.append(nodes79);
    (mobl.ui.generic.backButton)(tmp128, tmp129, function(_, callback) {
      var root87 = $("<span>");
      callback(root87); return;
    }, function(node) {
      var oldNodes = nodes79;
      nodes79 = node.contents();
      oldNodes.replaceWith(nodes79);
    });
    callback(root86); return;
    
  }, function(node) {
    var oldNodes = nodes78;
    nodes78 = node.contents();
    oldNodes.replaceWith(nodes78);
  });
  var nodes80 = $("<span>");
  root85.append(nodes80);
  (mobl.ui.generic.group)(function(_, callback) {
    var root88 = $("<span>");
    
    var tmp132 = mobl.ref("<h4>Name:</h4>");
    
    var nodes81 = $("<span>");
    root88.append(nodes81);
    (mobl.html)(tmp132, function(_, callback) {
      var root89 = $("<span>");
      callback(root89); return;
    }, function(node) {
      var oldNodes = nodes81;
      nodes81 = node.contents();
      oldNodes.replaceWith(nodes81);
    });
    
    var tmp135 = mobl.ref(null);
    
    
    var tmp134 = mobl.ref(null);
    
    var nodes82 = $("<span>");
    root88.append(nodes82);
    (mobl.ui.generic.item)(tmp134, tmp135, function(_, callback) {
      var root90 = $("<span>");
      
      var tmp133 = mobl.ref(null);
      
      var nodes83 = $("<span>");
      root90.append(nodes83);
      (mobl.label)(mobl.ref(e, 'name'), tmp133, function(_, callback) {
        var root91 = $("<span>");
        callback(root91); return;
      }, function(node) {
        var oldNodes = nodes83;
        nodes83 = node.contents();
        oldNodes.replaceWith(nodes83);
      });
      callback(root90); return;
      
    }, function(node) {
      var oldNodes = nodes82;
      nodes82 = node.contents();
      oldNodes.replaceWith(nodes82);
    });
    
    var tmp136 = mobl.ref("<h4>Address:</h4>");
    
    var nodes84 = $("<span>");
    root88.append(nodes84);
    (mobl.html)(tmp136, function(_, callback) {
      var root92 = $("<span>");
      callback(root92); return;
    }, function(node) {
      var oldNodes = nodes84;
      nodes84 = node.contents();
      oldNodes.replaceWith(nodes84);
    });
    
    var tmp139 = mobl.ref(null);
    
    
    var tmp138 = mobl.ref(null);
    
    var nodes85 = $("<span>");
    root88.append(nodes85);
    (mobl.ui.generic.item)(tmp138, tmp139, function(_, callback) {
      var root93 = $("<span>");
      
      var tmp137 = mobl.ref(null);
      
      var nodes86 = $("<span>");
      root93.append(nodes86);
      (mobl.label)(mobl.ref(e, 'address'), tmp137, function(_, callback) {
        var root94 = $("<span>");
        callback(root94); return;
      }, function(node) {
        var oldNodes = nodes86;
        nodes86 = node.contents();
        oldNodes.replaceWith(nodes86);
      });
      callback(root93); return;
      
    }, function(node) {
      var oldNodes = nodes85;
      nodes85 = node.contents();
      oldNodes.replaceWith(nodes85);
    });
    
    var tmp141 = mobl.ref("<h4>Salary:</h4>");
    
    var nodes87 = $("<span>");
    root88.append(nodes87);
    (mobl.html)(tmp141, function(_, callback) {
      var root95 = $("<span>");
      callback(root95); return;
    }, function(node) {
      var oldNodes = nodes87;
      nodes87 = node.contents();
      oldNodes.replaceWith(nodes87);
    });
    
    var tmp144 = mobl.ref(null);
    
    
    var tmp143 = mobl.ref(null);
    
    var nodes88 = $("<span>");
    root88.append(nodes88);
    (mobl.ui.generic.item)(tmp143, tmp144, function(_, callback) {
      var root96 = $("<span>");
      
      var tmp142 = mobl.ref(null);
      
      var nodes89 = $("<span>");
      root96.append(nodes89);
      (mobl.label)(mobl.ref(e, 'salary'), tmp142, function(_, callback) {
        var root97 = $("<span>");
        callback(root97); return;
      }, function(node) {
        var oldNodes = nodes89;
        nodes89 = node.contents();
        oldNodes.replaceWith(nodes89);
      });
      callback(root96); return;
      
    }, function(node) {
      var oldNodes = nodes88;
      nodes88 = node.contents();
      oldNodes.replaceWith(nodes88);
    });
    callback(root88); return;
    
    
    
    
    
    
  }, function(node) {
    var oldNodes = nodes80;
    nodes80 = node.contents();
    oldNodes.replaceWith(nodes80);
  });
  callback(root85); return;
  
  
};
