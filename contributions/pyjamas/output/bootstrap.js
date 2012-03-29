// this is almost directly taken from Google's GWT which is now open source

var __PYGWT_JS_INCLUDED;

if (!__PYGWT_JS_INCLUDED) {
  __PYGWT_JS_INCLUDED = true;

var __pygwt_retryWaitMs = 50;
var __pygwt_moduleNames = [];
var __pygwt_isHostPageLoaded = false;
var __pygwt_onLoadError = function (exception, name) {
   var exc_name = exception.__name__;
   var msg = exception.message;

   if (typeof exc_name == 'undefined') {
     exc_name = exception.name;
   }
   if (typeof msg == 'undefined' || msg == '' || msg == exc_name) {
     if (    exception.args
         && exception.args.__array
	 && exception.args.__array.length > 0) {
        msg = exception.args.__array.join(", ");
     } else {
        msg = exception.toString();
     }
   }
   alert( name + " " + exc_name + ': '  + msg );

};


function __pygwt_processMetas() {
  var metas = document.getElementsByTagName("meta");
  for (var i = 0, n = metas.length; i < n; ++i) {
    var meta = metas[i];
    var name = meta.getAttribute("name");
    if (name) {
      if (name == "pygwt:module") {
        var content = meta.getAttribute("content");
        if (content) {
          __pygwt_moduleNames = __pygwt_moduleNames.concat(content);
        }
      }
    }
  }
}


function __pygwt_forEachModule(lambda) {
  for (var i = 0; i < __pygwt_moduleNames.length; ++i) {
    lambda(__pygwt_moduleNames[i]);
  }
}


// When nested IFRAMEs load, they reach up into the parent page to announce that
// they are ready to run. Because IFRAMEs load asynchronously relative to the 
// host page, one of two things can happen when they reach up:
// (1) The host page's onload handler has not yet been called, in which case we 
//     retry until it has been called.
// (2) The host page's onload handler has already been called, in which case the
//     nested IFRAME should be initialized immediately.
//
function __pygwt_webModeFrameOnLoad(iframeWindow, name) {
  var moduleInitFn = iframeWindow.pygwtOnLoad;
  if (__pygwt_isHostPageLoaded && moduleInitFn) {
    var old = window.status;
    window.status = "Initializing module '" + name + "'";
    try {
        moduleInitFn(__pygwt_onLoadError, name);
    } finally {
        window.status = old;
    }
  } else {
    setTimeout(function() { __pygwt_webModeFrameOnLoad(iframeWindow, name); }, __pygwt_retryWaitMs);
  }
}


function __pygwt_hookOnLoad() {
  var oldHandler = window.onload;
  window.onload = function() {
    __pygwt_isHostPageLoaded = true;
    if (oldHandler) {
      oldHandler();
    }
  };
}


// Returns an array that splits the module name from the meta content into
// [0] the prefix url, if any, guaranteed to end with a slash
// [1] the dotted module name
//
function __pygwt_splitModuleNameRef(moduleName) {
   var parts = ['', moduleName];
   var i = moduleName.lastIndexOf("=");
   if (i != -1) {
      parts[0] = moduleName.substring(0, i) + '/';
      parts[1] = moduleName.substring(i+1);
   }
   return parts;
}


//////////////////////////////////////////////////////////////////
// Called directly from compiled code
//
function __pygwt_initHandlers(resize, beforeunload, unload) {
   var oldOnResize = window.onresize;
   window.onresize = function() {
      resize();
      if (oldOnResize)
         oldOnResize();
   };

   var oldOnBeforeUnload = window.onbeforeunload;
   window.onbeforeunload = function() {
      var ret = beforeunload();

      var oldRet;
      if (oldOnBeforeUnload)
        oldRet = oldOnBeforeUnload();

      if (ret !== null)
        return ret;
      return oldRet;
   };

   var oldOnUnload = window.onunload;
   window.onunload = function() {
      unload();
      if (oldOnUnload)
         oldOnUnload();
   };
    var errordialog=function(msg, url, linenumber) {
        var dialog=document.createElement("div");
            dialog.className='errordialog';
            dialog.innerHTML='&nbsp;<b style="color:red">JavaScript Error: </b>' + msg +' at line number ' + linenumber +'. Please inform webmaster.';
            document.body.appendChild(dialog);
            return true;
    }

    window.onerror=function(msg, url, linenumber){
        return errordialog(msg, url, linenumber);
    }
}


//////////////////////////////////////////////////////////////////
// Web Mode
//
function __pygwt_injectWebModeFrame(name) {
   if (document.body) {
      var parts = __pygwt_splitModuleNameRef(name);
   
      // Insert an IFRAME
      var iframe = document.createElement("iframe");
      var selectorURL = parts[0] + parts[1] + ".nocache.html";
      iframe.src = selectorURL;
      iframe.style.border = '0px';
      iframe.style.width = '0px';
      iframe.style.height = '0px';
      if (document.body.firstChild) {
         document.body.insertBefore(iframe, document.body.firstChild);
      } else {
         document.body.appendChild(iframe);
      }
   } else {
      // Try again in a moment.
      //
      window.setTimeout(function() { __pygwt_injectWebModeFrame(name); }, __pygwt_retryWaitMs);
   }
}

//////////////////////////////////////////////////////////////////
// Module Load Controller
//
var __pygwt_modController = {
    __apps: {
        block: 0,
        list: {}
    },
    __listeners: {
        disabled: {},
        list: {
            init: [],
            appInit: [],
            moduleInit: [],
            moduleLoad: [],
            appLoad: [],
            load: [],
            hookException: []
        }
    },
    _get: function(type, item) {
        type = '__' + type
        if(!(type in this))
            return false
        if(!('list' in this[type]))
            return false
        if(!item)
            return this[type].list
        if(item in this[type].list)
            return this[type].list[item]
        return false
    },
    _onEvent: function(event, name, module) {
        var l = this._get('listeners', event)
        if(!l || this.__listeners.disabled[event])
            return false
        var app = this._get('apps', name)
        try {
            for(var i in l) if(l[i]) l[i](app, module)
        } catch(e) {
            try {
                var l = this._get('listeners', 'hookException')
                if(l) for(var i in l) if(l[i]) l[i](e)
            } catch(e) { /* console.log(e) */ }
        }
        if(event=='init' || event=='load')
            this.__listeners.disabled[event] = true
        if(event=='appLoad')
            __pygwt_webModeFrameOnLoad(app.reference, app.name)
    },
    _initApp: function(name, win) {
        this._onEvent('init')
        this.__apps.list[name] = {
            name: name,
            reference: win,
            loaded: false,
            modules: {
                list: {},
                block: 0,
                init: function(module) {
                    var m = this.list[module] = {}
                    m.start = new Date().getTime()
                    this.block++
                },
                load: function(module){
                    var m = this.list[module]
                    m.end = new Date().getTime()
                    m.duration = m.end - m.start
                    this.block--
                }
            }
        }
        this.__apps.block++
        this._onEvent('appInit', name)
    },
    _initModule: function(name, module) {
        var app = this._get('apps', name)
        var doc = app.reference.document
        var s = doc.createElement('script')
        s.onload = s.onreadystatechange = function() {
            if(s.onload.fired)
                return
            if(!s.readyState || s.readyState == 'loaded' || s.readyState == 'complete') {
                s.onload.fired = true
                __pygwt_modController._loadModule(name, module)
            }
        }
        s.onload.fired = false
        s.type = 'text/javascript'
        s.src = module
        doc.getElementsByTagName('head')[0].appendChild(s)
        this._onEvent('moduleInit', name, module)
    },
    _loadModule: function(name, module) {
        var app = this._get('apps', name)
        app.modules.load(module)
        this._onEvent('moduleLoad', name, module)
        if(app.modules.block==0) this._loadApp(name)
    },
    _loadApp: function(name) {
        var app = this._get('apps', name)
        if(!app.loaded && app.modules.block==0) {
            app.loaded = true
            this.__apps.block--
            this._onEvent('appLoad', name)
            if(this.__apps.block==0) this._onEvent('load')
        }
    },
    init: function(name, win) {
        this._initApp(name, win)
    },
    load: function(name, modules) {
        var i, app = this._get('apps', name)
        var f = function(a, m) {
            setTimeout(function(){
                __pygwt_modController._initModule(a, m)
                a=null; m=null
            }, 1)
            app.modules.init(m)
        }
        for(i in modules) if(modules[i]) f(name, modules[i])
        if(i===undefined && modules) f(name, modules)
    },
    done: function(name) {
        this._loadApp(name)
    },
    addListener: function(event, listener) {
        var list = this._get('listeners', event)
        if(list)
            return list.push(listener)-1
        return false
    },
    removeListener: function(event, target) {
        var list = this._get('listeners', event)
        if(!list)
            return false
        if(target in list)
            return list.splice(target, 1, false)
        for(var i in list)
            if(target===list[i])
                return list.splice(i, 1, false)
        return false
    }
}

//////////////////////////////////////////////////////////////////
// Early user custom routines
//
function __pygwt_earlyUser() {
    // bootsplash/custom stuff here
}

//////////////////////////////////////////////////////////////////
// Set it up
//
__pygwt_earlyUser();
__pygwt_processMetas();
__pygwt_hookOnLoad();
__pygwt_forEachModule(__pygwt_injectWebModeFrame);


} // __PYGWT_JS_INCLUDED
