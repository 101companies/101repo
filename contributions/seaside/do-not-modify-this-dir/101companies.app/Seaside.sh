#!/bin/sh

# path
ROOT=`readlink -f $(dirname $0)`
LINUX="$ROOT/Contents/Linux"
RESOURCES="$ROOT/Contents/Resources"

# icon (note: gvfs-set-attribute is found in gvfs-bin on Ubuntu
# systems and it seems to require an absolute filename)
gvfs-set-attribute \
	"$0" \
	"metadata::custom-icon" \
	"file://$RESOURCES/Squeak.png" \
		2> /dev/null

# zenity is part of GNOME
image_count=`ls "$RESOURCES"/*.image 2>/dev/null |wc -l`
if which zenity &>/dev/null && [ "$image_count"  -ne 1 ]; then
	olddir=`pwd`
	cd "$RESOURCES"
	image=`zenity --title 'Select an image' --file-selection --file-filter '*.image' --file-filter '*'`
	cd "$olddir"
else
	image="$RESOURCES/Seaside.image"
fi

# execute
exec "$LINUX/squeak" \
	-plugins "$LINUX" \
	-encoding latin1 \
	-vm-display-X11 \
	"$image"
