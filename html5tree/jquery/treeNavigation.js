var treeNavigation = {
    toggleList: function(el) {
        var minimized = jQuery(el).prop("minimized");
        
        if (minimized || minimized == null) {
            jQuery(el).prop("src", "symbols/minus.gif");
            jQuery(el).parent().children("ul").each(function() {
                jQuery(this).css("display", "block");
                
            });
        } else {
            jQuery(el).prop("src", "symbols/plus.gif");
            jQuery(el).parent().children("ul").each(function() {
                jQuery(this).css("display", "none");
                
            });
        }
        if (minimized == null) {
            minimized = true;
        }
        
        jQuery(el).prop("minimized", !minimized);
    }
}

