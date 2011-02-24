/**
 * You can identify a swipe gesture as follows: 1. Begin gesture if you receive
 * a touchstart event containing one target touch. 2. Abort gesture if, at any
 * time, you receive an event with >1 touches. 3. Continue gesture if you
 * receive a touchmove event mostly in the x-direction. 4. Abort gesture if you
 * receive a touchmove event mostly the y-direction. 5. End gesture if you
 * receive a touchend event.
 *
 * @author Dave Dunkin
 * @copyright public domain
 */
function addSwipeListener (el, listener) {
    var startX;
    var dx;
    var direction;

    function cancelTouch () {
        el.removeEventListener('touchmove', onTouchMove);
        el.removeEventListener('touchend', onTouchEnd);
        startX = null;
        startY = null;
        direction = null;
    }

    function onTouchMove (e) {
        if (e.touches.length > 1) {
            cancelTouch();
        } else {
            dx = e.touches[0].pageX - startX;
            var dy = e.touches[0].pageY - startY;
            if (direction == null) {
                direction = dx;
                e.preventDefault();
            } else if ((direction < 0 && dx > 0) || (direction > 0 && dx < 0) || Math.abs(dy) > 15) {
                cancelTouch();
            }
        }
    }

    function onTouchEnd (e) {
        cancelTouch();
        if (Math.abs(dx) > 50) {
            listener(e);
        }
    }

    function onTouchStart (e) {
        if (e.touches.length == 1) {
            startX = e.touches[0].pageX;
            startY = e.touches[0].pageY;
            el.addEventListener('touchmove', onTouchMove, false);
            el.addEventListener('touchend', onTouchEnd, false);
        }
    }

    el.addEventListener('touchstart', onTouchStart, false);
}

jQuery.fn.swipe = function (callback) {
    this.each(function (idx, node) {
        addSwipeListener(node, callback);
    });
}

$.event.special.swipe = {
    add: function (callback) {
        addSwipeListener(this, callback);
        $(this).bind('dblclick', callback);
    }
};

function NoClickDelay (el, callback) {
    this.element = el;
    this.element.addEventListener('touchstart', this, false);
    this.callback = callback;
}

NoClickDelay.prototype = {
    handleEvent: function (e) {
        switch (e.type) {
        case 'touchstart':
            this.onTouchStart(e);
            break;
        case 'touchmove':
            this.onTouchMove(e);
            break;
        case 'touchend':
            this.onTouchEnd(e);
            break;
        }
    },

    onTouchStart: function (e) {
        //e.preventDefault();
        this.moved = false;
        //console.log("Starting...");
        this.element.addEventListener('touchmove', this, false);
        this.element.addEventListener('touchend', this, false);
        this.touchStartY = e.touches[0].pageY;
        this.touchStartX = e.touches[0].pageX;
    },

    onTouchMove: function (e) {
        //console.log("Moving");
        var topDelta = e.touches[0].pageY - this.touchStartY;
        var leftDelta = e.touches[0].pageX - this.touchStartX;
        if(Math.abs(topDelta) > 5 || Math.abs(leftDelta) > 5) {
            this.moved = true;
        }
    },

    onTouchEnd: function (e) {
        this.element.removeEventListener('touchmove', this, false);
        this.element.removeEventListener('touchend', this, false);

        //console.log("The end");
        if (!this.moved) {
            this.callback(e);
        }
    }
};

jQuery.fn.tap = function (callback) {
    // if (true) {//(mobl.isIphone) {
     //new NoClickDelay(this[0], callback);
    // } else {
     this.click(callback);
    // }
};

$.event.special.touchdown = {
    add: function (callback) {
      var that = $(this);

      that.mousedown(function(event) {
        event.preventDefault();
        this.dragging = true;
        event.x = event.offsetX || event.layerX - that.offset().left;
        event.y = event.offsetY || event.layerY - that.offset().top;
        callback(event);
      });
      that.bind('touchstart', function(event) {
        event = event.originalEvent;
        event.preventDefault();
        if(event.touches.length === 1) {
          var touch = event.touches[0];
          event.x = touch.pageX - that.offset().left;
          event.y = touch.pageY - that.offset().top;
          event.clientX = touch.pageX;
          event.clientY = touch.pageY;
          callback(event);
        }
      });
    }
};

$.event.special.touchdrag = {
    add: function (callback) {
      var that = $(this);
      that.mousemove(function(event) {
        event.preventDefault();
        if(this.dragging) {
          event.x = event.offsetX || event.layerX - that.offset().left;
          event.y = event.offsetY || event.layerY - that.offset().top;
          callback(event);
        }
      });
      that.bind('touchmove', function(event) {
        event = event.originalEvent;
        event.preventDefault();
        if(event.touches.length === 1) {
          var touch = event.touches[0];
          event.x = touch.pageX - that.offset().left;
          event.y = touch.pageY - that.offset().top;
          event.clientX = touch.pageX;
          event.clientY = touch.pageY;
          callback(event);
        }
      });
      that.mouseup(function() {
        this.dragging = false;
      });
    }
};

$.event.special.touchup = {
    add: function (callback) {
      var that = $(this);
      that.mouseup(function(event) {
        event.preventDefault();
        this.dragging = false;
        callback(event);
      });
      that.bind('touchend', function(event) {
        event = event.originalEvent;
        event.preventDefault();
        callback(event);
      });
    }
};
