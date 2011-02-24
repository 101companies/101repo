mobl.provides('mobl.ui');
mobl.load('mobl.js');

mobl.ui.float = function(side, distance, elements, callback) {
  var root168 = $("<span>");
  
  var node129 = $("<span class=\"float\">");
  
  var ref77 = mobl.ref("float: " + side.get() + "; " + (side.get() == "left" ? "margin-left: " + distance.get() + "px;" : "margin-right: " + distance.get() + "px;"));
  if(ref77.get() !== null) {
    node129.attr('style', ref77.get());
    ref77.addEventListener('change', function(_, ref, val) {
      if(ref === ref77) {
        node129.attr('style', val);
      } else {
        console.log("Garbage!");
      }
    });
    side.addEventListener('change', function() {
      node129.attr('style', "float: " + side.get() + "; " + (side.get() == "left" ? "margin-left: " + distance.get() + "px;" : "margin-right: " + distance.get() + "px;"));
    });
    distance.addEventListener('change', function() {
      node129.attr('style', "float: " + side.get() + "; " + (side.get() == "left" ? "margin-left: " + distance.get() + "px;" : "margin-right: " + distance.get() + "px;"));
    });
    
  }
  ref77.rebind();
  
  var nodes87 = $("<span>");
  node129.append(nodes87);
  mobl.ref(elements).addEventListener('change', function() {
    renderControl47();
  });
  
  function renderControl47() {
    (elements)(function(elements, callback) {
      var root169 = $("<span>");
      callback(root169); return;
    }, function(node) {
      var oldNodes = nodes87;
      nodes87 = node.contents();
      oldNodes.replaceWith(nodes87);
    });
  }
  renderControl47();
  root168.append(node129);
  callback(root168); return;
  
  
};

if(mobl.isIphone() || mobl.isIpad())
{
  mobl.load('mobl/ui/ios.js');
  mobl.load('mobl/ui/ios.css');
  mobl.ui.impl = mobl.ui.ios;
}
else
{
  mobl.load('mobl/ui/generic.js');
  mobl.load('mobl/ui/generic.css');
  mobl.ui.impl = mobl.ui.generic;
}
mobl.implementInterface(mobl.ui.impl, mobl.ui, ['header','button','sideButton','backButton','group','item','itemArrow','checkBox','textField','numField','searchBox','tabSet','contextMenu']);