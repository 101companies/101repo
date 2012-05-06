/**
 * Components library for bootstrap
 * 
 *	These are some handy components which could be used
 *	with Twitter's bootstrap and jQuery.
 * 
 * Indentation: by tabs (size=4)
 * 
 * @author {Marius Rackwitz}
 * @version {0.1}
 */

var components = {};

/**
 * A container, in which different types of messages could be written.
 * 
 * @this {components.Console}
 */
components.Console = function(elem) {
	var container = elem;
	
	var write = function(className, message) {
		container.prepend(
				$('<div class="alert alert-'+className+'"></div>')
					.html(message)
					.append($('<button class="close" data-dismiss="alert">×</button>'))
			);
	};
	
	this.info		= function(msg) { write('info',		msg); };
	this.success	= function(msg) { write('success',	msg); };
	this.warning	= function(msg) { write('warning',	msg); };
	this.error		= function(msg) { write('error',	msg); };
	
	this.log = this.info;
	
	this.clear = function() {
		container.html('');
	};
	
};


/**
 * A progress bar, which could be easily updated
 *
 * @this {components.ProgressBar}
 */
components.ProgressBar = function(elem) {
	var bar = elem.find('.bar');
	var progress = 0;
	
	this.setProgress = function(newProgress) {
		progress = newProgress;
		this.update();
	};
	
	this.update = function() {
		if (progress == 0) {
			bar.css("width", "0%");
		} else {
			bar.css({ width: progress + "%" });
		}
	}
};