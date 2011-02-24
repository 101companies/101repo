mobl.provides('mobl');
mobl.isIphone = function() {
                  return !!navigator.userAgent.match(/iPhone/i) || !!navigator.userAgent.match(/iPod/i);
                };
mobl.isIpad = function() {
                return !!navigator.userAgent.match(/iPad/i);
              };
mobl.isAndroid = function() {
                   return !!navigator.userAgent.match(/Android/i);
                 };
mobl.isLandscape = function() {
                     return window.innerHeight < window.innerWidth;
                   };
mobl.isPortrait = function() {
                    return window.innerHeight >= window.innerWidth;
                  };
mobl.getScreenWidth = function() {
                        return window.innerWidth;
                      };
mobl.getScreenHeight = function() {
                         return window.innerHeighth;
                       };
mobl.label = function(s, onclick, elements, callback) {
  var root127 = $("<span>");
  
  var node92 = $("<span >");
  
  var ref53 = s;
  node92.text(ref53.get().toString());
  var ignore23 = false;
  ref53.addEventListener('change', function(_, ref, val) {
    if(ignore23) return;
    if(ref === ref53) {
      node92.text(val.toString());
    } else {
      console.log("Garbage!");
    }
  });
  ref53.rebind();
  
  
  var val41 = onclick.get();
  if(val41 !== null) {
    node92.tap(val41);
  }
  
  root127.append(node92);
  callback(root127); return;
  
};

mobl.link = function(url, target, elements, callback) {
  var root128 = $("<span>");
  
  var node93 = $("<a >");
  
  var ref54 = url;
  if(ref54.get() !== null) {
    node93.attr('href', ref54.get());
    ref54.addEventListener('change', function(_, ref, val) {
      if(ref === ref54) {
        node93.attr('href', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref54.rebind();
  
  var ref55 = target;
  if(ref55.get() !== null) {
    node93.attr('target', ref55.get());
    ref55.addEventListener('change', function(_, ref, val) {
      if(ref === ref55) {
        node93.attr('target', val);
      } else {
        console.log("Garbage!");
      }
    });
    
  }
  ref55.rebind();
  
  var nodes69 = $("<span>");
  node93.append(nodes69);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl36();
  });
  
  function renderControl36() {
    (elements)(function(elements, callback) {
      var root129 = $("<span>");
      callback(root129); return;
    }, function(node) {
      var oldNodes = nodes69;
      nodes69 = node.contents();
      oldNodes.replaceWith(nodes69);
    });
  }
  renderControl36();
  root128.append(node93);
  callback(root128); return;
  
  
};
var argspec = persistence.argspec;
mobl.$ = jQuery;
mobl.sleep = function(time, callback) {
               setTimeout(callback, time);
             };
mobl.repeat = function(time, callback) {
                setInterval(callback, time);
              };
mobl.alert = function(s, _, callback) {
               alert(s);
               if(callback)
               callback();
             };
mobl.log = function(s, _, callback) {
             console.log(s);
             if(callback)
             callback();
           };
mobl.add = function(e, _, callback) {
             var allEnt = persistence.define(e._type).all();
             allEnt.add(e);
             if(callback)
             callback();
           };
mobl.now = function() {
             return new Date();
           };
mobl.remove = function(e, _, callback) {
                persistence.remove(e);
                var allEnt = persistence.define(e._type).all();
                allEnt.triggerEvent('remove', allEnt, e);
                allEnt.triggerEvent('change', allEnt, e);
                if(callback)
                callback();
              };
mobl.flushDatabase = function(callback) {
                       persistence.flush(callback);
                     };
mobl.resetDatabase = function(callback) {
                       persistence.reset(function() {
                                           persistence.schemaSync(callback);
                                         });
                     };
mobl.reload = function() {
                persistence.flush(function() {
                                    window.location.reload();
                                  });
              };
mobl.openUrl = function(url) {
                 location = url;
               };
mobl.random = function(max) {
                return Math.round(Math.random() * max);
              };
persistence.QueryCollection.prototype.updates = function() {
                                                  this.triggerEvent('change', this);
                                                };
mobl.DateTime = {
                  parse: function(s) {
                           return new Date(Date.parse(s));
                         },
                  fromTimestamp: function(timestamp) {
                                   return new Date(timestamp);
                                 },
                  create: function(year, month, day, hour, minute, second, ms) {
                            return new Date(year,month,day,hour,minute,second,ms);
                          }
                };
Date.prototype.toDateString = function() {
                                return "" + ( this.getMonth() + 1 ) + "/" + this.getDate() + "/" + this.getFullYear();
                              };
mobl.Math = Math;
mobl.JSON = JSON;
mobl.formatDate = function(date) {
                    var diff = (( (new Date()).getTime() - date.getTime() ) / 1000);
                    var day_diff = Math.floor(diff / 86400);
                    if(isNaN(day_diff) || day_diff < 0 || day_diff >= 31)
                    return;
                    return day_diff === 0 && ( diff < 60 && "just now" || diff < 120 && "1 minute ago" || diff < 3600 && Math.floor(diff / 60) + " minutes ago" || diff < 7200 && "1 hour ago" || diff < 86400 && Math.floor(diff / 3600) + " hours ago" ) || day_diff === 1 && "Yesterday" || day_diff < 7 && day_diff + " days ago" || day_diff < 31 && Math.ceil(day_diff / 7) + " weeks ago";
                  };
mobl.range = function(from, to) {
               var ar = [];
               for(var i = from; i < to; i++)
               {
                 ar.push(i);
               }
               return ar;
             };
mobl.html = function(html, elements, callback) {
              var root192 = $("<span>");
              var node180 = $("<span >");
              var ref108 = html;
              node180.html(html.get().toString());
              var ignore51 = false;
              ref108.addEventListener('change', function(_, ref, val) {
                                                  if(ignore51)
                                                  return;
                                                  if(ref === ref108)
                                                  {
                                                    node180.html(val.toString());
                                                  }
                                                });
              ref108.rebind();
              root192.append(node180);
              callback(root192);
              return;
            };
persistence.entityDecoratorHooks.push(function(Entity) {
                                        Entity.searchPrefix = function(query) {
                                                                return Entity.search(query, true);
                                                              };
                                      });
Array.prototype.list = function(tx, callback) {
                         var args = argspec.getArgs(arguments, [{
                                                                  name: 'tx',
                                                                  optional: true,
                                                                  check: function(obj) {
                                                                           return tx.executeSql;
                                                                         }
                                                                },{
                                                                    name: 'callback',
                                                                    optional: false,
                                                                    check: argspec.isCallback()
                                                                  }]);
                         tx = args.tx;
                         callback = args.callback;
                         var valueCopy = [];
                         for(var i = 0; i < this.length; i++)
                         {
                           valueCopy[i] = this[i];
                         }
                         callback(valueCopy);
                       };
Array.prototype.insert = function(idx, item) {
                           this.splice(idx, 0, item);
                         };
Array.prototype.get = function(idx) {
                        return this[idx];
                      };
Array.prototype.one = function(callback) {
                        if(this.length === 0)
                        {
                          callback(null);
                        }
                        else
                        {
                          callback(this[0]);
                        }
                      };
Array.prototype.contains = function(el) {
                             for(var i = 0; i < this.length; i++)
                             {
                               if(this[i] === el)
                               {
                                 return true;
                               }
                             }
                             return false;
                           };
Array.prototype.remove = function(el) {
                           for(var i = 0; i < this.length; i++)
                           {
                             if(this[i] === el)
                             {
                               this.splice(i, 1);
                               return;
                             }
                           }
                         };
Array.prototype.addEventListener = function() {
                                   };
mobl.dummyMapper = function(data, callback) {
                     callback(data);
                   };
mobl.Map = function() {
             this.data = {
                         };
           };
mobl.Map.prototype.set = function(k, v) {
                           this.data[k] = v;
                         };
mobl.Map.prototype.get = function(k) {
                           return this.data[k];
                         };
mobl.Map.prototype.keys = function() {
                            var keys = [];
                            for(var p in this.data)
                            {
                              if(this.data.hasOwnProperty(p))
                              {
                                keys.push(p);
                              }
                            }
                            return keys;
                          };
mobl.screenStack = [ ];
mobl.innerHeight = false;
setTimeout(function() {
             if(mobl.isAndroid)
             {
               mobl.innerHeight = window.innerHeight;
             }
           }, 200);
function updateScrollers ( ) {
  var scrollwrappers = $("div#scrollwrapper");
  if(scrollwrappers.length > 0)
  {
    var height = mobl.innerHeight?mobl.innerHeight:window.innerHeight;
    height -= $("#footer:visible").height();
    height -= $("#tabbar:visible").height();
    scrollwrappers.height(height);
  }
  var scrollers = $("div#scrollwrapper div#content");
  for(var i = 0; i < scrollers.length; i++)
  {
    var scroller = scrollers.eq(i).data("scroller");
    if(scroller)
    {
      scroller.refresh();
    }
    else
    {
    }
  }
}
mobl.delayedUpdateScrollers = function() {
                                setTimeout(updateScrollers, 200);
                              };
if(!mobl.isAndroid)
{
  $(window).resize(updateScrollers);
}
$(function() {
    setInterval(function() {
                  persistence.flush();
                }, 2500);
  });
mobl.postCallHooks = [ ];
mobl.call = function(screenName, args, callback) {
              var screenFrame = {
                                  "name": screenName,
                                  "args": args,
                                  "callback": callback,
                                  "div": screenName.replace(/\./g, '__') + mobl.screenStack.length
                                };
              mobl.screenStack.push(screenFrame);
              var callbackFn = function() {
                                 mobl.screenStack.pop();
                                 if(mobl.screenStack.length > 0)
                                 {
                                   var previousScreen = mobl.screenStack[mobl.screenStack.length - 1];
                                   $("body > #" + screenFrame.div).remove();
                                   mobl.delayedUpdateScrollers();
                                   $("body > #" + previousScreen.div).show();
                                   scrollTo(0, previousScreen.pageYOffset);
                                 }
                                 if(callback)
                                 {
                                   callback.apply(null, arguments);
                                 }
                               };
              var parts = screenName.split('.');
              var current = window;
              for(var i = 0; i < parts.length; i++)
              {
                current = current[parts[i]];
              }
              var screenTemplate = current;
              screenTemplate.apply(null, args.concat([function(node) {
                                                        node.attr('id', screenFrame.div);
                                                        node.addClass('screen');
                                                        node.attr('style', "position: absolute; left: 0; top: 0; width: 100%;");
                                                        var body = $("body");
                                                        if(mobl.screenStack.length > 1)
                                                        {
                                                          var previousScreen = mobl.screenStack[mobl.screenStack.length - 2];
                                                          previousScreen.pageYOffset = window.pageYOffset;
                                                          $("body > #" + previousScreen.div).hide();
                                                          node.prependTo(body);
                                                          scrollTo(0, 0);
                                                        }
                                                        else
                                                        {
                                                          node.prependTo(body);
                                                        }
                                                        mobl.postCallHooks.forEach(function(fn) {
                                                                                     fn(node);
                                                                                   });
                                                        $(function() {
                                                            var scrollers = $("div#scrollwrapper div#content");
                                                            var i = 0;
                                                            if(scrollers.length > 0)
                                                            {
                                                              for(i = 0; i < scrollers.length; i++)
                                                              {
                                                                if(!scrollers.eq(i).data("scroller"))
                                                                {
                                                                  scrollers.eq(i).data("scroller", new iScroll(scrollers.get(i),'y'));
                                                                }
                                                              }
                                                              mobl.delayedUpdateScrollers();
                                                            }
                                                          });
                                                      },callbackFn]));
            };
mobl.ref = function(e, property) {
             return new mobl.Reference(e,property);
           };
function fromScope ( that , prop ) {
  if(prop)
  {
    return $(that).scope().get(prop);
  }
  else
  {
    return $(that).scope();
  }
}
mobl.stringTomobl__Num = function(s) {
                           return parseFloat(s, 10);
                         };
mobl.stringTomobl__String = function(s) {
                              return s;
                            };
mobl.conditionalDef = function(oldDef, condFn, newDef) {
                        return function() {
                                 if(condFn())
                                 {
                                   return newDef.apply(null, arguments);
                                 }
                                 else
                                 {
                                   return oldDef.apply(null, arguments);
                                 }
                               };
                      };
mobl.stringTomobl__DateTime = function(s) {
                                return new Date(s);
                              };
mobl.encodeUrlObj = function(obj) {
                      var parts = [];
                      for(var k in obj)
                      {
                        if(obj.hasOwnProperty(k))
                        {
                          parts.push(encodeURI(k) + "=" + encodeURI(obj[k]));
                        }
                      }
                      return "?" + parts.join("&");
                    };
function op ( operator , e1 , e2 , callback ) {
  switch(operator) {
    case '+':
      callback(e1 + e2);
      break;
    case '-':
      callback(e1 - e2);
      break;
    case '*':
      callback(e1 * e2);
      break;
    case '/':
      callback(e1 / e2);
      break;
    case '%':
      callback(e1 % e2);
      break;
    }
}
mobl.proxyUrl = function(url, user, password) {
                  if(user && password)
                  {
                    return '/proxy.php?user=' + user + '&pwd=' + password + '&proxy_url=' + encodeURIComponent(url);
                  }
                  else
                  {
                    return '/proxy.php?proxy_url=' + encodeURIComponent(url);
                  }
                };
mobl.remoteCollection = function(uri, datatype, processor) {
                          return {
                                   addEventListener: function() {
                                                     },
                                   list: function(_, callback) {
                                           $.ajax({
                                                    url: mobl.proxyUrl(uri),
                                                    datatype: datatype,
                                                    error: function(_, message, error) {
                                                             console.log(message);
                                                             console.log(error);
                                                             callback([]);
                                                           },
                                                    success: function(data) {
                                                               callback(processor(data));
                                                             }
                                                  });
                                         }
                                 };
                        };
mobl.instantiate = function(sup, props) {
                     var obj = {
                               };
                     for(var p in sup)
                     {
                       if(sup.hasOwnProperty(p))
                       {
                         obj[p] = sup[p];
                       }
                     }
                     for(var p in props)
                     {
                       if(props.hasOwnProperty(p))
                       {
                         obj[p] = props[p];
                       }
                     }
                     return new mobl.ObservableObject(obj);
                   };
mobl.ObservableObject = function(props) {
                          this._data = props;
                          this.subscribers = {
                                             };
                          var that = this;
                          for(var property in props)
                          {
                            if(props.hasOwnProperty(property))
                            {
                              (function() {
                                 var p = property;
                                 that.__defineGetter__(p, function() {
                                                            return that._data[p];
                                                          });
                                 that.__defineSetter__(p, function(val) {
                                                            that._data[p] = val;
                                                            that.triggerEvent('change', that, p, val);
                                                          });
                               }());
                            }
                          }
                        };
mobl.ObservableObject.prototype = new persistence.Observable ( );
mobl.ObservableObject.prototype.toJSON = function() {
                                           var obj = {
                                                     };
                                           for(var p in this._data)
                                           {
                                             if(this._data.hasOwnProperty(p))
                                             {
                                               obj[p] = this._data[p];
                                             }
                                           }
                                           return obj;
                                         };
function log ( s ) {
  console.log(s);
}
mobl.implementInterface = function(sourceModule, targetModule, items) {
                            for(var i = 0; i < items.length; i++)
                            {
                              targetModule[items[i]] = sourceModule[items[i]];
                            }
                          };
(function() {
   function Tuple ( ) {
     for(var i = 0; i < arguments.length; i++)
     {
       this['_' + ( i + 1 )] = arguments[i];
     }
     this.subscribers = {
                        };
     this.length = arguments.length;
   }
   Tuple.prototype = new persistence.Observable ( );
   Tuple.prototype.toJSON = function() {
                              var obj = {
                                        };
                              for(var i = 0; i < this.length; i++)
                              {
                                obj['_' + ( i + 1 )] = this['_' + ( i + 1 )];
                              }
                              return obj;
                            };
   function Template ( renderFn ) {
     this.render = renderFn;
     this.calledTemplates = [ ];
     this.subscriptions = [ ];
   }
   Template.prototype.addSubscription = function(subId) {
                                          this.subscriptions.push(subId);
                                        };
   Template.prototype.addCalledTemplate = function(template) {
                                            this.calledTemplates.push(template);
                                          };
   function LinkedMap ( parent , values ) {
     this.values = values || {
                             };
     this.parent = parent;
   }
   LinkedMap.prototype.get = function(key) {
                               if(keyinthis.values)
                               {
                                 return this.values[key];
                               }
                               else
                               if(this.parent)
                               {
                                 return this.parent.get(key);
                               }
                               else
                               {
                                 return undefined;
                               }
                             };
   LinkedMap.prototype.set = function(key, value) {
                               var current = this;
                               while ( !(keyincurrent.values) && current.parent )
                               {
                                 current = current.parent;
                               }
                               if(keyincurrent.values)
                               {
                                 current.values[key] = value;
                               }
                               else
                               {
                                 this.values[key] = value;
                               }
                             };
   LinkedMap.prototype.setLocal = function(key, value) {
                                    this.values[key] = value;
                                  };
   LinkedMap.prototype.getRoot = function() {
                                   return !this.parent?this:this.parent.getRoot();
                                 };
   function Reference ( ref , prop ) {
     this.ref = ref;
     this.prop = prop;
     this.childRefs = [ ];
     if(prop)
     {
       ref.childRefs.push(this);
     }
     this.subscribers = {
                        };
   }
   Reference.prototype = new persistence.Observable ( );
   Reference.prototype.oldAddListener = Reference.prototype.addEventListener;
   Reference.prototype.addEventListener = function(eventType, callback) {
                                            if(eventType === 'change' && this.prop !== undefined && this.ref.get().addEventListener)
                                            {
                                              var that = this;
                                              this.ref.get().addEventListener('change', function(_, _, prop, value) {
                                                                                          if(prop === that.prop)
                                                                                          {
                                                                                            callback(eventType, that, value);
                                                                                          }
                                                                                        });
                                            }
                                            this.oldAddListener(eventType, callback);
                                          };
   Reference.prototype.addSetListener = function(callback) {
                                          var that = this;
                                          if(this.ref.addEventListener)
                                          {
                                            this.ref.addEventListener('change', function(_, _, prop, value) {
                                                                                  if(prop === that.prop)
                                                                                  {
                                                                                    callback(eventType, that, value);
                                                                                  }
                                                                                });
                                          }
                                        };
   Reference.prototype.get = function() {
                               if(this.prop === undefined)
                               {
                                 return this.ref;
                               }
                               if(this.ref.get)
                               {
                                 return this.ref.get()[this.prop];
                               }
                             };
   Reference.prototype.set = function(value) {
                               if(this.prop === undefined)
                               {
                                 this.ref = value;
                                 this.triggerEvent('change', this, value);
                               }
                               else
                               {
                                 this.ref.get()[this.prop] = value;
                                 this.triggerEvent('change', this, value);
                               }
                               for(var i = 0; i < this.childRefs.length; i++)
                               {
                                 var childRef = this.childRefs[i];
                                 childRef.rebind();
                                 childRef.triggerEvent('change', childRef, childRef.get());
                               }
                             };
   Reference.prototype.rebind = function() {
                                  var that = this;
                                  if(this.prop !== undefined)
                                  {
                                    if(this.ref.get().addEventListener)
                                    {
                                      window.newTask2 = this.ref.get();
                                      this.ref.get().addEventListener('change', function(_, _, prop, value) {
                                                                                  if(prop === that.prop)
                                                                                  {
                                                                                    that.triggerEvent('change', that, value);
                                                                                  }
                                                                                });
                                    }
                                    else
                                    {
                                    }
                                  }
                                  for(var i = 0; i < this.childRefs.length; i++)
                                  {
                                    this.childRefs[i].rebind(value[this.childRefs[i].prop]);
                                  }
                                };
   mobl.Tuple = Tuple;
   mobl.LinkedMap = LinkedMap;
   mobl.Reference = Reference;
 }());mobl.window = mobl.ref(null);
mobl.window = mobl.ref(window);