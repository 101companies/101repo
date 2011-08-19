(************************************************************************
*  company.mli
*  101implementations
*
*  Created by Jan Baltzer on 
Warning: date(): It is not safe to rely on the system's timezone settings. You are *required* to use the date.timezone setting or the date_default_timezone_set() function. In case you used any of those methods and you are still getting this warning, you most likely misspelled the timezone identifier. We selected 'Europe/Berlin' for 'CEST/2.0/DST' instead in /Library/Application Support/TextMate/Bundles/OCaml.tmbundle/Templates/OCaml Source File/source.mli on line 9
5 Aug 2011.
*  Copyright (c) 
Warning: date(): It is not safe to rely on the system's timezone settings. You are *required* to use the date.timezone setting or the date_default_timezone_set() function. In case you used any of those methods and you are still getting this warning, you most likely misspelled the timezone identifier. We selected 'Europe/Berlin' for 'CEST/2.0/DST' instead in /Library/Application Support/TextMate/Bundles/OCaml.tmbundle/Templates/OCaml Source File/source.mli on line 10
2011 __MyCompanyName__. All rights reserved.
************************************************************************)

val employee : 
    'a -> 
    'b -> 
    float -> 
    (unit -> float) * unit Join.chan

val department :
    'a ->
    (unit -> float) * unit Join.chan ->
    ((unit -> float) * unit Join.chan) list ->
    ((unit -> float) * unit Join.chan) list -> 
    (unit -> float) * unit Join.chan

val company :
    'a ->
    ((unit -> float) * unit Join.chan) list -> 
    (unit -> float) * unit Join.chan

val applyCut : 
    'a * unit Join.chan -> 
    'a * unit Join.chan

val applyTotal : 
    (unit -> 'a) * 'b -> 
    'a
