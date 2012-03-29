"Preparations"
MCCacheRepository instVarNamed: 'default' put: nil.
!
(ToolSet browse: WACounter selector: #renderContentOn:)
	right: World width - 10;
	bottom: World height - 40.
!
(Workspace new
	contents: (String streamContents: [ :stream |
		stream
			nextPutAll: 'Welcome to Seaside ';
			nextPutAll: GRPlatform current seasideVersion greaseString;
			nextPut: $.;
			cr; cr;
			nextPutAll: 'Seaside is already running on port 8080. To get started, simply use your browser to open http://localhost:8080/ and take a look at the examples and documentation listed there.';
			cr; cr;
			nextPutAll: 'You can start and stop the server (and change the port) using the new Seaside Control Panel.' ]);
	openLabel: 'Seaside ', GRPlatform current seasideVersion greaseString;
	topView)
		width: 450;
		height: 210;
		top: 10;
		right: World width - 10.!
"Clear Author"
Author reset.
!
"Clear Monticello Caches"
MCCacheRepository instVarNamed: 'default' put: nil.
MCFileBasedRepository flushAllCaches.
MCMethodDefinition shutDown.
MCDefinition clearInstances.
!
"Cleanup Smalltalk"
Smalltalk flushClassNameCache.
Smalltalk organization removeEmptyCategories.
Smalltalk allClassesAndTraitsDo: [ :each |
	each organization removeEmptyCategories; sortCategories.
	each class organization removeEmptyCategories; sortCategories ].
!
"Cleanup System Memory"
Smalltalk garbageCollect.
Symbol compactSymbolTable.
!
"Save and Quit"
WorldState addDeferredUIMessage: [
	SmalltalkImage current snapshot: true andQuit: true ].
!
